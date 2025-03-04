package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.items.weapons.normal.BattleaxeItem;
import net.forixaim.battle_arts.core_assets.items.weapons.normal.SabreItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.world.item.DaggerItem;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EpicFightBattleArts.MOD_ID);

	//Sabres
	public static final RegistryObject<Item> IRON_SABRE = ITEMS.register("iron_sabre", () -> new SabreItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_SABRE = ITEMS.register("golden_sabre", () -> new SabreItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_SABRE = ITEMS.register("diamond_sabre", () -> new SabreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_SABRE = ITEMS.register("netherite_sabre", () -> new SabreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Battleaxes
	public static final RegistryObject<Item> IRON_BATTLEAXE = ITEMS.register("iron_battleaxe", () -> new BattleaxeItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_BATTLEAXE = ITEMS.register("golden_battleaxe", () -> new BattleaxeItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_BATTLEAXE = ITEMS.register("diamond_battleaxe", () -> new BattleaxeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_BATTLEAXE = ITEMS.register("netherite_battleaxe", () -> new BattleaxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Misc
	public static final RegistryObject<Item> TACHI_SHEATH = ITEMS.register("tachi_sheath", () -> new Item(new Item.Properties()));
}
