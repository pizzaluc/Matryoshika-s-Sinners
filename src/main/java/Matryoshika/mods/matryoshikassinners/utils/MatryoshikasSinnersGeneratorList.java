package Matryoshika.mods.matryoshikassinners.utils;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class MatryoshikasSinnersGeneratorList {
	
	public static Configuration config;
	
	public static String[] generatorWhitelist;
	public static String[] whitelist = {};
	
	public static void init(File configFile) {
		config = new Configuration(configFile);
        config.load();
        syncConfig();
        config.save();
        
	}
	
	public static void syncConfig() {
		
		try {
			
			generatorWhitelist = config.get("Generator Whitelist", "Whitelist", whitelist, "Allows specified RF-generator to be added to the Dynamic Generator. \nSyntax must be: modid:blockname:meta, fueltype, burnModifier, output per tick. \nFuelType is either item or fluid. BurnModifier is how many times faster/slower a regular plank burns (like in a survivalist's generator). \nOtherwise, use 'Regular' as burnModifier. Always add new generators on a new line. \nExample: \nsupermod:blockFurnaceGenerator:0, Item, Regular, 50 \nsupermod:blockWaterGenerator:0, Fluid, regular, 20 \nsupermod:blockMasterGenerator:0, Item, 0.25, 100").getStringList();
			
		}
		
		catch(Exception except){}
		
		finally{
			if(config.hasChanged()){
				config.save();
			}
		}
		
	}

}
