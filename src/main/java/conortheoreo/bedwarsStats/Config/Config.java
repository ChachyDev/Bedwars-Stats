package conortheoreo.bedwarsStats.Config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import conortheoreo.bedwarsStats.Main.MainClass;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class Config {

    public static File getConfigFile() {
        return configFile;
    }

    private static final File configFile = new File(new File(String.valueOf(Minecraft.getMinecraft().mcDataDir.getPath()) + "/config/BedwarsStats"), "BedwarsStats.config");
    private static JsonObject config;

    Gson gson = new Gson();

    public static boolean configExists() {
        return exists(Config.configFile.getPath());
    }

    public static void loadSettings() {
        if (configExists()) {
            log("Config file exists! Reading...", new String[0]);
            System.out.println("Config file exists! Reading..");
            try {
                final FileReader ex = new FileReader(Config.configFile);
                final BufferedReader bufferedReader = new BufferedReader(ex);
                final StringBuilder builder = new StringBuilder();
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    builder.append(currentLine);
                }
                bufferedReader.close();
                final String complete = builder.toString();
                Config.config = new JsonParser().parse(complete).getAsJsonObject();
            } catch (Exception var5) {
                log("Could not write config! Saving...", new String[0]);
                saveSettings();
            }
            System.out.println("reading...");
            //read with dis
            //MainClass.whatever= (Config.config.has("whatever") && Config.config.get("whatever").getAsBoolean());
        } else {
            log("Config does not exist! Saving...", new String[0]);
            saveSettings();
        }
    }

    public static void saveSettings() {
        Config.config = new JsonObject();
        try {
            if (!Config.configFile.getParentFile().exists()) {
                Config.configFile.getParentFile().mkdir();
            }
            Config.configFile.createNewFile();
            final FileWriter ex = new FileWriter(Config.configFile);
            final BufferedWriter bufferedWriter = new BufferedWriter(ex);
            //Config.config.addProperty("whatever", MainClass.whatever);
            bufferedWriter.write(Config.config.toString());
            bufferedWriter.close();
            ex.close();
        } catch (Exception var2) {
            log("Could not save config!", new String[0]);
            var2.printStackTrace();
        }
    }

    private static boolean exists(final String path) {
        return Files.exists(Paths.get(path, new String[0]), new LinkOption[0]);
    }

    private static void log(final Object message, final String... replacements) {
        LogManager.getLogger("FileUtils").info(String.format(String.valueOf(message), replacements));
    }
}

