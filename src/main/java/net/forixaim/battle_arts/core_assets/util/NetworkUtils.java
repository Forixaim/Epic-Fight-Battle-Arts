package net.forixaim.battle_arts.core_assets.util;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import yesman.epicfight.network.EpicFightNetworkManager;
import yesman.epicfight.network.server.SPChangeSkill;
import yesman.epicfight.network.server.SPSetRemotePlayerSkill;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillSlot;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

import javax.annotation.Nullable;

public class NetworkUtils
{
    public static void syncPlayer(Player player, EpicFightNetworkManager.PayloadBundleBuilder localBundle, EpicFightNetworkManager.PayloadBundleBuilder serverBundle)
    {

        if (player.level().isClientSide() && Minecraft.getInstance().getConnection() == null)
        {
            return;
        }
        if (player instanceof ServerPlayer sp && sp.connection != null)
        {
            localBundle.send((first, others) -> EpicFightNetworkManager.sendToPlayer(first, (ServerPlayer) player, others));
            serverBundle.send((first, others) -> EpicFightNetworkManager.sendToAllPlayerTrackingThisEntity(first, player, others));
        }
    }

    public static void changeSkill(PlayerPatch<? extends Player> playerPatch, SkillSlot slot, @Nullable Skill skill)
    {
        if (skill != null && slot.category() != skill.getCategory())
            return;
        EpicFightNetworkManager.PayloadBundleBuilder toLocal = EpicFightNetworkManager.PayloadBundleBuilder.create();
        EpicFightNetworkManager.PayloadBundleBuilder toRemote = EpicFightNetworkManager.PayloadBundleBuilder.create();
        toLocal.and(new SPChangeSkill(slot, playerPatch.getOriginal().getId(), skill));
        toRemote.and(new SPSetRemotePlayerSkill(playerPatch.getOriginal().getId(), slot, skill));
        NetworkUtils.syncPlayer(playerPatch.getOriginal(), toLocal, toRemote);
        playerPatch.getSkill(slot).setSkill(skill);

    }
}
