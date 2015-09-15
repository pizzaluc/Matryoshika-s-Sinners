package Matryoshika.mods.matryoshikassinners.blocks;

import java.util.List;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import Matryoshika.mods.matryoshikassinners.rendering.GUIHandler.MSGuiHandler.GUI;
import Matryoshika.mods.matryoshikassinners.tile.generator.TileGenerator;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockDynamicGenerator extends BlockContainer{

	public BlockDynamicGenerator(){
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setBlockTextureName(matryoshikassinners.MODID+":BlockDynamicGenerator");
		setHardness(10);
		this.setResistance(150);
		this.setBlockName("BlockDynamicGenerator");
		setLightLevel(.3f);
		this.isBlockContainer = true;
	}

	

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack){

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p6, float p7, float p8, float p9){
		player.openGui(matryoshikassinners.MODID, 0, world, x, y, z);
		return true;

	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileGenerator();
    }

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		TileGenerator incinerator = (TileGenerator) world.getTileEntity(x, y, z);
		if (incinerator != null){
			for (int i = 0; i < incinerator.getSizeInventory(); ++i){
				ItemStack itemstack = incinerator.getStackInSlot(i);

				if (itemstack != null){
					float f = world.rand.nextFloat() * 0.6F + 0.1F;
					float f1 = world.rand.nextFloat() * 0.6F + 0.1F;
					float f2 = world.rand.nextFloat() * 0.6F + 0.1F;

					while (itemstack.stackSize > 0){
						int j = world.rand.nextInt(21) + 10;

						if (j > itemstack.stackSize){
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;
						EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
								(double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()){
							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
						}

						float f3 = 0.025F;
						entityitem.motionX = (double) ((float) world.rand.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) world.rand.nextGaussian() * f3 + 0.1F);
						entityitem.motionZ = (double) ((float) world.rand.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
}