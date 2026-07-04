package net.forixaim.battle_arts.core_assets.world.entities;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.registry.entries.EpicFightItems;

public class TestEuclidiaEntity extends Zombie
{

    public TestEuclidiaEntity(EntityType<? extends Zombie> entityType, Level level)
    {
        super(entityType, level);
    }

    public TestEuclidiaEntity(Level level)
    {
        super(level);
    }


    @Override
    protected void registerGoals()
    {
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData)
    {
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(EpicFightItems.IRON_LONGSWORD));
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Zombie.createAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

}
