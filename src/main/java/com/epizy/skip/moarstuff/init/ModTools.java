package com.epizy.skip.moarstuff.init;

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
public class ModTools {

    /*Material declaration

    Parameters :
        Name - String
        HarvestLevel (What it can mine) - Int
        Durability - Int
        Efficiency (How fast it can mine) - Float
        Damages (How much it deals) - Float
        Enchantability - Int

     */

    public static final Item.ToolMaterial LEADITEM = EnumHelper.addToolMaterial("leaditem", 2, 600, 7.0f, 2.5f, 13);
    public static final Item.ToolMaterial COPPERITEM = EnumHelper.addToolMaterial("copperitem", 2, 200, 6.5f, 2.0f, 13);

    public static final Item.ToolMaterial OMNILEAD = EnumHelper.addToolMaterial("omni"+LEADITEM.name(), LEADITEM.getHarvestLevel(), (LEADITEM.getMaxUses()*4), LEADITEM.getEfficiency(), LEADITEM.getAttackDamage(), LEADITEM.getEnchantability());
    public static final Item.ToolMaterial OMNICOPPER = EnumHelper.addToolMaterial("omni"+COPPERITEM.name(), COPPERITEM.getHarvestLevel(), (COPPERITEM.getMaxUses()*4), COPPERITEM.getEfficiency(), COPPERITEM.getAttackDamage(), COPPERITEM.getEnchantability());

    //Tools declaration

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
    public static Item OMNI_COPPER;

    //Initializing tools

    public static void init() {

        PICKAXE_LEAD = new CustomPickaxe("pickaxe_lead", LEADITEM);
        HOE_LEAD = new CustomHoe("hoe_lead", LEADITEM);
        SWORD_LEAD = new CustomSword("sword_lead", LEADITEM);
        AXE_LEAD = new CustomAxe("axe_lead", LEADITEM, 8.0f, -2.9f);
        SHOVEL_LEAD = new CustomShovel("shovel_lead", LEADITEM);
        OMNI_LEAD = new Omnitool("omni_lead", OMNILEAD);

        OMNI_COPPER = new Omnitool("omni_copper", OMNICOPPER);

    }

    //Registering tools

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(PICKAXE_LEAD, SHOVEL_LEAD, HOE_LEAD, SWORD_LEAD, AXE_LEAD, OMNI_LEAD, OMNI_COPPER);
    }

    // Registering tools' render

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){

        registerRender(PICKAXE_LEAD);
        registerRender(SHOVEL_LEAD);
        registerRender(HOE_LEAD);
        registerRender(SWORD_LEAD);
        registerRender(AXE_LEAD);
        registerRender(OMNI_LEAD);

        registerRender(OMNI_COPPER);

    }

    private static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
