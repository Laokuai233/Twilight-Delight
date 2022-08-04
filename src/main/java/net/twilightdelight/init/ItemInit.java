package net.twilightdelight.init;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twilightdelight.TwilightDelight;
import net.twilightdelight.common.item.TeardropSword;
import net.twilightdelight.common.item.drink.TDDrinkableItem;
import net.twilightdelight.common.item.food.FoodItem;
import net.twilightdelight.common.item.food.InBowlItem;
import net.twilightdelight.common.item.knife.*;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModEffects;


/**
 * @author Goulixiaoji
 */
public class ItemInit {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, TwilightDelight.MOD_ID);

    public static final RegistryObject<BlockItem> MAZE_STOVE;
    public static final RegistryObject<BlockItem> LILY_CHICKEN;
    public static final RegistryObject<BlockItem> FIERY_SNAKES;


    public static final RegistryObject<InBowlItem> GLOWSTWE;
    public static final RegistryObject<InBowlItem> PLATE_OF_FIERY_SNAKES;
    public static final RegistryObject<InBowlItem> GLOW_VENISON_RIB_WITH_PASTA;
    public static final RegistryObject<InBowlItem> FRIED_INSECT;
    public static final RegistryObject<InBowlItem> THOUSAND_PLANT_STEW;
    public static final RegistryObject<InBowlItem> GRILLED_GHAST;
    public static final RegistryObject<InBowlItem> PLATE_OF_LILY_CHICKEN;
    public static final RegistryObject<InBowlItem> AURORA_ICE_CREAM;

    public static final RegistryObject<Item> HYDRA_PIECE;
    public static final RegistryObject<Item> RAW_VENISON_RIB;
    public static final RegistryObject<Item> COOKED_VENISON_RIB;
    public static final RegistryObject<Item> RAW_MEEF_SLICE;
    public static final RegistryObject<Item> COOKED_MEEF_SLICE;
    public static final RegistryObject<Item> RAW_INSECT;
    public static final RegistryObject<Item> COOKED_INSECT;
    public static final RegistryObject<Item> TORCHBERRY_COOKIE;
    public static final RegistryObject<Item> CHOCOLATE_WAFER;
    public static final RegistryObject<Item> EXPERIMENT_113;
    public static final RegistryObject<Item> EXPERIMENT_110;
    public static final RegistryObject<Item> BERRY_STICK;


    public static final RegistryObject<DrinkableItem> THORN_ROSE_TEA;
    public static final RegistryObject<DrinkableItem> TORCHBERRY_JUICE;
    public static final RegistryObject<DrinkableItem> PHYTOCHEMICAL_JUICE;
    public static final RegistryObject<DrinkableItem> GLACIER_ICE_TEA;
    public static final RegistryObject<DrinkableItem> TWILIGHT_SPRING;
    public static final RegistryObject<DrinkableItem> TEAR_DRINK;

    public static final RegistryObject<KnifeItem> FIERY_KNIFE;
    public static final RegistryObject<KnifeItem> IRONWOOD_KNIFE;
    public static final RegistryObject<KnifeItem> STEELEAF_KNIFE;
    public static final RegistryObject<KnifeItem> KNIGHTLY_KNIFE;

    public static final RegistryObject<SwordItem> TEARDROP_SWORD;


    // BLOCK ITEMS
    static {
        MAZE_STOVE = REGISTER.register("maze_stove", ()-> new BlockItem(BlockInit.MAZE_STOVE.get(), new Item.Properties().tab(TwilightDelight.TAB_TWILIGHTDELIGHT)));
        LILY_CHICKEN = REGISTER.register("lily_chicken_block", ()-> new BlockItem(BlockInit.LILY_CHICKEN.get(), new Item.Properties().tab(TwilightDelight.TAB_TWILIGHTDELIGHT)));
        FIERY_SNAKES = REGISTER.register("fiery_snakes_block", ()-> new BlockItem(BlockInit.FIERY_SNAKES.get(), new Item.Properties().tab(TwilightDelight.TAB_TWILIGHTDELIGHT)));
    }

    // COMMON FOOD
    static {
        HYDRA_PIECE = REGISTER.register("hydra_piece", ()-> new FoodItem(
                new Item.Properties().rarity(Rarity.UNCOMMON),
                new FoodProperties.Builder()
                        .nutrition(9)
                        .saturationMod(2.0F)
                        .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 20, 0), 1)
                        .meat()
                        .build()
        ));

        RAW_VENISON_RIB = REGISTER.register("raw_venison_rib", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.25F)
                        .meat()
                        .build()
        ));

        COOKED_VENISON_RIB = REGISTER.register("cooked_venison_rib", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(0.875f)
                        .meat()
                        .build()
        ));

        RAW_MEEF_SLICE = REGISTER.register("raw_meef_slice", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.7F)
                        .meat().build()
        ));

        COOKED_MEEF_SLICE = REGISTER.register("cooked_meef_slice", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(3)
                        .saturationMod(0.6F)
                        .meat()
                        .build()
        ));

        RAW_INSECT = REGISTER.register("raw_insect", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.2F)
                        .meat()
                        .build()
        ));

        COOKED_INSECT = REGISTER.register("cooked_insect", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(6)
                        .saturationMod(0.6F)
                        .meat()
                        .build()
        ));

        TORCHBERRY_COOKIE = REGISTER.register("torchberry_cookie", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.2F)
                        .build()
        ));

        CHOCOLATE_WAFER = REGISTER.register("chocolate_wafer", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(9)
                        .saturationMod(0.6F)
                        .build()
        ));

        EXPERIMENT_113 = REGISTER.register("experiment_113", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(6)
                        .saturationMod(0.2F)
                        .effect(()-> new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), 0.33F)
                        .meat()
                        .build()
        ));

        EXPERIMENT_110 = REGISTER.register("experiment_110", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(12)
                        .saturationMod(0.3F)
                        .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 1200, 0), 1)
                        .effect(()-> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 4), 1)
                        .effect(()-> new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0), 1)
                        .meat()
                        .build()

        ));

        BERRY_STICK = REGISTER.register("berry_stick", ()-> new FoodItem(
                new Item.Properties(),
                new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(0.2F)
                        .build()
        ));
    }


    // BOWL FOOD
    static {
        GLOWSTWE = REGISTER.register("glowstew", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(1),
                new FoodProperties.Builder()
                        .saturationMod(0.675F)
                        .nutrition(7)
                        .effect(()-> new MobEffectInstance(MobEffects.GLOWING, 200, 1), 1)
                        .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 1), 1)
                        .build()
        ));

        GLOW_VENISON_RIB_WITH_PASTA = REGISTER.register("glow_venison_rib_with_pasta", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(16),
                new FoodProperties.Builder()
                        .saturationMod(0.7F)
                        .nutrition(12)
                        .meat()
                        .effect(()-> new MobEffectInstance(MobEffects.GLOWING, 200, 1), 1)
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 1), 1)
                        .build()
        ));

        FRIED_INSECT =  REGISTER.register("fried_insect", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(16),
                new FoodProperties.Builder()
                        .nutrition(10)
                        .saturationMod(0.61F)
                        .meat()
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1)
                        .build()
        ));

        THOUSAND_PLANT_STEW = REGISTER.register("thousand_plant_stew", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(16),
                new FoodProperties.Builder()
                        .nutrition(10)
                        .saturationMod(0.61F)
                        .effect(()-> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 1), 1)
                        .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 300, 1), 0.1F)
                        .build()
        ));

        GRILLED_GHAST = REGISTER.register("grilled_ghast", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(16),
                new FoodProperties.Builder()
                        .nutrition(10)
                        .saturationMod(0.72F)
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 1), 1)
                        .meat()
                        .build()
        ));

        PLATE_OF_LILY_CHICKEN = REGISTER.register("lily_chicken", ()-> new InBowlItem(
           new Item.Properties()
                   .stacksTo(16),
                new FoodProperties.Builder()
                        .nutrition(16)
                        .saturationMod(0.875F)
                        .effect(()-> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 1), 1)
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 1), 1)
                        .meat()
                        .build()
        ));

        PLATE_OF_FIERY_SNAKES = REGISTER.register("fiery_snakes", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(16),
                new FoodProperties.Builder()
                        .nutrition(20)
                        .saturationMod(1.9F)
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 12000, 1), 1)
                        .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 1), 1)
                        .effect(()-> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1)
                        .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1)
                        .meat()
                        .build()
        ));

        AURORA_ICE_CREAM = REGISTER.register("aurora_ice_cream", ()-> new InBowlItem(
                new Item.Properties()
                        .stacksTo(16),
                new FoodProperties.Builder()
                        .nutrition(5)
                        .saturationMod(0.2F)
                        .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2), 1)
                        .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1)
                        .build()
        ));
    }

    // Define Drinks
    static {
        THORN_ROSE_TEA = REGISTER.register("thorn_rose_tea", ()-> new TDDrinkableItem(
                new FoodProperties.Builder()
                        .saturationMod(0.25F)
                        .nutrition(4)
                        .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1)
                        .alwaysEat()
                        .build()){
            @Override
            public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity consumer) {
                consumer.hurt(new DamageSource("twilightdelight.thorn_rose_tea"), 4);
                return super.finishUsingItem(stack, worldIn, consumer);
            }
        });

        TORCHBERRY_JUICE = REGISTER.register("torchberry_juice", ()-> new TDDrinkableItem(
                new FoodProperties.Builder()
                        .saturationMod(0.25F)
                        .nutrition(4)
                        .effect(()-> new MobEffectInstance(MobEffectInit.FIRE_RANGE.get(), 3600, 0), 1)
                        .alwaysEat()
                        .build()
        ));

        PHYTOCHEMICAL_JUICE = REGISTER.register("phytochemical_juice", ()-> new TDDrinkableItem(
                new FoodProperties.Builder()
                        .saturationMod(0.25F)
                        .nutrition(4)
                        .effect(()-> new MobEffectInstance(MobEffectInit.POISON_RANGE.get(), 3600, 2), 1)
                        .alwaysEat()
                        .build()
        ));

        GLACIER_ICE_TEA = REGISTER.register("glacier_ice_tea", ()-> new TDDrinkableItem(
                new FoodProperties.Builder()
                        .saturationMod(0.25F)
                        .nutrition(4)
                        .effect(()-> new MobEffectInstance(MobEffectInit.FROZEN_RANGE.get(), 7200, 0), 1)
                        .alwaysEat()
                        .build()
        ));

        TWILIGHT_SPRING = REGISTER.register("twilight_spring", ()-> new TDDrinkableItem(
                new FoodProperties.Builder()
                        .saturationMod(0.0F)
                        .nutrition(0)
                        .effect(()-> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1), 1)
                        .alwaysEat()
                        .build()
        ));

        TEAR_DRINK = REGISTER.register("tear_drink", ()-> new TDDrinkableItem(
                new FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.0F)
                        .effect(()-> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 24000, 0), 1)
                        .effect(()-> new MobEffectInstance(MobEffectInit.TEMPORAL_SADNESS.get(), 1200, 0), 1)
                        .alwaysEat()
                        .build()
        ));
    }

    // KNIVES
    static {
        FIERY_KNIFE = REGISTER.register("fiery_knife", FieryKnife::new);

        IRONWOOD_KNIFE = REGISTER.register("ironwood_knife", IronwoodKnife::new);

        STEELEAF_KNIFE = REGISTER.register("steeleaf_knife", StelleafKnife::new);

        KNIGHTLY_KNIFE = REGISTER.register("knightmetal_knife", KnightlyKnife::new);
    }

    static {
        TEARDROP_SWORD = REGISTER.register("teardrop_sword", TeardropSword::new);
    }
}
