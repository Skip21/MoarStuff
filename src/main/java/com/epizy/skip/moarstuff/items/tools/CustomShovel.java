package com.epizy.skip.moarstuff.items.tools;

import net.minecraft.item.ItemSpade;

public class CustomShovel extends ItemSpade {

    public CustomShovel(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

}
