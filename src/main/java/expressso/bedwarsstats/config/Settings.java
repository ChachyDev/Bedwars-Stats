package expressso.bedwarsstats.config;

public class Settings {

    private static int TotalStars_Position_X;
    private static int TotalStars_Position_Y;
    private static int TotalStars_Colour;
    private static boolean apiChecked;

    //getters and setters
    public static int getTotalStars_Position_X() {
        return TotalStars_Position_X;
    }

    public static void setTotalStars_Position_X(int totalStars_Position_X) {
        TotalStars_Position_X = totalStars_Position_X;
    }

    public static int getTotalStars_Position_Y() {
        return TotalStars_Position_Y;
    }

    public static void setTotalStars_Position_Y(int totalStars_Position_Y) {
        TotalStars_Position_Y = totalStars_Position_Y;
    }

    public static int getTotalStars_Colour() {
        return TotalStars_Colour;
    }

    public static void setTotalStars_Colour(int totalStars_Colour) {
        TotalStars_Colour = totalStars_Colour;
    }

    public static boolean getApiChecked() {
        return apiChecked;
    }

    public static void setApiChecked(boolean apiChecked) {
        apiChecked = apiChecked;
    }
}
