package Matryoshika.mods.matryoshikassinners;

import Matryoshika.mods.matryoshikassinners.rendering.GUI.GuiDynamicGenerator;
import Matryoshika.mods.matryoshikassinners.rendering.GUIHandler.MSGuiHandler;
import Matryoshika.mods.matryoshikassinners.utils.ConfigHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.config.Configuration;

public class CommonProxy {

	public void registerRenderers(){
		
	}
	
	public void registerEntities(){
		
	}
	
	public void initCommon() {
	       NetworkRegistry.INSTANCE.registerGuiHandler(matryoshikassinners.MODID, new MSGuiHandler());
	}

	public void initClient() {

	}

	public void initServer() {

	}
	
	public void preInit(FMLPreInitializationEvent event){
		
	}
	
}
