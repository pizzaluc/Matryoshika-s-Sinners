package Matryoshika.mods.matryoshikassinners.blocks.altars;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DemonicAltar extends Block {
	
	public DemonicAltar (Block DemonicAltar){
		super(Material.iron);
		setStepSound(soundTypeStone);
		setBlockTextureName(matryoshikassinners.MODID+":DemonicAltar");
		setHardness(10);
		this.setResistance(18000000);
		this.setBlockName("DemonicAltar");
	}

}
