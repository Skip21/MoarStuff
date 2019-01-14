package com.epizy.skip.moarstuff.utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

import java.util.UUID;

public class UtilEntity {

    private static final UUID HEALTH_MODIFIER_ID = UUID.fromString("d3855c89-e53c-45f7-87a7-fd5f79b4f9cb");
    public static final String HEALTH_MODIFIER_NAME = "MoarStuff Health Modifier";

    public static void setMaxHealth(EntityLivingBase living, double max) {
        IAttributeInstance healthAttribute = living.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        double amount = max - healthAttribute.getBaseValue();
        AttributeModifier modifier = healthAttribute.getModifier(HEALTH_MODIFIER_ID);
        // Need to remove modifier to apply a new one
        if (modifier != null) {
            healthAttribute.removeModifier(modifier);
        }
        // Operation 0 is a flat increase
        modifier = new AttributeModifier(HEALTH_MODIFIER_ID, HEALTH_MODIFIER_NAME, amount, 0);
        healthAttribute.applyModifier(modifier);
    }

    public static double getMaxHealth(EntityLivingBase living) {
        IAttributeInstance healthAttribute = living.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        double maxHealth = healthAttribute.getBaseValue();
        AttributeModifier modifier = healthAttribute.getModifier(HEALTH_MODIFIER_ID);
        if (modifier != null) {
            maxHealth += modifier.getAmount();
        }
        return maxHealth;
    }

    public static int incrementMaxHealth(EntityLivingBase living, int by) {
        int newVal = (int) getMaxHealth(living) + by;
        setMaxHealth(living, newVal);
        return newVal;
    }

}
