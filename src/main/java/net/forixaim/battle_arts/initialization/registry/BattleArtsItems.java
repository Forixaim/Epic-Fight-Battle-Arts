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


public final class BattleArtsItems
{
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, BattleArts.MOD_ID);

	//Sabres
	public static final DeferredHolder<Item, Item> WOODEN_SABRE = REGISTRY.register("wooden_sabre", () -> new SabreItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_SABRE = REGISTRY.register("stone_sabre", () -> new SabreItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_SABRE = REGISTRY.register("iron_sabre", () -> new SabreItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_SABRE = REGISTRY.register("golden_sabre", () -> new SabreItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_SABRE = REGISTRY.register("diamond_sabre", () -> new SabreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_SABRE = REGISTRY.register("netherite_sabre", () -> new SabreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Battleaxes
	public static final DeferredHolder<Item, Item> WOODEN_BATTLEAXE = REGISTRY.register("wooden_battleaxe", () -> new BattleaxeItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_BATTLEAXE = REGISTRY.register("stone_battleaxe", () -> new BattleaxeItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_BATTLEAXE = REGISTRY.register("iron_battleaxe", () -> new BattleaxeItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_BATTLEAXE = REGISTRY.register("golden_battleaxe", () -> new BattleaxeItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_BATTLEAXE = REGISTRY.register("diamond_battleaxe", () -> new BattleaxeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_BATTLEAXE = REGISTRY.register("netherite_battleaxe", () -> new BattleaxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Claymores
	public static final DeferredHolder<Item, Item> WOODEN_CLAYMORE = REGISTRY.register("wooden_claymore", () -> new ClaymoreItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_CLAYMORE = REGISTRY.register("stone_claymore", () -> new ClaymoreItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_CLAYMORE = REGISTRY.register("iron_claymore", () -> new ClaymoreItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_CLAYMORE = REGISTRY.register("golden_claymore", () -> new ClaymoreItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_CLAYMORE = REGISTRY.register("diamond_claymore", () -> new ClaymoreItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_CLAYMORE = REGISTRY.register("netherite_claymore", () -> new ClaymoreItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Guandaos
	public static final DeferredHolder<Item, Item> WOODEN_GUANDAO = REGISTRY.register("wooden_guandao", () -> new GuandaoItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_GUANDAO = REGISTRY.register("stone_guandao", () -> new GuandaoItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_GUANDAO = REGISTRY.register("iron_guandao", () -> new GuandaoItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_GUANDAO = REGISTRY.register("golden_guandao", () -> new GuandaoItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_GUANDAO = REGISTRY.register("diamond_guandao", () -> new GuandaoItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_GUANDAO = REGISTRY.register("netherite_guandao", () -> new GuandaoItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item, Item> LIU_GUANDAO = REGISTRY.register("liu_guandao", LiuGuandaoItem::new);

	public static final DeferredHolder<Item, Item> WOODEN_TAIJIAN = REGISTRY.register("wooden_taijian", () -> new TaijianItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_TAIJIAN = REGISTRY.register("stone_taijian", () -> new TaijianItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_TAIJIAN = REGISTRY.register("iron_taijian", () -> new TaijianItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_TAIJIAN = REGISTRY.register("golden_taijian", () -> new TaijianItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_TAIJIAN = REGISTRY.register("diamond_taijian", () -> new TaijianItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_TAIJIAN = REGISTRY.register("netherite_taijian", () -> new TaijianItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item, Item> LIU_TAIJIAN = REGISTRY.register("liu_taijian", LiuTaijianItem::new);

	//Bayonets
	public static final DeferredHolder<Item, Item> WOODEN_BAYONET = REGISTRY.register("wooden_bayonet", () -> new BayonetItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_BAYONET = REGISTRY.register("stone_bayonet", () -> new BayonetItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_BAYONET = REGISTRY.register("iron_bayonet", () -> new BayonetItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_BAYONET = REGISTRY.register("golden_bayonet", () -> new BayonetItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_BAYONET = REGISTRY.register("diamond_bayonet", () -> new BayonetItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_BAYONET = REGISTRY.register("netherite_bayonet", () -> new BayonetItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Rapiers
	public static final DeferredHolder<Item, Item> WOODEN_RAPIER = REGISTRY.register("wooden_rapier", () -> new RapierItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_RAPIER = REGISTRY.register("stone_rapier", () -> new RapierItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_RAPIER = REGISTRY.register("iron_rapier", () -> new RapierItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_RAPIER = REGISTRY.register("golden_rapier", () -> new RapierItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_RAPIER = REGISTRY.register("diamond_rapier", () -> new RapierItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_RAPIER = REGISTRY.register("netherite_rapier", () -> new RapierItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

    //Viking Axes
    public static final DeferredHolder<Item, Item> WOODEN_VIKING_AXE = REGISTRY.register("wooden_viking_axe", () -> new VikingAxeItem(Tiers.WOOD, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STONE_VIKING_AXE = REGISTRY.register("stone_viking_axe", () -> new VikingAxeItem(Tiers.STONE, new Item.Properties()));
    public static final DeferredHolder<Item, Item> IRON_VIKING_AXE = REGISTRY.register("iron_viking_axe", () -> new VikingAxeItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredHolder<Item, Item> GOLDEN_VIKING_AXE = REGISTRY.register("golden_viking_axe", () -> new VikingAxeItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredHolder<Item, Item> DIAMOND_VIKING_AXE = REGISTRY.register("diamond_viking_axe", () -> new VikingAxeItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredHolder<Item, Item> NETHERITE_VIKING_AXE = REGISTRY.register("netherite_viking_axe", () -> new VikingAxeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Dories
	public static final DeferredHolder<Item, Item> WOODEN_DORY = REGISTRY.register("wooden_dory", () -> new DoryItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_DORY = REGISTRY.register("stone_dory", () -> new DoryItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_DORY = REGISTRY.register("iron_dory", () -> new DoryItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_DORY = REGISTRY.register("golden_dory", () -> new DoryItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_DORY = REGISTRY.register("diamond_dory", () -> new DoryItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_DORY = REGISTRY.register("netherite_dory", () -> new DoryItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Special
	public static final DeferredHolder<Item, Item> EXALTED_FALCHION = REGISTRY.register("exalted_falchion", ExaltedFalchionItem::new);
	public static final DeferredHolder<Item, Item> VALENTIAN_FALCHION = REGISTRY.register("valentian_falchion", ValentianFalchionItem::new);
	public static final DeferredHolder<Item, Item> PARALLEL_FALCHION = REGISTRY.register("parallel_falchion", ParallelFalchionItem::new);
	public static final DeferredHolder<Item, Item> YLISSEAN_FALCHION = REGISTRY.register("ylissean_falchion", ValentianFalchionItem::new);
	public static final DeferredHolder<Item, Item> BINDING_BLADE = REGISTRY.register("binding_blade", BindingBladeItem::new);
    public static final DeferredHolder<Item, Item> SILVER_HALBERD = REGISTRY.register("the_silver_halberd", TheSilverHalberdItem::new);
    public static final DeferredHolder<Item, Item> ERDRICKS_SWORD = REGISTRY.register("erdricks_sword", ErdricksSwordItem::new);
	public static final DeferredHolder<Item, Item> ERDRICKS_SHIELD = REGISTRY.register("erdricks_shield", ErdricksShieldItem::new);
	public static final DeferredHolder<Item, Item> DRAGOVIAN_KING_SWORD = REGISTRY.register("dragovian_king_sword", ErdricksSwordItem::new);
	public static final DeferredHolder<Item, Enki> ENKI = REGISTRY.register("enki", Enki::new);



    //Naginatas
	public static final DeferredHolder<Item, Item> WOODEN_NAGINATA = REGISTRY.register("wooden_naginata", () -> new NaginataItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_NAGINATA = REGISTRY.register("stone_naginata", () -> new NaginataItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_NAGINATA = REGISTRY.register("iron_naginata", () -> new NaginataItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_NAGINATA = REGISTRY.register("golden_naginata", () -> new NaginataItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_NAGINATA = REGISTRY.register("diamond_naginata", () -> new NaginataItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_NAGINATA = REGISTRY.register("netherite_naginata", () -> new NaginataItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Halberds
	public static final DeferredHolder<Item, Item> WOODEN_HALBERD = REGISTRY.register("wooden_halberd", () -> new HalberdItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_HALBERD = REGISTRY.register("stone_halberd", () -> new HalberdItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_HALBERD = REGISTRY.register("iron_halberd", () -> new HalberdItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_HALBERD = REGISTRY.register("golden_halberd", () -> new HalberdItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_HALBERD = REGISTRY.register("diamond_halberd", () -> new HalberdItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_HALBERD = REGISTRY.register("netherite_halberd", () -> new HalberdItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Pikes
	public static final DeferredHolder<Item, Item> WOODEN_PIKE = REGISTRY.register("wooden_pike", () -> new PikeItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_PIKE = REGISTRY.register("stone_pike", () -> new PikeItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_PIKE = REGISTRY.register("iron_pike", () -> new PikeItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_PIKE = REGISTRY.register("golden_pike", () -> new PikeItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_PIKE = REGISTRY.register("diamond_pike", () -> new PikeItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_PIKE = REGISTRY.register("netherite_pike", () -> new PikeItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Longbow
	public static final DeferredHolder<Item, Item> WOODEN_LONGBOW = REGISTRY.register("wooden_longbow", () -> new LongbowItem(Tiers.WOOD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> STONE_LONGBOW = REGISTRY.register("stone_longbow", () -> new LongbowItem(Tiers.STONE, new Item.Properties()));
	public static final DeferredHolder<Item, Item> IRON_LONGBOW = REGISTRY.register("iron_longbow", () -> new LongbowItem(Tiers.IRON, new Item.Properties()));
	public static final DeferredHolder<Item, Item> GOLDEN_LONGBOW = REGISTRY.register("golden_longbow", () -> new LongbowItem(Tiers.GOLD, new Item.Properties()));
	public static final DeferredHolder<Item, Item> DIAMOND_LONGBOW = REGISTRY.register("diamond_longbow", () -> new LongbowItem(Tiers.DIAMOND, new Item.Properties()));
	public static final DeferredHolder<Item, Item> NETHERITE_LONGBOW = REGISTRY.register("netherite_longbow", () -> new LongbowItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));

	//Gloves and Gauntlets
	public static final DeferredHolder<Item, Item> LIU_GLOVE = REGISTRY.register("liu_glove", LiuGloveItem::new);

    //Steel weapons for PvP
    public static final DeferredHolder<Item, Item> STEEL_SWORD = REGISTRY.register("steel_sword", () -> new SteelWeaponItem(new Item.Properties().attributes(SteelWeaponItem.createSwordAttributes())));
    public static final DeferredHolder<Item, Item> STEEL_AXE = REGISTRY.register("steel_axe", () -> new SteelWeaponItem(new Item.Properties().attributes(SteelWeaponItem.createAxeAttributes())));
    public static final DeferredHolder<Item, Item> STEEL_LONGBOW = REGISTRY.register("steel_longbow", () -> new LongbowItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_PIKE = REGISTRY.register("steel_pike", () -> new PikeItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_BATTLEAXE = REGISTRY.register("steel_battleaxe", () -> new BattleaxeItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_HALBERD = REGISTRY.register("steel_halberd", () -> new HalberdItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_NAGINATA = REGISTRY.register("steel_naginata", () -> new NaginataItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_DORY = REGISTRY.register("steel_dory", () -> new DoryItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_VIKING_AXE = REGISTRY.register("steel_viking_axe", () -> new VikingAxeItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_RAPIER = REGISTRY.register("steel_rapier", () -> new RapierItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_TAIJIAN = REGISTRY.register("steel_taijian", () -> new TaijianItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_GUANDAO = REGISTRY.register("steel_guandao", () -> new GuandaoItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_CLAYMORE = REGISTRY.register("steel_claymore", () -> new ClaymoreItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_SABRE = REGISTRY.register("steel_sabre", () -> new SabreItem(SpecialTiers.STEEL, new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_DAGGER = REGISTRY.register("steel_dagger", () -> new DaggerItem(SpecialTiers.STEEL, new Item.Properties().attributes(DaggerItem.createDaggerAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_LONGSWORD = REGISTRY.register("steel_longsword", () -> new LongswordItem(SpecialTiers.STEEL, new Item.Properties().attributes(LongswordItem.createLongswordAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_GREATSWORD = REGISTRY.register("steel_greatsword", () -> new GreatswordItem(SpecialTiers.STEEL, new Item.Properties().attributes(GreatswordItem.createGreatswordAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_SPEAR = REGISTRY.register("steel_spear", () -> new SpearItem(SpecialTiers.STEEL, new Item.Properties().attributes(SpearItem.createSpearAttributes(SpecialTiers.STEEL))));
    public static final DeferredHolder<Item, Item> STEEL_TACHI = REGISTRY.register("steel_tachi", () -> new TachiItem(SpecialTiers.STEEL, new Item.Properties().attributes(TachiItem.createTachiAttributes(SpecialTiers.STEEL))));



    //Misc
	public static final DeferredHolder<Item, Item> TACHI_SHEATH = REGISTRY.register("tachi_sheath", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> DOGEY = REGISTRY.register("dogey", () -> new DogeyItem(BattleArtsBlocks.DOGEY.get(),  new Item.Properties().fireResistant()));
}
