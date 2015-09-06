package Matryoshika.mods.matryoshikassinners.blocks;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIra extends Block {
	
	public BlockIra (Block BlockIra){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":BlockIra");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockIra");
	}

}