package Matryoshika.mods.matryoshikassinners.items.souls;

import java.util.List;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumChatFormatting;

public class AnimalSoul extends Item{
	public AnimalSoul(ToolMaterial soul){
		super();
		this.maxStackSize = 16;
		this.setUnlocalizedName("ItemAnimalSoul");
		this.setTextureName(matryoshikassinners.MODID+":soul");
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par){
		list.add(EnumChatFormatting.DARK_GRAY + "Belonged to an innocent but undeveloped soul...");
	}
	@Override
	public boolean hasEffect(ItemStack stack){
		return true;
	}

}