package conortheoreo.bedwarsStats.Main;

import conortheoreo.bedwarsStats.Config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sun.awt.EmbeddedFrame;

import java.io.File;

@Mod(modid = MainClass.MODID, version = MainClass.VERSION, acceptedMinecraftVersions = MainClass.MCVERSION)
public class MainClass
{
    public static final String MODID = "bedwars-stats";
    public static final String VERSION = "1";
    public static final String MCVERSION = "[1.8.9]";

    public int totalStars;

    private File ConfigFile = Config.getConfigFile();

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println(ConfigFile);
    }

    @SubscribeEvent
    public void render(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }
            System.out.println(ConfigFile);
            Minecraft.getMinecraft().fontRendererObj.drawString(EnumChatFormatting.GREEN + "Total Stars:" + EnumChatFormatting.WHITE + totalStars, 5, 5, 0);
        }

}
