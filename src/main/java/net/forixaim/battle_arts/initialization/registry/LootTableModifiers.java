package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.SkillLootTableRegistryEvent;
import yesman.epicfight.data.loot.function.SetSkillFunction;
import yesman.epicfight.world.item.EpicFightItems;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootTableModifiers
{
    @SubscribeEvent
    public static void onModifyLootTable(SkillLootTableRegistryEvent event)
    {
        event.add(EntityType.ZOMBIE, LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                .add(LootItem.lootTableItem(EpicFightItems.SKILLBOOK.get()).apply(
                        SetSkillFunction.builder(1.0f, "battle_arts:squire")
                )));
        event.add(EntityType.SKELETON, LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                .add(LootItem.lootTableItem(EpicFightItems.SKILLBOOK.get()).apply(
                        SetSkillFunction.builder(1.0f, "battle_arts:recruit")
                )));
        event.add(EntityType.CREEPER, LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                .add(LootItem.lootTableItem(EpicFightItems.SKILLBOOK.get()).apply(
                        SetSkillFunction.builder(1.0f, "battle_arts:journeyman")
                )));
        event.add(EntityType.SPIDER, LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(0.05f))
                .add(LootItem.lootTableItem(EpicFightItems.SKILLBOOK.get()).apply(
                        SetSkillFunction.builder(1.0f, "battle_arts:ronin")
                ))
                .add(LootItem.lootTableItem(EpicFightItems.SKILLBOOK.get()).apply(
                        SetSkillFunction.builder(1.0f, "battle_arts:tranquility_unleash")
                )));
    }
}
