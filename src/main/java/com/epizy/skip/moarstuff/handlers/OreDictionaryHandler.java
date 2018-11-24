package com.epizy.skip.moarstuff.handlers;

import com.epizy.skip.moarstuff.init.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

    public static void registerOreDictionary(){

        OreDictionary.registerOre("ingotCopper", ModItems.INGOT_COPPER);
        OreDictionary.registerOre("nuggetCopper", ModItems.NUGGET_COPPER);

    }

}
