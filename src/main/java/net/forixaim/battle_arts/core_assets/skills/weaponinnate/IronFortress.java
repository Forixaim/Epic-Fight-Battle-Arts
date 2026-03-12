package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.entries.EpicFightMobEffects;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;


import java.util.UUID;

public class IronFortress extends WeaponInnateSkill
{
	private static final UUID ID = UUID.fromString("7d0148e7-f1ed-4715-8123-0e69b4d49c40");
	public IronFortress(WeaponInnateSkill.Builder<?> builder)
	{
		super(builder);
	}

	@Override
	public void executeOnServer(SkillContainer container, CompoundTag args) {
		super.executeOnServer(container, args);
		this.setDurationSynchronize(container, this.getMaxDuration());
		container.getExecutor().getOriginal().addEffect(new MobEffectInstance(EpicFightMobEffects.STUN_IMMUNITY, this.getMaxDuration(), 0, false, false));
	}

	@Override
	public void onInitiate(SkillContainer container, EntityEventListener eventListener)
	{
		super.onInitiate(container, eventListener);
        eventListener.registerEvent(EpicFightEventHooks.Entity.TAKE_DAMAGE_PRE, event -> {
            if (container.getRemainDuration() > 0)
            {
                event.attachValueModifier(ValueModifier.multiplier(0.8f));
                event.getEntityPatch().playSound(SoundEvents.ANVIL_PLACE, 0, 0);
            }
        }, this);
	}

	@Override
	public void onRemoved(SkillContainer container) {
		super.onRemoved(container);
    }
}
