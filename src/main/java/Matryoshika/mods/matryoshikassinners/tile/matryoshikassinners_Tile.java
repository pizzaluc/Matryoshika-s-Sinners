package Matryoshika.mods.matryoshikassinners.tile;

import java.util.ArrayList;
import java.util.List;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class matryoshikassinners_Tile {

	public static TileEntity MatryoshikaBrain;
	
	public static List<TileEntity>TileList=new ArrayList<TileEntity>();
	
	public static void registerTiles() {
		TileList.add(MatryoshikaBrain = new TileEntityMatryoshikaBrain());
		
		for(TileEntity Tile:TileList){
			
		}
		
	}

}
