package com.epizy.skip;

import com.epizy.skip.gen.OreGen;
import com.epizy.skip.init.ModBlocks;
import com.epizy.skip.init.ModItems;
import com.epizy.skip.init.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;


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
        GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.shardOre, 4, 1, 25, 6), 0);
        GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.malachiteOre, 8, 40, 54, 11), 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

        System.out.println(Reference.MODID + ":postinit");
    }

}
