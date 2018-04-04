package expressso.bedwarsstats.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import org.lwjgl.input.Keyboard;


public class Keybinds {
    public static KeyBinding bdsgui;

    public static void load() {
        bdsgui = new KeyBinding("key.bdsgui", Keyboard.KEY_Z, "key.categories.BedwarsStats");
        ClientRegistry.registerKeyBinding(bdsgui);
    }

    public static int isHotbarKeyDown() {
        KeyBinding[] bindings = Minecraft.getMinecraft().gameSettings.keyBindsHotbar;
        for (int i = 0; i < bindings.length; i++)
            if (bindings[i].isPressed())
                return i;
        return -1;
    }
}
