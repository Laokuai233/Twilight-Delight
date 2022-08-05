package net.twilightdelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.twilightdelight.init.MobEffectInit;
import net.twilightdelight.util.UtilEffectMethod;

import java.util.List;

/**
 * @author Goulixiaoji
 */
public class FireRange extends MobEffect {
    /**
     * MobEffectCategory effectCategory,
     * int color
     */
    public FireRange() {
        super(MobEffectCategory.BENEFICIAL, -39424);
    }

    @Override
    public String getDescriptionId() {
        return "effect.twilightdelight.fire_range";
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        List<Entity> entityListFoundInLevel = UtilEffectMethod.getEntitiesInRange(12.0D / 2.0D, entity);

        for (Entity entityInList : entityListFoundInLevel){
            entityInList.setSecondsOnFire(
                    (entityInList instanceof LivingEntity livingEntity && livingEntity.hasEffect(MobEffectInit.FIRE_RANGE.get())
                            ? livingEntity.getEffect(MobEffectInit.FIRE_RANGE.get()).getAmplifier()
                            : 4
                    ) + 1
            );

            entity.clearFire();

            if (entityInList instanceof ItemEntity itemEntity){
                itemEntity.clearFire();
            }
        }


    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
