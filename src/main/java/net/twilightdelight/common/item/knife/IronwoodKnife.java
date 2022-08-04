package net.twilightdelight.common.item.knife;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.twilightdelight.TwilightDelight;
import vectorwing.farmersdelight.common.item.KnifeItem;

/**
 * @author Goulixiaoji
 */
public class IronwoodKnife extends KnifeItem {
    public IronwoodKnife() {
        super(tierGetter(), 1.0F, 2.5F, new Properties().tab(TwilightDelight.TAB_TWILIGHTDELIGHT).stacksTo(1).rarity(Rarity.COMMON).fireResistant());
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState blockstate) {
        int tier = 1;
        if (tier < 3 && blockstate.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
            return false;
        } else if (tier < 2 && blockstate.is(BlockTags.NEEDS_IRON_TOOL)) {
            return false;
        } else {
            return (tier >= 1 || !blockstate.is(BlockTags.NEEDS_STONE_TOOL)) && (blockstate.is(BlockTags.MINEABLE_WITH_AXE) || blockstate.is(BlockTags.MINEABLE_WITH_HOE)
                    || blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE) || blockstate.is(BlockTags.MINEABLE_WITH_SHOVEL));
        }
    }

    @Override
    public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
        return 1.0F;
    }


    @Override
    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        itemstack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        itemstack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        if (allowdedIn(tab)) {
            ItemStack istack = new ItemStack(this);
            istack.enchant(Enchantments.KNOCKBACK, 1);
            list.add(istack);
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
            builder.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 2.5f, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2, AttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.getDefaultAttributeModifiers(equipmentSlot);
    }

    protected static Tier tierGetter(){
        return new Tier() {
            @Override
            public int getUses() {
                return 131;
            }

            @Override
            public float getSpeed() {
                return 1f;
            }

            @Override
            public float getAttackDamageBonus() {
                return 3.5f;
            }

            @Override
            public int getLevel() {
                return 1;
            }

            @Override
            public int getEnchantmentValue() {
                return 10;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.EMPTY;
            }
        };
    }
}
