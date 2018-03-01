package conortheoreo.bedwarsstats.stats;

import conortheoreo.bedwarsstats.main.MainClass;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.player.stats.bedwars.Bedwars;
import me.kbrewster.hypixelapi.player.stats.uhc.UHC;
import net.minecraft.client.Minecraft;
import scala.runtime.AbstractFunction0$mcB$sp;

public class BedwarsLevel {

    final Minecraft mc = Minecraft.getMinecraft();
    private static String username = Minecraft.getMinecraft().thePlayer.getName();

    public static void getBedwarsLevel() {
        try {
            main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String KEY = null;

    public static void main() throws Exception {
        HypixelAPI api = new HypixelAPI(KEY);
        HypixelPlayer player = api.getPlayer(username);
        Bedwars bw = player.getStats().getBedwars();
        System.out.println(username + "'s Stats:");
        System.out.println("Bedwars Level: " + bw.getExperience());
        MainClass.totalStars = bw.getExperience();
        if (player.getLastNick() != null) {
            System.out.println("The player is currently nicked: " + player.getLastNick());
        }

    }

}
