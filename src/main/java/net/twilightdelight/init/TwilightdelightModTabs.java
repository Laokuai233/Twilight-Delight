
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.twilightdelight.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TwilightdelightModTabs {
	public static CreativeModeTab TAB_TWILIGHTDELIGHTFOOD;

	public static void load() {
		TAB_TWILIGHTDELIGHTFOOD = new CreativeModeTab("tabtwilightdelightfood") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TwilightdelightModItems.GLOWSTEW.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
