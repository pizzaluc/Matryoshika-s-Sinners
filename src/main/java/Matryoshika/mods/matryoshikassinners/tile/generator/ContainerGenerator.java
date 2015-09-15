package Matryoshika.mods.matryoshikassinners.tile.generator;

import Matryoshika.mods.matryoshikassinners.utils.ConfigHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

public class ContainerGenerator extends Container{
	
	protected TileGenerator tileEntity;

    public ContainerGenerator (InventoryPlayer inventoryPlayer, TileGenerator te){
            this.tileEntity = te;
            
            if(ConfigHandler.useOriginalFuelsOrSinFuel == false){
            	if(te.type1 == true){this.addSlotToContainer(new Slot(tileEntity, 1, 16, 20));}
            	if(te.type2 == true){this.addSlotToContainer(new Slot(tileEntity, 2, 52, 20));}
            	if(te.type3 == true){this.addSlotToContainer(new Slot(tileEntity, 3, 106, 20));}
            	if(te.type4 == true){this.addSlotToContainer(new Slot(tileEntity, 4, 144, 20));}
            	if(te.type5 == true){this.addSlotToContainer(new Slot(tileEntity, 5, 16, 60));}
            	if(te.type6 == true){this.addSlotToContainer(new Slot(tileEntity, 6, 52, 60));}
            	if(te.type7 == true){this.addSlotToContainer(new Slot(tileEntity, 7, 106, 60));}
            	if(te.type8 == true){this.addSlotToContainer(new Slot(tileEntity, 8, 144, 60));}
            	
            }
            else{
            	this.addSlotToContainer(new Slot(tileEntity, 1, 79, 48 ));
            }
        

            bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
    }


    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
            for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 9; x++) {
                            addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9,
                                    8 + x * 18, 84 + y * 18));
                    }
            }

            for (int i = 0; i < 9; i++) {
                    addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
            }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
    	Slot slot = getSlot(i);

		if (slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();

			if (i >= 36){
				if (!mergeItemStack(stack, 0, 36, false)){
					return null;
				}
			}else if (!mergeItemStack(stack, 36, 36 + tileEntity.getSizeInventory(), false)){
				return null;
			}

			if (stack.stackSize == 0) {
				slot.putStack(null);
			}else{
				slot.onSlotChanged();
			}

			slot.onPickupFromSlot(player, stack);

			return result;
		}

		return null;
	}
}
