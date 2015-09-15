package Matryoshika.mods.matryoshikassinners.rendering.GUI;

import java.text.NumberFormat;

import org.lwjgl.opengl.GL11;

import Matryoshika.mods.matryoshikassinners.matryoshikassinners;
import Matryoshika.mods.matryoshikassinners.blocks.matryoshikassinners_Blocks;
import Matryoshika.mods.matryoshikassinners.tile.generator.ContainerGenerator;
import Matryoshika.mods.matryoshikassinners.tile.generator.TileGenerator;
import Matryoshika.mods.matryoshikassinners.utils.ConfigHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiDynamicGenerator extends GuiContainer
{
    private static final ResourceLocation guiScreen1 = new ResourceLocation(matryoshikassinners.MODID, "textures/gui/generatorGUI.png");
    private static final ResourceLocation guiScreen2 = new ResourceLocation(matryoshikassinners.MODID, "textures/gui/generatorGUIAlt.png");
    private TileGenerator generator;

    public GuiDynamicGenerator(InventoryPlayer playerInventory, TileGenerator generator)
    {
        super(new ContainerGenerator(playerInventory, generator));
        this.generator = generator;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p1, int p2)
    {
        String name = matryoshikassinners_Blocks.GeneratorDynamic.getLocalizedName();
        this.fontRendererObj.drawString(name, 6, 5, 4210752);
        String energy = NumberFormat.getIntegerInstance().format(generator.getEnergyStored(null));
        this.fontRendererObj.drawString(energy, 6, 15, 4210752);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p1, int p2, int p3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        if(ConfigHandler.useOriginalFuelsOrSinFuel == false){
        	this.mc.getTextureManager().bindTexture(guiScreen2);
        }
        else{
        	this.mc.getTextureManager().bindTexture(guiScreen1);
        }
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

    }
}
