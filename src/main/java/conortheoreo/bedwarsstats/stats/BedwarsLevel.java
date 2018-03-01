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
        System.out.println(username);
        try {
            main(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static final String KEY = KeyReader.main(KeyReader.fileName);

    public static void main(String args) throws Exception {
        HypixelAPI api = new HypixelAPI(KEY);
        HypixelPlayer player = api.getPlayer(args);
        Bedwars bw = player.getStats().getBedwars();
        System.out.println(username + "'s Stats:");
        System.out.println("Bedwars Level: " + bw.getExperienceNew());
        MainClass.totalStars = (int) bw.getExperienceNew();
        if (player.getLastNick() != null) {
            System.out.println("The player is currently nicked: " + player.getLastNick());
        }

    }

}
