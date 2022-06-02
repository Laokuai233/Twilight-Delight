
package net.twilightdelight.item;

import net.twilightdelight.init.TwilightdelightModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class RawvenisonribItem extends Item {
	public RawvenisonribItem() {
		super(new Item.Properties().tab(TwilightdelightModTabs.TAB_TWILIGHTDELIGHTFOOD).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(2).saturationMod(1f)

						.meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
