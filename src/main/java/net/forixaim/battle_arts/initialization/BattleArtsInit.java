package net.forixaim.battle_arts.initialization;

import com.google.common.collect.Lists;
import net.forixaim.battle_arts.initialization.registry.*;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class BattleArtsInit
{
    public static List<DeferredRegister<?>> REGISTERS = Lists.newArrayList(
            BattleArtsBlocks.REGISTRY,
            BattleArtsConditionals.REGISTRY,
            BattleArtsItems.REGISTRY,
            BattleArtsCreativeTabs.REGISTRY,
            BattleArtsMovesets.REGISTRY,
            BattleArtsItemCapabilityPresets.REGISTRY,
            BattleArtsWeaponModifiers.REGISTRY,
            BattleArtsSounds.REGISTRY,
            BattleArtsSkills.REGISTRY,
            BattleArtsParticles.REGISTRY,
            BattleArtsDataKeys.REGISTRY,
            BattleArtsProjectiles.REGISTRY,
            BattleArtsWeaponData.REGISTRY
    );


}
