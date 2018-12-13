package com.epizy.skip.moarstuff.items.tools;

import net.minecraft.item.ItemPickaxe;

public class CustomPickaxe extends ItemPickaxe {

    public CustomPickaxe(String name, ToolMaterial material) {

        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

    }
}
