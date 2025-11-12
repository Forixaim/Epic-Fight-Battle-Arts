package net.forixaim.battle_arts.core_assets.client.particle;

import com.google.common.collect.Lists;
import com.mojang.logging.LogUtils;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.api.client.animation.property.TrailInfo;
import yesman.epicfight.api.physics.bezier.CubicBezierCurve;
import yesman.epicfight.api.utils.math.MathUtils;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.client.particle.AbstractTrailParticle;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.projectile.ProjectilePatch;

import java.util.List;

public class BattleArtsProjectileTrailParticle extends AbstractTrailParticle<ProjectilePatch<? extends Projectile>> {
    protected float lastXRot;
    protected float lastYRot;
    public static Provider createRecord()
    {
        return new BattleArtsProjectileTrailParticle.Provider();
    }
    protected BattleArtsProjectileTrailParticle(ClientLevel level, ProjectilePatch<?> entityPatch, TrailInfo trailInfo) {
        super(level, entityPatch, trailInfo);
        this.rCol = trailInfo.rCol();
        this.gCol = trailInfo.gCol();
        this.bCol = trailInfo.bCol();
    }
    protected boolean canContinue() {
        Projectile var2 = this.owner.getOriginal();
        if (var2 instanceof ThrownTrident thrownTrident) {
            if (thrownTrident.clientSideReturnTridentTickCount > 0) {
                return false;
            }
        }
        return !this.owner.getOriginal().isRemoved();
    }

    protected void createNextCurve() {
        if (!this.shouldRemove) {
            boolean isFirstTrail = this.trailEdges.isEmpty();
            if (isFirstTrail) {
                this.lastXRot = this.owner.getOriginal().getXRot();
                this.lastYRot = 180.0F + this.owner.getOriginal().getYRot();
            }

            TrailInfo trailInfo = this.trailInfo;
            Vec3 posOld = this.owner.getOriginal().getPosition(0.0F);
            Vec3 posCur = this.owner.getOriginal().getPosition(1.0F);
            Vec3 posMid = MathUtils.lerpVector(posOld, posCur, 0.5F);
            float xRotO = this.lastXRot;
            float xRot = this.owner.getOriginal().getXRot();
            float xRotMod = Mth.rotLerp(0.5F, xRotO, xRot);
            float yRotO = this.lastYRot;
            float yRot = 180.0F + this.owner.getOriginal().getYRot();
            float yRotMod = Mth.rotLerp(0.5F, yRotO, yRot);
            OpenMatrix4f prevTransform = OpenMatrix4f.createTranslation((float)posOld.x, (float)posOld.y, (float)posOld.z).rotateDeg(yRotO, Vec3f.Y_AXIS).rotateDeg(xRotO, Vec3f.X_AXIS);
            OpenMatrix4f modTransform = OpenMatrix4f.createTranslation((float)posMid.x, (float)posMid.y, (float)posMid.z).rotateDeg(yRotMod, Vec3f.Y_AXIS).rotateDeg(xRotMod, Vec3f.X_AXIS);
            OpenMatrix4f curTransform = OpenMatrix4f.createTranslation((float)posCur.x, (float)posCur.y, (float)posCur.z).rotateDeg(yRot, Vec3f.Y_AXIS).rotateDeg(xRot, Vec3f.X_AXIS);
            Vec3 prevStartPos = OpenMatrix4f.transform(prevTransform, trailInfo.start());
            Vec3 prevEndPos = OpenMatrix4f.transform(prevTransform, trailInfo.end());
            Vec3 middleStartPos = OpenMatrix4f.transform(modTransform, trailInfo.start());
            Vec3 middleEndPos = OpenMatrix4f.transform(modTransform, trailInfo.end());
            Vec3 currentStartPos = OpenMatrix4f.transform(curTransform, trailInfo.start());
            Vec3 currentEndPos = OpenMatrix4f.transform(curTransform, trailInfo.end());
            List<Vec3> startPosList = Lists.newArrayList();
            List<Vec3> endPosList = Lists.newArrayList();
            TrailEdge edge1;
            TrailEdge edge2;
            if (isFirstTrail) {
                edge1 = new TrailEdge(prevStartPos, prevEndPos, -1);
                edge2 = new TrailEdge(middleStartPos, middleEndPos, -1);
            } else {
                edge1 = this.trailEdges.get(this.trailEdges.size() - (this.trailInfo.interpolateCount() / 2 + 1));
                edge2 = this.trailEdges.get(this.trailEdges.size() - 1);
                ++edge2.lifetime;
            }

            startPosList.add(edge1.start);
            endPosList.add(edge1.end);
            startPosList.add(edge2.start);
            endPosList.add(edge2.end);
            startPosList.add(middleStartPos);
            endPosList.add(middleEndPos);
            startPosList.add(currentStartPos);
            endPosList.add(currentEndPos);
            List<Vec3> finalStartPositions = CubicBezierCurve.getBezierInterpolatedPoints(startPosList, 1, 3, this.trailInfo.interpolateCount());
            List<Vec3> finalEndPositions = CubicBezierCurve.getBezierInterpolatedPoints(endPosList, 1, 3, this.trailInfo.interpolateCount());
            if (!isFirstTrail) {
                finalStartPositions.remove(0);
                finalEndPositions.remove(0);
            }

            this.makeTrailEdges(finalStartPositions, finalEndPositions, this.trailEdges);
            this.lastXRot = xRot;
            this.lastYRot = yRot;
        }
    }

    public static class Provider implements ParticleProvider<TrailParticleType> {

        @Override
        public Particle createParticle(@NotNull TrailParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            int eid = (int)Double.doubleToRawLongBits(x);
            Entity entity = level.getEntity(eid);

            if (entity == null) {
                LogUtils.getLogger().debug("null");
                return null;
            }

            ProjectilePatch<?> entityPatch = EpicFightCapabilities.getEntityPatch(entity, ProjectilePatch.class);

            if (entityPatch != null) {
                LogUtils.getLogger().debug("creating trail");
                return new BattleArtsProjectileTrailParticle(level, entityPatch, type.getTrailInfo());
            }
            LogUtils.getLogger().debug("null");
            return null;
        }
    }
}
