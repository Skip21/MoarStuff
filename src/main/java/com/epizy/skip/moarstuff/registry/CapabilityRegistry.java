package com.epizy.skip.moarstuff.registry;

import com.epizy.skip.moarstuff.MoarStuff;
import com.epizy.skip.moarstuff.interfaces.IPlayerExtendedProperties;
import com.epizy.skip.moarstuff.network.PacketSyncPlayerData;
import com.epizy.skip.moarstuff.capability.InstancePlayerExtendedProperties;
import com.epizy.skip.moarstuff.capability.PlayerStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityRegistry {

    @SuppressWarnings("deprecation")
    public static void register(){

        CapabilityManager.INSTANCE.register(IPlayerExtendedProperties.class, new PlayerStorage(),
                InstancePlayerExtendedProperties.class);

    }

    public static IPlayerExtendedProperties getPlayerProperties(EntityPlayer player){

        IPlayerExtendedProperties c = player.getCapability(MoarStuff.CAPABILITYSTORAGE, null);
        if(c==null){

            //MoarStuff.logger.error("Null IPlayerExtendedProperties error, cannot get properties");

        }
        return c;

    }

    public static void syncServerDataToClient(EntityPlayerMP p){

        if(p==null){
            return;
        }
        IPlayerExtendedProperties props = CapabilityRegistry.getPlayerProperties(p);
        if(props!=null){
            MoarStuff.network.sendTo(new PacketSyncPlayerData(props.getDataAsNBT()), p);
        }
    }

}
