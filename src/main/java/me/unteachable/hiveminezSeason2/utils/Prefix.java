package me.unteachable.hiveminezSeason2.utils;

import org.bukkit.ChatColor;

import java.text.DecimalFormat;
import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prefix {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,###,###.##");

    public static String setHiveMinezFormat(String format) {
        return ChatColor.translateAlternateColorCodes('&', "&c&lHive&e&lMinez &8&l» &c" + format);
    }

    public static String translateColorCodes(String msg, Object... values) {
        if (msg == null) return null;

        try {
            String formatted = String.format(msg, values);
            return translateColorCodes(formatted);
        } catch (IllegalFormatException e) {
            return translateColorCodes(msg);
        }
    }

    public static String translateColorCodes(String msg) {
        if (msg == null || msg.isEmpty()) return msg;

        msg = ChatColor.translateAlternateColorCodes('&', msg);

        // The pattern is setting what it is looking for in the string msg.
        Pattern hexPattern = Pattern.compile("(?:&x|&#|§x)#?([A-Fa-f0-9]{6})", Pattern.CASE_INSENSITIVE);
        // The matcher finds the pattern in the message and sets it to the &#.
        Matcher matcher = hexPattern.matcher(msg);
        StringBuilder buffer = new StringBuilder();

        while (matcher.find()) {
            String hex = matcher.group(1); // Now this only contains the 6 digits

            // Safety check: Only parse if it's exactly 6 characters
            if (hex != null && hex.length() == 6) {
                try {
                    matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.of("#" + hex).toString());
                } catch (IllegalArgumentException e) {
                    // Log if a weird color code slips through, but don't crash
                    System.err.println("Invalid color format found: " + hex);
                }
            }
        }
        return matcher.appendTail(buffer).toString();
    }

    public static String formatNumber(double num) {
        return DECIMAL_FORMAT.format(num);
    }
}
