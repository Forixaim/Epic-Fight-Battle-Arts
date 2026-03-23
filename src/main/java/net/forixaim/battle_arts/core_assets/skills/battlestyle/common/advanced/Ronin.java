package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.UsesUchigatana;
import net.forixaim.battle_arts.core_assets.skills.combat_art.TranquilityUnleash;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Tranquility;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts.initialization.registry.SoundRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DeferredHolder;
import yesman.epicfight.api.animation.types.AirSlashAnimation;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.UUID;

public class Ronin extends BattleStyle implements UsesUchigatana
{

	public Ronin(SkillBuilder<?> builder)
	{
		super(builder);
	}

	@Override
	public void onInitiate(SkillContainer container, EntityEventListener listener) {
		super.onInitiate(container, listener);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, SkillRegistry.TRANQUILITY_UNLEASH);
        listener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, CommonEvents::BUILD_METER, this);

        listener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_INCOME, event -> {
            double critPower = event.getEntityPatch().getOriginal().getAttributeValue(Attributes.ATTACK_SPEED) * 0.4;
            BattleArts.LOGGER.debug(String.format("%s", critPower));
            double critChance = critPower * 0.1f;
            BattleArts.LOGGER.debug(String.format("%s", critChance));

            if (event.getEntityPatch().getOriginal().getRandom().nextDouble() < critChance || event.getDamageSource().getAnimation() == RoninUchigatanaAnimations.FLASH_CLEAVE)
            {
                if (event.getEntityPatch().getOriginal().level() instanceof ServerLevel trueLevel)
                {
                    trueLevel.sendParticles(ParticleTypes.CRIT, event.getTarget().getX(), event.getTarget().getEyeY(), event.getTarget().getZ(), 15, 0.0F, 0.0F, 0.0F, 1.0F);
                }
                event.getDamageSource().attachDamageModifier(ValueModifier.multiplier((float)(1 + critPower)));
                event.getEntityPatch().playSound(EpicFightSounds.EVISCERATE.get(), 0, 0);
            }
        }, this);

        listener.registerEvent(EpicFightEventHooks.Entity.MODIFY_ATTACK_SPEED, event -> {
            if (event.getItemCapability().getWeaponCategory() == CapabilityItem.WeaponCategories.TACHI)
            {
                event.setAttackSpeed(event.getAttackSpeed() * 2f);
            }
        }, this);
	}

	@Override
	public void onRemoved(SkillContainer container)
	{
        super.onRemoved(container);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
	}


	@Override
	public void executeOnServer(SkillContainer container, CompoundTag args)
	{
		super.executeOnServer(container, args);
		if (container.getDataManager().getDataValue(BattleArtsDataKeys.TRANQUILITY_SHEATH))
		{
			container.getDataManager().setDataSync(BattleArtsDataKeys.TRANQUILITY_SHEATH, false);
			container.getServerExecutor().modifyLivingMotionByCurrentItem(true);
		}
		else
		{
			container.getDataManager().setDataSync(BattleArtsDataKeys.TRANQUILITY_SHEATH, true);
			container.getServerExecutor().modifyLivingMotionByCurrentItem(true);
		}
	}
}
