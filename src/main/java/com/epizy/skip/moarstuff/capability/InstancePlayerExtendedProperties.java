package com.epizy.skip.moarstuff.capability;

import com.epizy.skip.moarstuff.interfaces.IPlayerExtendedProperties;
import com.epizy.skip.moarstuff.items.HealthBooster;
import net.minecraft.nbt.NBTTagCompound;

public class InstancePlayerExtendedProperties implements IPlayerExtendedProperties {

    private static final String MHEALTH = "mhealth";
    private static final String IS_SLEEPING = "isSleeping";
    private int health = HealthBooster.defaultHearts * 2;
    private boolean isSleeping = false;

    @Override
    public int getMaxHealth() {
        return health;
    }

    @Override
    public void setMaxHealth(int value) {
        health = value;
    }

    @Override
    public boolean isSleeping() {
        return isSleeping;
    }

    @Override
    public void setSleeping(boolean sleeping) {
        this.isSleeping = sleeping;
    }

    @Override
    public NBTTagCompound getDataAsNBT() {
        NBTTagCompound tags = new NBTTagCompound();
        tags.setByte(IS_SLEEPING, (byte)(this.isSleeping() ? 1 : 0));
        tags.setInteger(MHEALTH, this.getMaxHealth());
        return tags;
    }

    @Override
    public void setDataFromNBT(NBTTagCompound nbt) {
        NBTTagCompound tags;
        if (nbt instanceof NBTTagCompound == false){
            tags = new NBTTagCompound();
        }else {
            tags = (NBTTagCompound) nbt;
        }
        this.setMaxHealth(tags.getInteger(MHEALTH));
        this.setSleeping(tags.getByte(IS_SLEEPING) == 1);
    }
}
