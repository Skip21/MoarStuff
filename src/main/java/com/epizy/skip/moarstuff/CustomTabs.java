package com.epizy.skip.moarstuff;

import com.epizy.skip.moarstuff.init.ModItems;
import com.epizy.skip.moarstuff.init.ModTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CustomTabs {

    public static final CreativeTabs tabMoarStuffBase = (new CreativeTabs("tabMoarStuffBase") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.SHARD_BASIC);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }
    }).setBackgroundImageName("item_search.png");

    public static final CreativeTabs tabMoarStuffTools = (new CreativeTabs("tabMoarStuffTools") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModTools.OMNI_COPPER);
        }
    });

}
