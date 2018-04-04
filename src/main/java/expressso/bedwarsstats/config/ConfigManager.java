package expressso.bedwarsstats.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigManager {

    private static File ConfigFile = new File(new File(String.valueOf(Minecraft.getMinecraft().mcDataDir.getPath()) + "/config/BedwarsStats"), "config.config");
    private static JsonObject config = new JsonObject();

    public static File getConfigFile() {
        return ConfigFile;
    }

    private static boolean configExists() {
        return exists(ConfigManager.ConfigFile.getPath());
    }

    public static void loadSettings() {
        if (configExists()) {
            log("config file exists! Reading...");
            System.out.println("config file exists! Reading..");
            try {
                final FileReader ex = new FileReader(ConfigManager.ConfigFile);
                final BufferedReader bufferedReader = new BufferedReader(ex);
                final StringBuilder builder = new StringBuilder();
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    builder.append(currentLine);
                }
                bufferedReader.close();
                final String complete = builder.toString();
                ConfigManager.config = new JsonParser().parse(complete).getAsJsonObject();
            } catch (Exception var5) {
                log("Could not write config! Saving...");
                saveSettings();
                resetSettings();
            }
            System.out.println("reading...");
            Settings.setTotalStars_Position_X(ConfigManager.config.get("TotalStarsX").getAsInt());
            Settings.setTotalStars_Position_Y(ConfigManager.config.get("TotalStarsY").getAsInt());
        } else {
            log("config does not exist! Saving...");
            saveSettings();
            resetSettings();
        }
    }

    private static void saveSettings() {
        ConfigManager.config = new JsonObject();
        try {
            if (!ConfigManager.ConfigFile.getParentFile().exists()) {
                ConfigManager.ConfigFile.getParentFile().mkdir();
            }
            ConfigManager.ConfigFile.createNewFile();
            final FileWriter ex = new FileWriter(ConfigManager.ConfigFile);
            final BufferedWriter bufferedWriter = new BufferedWriter(ex);
            ConfigManager.config.addProperty("TotalStarsX", Settings.getTotalStars_Position_X());
            ConfigManager.config.addProperty("TotalStarsY", Settings.getTotalStars_Position_Y());
            bufferedWriter.write(ConfigManager.config.toString());
            bufferedWriter.close();
            ex.close();
        } catch (Exception var2) {
            log("Could not save config!");
            var2.printStackTrace();
        }
    }

    private static void resetSettings() {
        Settings.setTotalStars_Colour(0);
        Settings.setTotalStars_Position_Y(5);
        Settings.setTotalStars_Position_X(5);
    }

    private static boolean exists(final String path) {
        return Files.exists(Paths.get(path));
    }

    private static void log(final Object message, final String... replacements) {
        LogManager.getLogger("FileUtils").info(String.format(String.valueOf(message), (Object) replacements));
    }
}

