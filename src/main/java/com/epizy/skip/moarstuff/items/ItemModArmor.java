package com.epizy.skip.moarstuff.items;

import com.epizy.skip.moarstuff.CustomTabs;
import com.epizy.skip.moarstuff.Reference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor {


    public ItemModArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(Reference.MODID+name);
        setRegistryName(name);
        setMaxStackSize(1);

        setCreativeTab(CustomTabs.tabMoarStuffTools);
    }
}
