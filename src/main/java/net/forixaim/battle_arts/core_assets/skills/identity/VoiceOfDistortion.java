package net.forixaim.battle_arts.core_assets.skills.identity;

import net.forixaim.battle_arts.initialization.registry.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.stats.DistortionDamageSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

public class VoiceOfDistortion extends Skill
{
    public VoiceOfDistortion(SkillBuilder<?> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener listener)
    {
        super.onInitiate(container, listener);

    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
        if (container.getDataManager().getDataValue(BattleArtsDataKeys.DISTORTED))
        {
            container.getExecutor().getOriginal().setHealth(1);
            container.getExecutor().getOriginal().hurt(new DistortionDamageSource(container.getExecutor().getOriginal().level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), Integer.MAX_VALUE);
        }
    }

    @Override
    public void updateContainer(SkillContainer container)
    {
        super.updateContainer(container);
        if (container.getDataManager().getDataValue(BattleArtsDataKeys.DISTORTED))
        {
            container.getExecutor().getOriginal().addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10, 0, true, false));
            container.getExecutor().getOriginal().hurt(new DistortionDamageSource(container.getExecutor().getOriginal().level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 2);
        }
    }
}
