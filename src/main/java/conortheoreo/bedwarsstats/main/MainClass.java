package conortheoreo.bedwarsstats.main;

import conortheoreo.bedwarsstats.commands.UpdateLevel;
import conortheoreo.bedwarsstats.config.ConfigManager;
import conortheoreo.bedwarsstats.config.Settings;
import conortheoreo.bedwarsstats.handlers.isHypixel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.io.File;

@Mod(modid = MainClass.MODID, version = MainClass.VERSION, acceptedMinecraftVersions = MainClass.MCVERSION)
public class MainClass {

    public static final String MODID = "bedwars-stats";
    public static final String VERSION = "1";
    public static final String MCVERSION = "[1.8.9]";
    public static long totalStars;

    private static File ConfigFile = ConfigManager.getConfigFile();
    private boolean hypixel;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        FMLCommonHandler.instance().bus().register(new isHypixel());
        ConfigManager.loadSettings();
        System.out.println("[BedwarsStats] MCDIR Found! " + ConfigFile);
        ClientCommandHandler.instance.registerCommand(new UpdateLevel());
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
