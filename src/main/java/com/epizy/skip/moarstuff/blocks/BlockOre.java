package com.epizy.skip.moarstuff.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOre extends BlockBasic {

    //Stuff to drop and amount declaration as local variables

    Item toDrop;
    int minAmount;
    int maxAmount;

    //Constructors

    public BlockOre(String name, Material material){
        this(name, material, null, 1, 1);
    }

    public BlockOre(String name, Material material, Item toDrop){
        this(name, material, toDrop, 1, 1);
    }

    public BlockOre(String name, Material material, Item toDrop, int dropAmount){
        this(name, material, toDrop, dropAmount, dropAmount);
    }

    //Main constructor

    public BlockOre(String name, Material material, Item toDrop, int minAmount, int maxAmount){
        super(name, material);
        this.toDrop = toDrop;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    //Checking if items should drop himself or something else

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune){
        return toDrop==null?Item.getItemFromBlock(this):toDrop;
    }

    //Setting amount of items to drop

    @Override
    public int quantityDropped(Random random)    {
        if(this.minAmount>this.maxAmount) {
            int i = this.minAmount;
            this.minAmount=this.maxAmount;
            this.maxAmount=i;
        }
        return this.minAmount + random.nextInt(this.maxAmount - this.minAmount + 1);
    }

    //Setting amount to drop when mined with fortune

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random){
        if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)){
            int i = random.nextInt(fortune + 2)-1;
            if(i<0){
                i = 0;
            }
            return this.quantityDropped(random)*(i+1);
        }else{
            return this.quantityDropped(random);
        }
    }

}
