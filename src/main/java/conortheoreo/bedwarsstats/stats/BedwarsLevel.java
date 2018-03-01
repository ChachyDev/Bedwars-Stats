package conortheoreo.bedwarsstats.stats;

import net.minecraft.client.Minecraft;
import scala.runtime.AbstractFunction0$mcB$sp;

public class BedwarsLevel {

    final Minecraft mc = Minecraft.getMinecraft();
    private static String username = Minecraft.getMinecraft().thePlayer.getDisplayNameString();

    public static void getBedwarsLevel() {
        System.out.println(username);
    }

}
