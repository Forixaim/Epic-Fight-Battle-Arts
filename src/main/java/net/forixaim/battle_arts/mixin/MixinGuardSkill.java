package net.forixaim.battle_arts.mixin;

import net.forixaim.battle_arts.core_assets.stats.BattleArtsStats;
import net.minecraft.stats.Stats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.HurtEvent;

/**
 * This is an demo mixin on stats
 */
@Mixin(GuardSkill.class)
public class MixinGuardSkill
{
    @Inject(method = "dealEvent", at = @At("TAIL"), remap = false)
    public void dealEvent(PlayerPatch<?> playerpatch, HurtEvent.Pre event, boolean advanced, CallbackInfo ci)
    {
        if (advanced && !playerpatch.isLogicalClient())
        {
            //Increment stat
            ((ServerPlayerPatch)playerpatch).getOriginal().awardStat(BattleArtsStats.PARRIES, 1);
            //Do something with this
            int test = ((ServerPlayerPatch)playerpatch).getOriginal().getStats().getValue(Stats.CUSTOM.get(BattleArtsStats.PARRIES));
        }
    }
}
