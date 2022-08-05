package net.twilightdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.twilightdelight.init.ItemInit;
import vectorwing.farmersdelight.common.block.FeastBlock;


/**
 * @author Goulixiaoji
 */
public class FierySnakesBlock extends FeastBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);


    public FierySnakesBlock() {
        super(Properties.copy(Blocks.WHITE_WOOL), ItemInit.PLATE_OF_FIERY_SNAKES::get, true);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return (Integer)state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : thisGetShape(state, worldIn, pos, context);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        int servings = (Integer)state.getValue(SERVINGS);
        if (servings > 0){
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
        ItemEntity bowl = new ItemEntity(EntityType.ITEM, worldIn);
        bowl.setItem(new ItemStack(Items.BOWL));
        bowl.setPos(pos.getX(), pos.getY(), pos.getZ());

        worldIn.addFreshEntity(bowl);

        worldIn.playSound((Player)null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
        worldIn.destroyBlock(pos, true);
        return InteractionResult.SUCCESS;
    }

    protected static VoxelShape thisGetShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context){
        Vec3 offset = state.getOffset(world, pos);
        return switch ((Direction) state.getValue(FACING)) {
            default -> Shapes.or(box(3, 2, 4, 13, 7, 10), box(2, 0, 2, 15, 2, 15)).move(offset.x, offset.y, offset.z);
            case NORTH -> Shapes.or(box(3, 2, 6, 13, 7, 12), box(1, 0, 1, 14, 2, 14)).move(offset.x, offset.y, offset.z);
            case EAST -> Shapes.or(box(4, 2, 3, 10, 7, 13), box(2, 0, 1, 15, 2, 14)).move(offset.x, offset.y, offset.z);
            case WEST -> Shapes.or(box(6, 2, 3, 12, 7, 13), box(1, 0, 2, 14, 2, 15)).move(offset.x, offset.y, offset.z);
        };
    }
}
