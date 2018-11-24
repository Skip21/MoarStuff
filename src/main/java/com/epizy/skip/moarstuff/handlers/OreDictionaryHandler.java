package com.epizy.skip.moarstuff.handlers;

import com.epizy.skip.moarstuff.init.ModBlocks;
import com.epizy.skip.moarstuff.init.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

    public static void registerOreDictionary(){

        OreDictionary.registerOre("ingotCopper", ModItems.INGOT_COPPER);
        OreDictionary.registerOre("nuggetCopper", ModItems.NUGGET_COPPER);
        OreDictionary.registerOre("blockCopper", ModBlocks.BLOCK_COPPER);
        OreDictionary.registerOre("oreCopper", ModBlocks.ORE_COPPER);

        OreDictionary.registerOre("ingotLead", ModItems.INGOT_LEAD);
        OreDictionary.registerOre("nuggetLead", ModItems.NUGGET_LEAD);
        OreDictionary.registerOre("blockLead", ModBlocks.BLOCK_LEAD);
        OreDictionary.registerOre("oreLead", ModBlocks.ORE_LEAD);

    }

}
