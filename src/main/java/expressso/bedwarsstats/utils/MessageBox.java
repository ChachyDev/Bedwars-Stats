package expressso.bedwarsstats.utils;

import javax.swing.*;

public class MessageBox {

    public static void infoBox(String infoMessage, String titleBar, int icon)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, icon);
    }

    public static void inputBox(String infoMessage, String titleBar, int icon) {
        JOptionPane.showInputDialog(null, infoMessage, titleBar, icon);
    }

}
