package net.twilightdelight.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twilightdelight.TwilightDelight;
import net.twilightdelight.common.block.FierySnakesBlock;
import net.twilightdelight.common.block.LilyChickenBlock;
import vectorwing.farmersdelight.common.block.StoveBlock;

/**
 * @author Goulixiaoji
 */
public class BlockInit {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, TwilightDelight.MOD_ID);

    public static final RegistryObject<StoveBlock> MAZE_STOVE;
    public static final RegistryObject<Block> LILY_CHICKEN;
    public static final RegistryObject<Block> FIERY_SNAKES;

    static {
        MAZE_STOVE = REGISTER.register("maze_stove", ()-> new StoveBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(10f).lightLevel(s -> 15).requiresCorrectToolForDrops()));
        LILY_CHICKEN = REGISTER.register("lily_chicken_block", LilyChickenBlock::new);
        FIERY_SNAKES = REGISTER.register("fiery_snakes_block", FierySnakesBlock::new);
    }
}
