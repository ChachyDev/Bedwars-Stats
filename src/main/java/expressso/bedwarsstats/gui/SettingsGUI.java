package expressso.bedwarsstats.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.io.IOException;

public class SettingsGUI extends GuiScreen {


    public static final int ID = 0;

    private GuiButton a;
    private GuiButton b;
    private GuiButton c;
    private GuiButton d;

    Minecraft mc = Minecraft.getMinecraft();
    FontRenderer frenderer = Minecraft.getMinecraft().fontRendererObj;

    public boolean doesGuiPauseGame() {
        return false;
    }

    public boolean doesGuiClose() {
        return true;
    }

    public void drawScreen(int mouseX, int mouseY, float partials) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partials);
    }

    @Override
    public void initGui() {
        this.buttonList.add(this.a = new GuiButton(0, this.width / 2 - 100, this.height / 2 + 100, "Open Developer Settings"));
        this.buttonList.add(this.c = new GuiButton(2, this.width / 2 - 100, this.height / 2 + 50, "Close GUI"));
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == 1) {
            mc.inGameHasFocus = true;
            mc.thePlayer.closeScreen();
        }
        if (keyCode == 32) {
            mc.inGameHasFocus = true;
            mc.thePlayer.closeScreen();
            mc.thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Developer Settings Temp Disabled!"));
        }
    }

    @SubscribeEvent
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == this.a) {
            mc.inGameHasFocus = true;
            mc.thePlayer.closeScreen(); }
        if (button == this.b) {
            mc.inGameHasFocus = true;
            mc.thePlayer.closeScreen();
            mc.thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Successfully reset stats!"));
        }
        if (button == this.c) {
            mc.inGameHasFocus = true;
            mc.thePlayer.closeScreen();
        }
        if (button == this.d) {
            //this.d.displayString = ((MainClass.chromaEnabled = (MainClass.chromaEnabled ? false : true)) ? "Disable" : "Enable") + " Chroma";
        }
    }

}
