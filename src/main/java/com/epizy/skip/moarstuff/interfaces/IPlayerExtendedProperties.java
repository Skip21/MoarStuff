package com.epizy.skip.moarstuff.interfaces;

import net.minecraft.nbt.NBTTagCompound;

public interface IPlayerExtendedProperties {

    boolean isSleeping();

    void setSleeping(boolean value);

    int getMaxHealth();

    void setMaxHealth(int value);

    NBTTagCompound getDataAsNBT();

    void setDataFromNBT(NBTTagCompound nbt);

}
