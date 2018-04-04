package expressso.bedwarsstats.utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import javax.swing.*;

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

    /*
    credit to Sk1er for this
    https://github.com/Sk1er/Levelhead/
    */

    @SubscribeEvent
    public void onJoin(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
        Multithreading.runAsync(new Runnable() {
            public void run() {
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
                if (!event.isLocal) {
                    String apiCommand = "/api";
                    Minecraft.getMinecraft().thePlayer.sendChatMessage(apiCommand);
                }
            }
        });
    }

    @SubscribeEvent
    public void checkMSG(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText().contains("You already have an API Key")) {
            MessageBox.infoBox("It seems you already have an API Key! You need to your API key to continue using the mod!", "Bedwars Stats Mod", JOptionPane.ERROR_MESSAGE);
            MessageBox.inputBox("Please enter your API key below (if you don't have it saved, generate one with /apinew", "Bedwars Stats Mod", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
