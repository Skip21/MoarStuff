package com.epizy.skip.moarstuff.items.tools;

import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {

    public CustomSword(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
}
