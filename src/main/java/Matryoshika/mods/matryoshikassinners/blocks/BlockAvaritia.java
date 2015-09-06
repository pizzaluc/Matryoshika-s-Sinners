package Matryoshika.mods.matryoshikassinners.blocks;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAvaritia extends Block {
	
	public BlockAvaritia (Block BlockAvaritia){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":BlockAvaritia");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockAvaritia");
	}

}
