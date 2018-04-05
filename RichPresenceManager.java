package expressso.bedwarsstats.discord.rpc;

import com.github.psnrigner.discordrpcjava.*;
import net.minecraft.client.Minecraft;

public class RichPresenceManager {

    public static void run(String applicationId)
    {
        DiscordRpc discordRpc = new DiscordRpc();

        DiscordEventHandler discordEventHandler = new DiscordEventHandler()
        {
            @Override
            public void ready()
            {
                System.err.println("CLASS READY");
            }

            @Override
            public void disconnected(ErrorCode errorCode, String message)
            {
                System.err.println("DISCONNECTED : " + errorCode + " " + message);
            }

            @Override
            public void errored(ErrorCode errorCode, String message)
            {
                System.err.println("CLASS ERRORED : " + errorCode + " " + message);
            }

            @Override
            public void joinGame(String joinSecret)
            {
                System.err.println("JOIN GAME : " + joinSecret);
            }

            @Override
            public void spectateGame(String spectateSecret)
            {
                System.err.println("SPECTATE GAME : " + spectateSecret);
            }

            @Override
            public void joinRequest(DiscordJoinRequest joinRequest)
            {
                System.err.println("JOIN REQUEST : " + joinRequest);
            }
        };

        try
        {
            discordRpc.init(applicationId, discordEventHandler, true, null);

            Thread.sleep(5000L);
            discordRpc.runCallbacks();

            long start = System.currentTimeMillis() / 1000L;
            long end = System.currentTimeMillis() / 1000L + 14400L;

            for (int i = 0; i < 10000; ++i)
            {
                DiscordRichPresence discordRichPresence = new DiscordRichPresence();
                discordRichPresence.setState("Playing Bedwars");
                discordRichPresence.setDetails("IGN: " + Minecraft.getMinecraft().thePlayer.getDisplayNameString());
                discordRichPresence.setStartTimestamp(start);
                discordRichPresence.setEndTimestamp(end);
                discordRichPresence.setLargeImageKey("icon-large");
                discordRichPresence.setSmallImageKey("icon-small");
                discordRichPresence.setPartyId("ALONE");
                discordRichPresence.setPartySize(1);
                discordRichPresence.setPartyMax(4);
                discordRichPresence.setMatchSecret("match");
                discordRichPresence.setJoinSecret("join");
                discordRichPresence.setSpectateSecret("spectate");
                discordRichPresence.setInstance(false);

                discordRpc.updatePresence(discordRichPresence);

                Thread.sleep(5000L);

                discordRpc.runCallbacks();

                Thread.sleep(5000L);
            }
        }
        catch (InterruptedException ignored)
        {
        }
        finally
        {
            discordRpc.shutdown();
        }
    }

}
