package com.epizy.skip.moarstuff.items.tools;

import com.epizy.skip.moarstuff.CustomTabs;
import net.minecraft.item.ItemHoe;

public class CustomHoe extends ItemHoe {

    public CustomHoe(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        setCreativeTab(CustomTabs.tabMoarStuffTools);
    }

}
