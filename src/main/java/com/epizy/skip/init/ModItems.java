package com.epizy.skip.init;

import com.epizy.skip.items.ItemBasic;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    static Item basicStick;
    static Item basicShard;
    static Item malachiteIngot;

    public static void init(){
        basicStick = new ItemBasic("basicStick");
        basicShard = new ItemBasic("basicShard");
        malachiteIngot = new ItemBasic("malachiteIngot");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(basicStick, basicShard, malachiteIngot);

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){
        registerRender(basicStick);
        registerRender(basicShard);
        registerRender(malachiteIngot);
    }

    private static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
