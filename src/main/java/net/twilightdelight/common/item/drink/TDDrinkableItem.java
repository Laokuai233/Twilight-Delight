package net.twilightdelight.common.item.drink;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.twilightdelight.TwilightDelight;
import vectorwing.farmersdelight.common.item.DrinkableItem;

/**
 * @author goulixiaoji
 */
public class TDDrinkableItem extends DrinkableItem {

    public TDDrinkableItem(FoodProperties foodProperties) {
        this(new Properties().tab(TwilightDelight.TAB_TWILIGHTDELIGHT).food(foodProperties).stacksTo(16).rarity(Rarity.COMMON), foodProperties);
    }

    public TDDrinkableItem(Properties properties, FoodProperties foodProperties){
        super(properties.tab(TwilightDelight.TAB_TWILIGHTDELIGHT).food(foodProperties));
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity consumer) {
        super.finishUsingItem(stack, worldIn, consumer);
        ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
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

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }
}
