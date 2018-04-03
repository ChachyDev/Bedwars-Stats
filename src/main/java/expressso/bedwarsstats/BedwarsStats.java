package expressso.bedwarsstats;

import expressso.bedwarsstats.commands.UpdateLevel;
import expressso.bedwarsstats.config.ConfigManager;
import expressso.bedwarsstats.config.Settings;
import expressso.bedwarsstats.handlers.isHypixel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

import static expressso.bedwarsstats.config.Settings.setApiChecked;
import static expressso.bedwarsstats.handlers.isHypixel.getIsHypixel;

@Mod(modid = BedwarsStats.MODID, version = BedwarsStats.VERSION, acceptedMinecraftVersions = BedwarsStats.MCVERSION)
public class BedwarsStats {

    public static final String MODID = "bedwars-stats";
    public static final String VERSION = "1";
    public static final String MCVERSION = "[1.8.9]";
    public long totalStars;

    private static File ConfigFile = ConfigManager.getConfigFile();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new isHypixel());
        FMLCommonHandler.instance().bus().register(this);
        ConfigManager.loadSettings();
        System.out.println("[BedwarsStats] MCDIR Found! " + ConfigFile);
        ClientCommandHandler.instance.registerCommand(new UpdateLevel());
        setApiChecked(false);
    }

    @SubscribeEvent
    public void render(RenderGameOverlayEvent event) {
        if (event.type != RenderGameOverlayEvent.ElementType.CHAT) {
            return;
        }
        if (getIsHypixel()) {
            FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
            fr.drawString("Bedwars Level: " + Settings.getTotalStars_Colour() + totalStars, Settings.getTotalStars_Position_X(), Settings.getTotalStars_Position_Y(), Settings.getTotalStars_Colour());
        }
    }
}
