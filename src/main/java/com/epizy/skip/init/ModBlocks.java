package com.epizy.skip.init;

import com.epizy.skip.Reference;
import com.epizy.skip.blocks.BlockBasic;
import com.epizy.skip.blocks.BlockOre;
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

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBlocks {

    public static Block basicBlock;
    public static Block shardOre;
    public static Block malachiteOre;
    public static Block malachiteBlock;

    public static void init() {
        basicBlock = new BlockBasic("basicBlock", Material.ROCK);
        shardOre = new BlockOre("shardOre", Material.ROCK, ModItems.basicShard, 1, 3).setHardness(2.0f);
        shardOre.setHarvestLevel("pickaxe", 2);
        malachiteOre = new BlockOre("malachiteOre", Material.ROCK).setHardness(1.6f);
        malachiteOre.setHarvestLevel("pickaxe", 1);
        malachiteBlock = new BlockBasic("malachiteBlock", Material.ROCK).setHardness(1.6f);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(basicBlock, shardOre, malachiteOre, malachiteBlock);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(new ItemBlock(basicBlock).setRegistryName(basicBlock.getRegistryName()), new ItemBlock(shardOre).setRegistryName(shardOre.getRegistryName()),
        new ItemBlock(malachiteOre).setRegistryName(malachiteOre.getRegistryName()), new ItemBlock(malachiteBlock).setRegistryName(malachiteBlock.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(basicBlock));
        registerRender(Item.getItemFromBlock(shardOre));
        registerRender(Item.getItemFromBlock(malachiteOre));
        registerRender(Item.getItemFromBlock(malachiteBlock));
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
