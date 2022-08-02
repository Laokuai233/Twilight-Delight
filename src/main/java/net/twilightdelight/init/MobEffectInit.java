package net.twilightdelight.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twilightdelight.TwilightDelight;
import net.twilightdelight.common.effect.FireRange;
import net.twilightdelight.common.effect.FrozenRange;
import net.twilightdelight.common.effect.PoisonRange;
import net.twilightdelight.common.effect.TemporalSadness;

/**
 * @author Goulixiaoji
 */
public class MobEffectInit {
    public static final DeferredRegister<MobEffect> REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TwilightDelight.MOD_ID);

    public static final RegistryObject<MobEffect> FIRE_RANGE;
    public static final RegistryObject<MobEffect> POISON_RANGE;
    public static final RegistryObject<MobEffect> FROZEN_RANGE;
    public static final RegistryObject<MobEffect> TEMPORAL_SADNESS;


    static{
        FIRE_RANGE = REGISTER.register("fire_range", FireRange::new);
        POISON_RANGE = REGISTER.register("poison_range", PoisonRange::new);
        FROZEN_RANGE = REGISTER.register("frozen_range", FrozenRange::new);
        TEMPORAL_SADNESS = REGISTER.register("temporal_sadness", TemporalSadness::new);
    }
}
