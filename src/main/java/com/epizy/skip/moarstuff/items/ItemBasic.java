package com.epizy.skip.moarstuff.items;


import com.epizy.skip.moarstuff.CustomTabs;
import net.minecraft.item.Item;

public class ItemBasic extends Item {

    public ItemBasic(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(CustomTabs.tabMoarStuffBase);
    }

}
