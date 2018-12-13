package com.epizy.skip.moarstuff.items.tools;

import net.minecraft.item.ItemAxe;

public class CustomAxe extends ItemAxe {
    public CustomAxe(String name, ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

    }
}
