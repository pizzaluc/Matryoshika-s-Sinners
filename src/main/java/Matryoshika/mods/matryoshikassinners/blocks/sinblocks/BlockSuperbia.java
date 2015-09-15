package Matryoshika.mods.matryoshikassinners.blocks.sinblocks;

import java.util.Random;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSuperbia extends Block {
	
	public BlockSuperbia (Block BlockSuperbia){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":Core");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockSuperbia");
	}
}