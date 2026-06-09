package com.gmm.gctall.item;

import com.gmm.gctall.Tags;
import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GctAllFoodItem extends ItemFood {
    private final float sanityChange;

    public GctAllFoodItem(String registryName, int amount, float saturation, boolean wolfFood) {
        this(registryName, amount, saturation, wolfFood, 0.0F);
    }

    public GctAllFoodItem(String registryName, int amount, float saturation, boolean wolfFood, float sanityChange) {
        super(amount, saturation, wolfFood);
        this.sanityChange = sanityChange;
        setTranslationKey(registryName);
        setRegistryName(new ResourceLocation(Tags.MOD_ID, registryName));
        setCreativeTab(GctAllCreativeTab.TAB);
        setMaxStackSize(64);
        setAlwaysEdible();
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        player.setActiveHand(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
        boolean creativePlayer = entity instanceof EntityPlayer
                && ((EntityPlayer) entity).capabilities.isCreativeMode;
        ItemStack originalStack = creativePlayer ? stack.copy() : ItemStack.EMPTY;
        ItemStack result = super.onItemUseFinish(stack, world, entity);
        if (creativePlayer) {
            originalStack.setCount(Math.max(1, originalStack.getCount()));
            return originalStack;
        }
        return result;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
        if (sanityChange != 0.0F) {
            applySanityChange(player);
        }
    }

    private void applySanityChange(EntityPlayer player) {
        float current = player.getEntityData().getFloat("sanityAbyss");
        player.getEntityData().setFloat("sanityAbyss", clampSanity(current + sanityChange));
    }

    private float clampSanity(float sanity) {
        if (sanity < -100.0F) {
            return -100.0F;
        }
        if (sanity > 100.0F) {
            return 100.0F;
        }
        return sanity;
    }
}
