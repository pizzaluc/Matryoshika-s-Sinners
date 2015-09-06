package Matryoshika.mods.matryoshikassinners.blocks.altars;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CultistAltar extends Block {
	
	public CultistAltar (Block CultistAltar){
		super(Material.iron);
		setStepSound(soundTypeStone);
		setBlockTextureName(matryoshikassinners.MODID+":CultistAltar");
		setHardness(10);
		this.setResistance(18000000);
		this.setBlockName("CultistAltar");
	}

}
