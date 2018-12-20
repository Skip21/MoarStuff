package com.epizy.skip.moarstuff.init;

import com.epizy.skip.moarstuff.Reference;
import com.epizy.skip.moarstuff.items.ItemModArmor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModArmor {

    public static ItemArmor.ArmorMaterial COPPERARMOR = EnumHelper.addArmorMaterial("copperamor", Reference.MODID+":copper", 200, new int[] {2,6,5,2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0f);

    public static ItemArmor HELMET_COPPER;
    public static ItemArmor CHESTPLATE_COPPER;
    public static ItemArmor LEGGINGS_COPPER;
    public static ItemArmor BOOTS_COPPER;

    public static void init(){

        HELMET_COPPER = new ItemModArmor(COPPERARMOR, 1, EntityEquipmentSlot.HEAD, "helmet_copper");
        CHESTPLATE_COPPER = new ItemModArmor(COPPERARMOR, 1, EntityEquipmentSlot.CHEST, "chestplate_copper");
        LEGGINGS_COPPER = new ItemModArmor(COPPERARMOR, 2, EntityEquipmentSlot.LEGS, "leggings_copper");
        BOOTS_COPPER = new ItemModArmor(COPPERARMOR, 1, EntityEquipmentSlot.FEET, "boots_copper");

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){

        event.getRegistry().registerAll(HELMET_COPPER, CHESTPLATE_COPPER, LEGGINGS_COPPER, BOOTS_COPPER);

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){

        registerRender(HELMET_COPPER);
        registerRender(CHESTPLATE_COPPER);
        registerRender(LEGGINGS_COPPER);
        registerRender(BOOTS_COPPER);

    }

    private static void registerRender(Item item){

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        
    }

}
