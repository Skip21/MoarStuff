package com.epizy.skip.moarstuff;

import com.epizy.skip.moarstuff.init.ModItems;
import com.epizy.skip.moarstuff.init.ModTools;
import com.epizy.skip.moarstuff.items.ItemBasic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Comparator;

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

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> p_78018_1_) {
            super.displayAllRelevantItems(p_78018_1_);
            p_78018_1_.sort(new Comparator<ItemStack>() {

                @Override
                public int compare(ItemStack o1, ItemStack o2) {
                    if(o1.getItem() instanceof ItemBasic && o2.getItem() instanceof ItemBasic){

                        return o1.getDisplayName().compareTo(o2.getDisplayName());

                    }

                    if (o1.getItem() instanceof ItemBasic){
                        return 1;
                    }else if (o2.getItem() instanceof ItemBasic){
                        return -1;
                    }

                    return o1.getDisplayName().compareTo(o2.getDisplayName());

                }
            });
        }
    }).setBackgroundImageName("item_search.png");

    public static final CreativeTabs tabMoarStuffTools = (new CreativeTabs("tabMoarStuffTools") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModTools.OMNI_COPPER);
        }
    });

}
