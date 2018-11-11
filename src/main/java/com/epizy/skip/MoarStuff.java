package com.epizy.skip;

import com.epizy.skip.init.ModBlocks;
import com.epizy.skip.init.ModItems;
import com.epizy.skip.init.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;



@Mod(modid=Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class MoarStuff {

    @Instance
    public static MoarStuff instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        System.out.println(Reference.MODID + ":preinit");
        ModItems.init();
        ModBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

        System.out.println(Reference.MODID + ":init");
        ModRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

        System.out.println(Reference.MODID + ":postinit");
    }

}
