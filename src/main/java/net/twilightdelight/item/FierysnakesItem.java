
package net.twilightdelight.item;

import net.twilightdelight.procedures.FierysnakesUsedProcedure;
import net.twilightdelight.init.TwilightdelightModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

public class FierysnakesItem extends Item {
	public FierysnakesItem() {
		super(new Item.Properties().tab(TwilightdelightModTabs.TAB_TWILIGHTDELIGHTFOOD).stacksTo(64).rarity(Rarity.UNCOMMON)
				.food((new FoodProperties.Builder()).nutrition(24).saturationMod(76f)

						.meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.BOWL);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		FierysnakesUsedProcedure.execute(entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}
