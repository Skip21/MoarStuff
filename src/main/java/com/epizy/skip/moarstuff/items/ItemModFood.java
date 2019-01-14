package com.epizy.skip.moarstuff.items;

import com.epizy.skip.moarstuff.CustomTabs;
import net.minecraft.item.ItemFood;

public class ItemModFood extends ItemFood {


    public ItemModFood(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CustomTabs.tabMoarStuffBase);
    }


    public ItemModFood(String name, int amount, boolean isWolfFood) {
        this(name, amount, 0.0f, isWolfFood);
    }

    public ItemModFood(String name, int amount, float saturation){

        this(name, amount, saturation, false);

    }

}
