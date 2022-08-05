package net.twilightdelight.common.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.StoveBlockEntity;

/**
 * @author Goulixiaoji
 */
public class MazeStoveTileEntity extends StoveBlockEntity {
    private static final int NUM_SLOTS = 8;
    private static final int BURN_COOL_SPEED = 2;
    private final NonNullList<ItemStack> items = NonNullList.withSize(8, ItemStack.EMPTY);
    private final int[] cookingProgress = new int[8];
    private final int[] cookingTime = new int[4];

    public MazeStoveTileEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }
}
