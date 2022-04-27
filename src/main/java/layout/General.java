package layout;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class General {
    private static final String TEXT_CYAN = "\u001B[34m";
    public static final Scanner s = new Scanner(System.in);
    public static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    public static void hold() {
        s.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String formatId(String id) {
        return id.replaceAll("[\\s,;.]+", "").trim().toUpperCase();
    }

    public static String formatName(String name) {
        String[] ar = name.trim().split("[\\s,;.]+");

        StringBuilder b = new StringBuilder();
        for (String x: ar)
        {
            b.append(x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase()).append(' ');
        }
        return b.toString();
    }

    public static String getTextCyan() {
        return TEXT_CYAN;
    }
}
