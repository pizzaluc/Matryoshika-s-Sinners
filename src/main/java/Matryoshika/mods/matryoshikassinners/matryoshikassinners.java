package Matryoshika.mods.matryoshikassinners;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import Matryoshika.mods.matryoshikassinners.blocks.matryoshikassinners_Blocks;
import Matryoshika.mods.matryoshikassinners.enchantments.EnchantmentPurify;
import Matryoshika.mods.matryoshikassinners.entities.EntityAcedia;
import Matryoshika.mods.matryoshikassinners.entities.EntityAvaritia;
import Matryoshika.mods.matryoshikassinners.entities.EntityGula;
import Matryoshika.mods.matryoshikassinners.entities.EntityInvidia;
import Matryoshika.mods.matryoshikassinners.entities.EntityIra;
import Matryoshika.mods.matryoshikassinners.entities.EntityLuxuria;
import Matryoshika.mods.matryoshikassinners.entities.EntitySuperbia;
import Matryoshika.mods.matryoshikassinners.entities.matryoshikassinners_Entities;
import Matryoshika.mods.matryoshikassinners.items.matryoshikassinners_Items;
import Matryoshika.mods.matryoshikassinners.rendering.GUIHandler.MSGuiHandler;
import Matryoshika.mods.matryoshikassinners.utils.ConfigHandler;
import Matryoshika.mods.matryoshikassinners.utils.CreativeTabMatryoshika;
import Matryoshika.mods.matryoshikassinners.utils.MatryoshikasSinnersGeneratorList;
import Matryoshika.mods.matryoshikassinners.utils.SinnersDelight;
import Matryoshika.mods.matryoshikassinners.utils.matryoshikaEventHandler;
import Matryoshika.mods.matryoshikassinners.worldgen.worldGenAltar;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

	@Mod(modid=matryoshikassinners.MODID, version=matryoshikassinners.VERSION, name="matryoshikassinners")
		public class matryoshikassinners {	
		public static final String MODID="matryoshikassinners";
		public static final String LOCALIZING = "MS";
		public static final String VERSION="1.0";

	public static final CreativeTabMatryoshika MatryoshikaTab = new CreativeTabMatryoshika("Matryoshika's Sinners"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Items.ender_eye;
		}
	};
		
	@Instance("matryoshikassinners")
	public static matryoshikassinners instance;
	
	public static final Enchantment purify = new EnchantmentPurify(83, 1);
	public static Potion potionsSinnersDelight;
	
	public static worldGenAltar worldGen = new worldGenAltar();
	
	matryoshikaEventHandler events = new matryoshikaEventHandler();
	
	
	@SidedProxy(clientSide="Matryoshika.mods.matryoshikassinners.ClientProxy",serverSide="Matryoshika.mods.matryoshikassinners.CommonProxy")
	public static CommonProxy proxy;
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ConfigHandler.init(new Configuration(event.getSuggestedConfigurationFile()));
		MatryoshikasSinnersGeneratorList.init(new File(event.getModConfigurationDirectory(), "matryoshikassinnersGenerators.cfg"));
		matryoshikassinners_Items.registerItems();
		matryoshikassinners_Blocks.registerBlocks();
		
	}
	
	
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new matryoshikaEventHandler());
		proxy.registerRenderers();
		proxy.registerEntities();

		
		//Register entities
		matryoshikassinners_Entities.registerEntities(EntityAcedia.class, "Acedia");
		matryoshikassinners_Entities.registerEntities(EntityAvaritia.class, "Avaritia");
		matryoshikassinners_Entities.registerEntities(EntityGula.class, "Gula");
		matryoshikassinners_Entities.registerEntities(EntityInvidia.class, "Invidia");
		matryoshikassinners_Entities.registerEntities(EntityIra.class, "Ira");
		matryoshikassinners_Entities.registerEntities(EntityLuxuria.class, "Luxuria");
		matryoshikassinners_Entities.registerEntities(EntitySuperbia.class, "Superbia");
		
		potionsSinnersDelight = new SinnersDelight(28, true, 0).setIconIndex(0,0).setPotionName("Sinners Delight");

		GameRegistry.registerTileEntity(Matryoshika.mods.matryoshikassinners.tile.generator.TileGenerator.class, "DynamicGenerator");
		
		GameRegistry.registerWorldGenerator(worldGen, 33);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new MSGuiHandler());

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		
		
	}
}
