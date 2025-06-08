package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.Arrays;
import java.util.UUID;

public class Journeyman extends BattleStyle
{
    public static Skill SEISMIC_IMPACT;
    public static Skill SUPPRESSING_BLOW;
    public static Skill RECURVE_AXE;

    private static final UUID EUUID = UUID.fromString("c627ff1f-08f7-4000-b57f-5929767de922");

    public Journeyman(Builder<?> builder) {
        super(builder);
        innateInactiveColor = new float[]{0.271f, 0.212f, 0.133f};
        innateSkillColor = new float[]{1f, 0.561f, 0f};
        unarmedLivingMotions.put(
                LivingMotions.IDLE, JourneymanAnimations.JMAN_UNARMED_IDLE
        );
        unarmedLivingMotions.put(LivingMotions.WALK, JourneymanAnimations.JMAN_UNARMED_IDLE);
        unarmedLivingMotions.put(LivingMotions.SNEAK, JourneymanAnimations.JMAN_UNARMED_IDLE);
        unarmedLivingMotions.put(LivingMotions.JUMP, JourneymanAnimations.JMAN_UNARMED_IDLE);
        unarmedLivingMotions.put(LivingMotions.BLOCK, JourneymanAnimations.JMAN_UNARMED_GUARD);
        unarmedInnateSkill = SUPPRESSING_BLOW;
        unarmedAttackAnimations.addAll(Arrays.asList(JourneymanAnimations.JMAN_UNARMED_AUTO1, JourneymanAnimations.JMAN_UNARMED_AUTO2, JourneymanAnimations.JMAN_UNARMED_DASH, JourneymanAnimations.JMAN_SLEDGEHAMMER));
    }
    public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker) {
        RECURVE_AXE = worker.build("recurve_axe", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanAxeAnims.INNATE)).newProperty();
        SUPPRESSING_BLOW = worker.build("suppressing_blow", SimpleWeaponInnateSkill::new, ((SimpleWeaponInnateSkill.Builder)SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setResource(Resource.COOLDOWN)).setAnimations(JourneymanAnimations.JMAN_SUPPRESSING_BLOW)).newProperty();
        SEISMIC_IMPACT = worker.build("seismic_impact", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanBattleAxeAnims.SEISMIC_IMPACT)).newProperty();
    }

    @Override
    public boolean unarmedMoveset() {
        return true;
    }

    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);

        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MODIFY_DAMAGE_EVENT, EUUID, event -> {
            if (!(event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND) instanceof WeaponCapability))
            {
                event.setDamage(event.getDamage() + 2);
            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MODIFY_DAMAGE_EVENT, EUUID);
        super.onRemoved(container);
    }
}
