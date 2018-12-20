package com.epizy.skip.moarstuff.items.tools;

import com.epizy.skip.moarstuff.MoarStuff;
import net.minecraft.item.ItemSpade;

public class CustomShovel extends ItemSpade {

    public CustomShovel(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        setCreativeTab(MoarStuff.tabMoarStuffTools);
    }

}
