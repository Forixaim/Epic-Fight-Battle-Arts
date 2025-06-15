package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.initialization.registry.TagRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class Steal extends SimpleWeaponInnateSkill
{

    private static final UUID EVENT_UUID = UUID.fromString("e77d3d79-c569-4ad4-a4b2-d988c8305c60");
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
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_HURT, EVENT_UUID, event -> {
            if (event.getDamageSource().getAnimation() == this.attackAnimation)
                if (event.getTarget() instanceof Enemy && !event.getTarget().getTags().contains(TagRegistry.STOLEN.toString()) && !isFront(event.getTarget(), event.getPlayerPatch().getOriginal().position())) {
                    ItemEntity item = EntityType.ITEM.create(event.getTarget().level());
                    LogUtils.getLogger().debug("oof");
                    if (item != null)
                    {
                        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.MOB_LOOTING, container.getExecutor().getOriginal());
                        item.setItem(new ItemStack(Items.EMERALD, 1 + i));
                        item.setPos(event.getTarget().position());
                        event.getTarget().level().addFreshEntity(item);
                    }
                    event.getTarget().addTag(TagRegistry.STOLEN.toString());
                }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DEALT_DAMAGE_EVENT_HURT, EVENT_UUID);
    }
}
