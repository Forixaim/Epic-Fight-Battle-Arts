package net.forixaim.battle_arts.core_assets.skills.identity;

import net.forixaim.battle_arts.core_assets.events.player.BattleArtsPlayerEvents;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.stats.DistortionDamageSource;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class VoiceOfDistortion extends Skill
{
    private static final UUID EVENT_UUID = UUID.fromString("ddff5466-b29f-4666-a38f-ad7e3dd58155");
    public VoiceOfDistortion(SkillBuilder<? extends Skill> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container)
    {
        super.onInitiate(container);

        container.getExecutor().getEventListener().addEventListener(BattleArtsPlayerEvents.PLAYER_DEATH_EVENT, EVENT_UUID, event ->
        {
            if (!container.getDataManager().getDataValue(BattleArtsDataKeys.DISTORTED.get()))
            {
                event.getPlayerPatch().getOriginal().sendSystemMessage(Component.translatable("text.battle_arts.distort"));
                event.setCanceled(true);
            }
        });

        container.getExecutor().getEventListener().addEventListener(BattleArtsPlayerEvents.PLAYER_REVIVE_EVENT, EVENT_UUID, event ->
        {
            event.getPlayerPatch().getOriginal().setHealth(event.getPlayerPatch().getOriginal().getMaxHealth());
            container.getDataManager().setDataSync(BattleArtsDataKeys.DISTORTED.get(), true);
        });

        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MODIFY_DAMAGE_EVENT, EVENT_UUID, event ->
        {
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.DISTORTED.get()))
            {
                event.attachValueModifier(ValueModifier.multiplier(1.1f));
            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
        if (container.getDataManager().getDataValue(BattleArtsDataKeys.DISTORTED.get()))
        {
            container.getExecutor().getOriginal().setHealth(1);
            container.getExecutor().getOriginal().curePotionEffects(ItemStack.EMPTY);
            container.getExecutor().getOriginal().hurt(new DistortionDamageSource(container.getExecutor().getOriginal().level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), Integer.MAX_VALUE);
        }
        container.getExecutor().getEventListener().removeListener(BattleArtsPlayerEvents.PLAYER_DEATH_EVENT, EVENT_UUID);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MODIFY_DAMAGE_EVENT, EVENT_UUID);
        container.getExecutor().getEventListener().removeListener(BattleArtsPlayerEvents.PLAYER_REVIVE_EVENT, EVENT_UUID);
    }

    @Override
    public void updateContainer(SkillContainer container)
    {
        super.updateContainer(container);
        if (container.getDataManager().getDataValue(BattleArtsDataKeys.DISTORTED.get()))
        {
            container.getExecutor().getOriginal().addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10, 0, true, false));
            container.getExecutor().getOriginal().hurt(new DistortionDamageSource(container.getExecutor().getOriginal().level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 2);
        }
    }
}
