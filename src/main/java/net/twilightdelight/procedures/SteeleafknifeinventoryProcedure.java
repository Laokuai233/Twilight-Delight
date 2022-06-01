package net.twilightdelight.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class SteeleafknifeinventoryProcedure {
	public static void execute(ItemStack itemstack) {
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.MOB_LOOTING, 2);
		}
	}
}
