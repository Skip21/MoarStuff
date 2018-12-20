package com.epizy.skip.moarstuff.items.tools;

import com.epizy.skip.moarstuff.MoarStuff;
import net.minecraft.item.ItemPickaxe;

public class CustomPickaxe extends ItemPickaxe {

    public CustomPickaxe(String name, ToolMaterial material) {

        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        setCreativeTab(MoarStuff.tabMoarStuffTools);

    }
}
