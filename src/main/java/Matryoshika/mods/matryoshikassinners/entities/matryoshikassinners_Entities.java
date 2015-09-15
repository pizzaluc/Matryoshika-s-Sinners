package Matryoshika.mods.matryoshikassinners.entities;

import java.util.Random;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import Matryoshika.mods.matryoshikassinners.utils.CreativeTabMatryoshika;

public class matryoshikassinners_Entities {

	public static void registerEntities(Class entityClass, String name){
		
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777215;
		int subColor = random.nextInt() * 16777215;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, matryoshikassinners.MODID, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
		
	}
	
}
