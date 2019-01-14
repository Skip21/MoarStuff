package com.epizy.skip.moarstuff.proxy;

import com.epizy.skip.moarstuff.interfaces.IPlayerExtendedProperties;
import com.epizy.skip.moarstuff.registry.CapabilityRegistry;
import com.epizy.skip.moarstuff.utils.UtilEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
    }

    @Override
    public void init() {
    }

    @Override
    public World getClientWorld() {
        return FMLClientHandler.instance().getClient().world;
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().player;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public EnumFacing getSideMouseover(int max) {
        RayTraceResult mouseOver = Minecraft.getMinecraft().getRenderViewEntity().rayTrace(max, 1f);

        if (mouseOver != null) return mouseOver.sideHit;
        return null;

    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockPos getBlockMouseoverSingle() {
        RayTraceResult mouseOver = Minecraft.getMinecraft().objectMouseOver;
        if (mouseOver == null) {
            return null;
        }
        return mouseOver.getBlockPos();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockPos getBlockMouseoverExact(int max) {
        // Get the player and their held item
        RayTraceResult mouseOver = Minecraft.getMinecraft().getRenderViewEntity().rayTrace(max, 1f);
        // now get whatever block position we are mousing over if anything
        if (mouseOver != null) {
            // Get the block position and make sure it is a block
            return mouseOver.getBlockPos();
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockPos getBlockMouseoverOffset(int max) {
        // Get the player and their held item
        EntityPlayerSP player = (EntityPlayerSP) getClientPlayer();
        // int max = 50;
        RayTraceResult mouseOver = Minecraft.getMinecraft().getRenderViewEntity().rayTrace(max, 1f);
        // now get whatever block position we are mousing over if anything
        if (mouseOver != null && mouseOver.sideHit != null) {
            // Get the block position and make sure it is a block
            // World world = player.worldObj;
            BlockPos blockPos = mouseOver.getBlockPos();
            if (blockPos != null && player != null && player.getEntityWorld().getBlockState(blockPos) != null
                    && player.getEntityWorld().isAirBlock(blockPos) == false) {
                return blockPos.offset(mouseOver.sideHit);
            }
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setClientPlayerData(MessageContext ctx, NBTTagCompound tags) {
        EntityPlayer player = this.getPlayerEntity(ctx);
        if (player != null) {
            IPlayerExtendedProperties props = CapabilityRegistry.getPlayerProperties(getClientPlayer());
            if (props != null) {
                props.setDataFromNBT(tags);
                if (props.getMaxHealth() != 0 && props.getMaxHealth() > player.getMaxHealth()) {//it doesnt always need to do this somehow. i get 24>20 sometimes then 24>24 other tiems
                    UtilEntity.setMaxHealth(player, props.getMaxHealth());
                }
            }
        }
    }

    @Override
    public IThreadListener getThreadFromContext(MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft() : super.getThreadFromContext(ctx));
    }

    @Override
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return (ctx.side.isClient() ? getClientPlayer() : super.getPlayerEntity(ctx));
    }
}
