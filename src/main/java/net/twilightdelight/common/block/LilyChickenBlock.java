
package net.twilightdelight.common.block;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.items.ItemHandlerHelper;
import net.twilightdelight.init.BlockInit;
import net.twilightdelight.init.ItemInit;

import java.util.List;
import java.util.Collections;

/**
 * @author Laokuai233
 * @author Goulixiaoji
 */
public class LilyChickenBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public LilyChickenBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.5f, 2f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		switch ((Direction) state.getValue(FACING)) {
			case SOUTH :
			default :
				return Shapes.or(box(1, 0, 1, 15, 2, 15), box(4, 0, 4, 12, 9, 12)).move(offset.x, offset.y, offset.z);
			case NORTH :
				return Shapes.or(box(1, 0, 1, 15, 2, 15), box(4, 0, 4, 12, 9, 12)).move(offset.x, offset.y, offset.z);
			case EAST :
				return Shapes.or(box(1, 0, 1, 15, 2, 15), box(4, 0, 4, 12, 9, 12)).move(offset.x, offset.y, offset.z);
			case WEST :
				return Shapes.or(box(1, 0, 1, 15, 2, 15), box(4, 0, 4, 12, 9, 12)).move(offset.x, offset.y, offset.z);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);

		if (!world.isClientSide()) {
			BlockEntity _blockEntity = world.getBlockEntity(pos);
			BlockState _bs = world.getBlockState(pos);
			if (_blockEntity != null) {
				_blockEntity.getTileData().putDouble("getMaxServings", 4);
			}

			world.sendBlockUpdated(pos, _bs, _bs, 3);
		}
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();

		if ((entity.getMainHandItem().getOrCreateTag().getString("id")).equals("minecraft:bowl")) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null) {
						return blockEntity.getTileData().getDouble(tag);
					}
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "getMaxServings") > 0) {
				entity.getMainHandItem().shrink(1);

				ItemStack _setstack = new ItemStack(ItemInit.LILY_CHICKEN.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(entity, _setstack);

				if (!world.isClientSide()) {
					BlockPos _bp = new BlockPos(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getTileData().putDouble("getMaxServings", ((new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null) {
									return blockEntity.getTileData().getDouble(tag);
								}
								return -1;
							}
						}.getValue(world, new BlockPos(x, y, z), "getMaxServings")) - 1));
					}

					world.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null) {
					return blockEntity.getTileData().getDouble(tag);
				}
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "getMaxServings") == 0) {
			world.destroyBlock(new BlockPos(x, y, z), false);
			if (!world.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(Items.BOWL));
				entityToSpawn.setPickUpDelay(10);
				world.addFreshEntity(entityToSpawn);
			}
		} else {
			if (!entity.level.isClientSide()) {
				entity.displayClientMessage(new TextComponent((new TranslatableComponent("twilightdelight.feast.error").getString())), (true));
			}
		}
		return InteractionResult.SUCCESS;
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.LILY_CHICKEN.get(), renderType -> renderType == RenderType.cutout());
	}
}
