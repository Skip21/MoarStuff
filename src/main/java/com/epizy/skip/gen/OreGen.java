package com.epizy.skip.gen;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    WorldGenerator oreGen;
    int minHeight, maxHeight, spawnChance, dimension;

    public OreGen(Block blockToGen, int blockCount, int minHeight, int maxHeight, int spawnChance){
        this(blockToGen, blockCount, minHeight, maxHeight, spawnChance, 0, BlockMatcher.forBlock(Blocks.STONE));
    }

    public OreGen(Block blockToGen, int blockCount, int minHeight, int maxHeight, int spawnChance, int dimension){
        this(blockToGen, blockCount, minHeight, maxHeight, spawnChance, dimension, BlockMatcher.forBlock(Blocks.STONE));
    }

    public OreGen(Block blockToGen, int blockAmount, int minHeight, int maxHeight, int spawnChance, int dimension, Predicate<IBlockState> blockToReplace){
        oreGen = new WorldGenMinable(blockToGen.getDefaultState(), blockAmount, blockToReplace);
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.spawnChance = spawnChance;
        this.dimension = dimension;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        if(world.provider.getDimension()==dimension){
            this.runGenerator(this.oreGen, world, random, chunkX, chunkZ, spawnChance, minHeight, maxHeight);
        }

    }



    private void runGenerator(WorldGenerator generator, World worldIn, Random random, int chunkX, int chunkZ, int spawnChance, int minHeight, int maxHeight){

        if(minHeight<0 || maxHeight>256 || minHeight > maxHeight){
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
        }

        int heightDiff = maxHeight - minHeight +1;
        for (int i=0; i<spawnChance; i++){

            int x = chunkX *16 +random.nextInt(16);
            int y = minHeight+random.nextInt(heightDiff);
            int z = chunkZ*16+random.nextInt(16);
            generator.generate(worldIn, random, new BlockPos(x, y, z));

        }

    }
}
