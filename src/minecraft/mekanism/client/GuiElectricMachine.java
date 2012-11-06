package mekanism.client;

import org.lwjgl.opengl.GL11;

import mekanism.common.ContainerElectricMachine;
import mekanism.common.TileEntityElectricMachine;
import net.minecraft.src.*;

public class GuiElectricMachine extends GuiContainer
{
    public TileEntityElectricMachine tileEntity;

    public GuiElectricMachine(InventoryPlayer inventory, TileEntityElectricMachine tentity)
    {
        super(new ContainerElectricMachine(inventory, tentity));
        tileEntity = tentity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        fontRenderer.drawString(tileEntity.fullName, 45, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int texture = mc.renderEngine.getTexture(tileEntity.guiTexturePath);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(texture);
        int guiWidth = (width - xSize) / 2;
        int guiHeight = (height - ySize) / 2;
        drawTexturedModalRect(guiWidth, guiHeight, 0, 0, xSize, ySize);
        int displayInt;
        
        displayInt = tileEntity.getScaledEnergyLevel(52);
        drawTexturedModalRect(guiWidth + 165, guiHeight + 17 + 52 - displayInt, 176, 7 + 52 - displayInt, 4, displayInt);

        displayInt = tileEntity.getScaledProgress(24);
        drawTexturedModalRect(guiWidth + 79, guiHeight + 39, 176, 0, displayInt + 1, 7);
    }
}
