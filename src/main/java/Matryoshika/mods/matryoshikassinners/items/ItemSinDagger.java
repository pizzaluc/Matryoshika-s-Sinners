package Matryoshika.mods.matryoshikassinners.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import Matryoshika.mods.matryoshikassinners.matryoshikassinners;

public class ItemSinDagger extends ItemSword {
	
	public ItemSinDagger(ToolMaterial sin) {
		super(sin);
		
		this.setUnlocalizedName("ItemSinDagger");
		this.setTextureName(matryoshikassinners.MODID+":dagger1");
	}

	
}