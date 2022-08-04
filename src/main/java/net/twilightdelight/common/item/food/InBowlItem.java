package net.twilightdelight.common.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.twilightdelight.TwilightDelight;

/**
 * @author Goulixiaoji
 */
public class InBowlItem extends Item {

    public InBowlItem(Properties properties, FoodProperties foodProperties) {
        super(properties.tab(TwilightDelight.TAB_TWILIGHTDELIGHT).food(foodProperties).rarity(Rarity.COMMON));
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity consumer) {
        super.finishUsingItem(stack, worldIn, consumer);
        ItemStack itemStack = new ItemStack(Items.BOWL);
        if (stack.isEmpty()){
            return itemStack;
        }

        if (consumer instanceof Player player && !player.getAbilities().instabuild){
            if (!player.getInventory().add(itemStack)){
                player.drop(itemStack, false);
            }
        }

        return stack;
    }
}
