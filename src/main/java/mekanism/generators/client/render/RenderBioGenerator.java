package mekanism.generators.client.render;

import java.util.HashMap;
import java.util.Map;

import mekanism.client.render.MekanismRenderer;
import mekanism.client.render.MekanismRenderer.DisplayInteger;
import mekanism.client.render.MekanismRenderer.Model3D;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import mekanism.generators.client.model.ModelBioGenerator;
import mekanism.generators.common.tile.TileEntityBioGenerator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBioGenerator extends TileEntitySpecialRenderer
{
	private ModelBioGenerator model = new ModelBioGenerator();

	private Map<ForgeDirection, DisplayInteger[]> energyDisplays = new HashMap<ForgeDirection, DisplayInteger[]>();

	private static final int stages = 40;

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick)
	{
		renderAModelAt((TileEntityBioGenerator)tileEntity, x, y, z, partialTick);
	}

	private void renderAModelAt(TileEntityBioGenerator tileEntity, double x, double y, double z, float partialTick)
	{
		if(tileEntity.fuelTank.getStored() > 0)
		{
			push();

			boolean isEthanol = tileEntity.getFuelType() == 1;

			MekanismRenderer.glowOn();
			GL11.glTranslatef((float)x, (float)y, (float)z);
			bindTexture(MekanismRenderer.getBlocksTexture());
			getDisplayList(isEthanol, ForgeDirection.getOrientation(tileEntity.facing)) [tileEntity.getScaledFuelLevel(stages-1)].render();
			MekanismRenderer.glowOff();

			pop();
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "BioGenerator.png"));

		switch(tileEntity.facing)
		{
			case 2: GL11.glRotatef(180, 0.0F, 1.0F, 0.0F); break;
			case 3: GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); break;
			case 4: GL11.glRotatef(270, 0.0F, 1.0F, 0.0F); break;
			case 5: GL11.glRotatef(90, 0.0F, 1.0F, 0.0F); break;
		}
		
		GL11.glRotatef(180, 0F, 0F, 1F);
		model.render(0.0625F);
		GL11.glPopMatrix();
	}

	@SuppressWarnings("incomplete-switch")
	private DisplayInteger[] getDisplayList(boolean isEthanol, ForgeDirection side)
	{
		if(energyDisplays.containsKey(side))
		{
			return energyDisplays.get(side);
		}

		DisplayInteger[] displays = new DisplayInteger[stages];

		Model3D model3D = new Model3D();
		model3D.baseBlock = Blocks.water;

		if (isEthanol)
		model3D.setTexture(MekanismRenderer.ethanolIcon);
		else
			model3D.setTexture(MekanismRenderer.biomassIcon);

		for(int i = 0; i < stages; i++)
		{
			displays[i] = DisplayInteger.createAndStart();

			switch(side)
			{
				case NORTH:
				{
					model3D.minZ = 0.5;
					model3D.maxZ = 0.875;

					model3D.minX = 0.1875;
					model3D.maxX = 0.8215;
					model3D.minY = 0.4375;
					model3D.maxY = 0.4375 + ((float)i/stages)*0.4375;
					break;
				}
				case SOUTH:
				{
					model3D.minZ = 0.125;
					model3D.maxZ = 0.5;

					model3D.minX = 0.1875;
					model3D.maxX = 0.8215;
					model3D.minY = 0.4375;
					model3D.maxY = 0.4375 + ((float)i/stages)*0.4375;
					break;
				}
				case WEST:
				{
					model3D.minX = 0.5;
					model3D.maxX = 0.875;

					model3D.minZ = 0.1875;
					model3D.maxZ = 0.8215;
					model3D.minY = 0.4375;
					model3D.maxY = 0.4375 + ((float)i/stages)*0.4375;
					break;
				}
				case EAST:
				{
					model3D.minX = 0.125;
					model3D.maxX = 0.5;

					model3D.minZ = 0.1875;
					model3D.maxZ = 0.8215;
					model3D.minY = 0.4375;
					model3D.maxY = 0.4375 + ((float)i/stages)*0.4375;
					break;
				}
			}

			MekanismRenderer.renderObject(model3D);
			displays[i].endList();
		}

		energyDisplays.put(side, displays);

		return displays;
	}

	private void pop()
	{
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	private void push()
	{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
}
