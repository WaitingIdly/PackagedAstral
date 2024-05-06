package thelm.packagedastral.recipe;

import hellfirepvp.astralsorcery.common.block.BlockBlackMarble;
import hellfirepvp.astralsorcery.common.block.BlockMarble;
import hellfirepvp.astralsorcery.common.crafting.INighttimeRecipe;
import hellfirepvp.astralsorcery.common.crafting.ItemHandle;
import hellfirepvp.astralsorcery.common.crafting.altar.recipes.AttunementRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipeSlot;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import net.minecraft.item.ItemStack;
import thelm.packagedastral.block.BlockAttunementCrafter;
import thelm.packagedastral.block.BlockDiscoveryCrafter;
import thelm.packagedastral.tile.TileDiscoveryCrafter;

public class RecipeAttunementCrafter extends AttunementRecipe implements INighttimeRecipe {

	public static final RecipeAttunementCrafter INSTANCE = new RecipeAttunementCrafter();

	protected RecipeAttunementCrafter() {
		super(shapedRecipe("packagedastral/attunement_crafter", BlockAttunementCrafter.INSTANCE).
				addPart(TileDiscoveryCrafter.enabled ? new ItemStack(BlockDiscoveryCrafter.INSTANCE) : new ItemStack(BlocksAS.blockAltar, 1, 1), ShapedRecipeSlot.CENTER).
				addPart(ItemHandle.getCrystalVariant(false, false), ShapedRecipeSlot.UPPER_CENTER).
				addPart(BlocksAS.fluidLiquidStarlight, ShapedRecipeSlot.LOWER_CENTER).
				addPart(BlockMarble.MarbleBlockType.CHISELED.asStack(), ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT).
				addPart("dustAstralStarmetal", ShapedRecipeSlot.UPPER_LEFT, ShapedRecipeSlot.UPPER_RIGHT).
				addPart(BlockBlackMarble.BlackMarbleBlockType.RAW.asStack(), ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT).
				unregisteredAccessibleShapedRecipe());
		setAttItem(BlockMarble.MarbleBlockType.PILLAR.asStack(), AttunementAltarSlot.UPPER_LEFT, AttunementAltarSlot.UPPER_RIGHT, AttunementAltarSlot.LOWER_LEFT, AttunementAltarSlot.LOWER_RIGHT);
	}
}
