package mekanism.common.recipe.machines;

import mekanism.api.MekanismConfig;
import mekanism.common.recipe.inputs.AdvancedMachineInput;
import mekanism.common.recipe.outputs.ItemStackOutput;
import net.minecraft.item.ItemStack;

public class OsmiumCompressorRecipe extends AdvancedMachineRecipe<OsmiumCompressorRecipe>
{
	public OsmiumCompressorRecipe(AdvancedMachineInput input, ItemStackOutput output)
	{
		super(input, output);
	}

	public OsmiumCompressorRecipe(ItemStack input, ItemStack output)
	{
		super(input, (MekanismConfig.mekce.OreDictPlatinum && !MekanismConfig.mekce.OreDictOsmium) ? "liquidPlatinum" : "liquidOsmium", output);
	}

	@Override
	public OsmiumCompressorRecipe copy()
	{
		return new OsmiumCompressorRecipe(getInput().copy(), getOutput().copy());
	}
}
