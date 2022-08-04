package net.twilightdelight.init;

import com.mojang.datafixers.types.Type;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twilightdelight.TwilightDelight;
import net.twilightdelight.common.tileentity.MazeStoveTileEntity;

/**
 * @author Goulixiaoji
 */
public class BlockTileEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TwilightDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<MazeStoveTileEntity>> MAZE_STOVE_TILEENTITY;

    static{
        MAZE_STOVE_TILEENTITY = REGISTER.register("maze_stove", ()->{
            return BlockEntityType.Builder.of(MazeStoveTileEntity::new, BlockInit.MAZE_STOVE.get()).build((Type<?>) null);
        });
    }
}
