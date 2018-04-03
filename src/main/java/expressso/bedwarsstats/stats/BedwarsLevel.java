package expressso.bedwarsstats.stats;

import expressso.bedwarsstats.main.MainClass;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.player.stats.bedwars.Bedwars;
import net.minecraft.client.Minecraft;

public class BedwarsLevel {

    private static final String KEY = null;
    private static String username = Minecraft.getMinecraft().thePlayer.getName();
    final Minecraft mc = Minecraft.getMinecraft();

    public static void getBedwarsLevel() {
        try {
            main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
