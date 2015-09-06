package Matryoshika.mods.matryoshikassinners.blocks;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInvidia extends Block {
	
	public BlockInvidia (Block BlockInvidia){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":BlockInvidia");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockInvidia");
	}

}