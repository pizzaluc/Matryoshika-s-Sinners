package Matryoshika.mods.matryoshikassinners.blocks.altars;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class EvilAltar extends Block{
	
	public EvilAltar (Block EvilAltar){
		super(Material.iron);
		setStepSound(soundTypeStone);
		setBlockTextureName(matryoshikassinners.MODID+":EvilAltar");
		setHardness(10);
		this.setResistance(18000000);
		this.setBlockName("EvilAltar");
	}

}
