package net.twilightdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.twilightdelight.init.ItemInit;
import vectorwing.farmersdelight.common.block.FeastBlock;

/**
 * @author Goulixiaoji
 */
public class LilyChickenBlock extends FeastBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape ROAST_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4.0D, 2.0D, 4.0D, 12.0D, 9.0D, 12.0D), BooleanOp.OR);

    public LilyChickenBlock() {
        super(Properties.copy(Blocks.WHITE_WOOL), ItemInit.PLATE_OF_LILY_CHICKEN::get, true);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return (Integer)state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : ROAST_SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        int servings = (Integer)state.getValue(SERVINGS);
        if (servings > 0){
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
        ItemEntity bowl = new ItemEntity(EntityType.ITEM, worldIn), boneMeal = new ItemEntity(EntityType.ITEM, worldIn);
        bowl.setItem(new ItemStack(Items.BOWL));
        boneMeal.setItem(new ItemStack(Items.BONE_MEAL));
        bowl.setPos(pos.getX(), pos.getY(), pos.getZ());
        boneMeal.setPos(pos.getX(), pos.getY(), pos.getZ());

        worldIn.addFreshEntity(bowl);
        worldIn.addFreshEntity(boneMeal);

        worldIn.playSound((Player)null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
        worldIn.destroyBlock(pos, true);
        return InteractionResult.SUCCESS;
    }
}
