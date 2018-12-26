package com.epizy.skip.moarstuff.gen;

import com.epizy.skip.moarstuff.gen.Trees.HazelTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ModTreesGen implements IWorldGenerator {

    private final WorldGenerator HAZELTREE = new HazelTree();


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch(world.provider.getDimension()){

            case 1:
                break;

            case 0:

                runGenerator(HAZELTREE, world, random, chunkX, chunkZ, 1, -1, 0, BiomeForest.class);

                break;

            case -1:
        }

    }

    private void runGenerator(WorldGenerator generator, World world, Random random, int ChunkX, int ChunkZ, double spawnChance, int minHeight, int maxHeight, Class<?>... classes){

        if(spawnChance < 1) {
            if (random.nextDouble() < spawnChance)
                spawnChance = 1;
            else
                spawnChance = 0;
        }

        ArrayList<Class<?>> classeslist = new ArrayList<Class<?>>(Arrays.asList(classes));
        int heightDiff = maxHeight - minHeight +1;
        for(int i = 0; i<spawnChance; i++){

            BlockPos pos = new BlockPos(ChunkX*16+10+random.nextInt(15), minHeight+random.nextInt(heightDiff), ChunkZ*16+10+random.nextInt(15));
            if(minHeight<0) pos = world.getHeight(pos);
            Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
            if (classeslist.contains(biome) || classes.length == 0) generator.generate(world, random, pos);

        }

    }

    public static void register(){

        GameRegistry.registerWorldGenerator(new ModTreesGen(), 0);

    }

}
