package com.epizy.skip.moarstuff.items;


import com.epizy.skip.moarstuff.CustomTabs;
import com.epizy.skip.moarstuff.MoarStuff;
import com.epizy.skip.moarstuff.interfaces.IPlayerExtendedProperties;
import com.epizy.skip.moarstuff.registry.CapabilityRegistry;
import com.epizy.skip.moarstuff.network.PacketSyncPlayerHealth;
import com.epizy.skip.moarstuff.utils.UtilEntity;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import javax.annotation.Nullable;
import java.util.List;

public class HealthBooster extends ItemFood {

    private int bonusHealth;
    private static final int foodNum = 2;
    public static int defaultHearts = 10;
    private static int maxHearts = 20;

    public HealthBooster(String name, int bonusHealth){

        super(foodNum, false);

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(CustomTabs.tabMoarStuffBase);

        this.bonusHealth = bonusHealth;

    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        IPlayerExtendedProperties prop = CapabilityRegistry.getPlayerProperties(player);
        int heartBoost = 2*bonusHealth;

        int newVal = UtilEntity.incrementMaxHealth(player, heartBoost);
        prop.setMaxHealth(newVal);

    }

    @SubscribeEvent
    public void onPlayerWarp(PlayerChangedDimensionEvent event){

        IPlayerExtendedProperties props = CapabilityRegistry.getPlayerProperties(event.player);
        if (props.getMaxHealth() > 0 && event.player instanceof EntityPlayerMP){

            MoarStuff.network.sendTo(new PacketSyncPlayerHealth(props.getMaxHealth()), (EntityPlayerMP) event.player);

        }

    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){

        IPlayerExtendedProperties src = CapabilityRegistry.getPlayerProperties(event.getOriginal());
        IPlayerExtendedProperties dest = CapabilityRegistry.getPlayerProperties(event.getEntityPlayer());
        dest.setDataFromNBT(src.getDataAsNBT());

        if(src.getMaxHealth() > 0){

            UtilEntity.setMaxHealth(event.getEntityPlayer(), src.getMaxHealth());

        }

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        if(bonusHealth == 1) tooltip.add(I18n.format("Adds "+bonusHealth+" heart when eaten"));
        else tooltip.add(I18n.format("Adds "+bonusHealth+" hearts when eaten"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        double currentHearts = UtilEntity.getMaxHealth(playerIn)/2;

        if (currentHearts + bonusHealth > maxHearts || currentHearts + bonusHealth < 1){
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
}
