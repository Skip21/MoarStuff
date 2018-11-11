package com.epizy.skip.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){

        GameRegistry.addSmelting(new ItemStack(ModBlocks.malachiteOre, 1), new ItemStack(ModItems.malachiteIngot, 1), 1.2f);

    }

}
