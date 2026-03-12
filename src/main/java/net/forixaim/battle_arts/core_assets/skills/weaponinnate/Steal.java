package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.initialization.registry.TagRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;

import java.util.UUID;

public class Steal extends SimpleWeaponInnateSkill
{
    public Steal(Builder builder) {
        super(builder);
    }

    private boolean isFront(LivingEntity entity, Vec3 sourceLocation)
    {
        if (sourceLocation != null) {
            Vec3 viewVector = entity.getViewVector(1.0F);
            viewVector = viewVector.subtract(0.0F, viewVector.y, 0.0F).normalize();
            Vec3 toSourceLocation = sourceLocation.subtract(entity.position()).normalize();
            return toSourceLocation.dot(viewVector) > (double) 0.0F;
        }
        return false;
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container, eventListener);
        eventListener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, event -> {
            if (event.getDamageSource().getAnimation() == this.attackAnimation)
                if (event.getTarget() instanceof Enemy && !event.getTarget().getTags().contains(TagRegistry.STOLEN.toString()) && !isFront(event.getTarget(), event.getEntityPatch().getOriginal().position())) {
                    ItemEntity item = EntityType.ITEM.create(event.getTarget().level());
                    LogUtils.getLogger().debug("oof");
                    if (item != null)
                    {
                        int i = EnchantmentHelper.getEnchantmentLevel(event.getTarget().level().registryAccess().holderOrThrow(Enchantments.LOOTING), container.getExecutor().getOriginal());
                        item.setItem(new ItemStack(Items.EMERALD, 1 + i));
                        item.setPos(event.getTarget().position());
                        event.getTarget().level().addFreshEntity(item);
                    }
                    event.getTarget().addTag(TagRegistry.STOLEN.toString());
                }
        }, this);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);
    }
}
