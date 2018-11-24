package com.epizy.skip.moarstuff.items;

import com.epizy.skip.moarstuff.MoarStuff;
import net.minecraft.item.Item;

public class ItemBasic extends Item {

    public ItemBasic(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(MoarStuff.tabMoarStuffBase);
    }

}
