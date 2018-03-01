package conortheoreo.bedwarsstats.main;

import conortheoreo.bedwarsstats.config.ConfigManager;
import conortheoreo.bedwarsstats.config.Settings;
import conortheoreo.bedwarsstats.stats.KeyReader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.Timer;

import static conortheoreo.bedwarsstats.config.ConfigManager.saveSettings;
import static conortheoreo.bedwarsstats.stats.BedwarsLevel.getBedwarsLevel;

@Mod(modid = MainClass.MODID, version = MainClass.VERSION, acceptedMinecraftVersions = MainClass.MCVERSION)
public class MainClass {

    public static final String MODID = "bedwars-stats";
    public static final String VERSION = "1";
    public static final String MCVERSION = "[1.8.9]";

    String fileName = "C:\\Users\\conor\\Desktop\\Bedwars-Stats\\apikey.key";

    public static int totalStars;

    private File ConfigFile = ConfigManager.getConfigFile();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        ConfigManager.loadSettings();
        System.out.println("[BedwarsStats] MCDIR Found! " + ConfigFile);
        getBedwarsLevel();
    }

    @SubscribeEvent
    public void render(RenderGameOverlayEvent event) {
        if (event.type != RenderGameOverlayEvent.ElementType.CHAT) {
            return;
        }
        FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
        fr.drawString("Bedwars Level: " + Settings.getTotalStars_Colour() + totalStars, Settings.getTotalStars_Position_X(), Settings.getTotalStars_Position_Y(), Settings.getTotalStars_Colour());
    }
}
