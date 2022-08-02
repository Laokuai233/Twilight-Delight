package net.twilightdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.twilightdelight.init.BlockTileEntityInit;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.StoveBlock;

/**
 * @author Goulixiaoji
 */
public class MazeStove extends StoveBlock implements EntityBlock {

    public MazeStove(Properties builder) {
        super(builder);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ((BlockEntityType) BlockTileEntityInit.MAZE_STOVE_TILEENTITY.get()).create(pos, state);
    }
}
