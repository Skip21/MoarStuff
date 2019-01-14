package com.epizy.skip.moarstuff;

import com.epizy.skip.moarstuff.gen.ModTreesGen;
import com.epizy.skip.moarstuff.gen.OreGen;
import com.epizy.skip.moarstuff.handlers.OreDictionaryHandler;
import com.epizy.skip.moarstuff.init.*;
import com.epizy.skip.moarstuff.interfaces.IPlayerExtendedProperties;
import com.epizy.skip.moarstuff.proxy.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.core.Logger;


@Mod(modid=Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class MoarStuff {

    @Instance
    public static MoarStuff instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy proxy;

    public static Logger logger;
    public static SimpleNetworkWrapper network;
    @CapabilityInject(IPlayerExtendedProperties.class)
    public static final Capability<IPlayerExtendedProperties> CAPABILITYSTORAGE = null;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ModTools.init();
        ModItems.init();
        ModBlocks.init();
        ModArmor.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

        OreDictionaryHandler.registerOreDictionary();
        ModRecipes.init();
        ModTreesGen.register();
        GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.ORE_SHARD, 4, 1, 25, 6), 0);
        GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.ORE_COPPER, 8, 40, 54, 11), 0);
        GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.ORE_LEAD, 6, 1, 30, 8), 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }

}
