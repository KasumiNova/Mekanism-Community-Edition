package mekanism.common.inventory.container;

import mekanism.api.gas.IGasItem;
import mekanism.common.inventory.slot.SlotEnergy.SlotDischarge;
import mekanism.common.inventory.slot.SlotOutput;
import mekanism.common.inventory.slot.SlotStorageTank;
import mekanism.common.tile.TileEntityChemicalWasher;
import mekanism.common.util.ChargeUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class ContainerChemicalWasher extends Container
{
	private TileEntityChemicalWasher tileEntity;

	public ContainerChemicalWasher(InventoryPlayer inventory, TileEntityChemicalWasher tentity)
	{
		tileEntity = tentity;
		addSlotToContainer(new Slot(tentity, 0, 180, 71));
		addSlotToContainer(new SlotOutput(tentity, 1, 180, 102));
		addSlotToContainer(new SlotStorageTank(tentity, 2, 155, 56));
		addSlotToContainer(new SlotDischarge(tentity, 3, 155, 5));

		int slotY;

		for(slotY = 0; slotY < 3; slotY++)
		{
			for(int slotX = 0; slotX < 9; slotX++)
			{
				addSlotToContainer(new Slot(inventory, slotX + slotY * 9 + 9, 8 + slotX * 18, 84 + slotY * 18));
			}
		}

		for(slotY = 0; slotY < 9; slotY++)
		{
			addSlotToContainer(new Slot(inventory, slotY, 8 + slotY * 18, 142));
		}

		tileEntity.open(inventory.player);
		tileEntity.openInventory();
	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer)
	{
		super.onContainerClosed(entityplayer);

		tileEntity.close(entityplayer);
		tileEntity.closeInventory();
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return tileEntity.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack stack = null;
		Slot currentSlot = (Slot)inventorySlots.get(slotID);

		if(currentSlot != null && currentSlot.getHasStack())
		{
			
			int inputSlot = 0;
			int outputSlot = 1;
			int tankSlot = 2;
			int dischargeSlot = 3;
			int firstGenericInvSlot = 4;
			int firstHotbarSlot = 31;
			int lastHotbarSlot = inventorySlots.size();

			ItemStack slotStack = currentSlot.getStack();
			stack = slotStack.copy();

			//System.out.println(inventorySlots.size());

			if(slotID == outputSlot)
			{
				if(!mergeItemStack(slotStack, firstGenericInvSlot, lastHotbarSlot, true))
				{
					return null;
				}
			}
			else if(FluidContainerRegistry.isFilledContainer(slotStack) && FluidContainerRegistry.getFluidForFilledItem(slotStack).getFluid() == FluidRegistry.WATER)
			{
				if(slotID != inputSlot)
				{
					if(!mergeItemStack(slotStack, inputSlot, outputSlot, false))
					{
						return null;
					}
				}
				else {
					if(!mergeItemStack(slotStack, firstGenericInvSlot, lastHotbarSlot, true))
					{
						return null;
					}
				}
			}
			else if(slotStack.getItem() instanceof IGasItem)
			{
				if(slotID != tankSlot)
				{
					if(!mergeItemStack(slotStack, tankSlot, dischargeSlot, false))
					{
						return null;
					}
				}
				else {
					if(!mergeItemStack(slotStack, firstGenericInvSlot, lastHotbarSlot, true))
					{
						return null;
					}
				}
			}
			else if(ChargeUtils.canBeDischarged(slotStack))
			{
				if(slotID != dischargeSlot)
				{
					if(!mergeItemStack(slotStack, dischargeSlot, firstGenericInvSlot, false))
					{
						return null;
					}
				}
				else
				{
					if(!mergeItemStack(slotStack, firstGenericInvSlot, lastHotbarSlot, true))
					{
						return null;
					}
				}
			}
			else {
				if(slotID >= firstGenericInvSlot && slotID < firstHotbarSlot)
				{
					if(!mergeItemStack(slotStack, firstHotbarSlot, lastHotbarSlot, false))
					{
						return null;
					}
				}
				else if(slotID >= firstHotbarSlot && slotID <= lastHotbarSlot)
				{
					if(!mergeItemStack(slotStack, firstGenericInvSlot, firstHotbarSlot, false))
					{
						return null;
					}
				}
				else {
					if(!mergeItemStack(slotStack, firstGenericInvSlot, lastHotbarSlot, true))
					{
						return null;
					}
				}
			}

			if(slotStack.stackSize == 0)
			{
				currentSlot.putStack((ItemStack)null);
			}
			else {
				currentSlot.onSlotChanged();
			}

			if(slotStack.stackSize == stack.stackSize)
			{
				return null;
			}

			currentSlot.onPickupFromSlot(player, slotStack);
		}

		return stack;
	}
}
