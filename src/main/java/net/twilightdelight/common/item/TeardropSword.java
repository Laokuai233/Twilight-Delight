package net.twilightdelight.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.twilightdelight.TwilightDelight;
import net.twilightdelight.init.ItemInit;
import net.twilightdelight.init.MobEffectInit;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * @author Goulixiaoji
 */
public class TeardropSword extends SwordItem {

    public TeardropSword() {
        super(tierGetter(), 3, -2.4f, new Item.Properties().tab(TwilightDelight.TAB_TWILIGHTDELIGHT).rarity(Rarity.UNCOMMON).fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        double crying = 0;
        entity.setSecondsOnFire(15);
        crying = Mth.nextInt(new Random(), 1, 3);
        if (crying == 1) {
            entity.addEffect(new MobEffectInstance(MobEffectInit.TEMPORAL_SADNESS.get(), 100, 0));
        }

        return retval;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flags) {
        super.appendHoverText(stack, world, list, flags);
        list.add(new TranslatableComponent(getDescriptionId() + ".tooltip").withStyle(ChatFormatting.GRAY));
    }

    protected static Tier tierGetter(){
        return new Tier() {
            @Override
            public int getUses() {
                return 1536;
            }

            @Override
            public float getSpeed() {
                return 4f;
            }

            @Override
            public float getAttackDamageBonus() {
                return 5f;
            }

            @Override
            public int getLevel() {
                return 1;
            }

            @Override
            public int getEnchantmentValue() {
                return 30;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(ItemInit.EXPERIMENT_113.get()));
            }
        };
    }
}
