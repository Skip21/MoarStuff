package com.epizy.skip.moarstuff.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SpecialFoodHandler extends ItemFood {


    public SpecialFoodHandler(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
    }

    public SpecialFoodHandler(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setAlwaysEdible();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
