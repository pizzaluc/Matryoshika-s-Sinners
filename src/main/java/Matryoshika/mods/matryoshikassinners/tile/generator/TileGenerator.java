package Matryoshika.mods.matryoshikassinners.tile.generator;


import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

import Matryoshika.mods.matryoshikassinners.items.matryoshikassinners_Items;
import Matryoshika.mods.matryoshikassinners.utils.ConfigHandler;


public class TileGenerator extends TileEntity implements IEnergyProvider, IInventory {
	
	private ItemStack[] contents = new ItemStack[100];
	public int currentItemBurnTime;
	public int furnaceBurnTime;
	private String customName;
	
	public EnergyStorage storage = new EnergyStorage(1000000, 0 ,ConfigHandler.maxCapOnRFProduction);
	public int modifier;
	public int EPT = 20+(modifier);
	
	
	
	public boolean type1;
	public int fuelType1;
	public boolean type2;
	public int fuelType2;
	public boolean type3;
	public int fuelType3;
	public boolean type4;
	public int fuelType4;
	public boolean type5;
	public int fuelType5;
	public boolean type6;
	public int fuelType6;
	public boolean type7;
	public int fuelType7;
	public boolean type8;
	public int fuelType8;
	
	public int burnTimer;
	public boolean startBurnTimer;
	
	
	public void updateEntity()
    {
		
		if(ConfigHandler.useOriginalFuelsOrSinFuel == true){
			int slot = 1;
			int amount = 1;
			int currentStorage = storage.getEnergyStored();
		
			ItemStack stack = this.getStackInSlot(1);
		
			if (worldObj.isRemote) return;
		
			if(this.getStackInSlot(1) != null && stack.getItem() == matryoshikassinners_Items.SoulVortex){
				if(startBurnTimer == false){decrStackSize(slot, amount);}
				startBurnTimer = true;
			}
			if(startBurnTimer == true){burnTimer++; storage.setEnergyStored(currentStorage + EPT);}
			if(burnTimer >= 600){burnTimer = 0; startBurnTimer = false; System.out.println(storage.getEnergyStored());}
		}
		
		if(ConfigHandler.useOriginalFuelsOrSinFuel == false){
			ItemStack stack1 = this.getStackInSlot(1);
			ItemStack stack2 = this.getStackInSlot(2);
			ItemStack stack3 = this.getStackInSlot(3);
			ItemStack stack4 = this.getStackInSlot(4);
			ItemStack stack5 = this.getStackInSlot(5);
			ItemStack stack6 = this.getStackInSlot(6);
			ItemStack stack7 = this.getStackInSlot(7);
			ItemStack stack8 = this.getStackInSlot(8);
			
			if(type1 == true){
				if(fuelType1 == 1){
					
				}
				if(fuelType1 == 2){}
			}
			if(type2 == true){
				if(fuelType2 == 1){}
				if(fuelType2 == 2){}
			}
			if(type3 == true){
				if(fuelType3 == 1){}
				if(fuelType3 == 2){}
			}
			if(type4 == true){
				if(fuelType4 == 1){}
				if(fuelType4 == 2){}
			}
			if(type5 == true){
				if(fuelType5 == 1){}
				if(fuelType5 == 2){}
			}
			if(type6 == true){
				if(fuelType6 == 1){}
				if(fuelType6 == 2){}
			}
			if(type7 == true){
				if(fuelType7 == 1){}
				if(fuelType7 == 2){}
			}
			if(type8 == true){
				if(fuelType8 == 1){}
				if(fuelType8 == 2){}
			}
		}
		
    }
	
	
	
	
	
	public int getSizeInventory()
    {
        return this.contents.length;
    }
	
    public ItemStack getStackInSlot(int slot)
    {
        return this.contents[slot];
    }

    public ItemStack decrStackSize(int slot, int amount)
    {
        if (this.contents[slot] != null)
        {
            ItemStack itemstack;

            if (this.contents[slot].stackSize <= amount)
            {
                itemstack = this.contents[slot];
                this.contents[slot] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.contents[slot].splitStack(amount);

                if (this.contents[slot].stackSize == 0)
                {
                    this.contents[slot] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.contents[slot] != null)
        {
            ItemStack itemstack = this.contents[slot];
            this.contents[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        this.contents[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.customName : "container.ms.generator";
    }
    
    public boolean hasCustomInventoryName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    public void func_145951_a(String string)
    {
        this.customName = string;
    }

    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.contents = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.contents.length)
            {
                this.contents[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = tagCompound.getShort("BurnTime");
        this.currentItemBurnTime = getItemBurnTime(this.contents[1]);

        if (tagCompound.hasKey("CustomName", 8))
        {
            this.customName = tagCompound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.furnaceBurnTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.contents.length; ++i)
        {
            if (this.contents[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.contents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.customName);
        }
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }
 
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int scaled)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.furnaceBurnTime * scaled / this.currentItemBurnTime;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    

    private boolean canSmelt()
    {
        if (this.contents[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.contents[0]);
            if (itemstack == null) return false;
            if (this.contents[2] == null) return true;
            if (!this.contents[2].isItemEqual(itemstack)) return false;
            int result = contents[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.contents[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.contents[0]);

            if (this.contents[2] == null)
            {
                this.contents[2] = itemstack.copy();
            }
            else if (this.contents[2].getItem() == itemstack.getItem())
            {
                this.contents[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.contents[0].stackSize;

            if (this.contents[0].stackSize <= 0)
            {
                this.contents[0] = null;
            }
        }
    }
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        return getItemBurnTime(p_145954_0_) > 0;
    }
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
    }
    
    public int[] getAccessibleSlotsFromSide(int p_94128_1_)
    {
        return null;
    }
    
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_)
    {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }
    
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_)
    {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket;
    }

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return storage.extractEnergy(maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return storage.getMaxEnergyStored();
	}
}