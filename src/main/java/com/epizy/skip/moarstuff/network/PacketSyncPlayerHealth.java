package com.epizy.skip.moarstuff.network;

import com.epizy.skip.moarstuff.MoarStuff;
import com.epizy.skip.moarstuff.utils.UtilEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSyncPlayerHealth implements IMessage, IMessageHandler<PacketSyncPlayerHealth, IMessage>{

    private int health;

    public PacketSyncPlayerHealth() {}

    public PacketSyncPlayerHealth(int h){

        health = h;

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound tags = ByteBufUtils.readTag(buf);
        health = tags.getInteger("h");
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound tags = new NBTTagCompound();
        tags.setInteger("h", health);
        ByteBufUtils.writeTag(buf, tags);
    }

    @Override
    public IMessage onMessage(PacketSyncPlayerHealth message, MessageContext ctx) {
        if (ctx.side == Side.CLIENT) {
            EntityPlayer p = MoarStuff.proxy.getPlayerEntity(ctx);
            if (p != null) {
                //force clientside hearts to update and match real value
                UtilEntity.setMaxHealth(p, message.health);
            }
        }
        return null;
    }

}
