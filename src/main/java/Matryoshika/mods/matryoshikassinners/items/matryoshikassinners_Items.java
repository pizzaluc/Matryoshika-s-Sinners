package Matryoshika.mods.matryoshikassinners.items;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.item.Item.ToolMaterial;
import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import Matryoshika.mods.matryoshikassinners.utils.CreativeTabMatryoshika;
import Matryoshika.mods.matryoshikassinners.items.souls.*;
import net.minecraftforge.common.util.EnumHelper;

public class matryoshikassinners_Items {
	
	public static ToolMaterial SIN = EnumHelper.addToolMaterial("SIN", 3, -1, 15.0F, 21.0F, 0);
	public static ToolMaterial SACRIFICE = EnumHelper.addToolMaterial("sacrifice", 3, -1, 2.0F, -3.0F, 0);
	public static ToolMaterial BOWL = EnumHelper.addToolMaterial("bowl", 0, 1000, 0, 0, 0);
	public static ToolMaterial SOUL = EnumHelper.addToolMaterial("SOUL", 0, -1, 0, 0, 0);
	
	
	public static Item SinDagger;
	public static Item Deathhand;
	public static Item SoulCrucible;
	public static Item VillagerSoul;
	public static Item ZombieSoul;
	public static Item AnimalSoul;
	public static Item BuffMobSoul;
	
	public static List<Item>ItemList=new ArrayList<Item>();
	
	public static void registerItems() {
		ItemList.add(SinDagger = new ItemSinDagger(SIN).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		ItemList.add(Deathhand = new ItemDeathHand(SACRIFICE).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		ItemList.add(SoulCrucible = new ItemSoulCrucible(BOWL).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		ItemList.add(VillagerSoul = new VillagerSoul(SOUL).setCreativeTab(matryoshikassinners.MatryoshikaTab)); 
		ItemList.add(ZombieSoul = new ZombieSoul(SOUL).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		ItemList.add(AnimalSoul = new AnimalSoul(SOUL).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		ItemList.add(BuffMobSoul = new BuffMobSoul(SOUL).setCreativeTab(matryoshikassinners.MatryoshikaTab));
		
		for(Item Item:ItemList){
			GameRegistry.registerItem(Item,  Item.getUnlocalizedName());
			
			
		ItemStack SinDagger = new ItemStack(matryoshikassinners_Items.SinDagger );
		SinDagger.addEnchantment(matryoshikassinners.purify, 1);
		GameRegistry.addShapelessRecipe(SinDagger, new Object[]
				{
					Items.flint, 
					Items.stone_sword
				});
		
		GameRegistry.addRecipe(new ItemStack(matryoshikassinners_Items.SoulCrucible), new Object[]{
				"   ",
				"IBI",
				" I ",
				'I', Items.iron_ingot, 'B', Items.bowl
		});
		}
		
	}

}
