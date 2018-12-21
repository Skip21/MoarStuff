package com.epizy.skip.moarstuff.items.tools;

import com.epizy.skip.moarstuff.CustomTabs;
import net.minecraft.item.ItemSpade;

public class CustomShovel extends ItemSpade {

    public CustomShovel(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        setCreativeTab(CustomTabs.tabMoarStuffTools);
    }

}
