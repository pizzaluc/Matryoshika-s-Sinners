package Matryoshika.mods.matryoshikassinners.worldgen;

import java.util.Random;

import Matryoshika.mods.matryoshikassinners.blocks.matryoshikassinners_Blocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeManager.BiomeType;
import cpw.mods.fml.common.IWorldGenerator;

public class worldGenAltar implements IWorldGenerator{
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		Random randomchunk = new Random();
		int chunkrandom = randomchunk.nextInt(100) + 1;
		if(b.biomeName.equals("Hell")){
			if (chunkrandom <= 3){
			world.setBlock(chunkX*16 + random.nextInt(16), 70, chunkZ*16 + random.nextInt(16), matryoshikassinners_Blocks.AltarPagan);
			world.scheduleBlockUpdate(chunkX, 70, chunkZ, matryoshikassinners_Blocks.AltarPagan, 100);
			}
			else{
				return;
			}
		}
		else{
			return;
		}
	}
	
}