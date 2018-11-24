package com.epizy.skip.moarstuff.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){

        GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_COPPER, 1), new ItemStack(ModItems.INGOT_COPPER, 1), 1.2f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_LEAD, 1), new ItemStack(ModItems.INGOT_LEAD, 1), 1.4f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_SHARD, 1), new ItemStack(ModItems.SHARD_BASIC, 1), 0.1f);

    }

}
