package net.twilightdelight.common.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

/**
 * @author Goulixiaoji
 */
public class TemporalSadness extends MobEffect {
    /**
     * MobEffectCategory effectCategory,
     * int color
     */
    public TemporalSadness() {
        super(MobEffectCategory.HARMFUL, -1);
    }

    @Override
    public String getDescriptionId() {
        return "effect.twilightdelight.temporal_sadness";
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.setSprinting(false);

        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 1, (false), (false)));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1, (false), (false)));

        if (entity.level instanceof ServerLevel serverLevel){
            serverLevel.sendParticles(ParticleTypes.FALLING_WATER, entity.getX(), entity.getY(), entity.getZ(), 5, 1, 1, 1, 1);
        }

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
