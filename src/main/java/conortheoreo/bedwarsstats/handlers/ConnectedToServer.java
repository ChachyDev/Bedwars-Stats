package conortheoreo.bedwarsstats.handlers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import static conortheoreo.bedwarsstats.stats.BedwarsLevel.getBedwarsLevel;

public class ConnectedToServer {

    @Mod.EventHandler
    public static void isServer(FMLNetworkEvent.ClientConnectedToServerEvent e) {
        if (!e.isLocal) {
            getBedwarsLevel();
        }
    }

}
