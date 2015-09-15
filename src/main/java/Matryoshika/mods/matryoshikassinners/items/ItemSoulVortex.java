package Matryoshika.mods.matryoshikassinners.items;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ItemSoulVortex extends Item {
	public ItemSoulVortex(ToolMaterial soul){
		super();
		this.maxStackSize = 16;
		this.setUnlocalizedName("ItemSoulVortex");
		this.setTextureName(matryoshikassinners.MODID+":soul");
	}
	
}
