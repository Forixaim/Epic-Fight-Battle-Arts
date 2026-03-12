package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, BattleArts.MOD_ID);

    public static final DeferredHolder<Block, Block> DOGEY = BLOCKS.register("dogey", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).noOcclusion()));

}
