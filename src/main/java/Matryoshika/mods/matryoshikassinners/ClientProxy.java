package Matryoshika.mods.matryoshikassinners;

import Matryoshika.mods.matryoshikassinners.entities.EntityAcedia;
import Matryoshika.mods.matryoshikassinners.entities.EntityAvaritia;
import Matryoshika.mods.matryoshikassinners.entities.EntityGula;
import Matryoshika.mods.matryoshikassinners.entities.EntityInvidia;
import Matryoshika.mods.matryoshikassinners.entities.EntityIra;
import Matryoshika.mods.matryoshikassinners.entities.EntityLuxuria;
import Matryoshika.mods.matryoshikassinners.entities.EntitySuperbia;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderAcedia;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderAvaritia;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderGula;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderInvidia;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderIra;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderLuxuria;
import Matryoshika.mods.matryoshikassinners.rendering.entities.RenderSuperbia;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.model.ModelBiped;

public class ClientProxy extends CommonProxy {
	
	int ModEntityID;

	public void registerRenderers(){
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAcedia.class, new RenderAcedia(new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityAvaritia.class, new RenderAvaritia(new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGula.class, new RenderGula(new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityInvidia.class, new RenderInvidia(new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityIra.class, new RenderIra(new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityLuxuria.class, new RenderLuxuria(new ModelBiped(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperbia.class, new RenderSuperbia(new ModelBiped(), 0));
		
	}
	
}
