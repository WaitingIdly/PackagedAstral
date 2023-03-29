
package thelm.packagedastral.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.CapabilityEnergy;
import thelm.packagedastral.tile.TileConstellationCrafter;
import thelm.packagedauto.inventory.InventoryTileBase;

public class InventoryConstellationCrafter extends InventoryTileBase {

	public final TileConstellationCrafter tile;

	public InventoryConstellationCrafter(TileConstellationCrafter tile) {
		super(tile, 23);
		this.tile = tile;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(index == 22) {
			return stack.hasCapability(CapabilityEnergy.ENERGY, null);
		}
		return false;
	}

	@Override
	public int getField(int id) {
		switch(id) {
		case 0: return tile.starlight;
		case 1: return tile.starlightReq;
		case 2: return tile.progress;
		case 3: return tile.progressReq;
		case 4: return tile.remainingProgress;
		case 5: return tile.isWorking ? 1 : 0;
		default: return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch(id) {
		case 0:
			tile.starlight = value;
			break;
		case 1:
			tile.starlightReq = value;
			break;
		case 2:
			tile.progress = value;
			break;
		case 3:
			tile.progressReq = value;
			break;
		case 4:
			tile.remainingProgress = value;
			break;
		case 5:
			tile.isWorking = value != 0;
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 6;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return tile.isWorking ? index == 21 : index != 22;
	}
}
