package net.twilightdelight.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IronwoodknifeinventoryProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getCrafting());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.KNOCKBACK, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.KNOCKBACK, 1);
		}
	}
}
