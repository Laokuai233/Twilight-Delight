
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.twilightdelight.init;

import net.twilightdelight.item.SteeleafknifeItem;
import net.twilightdelight.item.RawvenisonribItem;
import net.twilightdelight.item.RawmeefsliceItem;
import net.twilightdelight.item.KnightmetalknifeItem;
import net.twilightdelight.item.IronwoodknifeItem;
import net.twilightdelight.item.HydrapieceItem;
import net.twilightdelight.item.GlowstewItem;
import net.twilightdelight.item.FierysnakesItem;
import net.twilightdelight.item.FielyknifeItem;
import net.twilightdelight.item.CookedvenisonribItem;
import net.twilightdelight.item.CookedmeefsliceItem;
import net.twilightdelight.TwilightdelightMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class TwilightdelightModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TwilightdelightMod.MODID);
	public static final RegistryObject<Item> GLOWSTEW = REGISTRY.register("glowstew", () -> new GlowstewItem());
	public static final RegistryObject<Item> FIERY_KNIFE = REGISTRY.register("fiery_knife", () -> new FielyknifeItem());
	public static final RegistryObject<Item> IRONWOOD_KNIFE = REGISTRY.register("ironwood_knife", () -> new IronwoodknifeItem());
	public static final RegistryObject<Item> KNIGHTMETAL_KNIFE = REGISTRY.register("knightmetal_knife", () -> new KnightmetalknifeItem());
	public static final RegistryObject<Item> STEELEAF_KNIFE = REGISTRY.register("steeleaf_knife", () -> new SteeleafknifeItem());
	public static final RegistryObject<Item> RAW_VENISON_RIB = REGISTRY.register("raw_venison_rib", () -> new RawvenisonribItem());
	public static final RegistryObject<Item> COOKED_VENISON_RIB = REGISTRY.register("cooked_venison_rib", () -> new CookedvenisonribItem());
	public static final RegistryObject<Item> HYDRA_PIECE = REGISTRY.register("hydra_piece", () -> new HydrapieceItem());
	public static final RegistryObject<Item> RAW_MEEF_SLICE = REGISTRY.register("raw_meef_slice", () -> new RawmeefsliceItem());
	public static final RegistryObject<Item> COOKED_MEEF_SLICE = REGISTRY.register("cooked_meef_slice", () -> new CookedmeefsliceItem());
	public static final RegistryObject<Item> FIERY_SNAKES = REGISTRY.register("fiery_snakes", () -> new FierysnakesItem());
}
