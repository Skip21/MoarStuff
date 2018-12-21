package com.epizy.skip.moarstuff.blocks;

import com.epizy.skip.moarstuff.CustomTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block {

    public BlockBasic(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(CustomTabs.tabMoarStuffBase);
    }

}
