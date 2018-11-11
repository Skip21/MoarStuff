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

    public static Item basicStick;
    public static Item basicShard;
    public static Item malachiteIngot;
    public static Item malachiteNugget;

    public static void init(){
        basicStick = new ItemBasic("basicStick");
        basicShard = new ItemBasic("basicShard");
        malachiteIngot = new ItemBasic("malachiteIngot");
        malachiteNugget = new ItemBasic("malachiteNugget");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(basicStick, basicShard, malachiteIngot, malachiteNugget);

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){
        registerRender(basicStick);
        registerRender(basicShard);
        registerRender(malachiteIngot);
        registerRender(malachiteNugget);
    }

    private static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
