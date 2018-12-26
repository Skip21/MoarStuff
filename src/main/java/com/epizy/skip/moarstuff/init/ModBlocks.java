package com.epizy.skip.moarstuff.init;

import com.epizy.skip.moarstuff.Reference;
import com.epizy.skip.moarstuff.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


//DON'T FORGET THAT LINE RIGHT BELOW
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBlocks {

    //Blocks declaration

    public static Block PLANK_HAZEL;
    public static Block LOG_HAZEL;
    public static Block LEAVES_HAZEL;
    public static Block SAPLING_HAZEL;

    public static Block BLOCK_SHARD_BASIC;
    public static Block BLOCK_COPPER;
    public static Block BLOCK_LEAD;

    public static Block ORE_SHARD;
    public static Block ORE_COPPER;
    public static Block ORE_LEAD;


    //Blocks initialization

    public static void init() {
        BLOCK_SHARD_BASIC = new BlockBasic("block_shard_basic", Material.ROCK).setHardness(1.6f);
        BLOCK_COPPER = new BlockBasic("block_copper", Material.ROCK).setHardness(1.6f);
        BLOCK_LEAD = new BlockBasic("block_lead", Material.ROCK).setHardness(1.6f);

        ORE_SHARD = new BlockOre("ore_shard", Material.ROCK, ModItems.SHARD_BASIC, 1, 3).setHardness(2.0f);
        ORE_SHARD.setHarvestLevel("pickaxe", 2);
        ORE_COPPER = new BlockOre("ore_copper", Material.ROCK).setHardness(1.6f);
        ORE_COPPER.setHarvestLevel("pickaxe", 1);
        ORE_LEAD = new BlockOre("ore_lead", Material.ROCK).setHardness(1.8f);
        ORE_LEAD.setHarvestLevel("pickaxe", 1);

        PLANK_HAZEL = new BlockBasic("plank_hazel", Material.WOOD);
        LOG_HAZEL = new BlockModLog("log_hazel");
        SAPLING_HAZEL = new BlockModSapling("sapling_hazel");
        LEAVES_HAZEL = new BlockModLeaves("leaves_hazel", SAPLING_HAZEL);

    }

    //Blocks registering

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BLOCK_SHARD_BASIC, ORE_SHARD, ORE_COPPER, BLOCK_COPPER, ORE_LEAD, BLOCK_LEAD,
                PLANK_HAZEL, LOG_HAZEL, LEAVES_HAZEL, SAPLING_HAZEL);
    }

    //Blocks' icon registering

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(new ItemBlock(BLOCK_SHARD_BASIC).setRegistryName(BLOCK_SHARD_BASIC.getRegistryName()), new ItemBlock(ORE_SHARD).setRegistryName(ORE_SHARD.getRegistryName()),
        new ItemBlock(ORE_COPPER).setRegistryName(ORE_COPPER.getRegistryName()), new ItemBlock(BLOCK_COPPER).setRegistryName(BLOCK_COPPER.getRegistryName()), new ItemBlock(ORE_LEAD).setRegistryName(ORE_LEAD.getRegistryName()),
        new ItemBlock(BLOCK_LEAD).setRegistryName(BLOCK_LEAD.getRegistryName()), new ItemBlock(PLANK_HAZEL).setRegistryName(PLANK_HAZEL.getRegistryName()),
        new ItemBlock(LOG_HAZEL).setRegistryName(LOG_HAZEL.getRegistryName()), new ItemBlock(LEAVES_HAZEL).setRegistryName(LEAVES_HAZEL.getRegistryName()),
        new ItemBlock(SAPLING_HAZEL).setRegistryName(SAPLING_HAZEL.getRegistryName()));
    }

    //Blocks' model registering

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(BLOCK_SHARD_BASIC));
        registerRender(Item.getItemFromBlock(BLOCK_COPPER));
        registerRender(Item.getItemFromBlock(BLOCK_LEAD));

        registerRender(Item.getItemFromBlock(ORE_SHARD));
        registerRender(Item.getItemFromBlock(ORE_COPPER));
        registerRender(Item.getItemFromBlock(ORE_LEAD));

        registerRender(Item.getItemFromBlock(PLANK_HAZEL));
        registerRender(Item.getItemFromBlock(LOG_HAZEL));
        registerRender(Item.getItemFromBlock(LEAVES_HAZEL));
        registerRender(Item.getItemFromBlock(SAPLING_HAZEL));

    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
