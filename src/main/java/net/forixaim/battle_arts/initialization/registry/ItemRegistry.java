package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.items.DogeyItem;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.*;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.*;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.LongbowItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.world.item.*;


public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, BattleArts.MOD_ID);

	//Sabres
	public static final DeferredHolder<Item, Item> WOODEN_SABRE = ITEMS.register("wooden_sabre", () -> new SabreItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_SABRE = ITEMS.register("stone_sabre", () -> new SabreItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_SABRE = ITEMS.register("iron_sabre", () -> new SabreItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_SABRE = ITEMS.register("golden_sabre", () -> new SabreItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_SABRE = ITEMS.register("diamond_sabre", () -> new SabreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_SABRE = ITEMS.register("netherite_sabre", () -> new SabreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Battleaxes
	public static final DeferredHolder<Item, Item> WOODEN_BATTLEAXE = ITEMS.register("wooden_battleaxe", () -> new BattleaxeItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_BATTLEAXE = ITEMS.register("stone_battleaxe", () -> new BattleaxeItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_BATTLEAXE = ITEMS.register("iron_battleaxe", () -> new BattleaxeItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_BATTLEAXE = ITEMS.register("golden_battleaxe", () -> new BattleaxeItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_BATTLEAXE = ITEMS.register("diamond_battleaxe", () -> new BattleaxeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_BATTLEAXE = ITEMS.register("netherite_battleaxe", () -> new BattleaxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Claymores
	public static final DeferredHolder<Item, Item> WOODEN_CLAYMORE = ITEMS.register("wooden_claymore", () -> new ClaymoreItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_CLAYMORE = ITEMS.register("stone_claymore", () -> new ClaymoreItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_CLAYMORE = ITEMS.register("iron_claymore", () -> new ClaymoreItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_CLAYMORE = ITEMS.register("golden_claymore", () -> new ClaymoreItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_CLAYMORE = ITEMS.register("diamond_claymore", () -> new ClaymoreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_CLAYMORE = ITEMS.register("netherite_claymore", () -> new ClaymoreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Guandaos
	public static final DeferredHolder<Item, Item> WOODEN_GUANDAO = ITEMS.register("wooden_guandao", () -> new GuandaoItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_GUANDAO = ITEMS.register("stone_guandao", () -> new GuandaoItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_GUANDAO = ITEMS.register("iron_guandao", () -> new GuandaoItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_GUANDAO = ITEMS.register("golden_guandao", () -> new GuandaoItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_GUANDAO = ITEMS.register("diamond_guandao", () -> new GuandaoItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_GUANDAO = ITEMS.register("netherite_guandao", () -> new GuandaoItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item, Item> LIU_GUANDAO = ITEMS.register("liu_guandao", LiuGuandaoItem::new);

	public static final DeferredHolder<Item, Item> WOODEN_TAIJIAN = ITEMS.register("wooden_taijian", () -> new TaijianItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_TAIJIAN = ITEMS.register("stone_taijian", () -> new TaijianItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_TAIJIAN = ITEMS.register("iron_taijian", () -> new TaijianItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_TAIJIAN = ITEMS.register("golden_taijian", () -> new TaijianItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_TAIJIAN = ITEMS.register("diamond_taijian", () -> new TaijianItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_TAIJIAN = ITEMS.register("netherite_taijian", () -> new TaijianItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item, Item> LIU_TAIJIAN = ITEMS.register("liu_taijian", LiuTaijianItem::new);

	//Bayonets
	public static final DeferredHolder<Item, Item> WOODEN_BAYONET = ITEMS.register("wooden_bayonet", () -> new BayonetItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_BAYONET = ITEMS.register("stone_bayonet", () -> new BayonetItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_BAYONET = ITEMS.register("iron_bayonet", () -> new BayonetItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_BAYONET = ITEMS.register("golden_bayonet", () -> new BayonetItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_BAYONET = ITEMS.register("diamond_bayonet", () -> new BayonetItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_BAYONET = ITEMS.register("netherite_bayonet", () -> new BayonetItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Rapiers
	public static final DeferredHolder<Item, Item> WOODEN_RAPIER = ITEMS.register("wooden_rapier", () -> new RapierItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_RAPIER = ITEMS.register("stone_rapier", () -> new RapierItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_RAPIER = ITEMS.register("iron_rapier", () -> new RapierItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_RAPIER = ITEMS.register("golden_rapier", () -> new RapierItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_RAPIER = ITEMS.register("diamond_rapier", () -> new RapierItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_RAPIER = ITEMS.register("netherite_rapier", () -> new RapierItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

    //Viking Axes
    public static final DeferredHolder<Item, Item> WOODEN_VIKING_AXE = ITEMS.register("wooden_viking_axe", () -> new VikingAxeItem(Tiers.WOOD, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STONE_VIKING_AXE = ITEMS.register("stone_viking_axe", () -> new VikingAxeItem(Tiers.STONE, new Item.Properties()));
    public static final DeferredHolder<Item, Item> IRON_VIKING_AXE = ITEMS.register("iron_viking_axe", () -> new VikingAxeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredHolder<Item, Item> GOLDEN_VIKING_AXE = ITEMS.register("golden_viking_axe", () -> new VikingAxeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredHolder<Item, Item> DIAMOND_VIKING_AXE = ITEMS.register("diamond_viking_axe", () -> new VikingAxeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredHolder<Item, Item> NETHERITE_VIKING_AXE = ITEMS.register("netherite_viking_axe", () -> new VikingAxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Dories
	public static final DeferredHolder<Item, Item> WOODEN_DORY = ITEMS.register("wooden_dory", () -> new DoryItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_DORY = ITEMS.register("stone_dory", () -> new DoryItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_DORY = ITEMS.register("iron_dory", () -> new DoryItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_DORY = ITEMS.register("golden_dory", () -> new DoryItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_DORY = ITEMS.register("diamond_dory", () -> new DoryItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_DORY = ITEMS.register("netherite_dory", () -> new DoryItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Special
	public static final DeferredHolder<Item, Item> EXALTED_FALCHION = ITEMS.register("exalted_falchion", ExaltedFalchionItem::new);
	public static final DeferredHolder<Item, Item> VALENTIAN_FALCHION = ITEMS.register("valentian_falchion", ValentianFalchionItem::new);
	public static final DeferredHolder<Item, Item> PARALLEL_FALCHION = ITEMS.register("parallel_falchion", ParallelFalchionItem::new);
	public static final DeferredHolder<Item, Item> YLISSEAN_FALCHION = ITEMS.register("ylissean_falchion", ValentianFalchionItem::new);
	public static final DeferredHolder<Item, Item> BINDING_BLADE = ITEMS.register("binding_blade", BindingBladeItem::new);
    public static final DeferredHolder<Item, Item> SILVER_HALBERD = ITEMS.register("the_silver_halberd", TheSilverHalberdItem::new);
    public static final DeferredHolder<Item, Item> ERDRICKS_SWORD = ITEMS.register("erdricks_sword", ErdricksSwordItem::new);
    public static final DeferredHolder<Item, Item> ERDRICKS_SHIELD = ITEMS.register("erdricks_shield", ErdricksShieldItem::new);



    //Naginatas
	public static final DeferredHolder<Item, Item> WOODEN_NAGINATA = ITEMS.register("wooden_naginata", () -> new NaginataItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_NAGINATA = ITEMS.register("stone_naginata", () -> new NaginataItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_NAGINATA = ITEMS.register("iron_naginata", () -> new NaginataItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_NAGINATA = ITEMS.register("golden_naginata", () -> new NaginataItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_NAGINATA = ITEMS.register("diamond_naginata", () -> new NaginataItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_NAGINATA = ITEMS.register("netherite_naginata", () -> new NaginataItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Halberds
	public static final DeferredHolder<Item, Item> WOODEN_HALBERD = ITEMS.register("wooden_halberd", () -> new HalberdItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_HALBERD = ITEMS.register("stone_halberd", () -> new HalberdItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_HALBERD = ITEMS.register("iron_halberd", () -> new HalberdItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_HALBERD = ITEMS.register("golden_halberd", () -> new HalberdItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd", () -> new HalberdItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_HALBERD = ITEMS.register("netherite_halberd", () -> new HalberdItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Pikes
	public static final DeferredHolder<Item, Item> WOODEN_PIKE = ITEMS.register("wooden_pike", () -> new PikeItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_PIKE = ITEMS.register("stone_pike", () -> new PikeItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_PIKE = ITEMS.register("iron_pike", () -> new PikeItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_PIKE = ITEMS.register("golden_pike", () -> new PikeItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_PIKE = ITEMS.register("diamond_pike", () -> new PikeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_PIKE = ITEMS.register("netherite_pike", () -> new PikeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Longbow
	public static final DeferredHolder<Item, Item> WOODEN_LONGBOW = ITEMS.register("wooden_longbow", () -> new LongbowItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_LONGBOW = ITEMS.register("stone_longbow", () -> new LongbowItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_LONGBOW = ITEMS.register("iron_longbow", () -> new LongbowItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_LONGBOW = ITEMS.register("golden_longbow", () -> new LongbowItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_LONGBOW = ITEMS.register("diamond_longbow", () -> new LongbowItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_LONGBOW = ITEMS.register("netherite_longbow", () -> new LongbowItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Gloves and Gauntlets
	public static final DeferredHolder<Item, Item> LIU_GLOVE = ITEMS.register("liu_glove", LiuGloveItem::new);

    //Steel weapons for PvP
    public static final DeferredHolder<Item, Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SteelWeaponItem(new Item.Properties().attributes(SteelWeaponItem.createSwordAttributes())));
    public static final DeferredHolder<Item, Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new SteelWeaponItem(new Item.Properties().attributes(SteelWeaponItem.createAxeAttributes())));
    public static final DeferredHolder<Item, Item> STEEL_LONGBOW = ITEMS.register("steel_longbow", () -> new LongbowItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_PIKE = ITEMS.register("steel_pike", () -> new PikeItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_BATTLEAXE = ITEMS.register("steel_battleaxe", () -> new BattleaxeItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_HALBERD = ITEMS.register("steel_halberd", () -> new HalberdItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_NAGINATA = ITEMS.register("steel_naginata", () -> new NaginataItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_DORY = ITEMS.register("steel_dory", () -> new DoryItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_VIKING_AXE = ITEMS.register("steel_viking_axe", () -> new VikingAxeItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_RAPIER = ITEMS.register("steel_rapier", () -> new RapierItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_TAIJIAN = ITEMS.register("steel_taijian", () -> new TaijianItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_GUANDAO = ITEMS.register("steel_guandao", () -> new GuandaoItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_CLAYMORE = ITEMS.register("steel_claymore", () -> new ClaymoreItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_SABRE = ITEMS.register("steel_sabre", () -> new SabreItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_DAGGER = ITEMS.register("steel_dagger", () -> new DaggerItem(SpecialTiers.STEEL, new Item.Properties().attributes(DaggerItem.createDaggerAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_LONGSWORD = ITEMS.register("steel_longsword", () -> new LongswordItem(SpecialTiers.STEEL, new Item.Properties().attributes(LongswordItem.createLongswordAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_GREATSWORD = ITEMS.register("steel_greatsword", () -> new GreatswordItem(SpecialTiers.STEEL, new Item.Properties().attributes(GreatswordItem.createGreatswordAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_SPEAR = ITEMS.register("steel_spear", () -> new SpearItem(SpecialTiers.STEEL, new Item.Properties().attributes(SpearItem.createSpearAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_TACHI = ITEMS.register("steel_tachi", () -> new TachiItem(SpecialTiers.STEEL, new Item.Properties().attributes(TachiItem.createTachiAttributes(SpecialTiers.STEEL))));



    //Misc
	public static final DeferredHolder<Item, Item> TACHI_SHEATH = ITEMS.register("tachi_sheath", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> DOGEY = ITEMS.register("dogey", () -> new DogeyItem(BlockRegistry.DOGEY.get(),  new Item.Properties().fireResistant()));
}
