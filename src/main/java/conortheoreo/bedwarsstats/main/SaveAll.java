package conortheoreo.bedwarsstats.main;

import java.util.TimerTask;
import static conortheoreo.bedwarsstats.config.ConfigManager.saveSettings;

public class SaveAll extends TimerTask {
    public void run() {
        saveSettings();
        System.out.println("AutoSave Succesful!");
    }
}
