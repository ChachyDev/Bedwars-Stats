package conortheoreo.bedwarsstats.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class ConfigManager {

    private static File ConfigFile = new File(new File(String.valueOf(Minecraft.getMinecraft().mcDataDir.getPath()) + "/config/BedwarsStats"), "config.config");
    private static JsonObject config = new JsonObject();

    public static File getConfigFile() {
        return ConfigFile;
    }

    public static boolean configExists() {
        return exists(ConfigManager.ConfigFile.getPath());
    }

    public static void loadSettings() {
        if (configExists()) {
            log("config file exists! Reading...", new String[0]);
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
                log("Could not write config! Saving...", new String[0]);
                saveSettings();
                resetSettings();
            }
            System.out.println("reading...");
            //config.whatever = (ConfigManager.config.has("whatever") && ConfigManager.config.get("whatever").getAsBoolean());
        } else {
            log("config does not exist! Saving...", new String[0]);
            saveSettings();
        }
    }

    public static void saveSettings() {
        ConfigManager.config = new JsonObject();
        try {
            if (!ConfigManager.ConfigFile.getParentFile().exists()) {
                ConfigManager.ConfigFile.getParentFile().mkdir();
            }
            ConfigManager.ConfigFile.createNewFile();
            final FileWriter ex = new FileWriter(ConfigManager.ConfigFile);
            final BufferedWriter bufferedWriter = new BufferedWriter(ex);
            //ConfigManager.config.addProperty("whatever", Settings.whatever);
            bufferedWriter.write(ConfigManager.config.toString());
            bufferedWriter.close();
            ex.close();
        } catch (Exception var2) {
            log("Could not save config!", new String[0]);
            var2.printStackTrace();
        }
    }

    public static void resetSettings() {
        Settings.setTotalStars_Colour(123);
    }

    private static boolean exists(final String path) {
        return Files.exists(Paths.get(path, new String[0]), new LinkOption[0]);
    }

    private static void log(final Object message, final String... replacements) {
        LogManager.getLogger("FileUtils").info(String.format(String.valueOf(message), replacements));
    }
}

