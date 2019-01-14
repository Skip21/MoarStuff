package com.epizy.skip.moarstuff.network;

import com.epizy.skip.moarstuff.MoarStuff;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSyncPlayerData implements IMessage, IMessageHandler<PacketSyncPlayerData, IMessage> {

    NBTTagCompound tags = new NBTTagCompound();

    public PacketSyncPlayerData() {}

    public PacketSyncPlayerData(NBTTagCompound ptags){
        tags = ptags;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, this.tags);
    }

    @Override
    public IMessage onMessage(PacketSyncPlayerData message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT){
            PacketSyncPlayerData.checkThreadAndEnqueue(message, ctx);
        }
        return null;
    }

    private static void checkThreadAndEnqueue(PacketSyncPlayerData message, MessageContext ctx) {

        IThreadListener thread = MoarStuff.proxy.getThreadFromContext(ctx);
        thread.addScheduledTask(new Runnable() {

            public void run() {
                MoarStuff.proxy.setClientPlayerData(ctx, message.tags);
            }
        });

    }
}
