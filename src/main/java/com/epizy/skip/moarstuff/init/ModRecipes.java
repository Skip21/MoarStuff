package com.epizy.skip.moarstuff.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){

        GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_COPPER, 1), new ItemStack(ModItems.INGOT_COPPER, 1), 1.2f);

    }

}
