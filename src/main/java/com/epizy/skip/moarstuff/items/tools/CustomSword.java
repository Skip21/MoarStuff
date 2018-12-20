package com.epizy.skip.moarstuff.items.tools;

import com.epizy.skip.moarstuff.MoarStuff;
import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {

    public CustomSword(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        setCreativeTab(MoarStuff.tabMoarStuffTools);
    }
}
