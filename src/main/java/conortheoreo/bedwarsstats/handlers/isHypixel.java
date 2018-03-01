package conortheoreo.bedwarsstats.handlers;

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverLocalFilesystem;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import scala.runtime.AbstractFunction0$mcB$sp;

public class isHypixel {

    private boolean hypixel;

    /*credit to Sk1er for this
        https://github.com/Sk1er/Levelhead/
    */
    @SubscribeEvent
    public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent event, ClientChatReceivedEvent chatmsg) {
        hypixel = !FMLClientHandler.instance().getClient().isSingleplayer()
                && (FMLClientHandler.instance().getClient().getCurrentServerData().serverIP.contains("hypixel.net") ||
                FMLClientHandler.instance().getClient().getCurrentServerData().serverName.equalsIgnoreCase("HYPIXEL"));
        if (hypixel == true && Minecraft.getMinecraft().theWorld != null) {
            System.out.println("Connected to Hypixel");
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/api");
            if (chatmsg.equals("")) {

            }else {

            }
        }
    }
}
