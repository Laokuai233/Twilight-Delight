package net.twilightdelight.common.item.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.twilightdelight.TwilightDelight;

/**
 * @author Goulixiaoji
 */
public class FoodItem extends Item {
    public FoodItem(Properties properties, FoodProperties foodProperties) {
        super(properties.food(foodProperties).tab(TwilightDelight.TAB_TWILIGHTDELIGHT));
    }
}
