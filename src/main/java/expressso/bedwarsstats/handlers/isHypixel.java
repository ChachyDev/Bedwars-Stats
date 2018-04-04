package expressso.bedwarsstats.handlers;

import expressso.bedwarsstats.config.Settings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class isHypixel {

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
        if (!event.isLocal) {
            getIsHypixel();
        }
    }

    @SubscribeEvent
    public void testmeth(ClientChatReceivedEvent chatmsg) {
        if (hypixel == true && Minecraft.getMinecraft().theWorld != null) {
            if (chatmsg.equals("You already have an API Key, are you sure you want to regenerate it?\n" +
                    "Click to run /api new") && Settings.getApiChecked() == false) {
                Settings.setApiChecked(true);
                System.out.println(Settings.getApiChecked());
            } else if (chatmsg.equals("")) {

            }
        }
    }
}
