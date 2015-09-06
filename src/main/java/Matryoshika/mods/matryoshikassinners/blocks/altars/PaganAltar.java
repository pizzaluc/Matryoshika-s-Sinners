package Matryoshika.mods.matryoshikassinners.blocks.altars;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;

public class PaganAltar extends BlockFalling {
	
	
	public PaganAltar (Block PaganAltar){
		super();
		setStepSound(soundTypeStone);
		setBlockTextureName(matryoshikassinners.MODID+":PaganAltar");
		setHardness(-1);
		this.setResistance(18000000);
		this.setBlockName("PaganAltar");
	}
}
