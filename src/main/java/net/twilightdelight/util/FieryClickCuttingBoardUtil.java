package net.twilightdelight.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.twilightdelight.common.item.knife.FieryKnife;
import vectorwing.farmersdelight.common.block.CuttingBoardBlock;
import vectorwing.farmersdelight.common.block.entity.CuttingBoardBlockEntity;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModAdvancements;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber()
public class FieryClickCuttingBoardUtil {

    public static void clickBoard(ItemStack toolItem, BlockPos posIn, Player playerIn){
        Level level = playerIn.getLevel();
        BlockState cuttingBoard = level.getBlockState(posIn);
        BlockEntity blockEntity = level.getBlockEntity(posIn);

        if (cuttingBoard.getBlock() instanceof CuttingBoardBlock && toolItem.getItem() instanceof FieryKnife){
            if (blockEntity instanceof CuttingBoardBlockEntity cuttingBoardEntity){
                Optional<CuttingBoardRecipe> matchingRecipe = getMatchingRecipe(cuttingBoardEntity, toolItem, playerIn);

                matchingRecipe.ifPresent((recipe) -> {
                    List<ItemStack> results = recipe.rollResults(level.random, EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, toolItem));

                    for (ItemStack resultStack : results) {
                        Direction direction = ((Direction) cuttingBoard.getValue(CuttingBoardBlock.FACING)).getCounterClockWise();
                        ItemStack stack = resultStack.copy();
                        Container container = new SimpleContainer(stack);
                        ItemStack newStack = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, container, level).map((smeltingRecipe)->{
                            return smeltingRecipe.assemble(container);
                        }).orElse(stack);
                        newStack.setCount(resultStack.getCount());

                        ItemUtils.spawnItemEntity(level, newStack.copy(), (double) posIn.getX() + 0.5D + (double) direction.getStepX() * 0.2D, (double) posIn.getY() + 0.2D, (double) posIn.getZ() + 0.5D + (double) direction.getStepZ() * 0.2D, (double) ((float) direction.getStepX() * 0.2F), 0.0D, (double) ((float) direction.getStepZ() * 0.2F));

                    }



                    if (playerIn != null) {
                        toolItem.hurtAndBreak(1, playerIn, (user) -> {
                            user.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                        });
                    } else if (toolItem.hurt(1, level.random, (ServerPlayer)null)) {
                        toolItem.setCount(0);
                    }

                    cuttingBoardEntity.playProcessingSound(recipe.getSoundEventID(), toolItem, cuttingBoardEntity.getStoredItem());
                    cuttingBoardEntity.removeItem();

                    if (playerIn instanceof ServerPlayer) {
                        ModAdvancements.CUTTING_BOARD.trigger((ServerPlayer) playerIn);
                    }

                });
            }
        }
    }

    /**
     * To get vectorwing.farmersdelight.common.block.entity.CuttingBoardBlockEntity.getMatchingRecipe(RecipeWrapper.class, ItemStack.class, Player.class)
     */
    protected static Optional<CuttingBoardRecipe> getMatchingRecipe(CuttingBoardBlockEntity blockEntity, ItemStack toolItem, Player player) {
        try {
            Field inventory = blockEntity.getClass().getDeclaredField("inventory");
            Method getMatchingRecipe = blockEntity.getClass().getDeclaredMethod("getMatchingRecipe", RecipeWrapper.class, ItemStack.class, Player.class);

            // visit private
            inventory.setAccessible(true);
            getMatchingRecipe.setAccessible(true);

            Optional<CuttingBoardRecipe> recipe =
                    (Optional<CuttingBoardRecipe>) getMatchingRecipe.invoke(blockEntity, new RecipeWrapper((IItemHandlerModifiable) inventory.get(blockEntity)), toolItem, player);

            return recipe;
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
