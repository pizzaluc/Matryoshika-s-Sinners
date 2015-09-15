package Matryoshika.mods.matryoshikassinners.tile;

import java.util.ArrayList;
import java.util.List;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import Matryoshika.mods.matryoshikassinners.tile.generator.TileGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class matryoshikassinners_Tile {

	public static TileEntity DynamicGenerator;
	
	public static List<TileEntity>TileList=new ArrayList<TileEntity>();
	
	public static void registerTiles() {
		
		TileList.add(DynamicGenerator = new TileGenerator());
		
		for(TileEntity Tile:TileList){
			
		}
		
	}

}
