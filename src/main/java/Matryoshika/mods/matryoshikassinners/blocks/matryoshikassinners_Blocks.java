package Matryoshika.mods.matryoshikassinners.blocks;

import java.util.ArrayList;
import java.util.List;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import Matryoshika.mods.matryoshikassinners.blocks.altars.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class matryoshikassinners_Blocks {
	
	public static Block MatryoshikaBrain;
	public static Block AcediaBlock;
	public static Block AvaritiaBlock;
	public static Block GulaBlock;
	public static Block InvidiaBlock;
	public static Block IraBlock;
	public static Block LuxuriaBlock;
	public static Block SuperbiaBlock;
	
	public static Block AltarPagan;
	public static Block AltarCultist;
	public static Block AltarEvil;
	public static Block AltarSinful;
	public static Block AltarDemonic;
	
	public static List<Block>BlockList=new ArrayList<Block>();
	
	public static void registerBlocks() {
		BlockList.add(MatryoshikaBrain = new BlockMatryoshikaBrain(MatryoshikaBrain).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AcediaBlock = new BlockAcedia(AcediaBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(GulaBlock = new BlockGula(GulaBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(InvidiaBlock = new BlockInvidia(InvidiaBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(IraBlock = new BlockIra(IraBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(LuxuriaBlock = new BlockLuxuria(LuxuriaBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(SuperbiaBlock = new BlockSuperbia(SuperbiaBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AvaritiaBlock = new BlockAvaritia(AvaritiaBlock).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AltarPagan = new PaganAltar(AltarPagan).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AltarCultist = new CultistAltar(AltarCultist).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AltarEvil = new EvilAltar(AltarEvil).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AltarSinful = new SinfulAltar(AltarSinful).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		BlockList.add(AltarDemonic = new DemonicAltar(AltarDemonic).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		
		for(Block block:BlockList){
			GameRegistry.registerBlock(block,  block.getUnlocalizedName());
		}
		
	}

}
