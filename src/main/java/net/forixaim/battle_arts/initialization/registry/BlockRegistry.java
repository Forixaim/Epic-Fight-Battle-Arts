package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EpicFightBattleArts.MOD_ID);

    public static final RegistryObject<Block> DOGEY = BLOCKS.register("dogey", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).noOcclusion()));

}
