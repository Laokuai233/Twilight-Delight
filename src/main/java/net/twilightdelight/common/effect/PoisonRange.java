package net.twilightdelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.twilightdelight.util.UtilEffectMethod;

import java.util.List;

/**
 * @author Goulixiaoji
 */
public class PoisonRange extends MobEffect {
    /**
     * MobEffectCategory effectCategory,
     * int color
     */
    public PoisonRange() {
        super(MobEffectCategory.BENEFICIAL, -16751104);
    }

    @Override
    public String getDescriptionId() {
        return "effect.twilightdelight.poison_range";
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        List<Entity> entityListFoundInLevel = UtilEffectMethod.getEntitiesInRange(12.0D / 2.0D, entity);

        for (Entity entityInList : entityListFoundInLevel){

            UtilEffectMethod.setEntityEffectByCommand(entityInList, "effect give @s[type=!player] poison 1 5");
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
