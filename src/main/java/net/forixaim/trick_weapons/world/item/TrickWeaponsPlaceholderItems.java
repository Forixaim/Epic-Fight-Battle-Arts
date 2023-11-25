package net.forixaim.trick_weapons.world.item;

import net.forixaim.trick_weapons.TrickWeapons;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.world.item.DaggerItem;
import yesman.epicfight.world.item.LongswordItem;

/**
 * The registry of placeholder items
 */
public class TrickWeaponsPlaceholderItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TrickWeapons.MOD_ID);
	/**
	 * Adds a placeholder chakram item mainly to test.
	 */
	//public static final RegistryObject<Item> wIron_Chakram = ITEMS.register("placeholder_chakram", () -> new DaggerItem(new Item.Properties(), Tiers.IRON));
	public static final RegistryObject<Item> Placeholder_Rapier = ITEMS.register("placeholder_rapier", () -> new SwordItem(Tiers.NETHERITE,1, -3.5f, new Item.Properties()));
	public static final RegistryObject<Item> Joyeuse = ITEMS.register("joyeuse", () -> new SwordItem(Tiers.NETHERITE,12, -3f, new Item.Properties()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}