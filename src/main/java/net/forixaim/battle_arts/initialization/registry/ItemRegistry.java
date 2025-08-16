package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.*;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.*;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.LongbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EpicFightBattleArts.MOD_ID);

	//Sabres
	public static final RegistryObject<Item> WOODEN_SABRE = ITEMS.register("wooden_sabre", () -> new SabreItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_SABRE = ITEMS.register("stone_sabre", () -> new SabreItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_SABRE = ITEMS.register("iron_sabre", () -> new SabreItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_SABRE = ITEMS.register("golden_sabre", () -> new SabreItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_SABRE = ITEMS.register("diamond_sabre", () -> new SabreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_SABRE = ITEMS.register("netherite_sabre", () -> new SabreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Battleaxes
	public static final RegistryObject<Item> WOODEN_BATTLEAXE = ITEMS.register("wooden_battleaxe", () -> new BattleaxeItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_BATTLEAXE = ITEMS.register("stone_battleaxe", () -> new BattleaxeItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_BATTLEAXE = ITEMS.register("iron_battleaxe", () -> new BattleaxeItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_BATTLEAXE = ITEMS.register("golden_battleaxe", () -> new BattleaxeItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_BATTLEAXE = ITEMS.register("diamond_battleaxe", () -> new BattleaxeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_BATTLEAXE = ITEMS.register("netherite_battleaxe", () -> new BattleaxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Claymores
	public static final RegistryObject<Item> WOODEN_CLAYMORE = ITEMS.register("wooden_claymore", () -> new ClaymoreItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_CLAYMORE = ITEMS.register("stone_claymore", () -> new ClaymoreItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_CLAYMORE = ITEMS.register("iron_claymore", () -> new ClaymoreItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_CLAYMORE = ITEMS.register("golden_claymore", () -> new ClaymoreItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_CLAYMORE = ITEMS.register("diamond_claymore", () -> new ClaymoreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_CLAYMORE = ITEMS.register("netherite_claymore", () -> new ClaymoreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Guandaos
	public static final RegistryObject<Item> WOODEN_GUANDAO = ITEMS.register("wooden_guandao", () -> new GuandaoItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_GUANDAO = ITEMS.register("stone_guandao", () -> new GuandaoItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_GUANDAO = ITEMS.register("iron_guandao", () -> new GuandaoItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_GUANDAO = ITEMS.register("golden_guandao", () -> new GuandaoItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_GUANDAO = ITEMS.register("diamond_guandao", () -> new GuandaoItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_GUANDAO = ITEMS.register("netherite_guandao", () -> new GuandaoItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> LIU_GUANDAO = ITEMS.register("liu_guandao", LiuGuandaoItem::new);

	public static final RegistryObject<Item> WOODEN_TAIJIAN = ITEMS.register("wooden_taijian", () -> new TaijianItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_TAIJIAN = ITEMS.register("stone_taijian", () -> new TaijianItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_TAIJIAN = ITEMS.register("iron_taijian", () -> new TaijianItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_TAIJIAN = ITEMS.register("golden_taijian", () -> new TaijianItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_TAIJIAN = ITEMS.register("diamond_taijian", () -> new TaijianItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_TAIJIAN = ITEMS.register("netherite_taijian", () -> new TaijianItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> LIU_TAIJIAN = ITEMS.register("liu_taijian", LiuTaijianItem::new);

	//Bayonets
	public static final RegistryObject<Item> WOODEN_BAYONET = ITEMS.register("wooden_bayonet", () -> new BayonetItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_BAYONET = ITEMS.register("stone_bayonet", () -> new BayonetItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_BAYONET = ITEMS.register("iron_bayonet", () -> new BayonetItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_BAYONET = ITEMS.register("golden_bayonet", () -> new BayonetItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_BAYONET = ITEMS.register("diamond_bayonet", () -> new BayonetItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_BAYONET = ITEMS.register("netherite_bayonet", () -> new BayonetItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Rapiers
	public static final RegistryObject<Item> WOODEN_RAPIER = ITEMS.register("wooden_rapier", () -> new RapierItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_RAPIER = ITEMS.register("stone_rapier", () -> new RapierItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_RAPIER = ITEMS.register("iron_rapier", () -> new RapierItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_RAPIER = ITEMS.register("golden_rapier", () -> new RapierItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_RAPIER = ITEMS.register("diamond_rapier", () -> new RapierItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_RAPIER = ITEMS.register("netherite_rapier", () -> new RapierItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Dories
	public static final RegistryObject<Item> WOODEN_DORY = ITEMS.register("wooden_dory", () -> new DoryItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_DORY = ITEMS.register("stone_dory", () -> new DoryItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_DORY = ITEMS.register("iron_dory", () -> new DoryItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_DORY = ITEMS.register("golden_dory", () -> new DoryItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_DORY = ITEMS.register("diamond_dory", () -> new DoryItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_DORY = ITEMS.register("netherite_dory", () -> new DoryItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Special
	public static final RegistryObject<Item> EXALTED_FALCHION = ITEMS.register("exalted_falchion", ExaltedFalchionItem::new);
	public static final RegistryObject<Item> VALENTIAN_FALCHION = ITEMS.register("valentian_falchion", ValentianFalchionItem::new);
	public static final RegistryObject<Item> PARALLEL_FALCHION = ITEMS.register("parallel_falchion", ParallelFalchionItem::new);
	public static final RegistryObject<Item> YLISSEAN_FALCHION = ITEMS.register("ylissean_falchion", ValentianFalchionItem::new);
	public static final RegistryObject<Item> BINDING_BLADE = ITEMS.register("binding_blade", BindingBladeItem::new);

	//Naginatas
	public static final RegistryObject<Item> WOODEN_NAGINATA = ITEMS.register("wooden_naginata", () -> new NaginataItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_NAGINATA = ITEMS.register("stone_naginata", () -> new NaginataItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_NAGINATA = ITEMS.register("iron_naginata", () -> new NaginataItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_NAGINATA = ITEMS.register("golden_naginata", () -> new NaginataItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_NAGINATA = ITEMS.register("diamond_naginata", () -> new NaginataItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_NAGINATA = ITEMS.register("netherite_naginata", () -> new NaginataItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Halberds
	public static final RegistryObject<Item> WOODEN_HALBERD = ITEMS.register("wooden_halberd", () -> new HalberdItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_HALBERD = ITEMS.register("stone_halberd", () -> new HalberdItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_HALBERD = ITEMS.register("iron_halberd", () -> new HalberdItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_HALBERD = ITEMS.register("golden_halberd", () -> new HalberdItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd", () -> new HalberdItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_HALBERD = ITEMS.register("netherite_halberd", () -> new HalberdItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Pikes
	public static final RegistryObject<Item> WOODEN_PIKE = ITEMS.register("wooden_pike", () -> new PikeItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_PIKE = ITEMS.register("stone_pike", () -> new PikeItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_PIKE = ITEMS.register("iron_pike", () -> new PikeItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_PIKE = ITEMS.register("golden_pike", () -> new PikeItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_PIKE = ITEMS.register("diamond_pike", () -> new PikeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_PIKE = ITEMS.register("netherite_pike", () -> new PikeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Longbow
	public static final RegistryObject<Item> WOODEN_LONGBOW = ITEMS.register("wooden_longbow", () -> new LongbowItem(Tiers.WOOD, new Item.Properties()));
	public static final RegistryObject<Item> STONE_LONGBOW = ITEMS.register("stone_longbow", () -> new LongbowItem(Tiers.STONE, new Item.Properties()));
	public static final RegistryObject<Item> IRON_LONGBOW = ITEMS.register("iron_longbow", () -> new LongbowItem(Tiers.IRON, new Item.Properties()));
	public static final RegistryObject<Item> GOLDEN_LONGBOW = ITEMS.register("golden_longbow", () -> new LongbowItem(Tiers.GOLD, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_LONGBOW = ITEMS.register("diamond_longbow", () -> new LongbowItem(Tiers.DIAMOND, new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_LONGBOW = ITEMS.register("netherite_longbow", () -> new LongbowItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Gloves and Gauntlets
	public static final RegistryObject<Item> LIU_GLOVE = ITEMS.register("liu_glove", LiuGloveItem::new);


	//Misc
	public static final RegistryObject<Item> TACHI_SHEATH = ITEMS.register("tachi_sheath", () -> new Item(new Item.Properties()));
}
