
package net.twilightdelight.item;

import net.twilightdelight.procedures.HydrapieceUsedProcedure;
import net.twilightdelight.init.TwilightdelightModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class HydrapieceItem extends Item {
	public HydrapieceItem() {
		super(new Item.Properties().tab(TwilightdelightModTabs.TAB_TWILIGHTDELIGHTFOOD).stacksTo(64).rarity(Rarity.UNCOMMON)
				.food((new FoodProperties.Builder()).nutrition(9).saturationMod(36f)

						.meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 20;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		HydrapieceUsedProcedure.execute(entity);
		return retval;
	}
}
