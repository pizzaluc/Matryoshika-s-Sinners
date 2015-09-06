package Matryoshika.mods.matryoshikassinners.blocks;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLuxuria extends Block {
	
	public BlockLuxuria (Block BlockLuxuria){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":BlockLuxuria");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockLuxuria");
	}

}