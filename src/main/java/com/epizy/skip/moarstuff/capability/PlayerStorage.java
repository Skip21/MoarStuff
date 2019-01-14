package com.epizy.skip.moarstuff.capability;

import com.epizy.skip.moarstuff.MoarStuff;
import com.epizy.skip.moarstuff.interfaces.IPlayerExtendedProperties;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerStorage implements Capability.IStorage<IPlayerExtendedProperties> {

    @Override
    public NBTTagCompound writeNBT(Capability<IPlayerExtendedProperties> capability, IPlayerExtendedProperties instance, EnumFacing side){
        return instance.getDataAsNBT();
    }

    @Override
    public void readNBT(Capability<IPlayerExtendedProperties> capability, IPlayerExtendedProperties instance, EnumFacing side, NBTBase nbt) {

        try{
            instance.setDataFromNBT((NBTTagCompound) nbt);
        }
        catch (Exception e){
            MoarStuff.logger.error("Invalid NBT Coumpound : "+e.getMessage());
            MoarStuff.logger.error(e.getStackTrace().toString());
        }
    }
}
