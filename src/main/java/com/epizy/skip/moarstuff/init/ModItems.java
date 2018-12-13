package com.epizy.skip.moarstuff.init;

import com.epizy.skip.moarstuff.items.ItemBasic;
import com.epizy.skip.moarstuff.items.tools.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    public static final Item.ToolMaterial LEAD = EnumHelper.addToolMaterial("LEAD", 2, 600, 7.0f, 2.5f, 13);
    public static final Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 2, 200, 6.5f, 2.0f, 13);

    public static final Item.ToolMaterial OMNILEAD = EnumHelper.addToolMaterial(LEAD.name(), LEAD.getHarvestLevel(), (LEAD.getMaxUses()*4), LEAD.getEfficiency(), LEAD.getAttackDamage(), LEAD.getEnchantability());

    public static Item PICKAXE_LEAD;
    public static Item AXE_LEAD;
    public static Item HOE_LEAD;
    public static Item SHOVEL_LEAD;
    public static Item SWORD_LEAD;
    public static Item OMNI_LEAD;

    /*public static Item PICKAXE_COPPER;
    public static Item AXE_COPPER;
    public static Item HOE_COPPER;
    public static Item SHOVEL_COPPER;
    public static Item SWORD_COPPER;*/


    public static Item STICK_BASIC;

    public static Item SHARD_BASIC;

    public static Item INGOT_COPPER;
    public static Item INGOT_LEAD;

    public static Item NUGGET_COPPER;
    public static Item NUGGET_LEAD;

    public static void init(){

        PICKAXE_LEAD = new CustomPickaxe("pickaxe_lead", LEAD);
        HOE_LEAD = new CustomHoe("hoe_lead", LEAD);
        SWORD_LEAD = new CustomSword("sword_lead", LEAD);
        AXE_LEAD = new CustomAxe("axe_lead", LEAD, 8.0f, -2.9f);
        SHOVEL_LEAD = new CustomShovel("shovel_lead", LEAD);
        OMNI_LEAD = new Omnitool("omni_lead", OMNILEAD);


        STICK_BASIC = new ItemBasic("stick_basic");

        SHARD_BASIC = new ItemBasic("shard_basic");

        INGOT_COPPER = new ItemBasic("ingot_copper");
        INGOT_LEAD = new ItemBasic("ingot_lead");

        NUGGET_COPPER = new ItemBasic("nugget_copper");
        NUGGET_LEAD = new ItemBasic("nugget_lead");

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(STICK_BASIC, SHARD_BASIC, INGOT_COPPER, NUGGET_COPPER, INGOT_LEAD, NUGGET_LEAD,
        PICKAXE_LEAD, SHOVEL_LEAD, HOE_LEAD, SWORD_LEAD, AXE_LEAD, OMNI_LEAD);

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){
        registerRender(STICK_BASIC);

        registerRender(SHARD_BASIC);

        registerRender(INGOT_COPPER);
        registerRender(INGOT_LEAD);

        registerRender(NUGGET_COPPER);
        registerRender(NUGGET_LEAD);

        registerRender(PICKAXE_LEAD);
        registerRender(SHOVEL_LEAD);
        registerRender(HOE_LEAD);
        registerRender(SWORD_LEAD);
        registerRender(AXE_LEAD);
        registerRender(OMNI_LEAD);
    }

    private static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
