package Matryoshika.mods.matryoshikassinners.blocks.sinblocks;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGula extends Block {
	
	public BlockGula (Block BlockGula){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":BlockGula");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockGula");
	}

}