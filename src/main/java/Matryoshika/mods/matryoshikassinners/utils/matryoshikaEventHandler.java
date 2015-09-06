package Matryoshika.mods.matryoshikassinners.utils;

import Matryoshika.mods.matryoshikassinners.entities.EntityAcedia;
import Matryoshika.mods.matryoshikassinners.entities.EntityAvaritia;
import Matryoshika.mods.matryoshikassinners.entities.EntityGula;
import Matryoshika.mods.matryoshikassinners.entities.EntityInvidia;
import Matryoshika.mods.matryoshikassinners.entities.EntityIra;
import Matryoshika.mods.matryoshikassinners.entities.EntityLuxuria;
import Matryoshika.mods.matryoshikassinners.entities.EntitySuperbia;
import Matryoshika.mods.matryoshikassinners.items.matryoshikassinners_Items;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class matryoshikaEventHandler {
	
	
	@SubscribeEvent
	public void allowSinWeapon (AttackEntityEvent attacker){
		
		Entity target = attacker.target;

			if((target instanceof EntityAcedia || 
					target instanceof EntityAvaritia || 
					target instanceof EntityGula || 
					target instanceof EntityInvidia || 
					target instanceof EntityIra || 
					target instanceof EntityLuxuria || 
					target instanceof EntitySuperbia)){
				if(attacker.entityPlayer.getCurrentEquippedItem() != null){
					
					ItemStack hand = attacker.entityPlayer.getCurrentEquippedItem();
					if (attacker.entityPlayer.getCurrentEquippedItem().getItem() == matryoshikassinners_Items.SinDagger){
						attacker.setCanceled(false);
					}
					else{
						attacker.setCanceled(true);
					}
				}
				else{
					attacker.setCanceled(true);
				}
			}
			else
			{
				return;
			}
	}
}