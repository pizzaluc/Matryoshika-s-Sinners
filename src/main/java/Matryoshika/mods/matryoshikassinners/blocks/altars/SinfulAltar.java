package Matryoshika.mods.matryoshikassinners.blocks.altars;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SinfulAltar extends Block {
	
	public SinfulAltar (Block SinfulAltar){
		super(Material.iron);
		setStepSound(soundTypeStone);
		setBlockTextureName(matryoshikassinners.MODID+":SinfulAltar");
		setHardness(10);
		this.setResistance(18000000);
		this.setBlockName("SinfulAltar");
	}

}
