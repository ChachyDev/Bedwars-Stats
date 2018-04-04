package expressso.bedwarsstats.utils;

import expressso.bedwarsstats.config.Settings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

/*
    before you go judging this class, it's a mess i know, i'll clean it up some other tim
 */

public class HypixelUtils {

    private static int tries;
    private static boolean hypixel;

    public static boolean getIsHypixel() {
        hypixel = !FMLClientHandler.instance().getClient().isSingleplayer()
                && (FMLClientHandler.instance().getClient().getCurrentServerData().serverIP.contains("hypixel.net") ||
                FMLClientHandler.instance().getClient().getCurrentServerData().serverName.equalsIgnoreCase("HYPIXEL"));
        return hypixel;
    }

    /*credit to Sk1er for this
            https://github.com/Sk1er/Levelhead/
    */

    @SubscribeEvent
    public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        Multithreading.runAsync(() -> {
            while (Minecraft.getMinecraft().thePlayer == null) {
                tries++;
                if (tries > 20 * 10) {
                    return;
                }
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            getIsHypixel();
            String apiCommand = "/api";
            Minecraft.getMinecraft().thePlayer.sendChatMessage(apiCommand);
        /*
        wait until (!hypixel && Minecraft.getMinecraft().theWorld != null) {
            String apiCommand = "api";
            Minecraft.getMinecraft().thePlayer.sendChatMessage(apiCommand);
        }
        */
        });
    }

    @SubscribeEvent
    public void checkforapikey(ClientChatReceivedEvent chatmsg) {
        while (!hypixel && Minecraft.getMinecraft().theWorld == null) {
            String apiMessage = "\"You already have an API Key, are you sure you want to regenerate it?\\\\n\\\" +\\n\" +\n" +
                    "                    \"                    \\\"Click to run /api new";
            if (chatmsg.equals("You already have an API Key, are you sure you want to regenerate it?\n" +
                    "Click to run /api new") && !Settings.getApiChecked()) {
                Settings.setApiChecked(true);
                System.out.println(Settings.getApiChecked());
            } else {
                if (!chatmsg.equals(apiMessage) && chatmsg.message.getUnformattedText().contains("generate")) {
                    chatmsg.message.getUnformattedText();
                }
            }
        }
    }
}
