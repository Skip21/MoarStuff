package com.epizy.skip.moarstuff.init;

import com.epizy.skip.moarstuff.items.ItemBasic;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    public static Item STICK_BASIC;
    public static Item SHARD_BASIC;
    public static Item INGOT_COPPER;
    public static Item NUGGET_COPPER;

    public static void init(){
        STICK_BASIC = new ItemBasic("stick_basic");
        SHARD_BASIC = new ItemBasic("shard_basic");
        INGOT_COPPER = new ItemBasic("ingot_copper");
        NUGGET_COPPER = new ItemBasic("nugget_copper");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(STICK_BASIC, SHARD_BASIC, INGOT_COPPER, NUGGET_COPPER);

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){
        registerRender(STICK_BASIC);
        registerRender(SHARD_BASIC);
        registerRender(INGOT_COPPER);
        registerRender(NUGGET_COPPER);
    }

    private static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
