package me.unteachable.hiveminezSeason2.utils;

import org.bukkit.ChatColor;

import java.text.DecimalFormat;
import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prefix {

    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,###,###.##");

    public String setHiveMinezFormat(String format) {
        return ChatColor.translateAlternateColorCodes('&', "&c&lHive&e&lMinez &8&l» &c" + format);
    }

    public String setHexStringFormat(String msg, Object... values) {
        if (msg == null) return null;

        try {
            // 1. Fill the placeholders using the real formatting engine
            // We cast to Object[] so it spreads the values into multiple %s
            String formatted = String.format(msg, values);

            // 2. Translate everything (Hex first, then Legacy)
            return translateColorCodes(formatted);
        } catch (IllegalFormatException e) {
            // Fallback if the placeholders don't match the values provided
            return translateColorCodes(msg);
        }
    }

    public String translateColorCodes(String msg) {
        if (msg == null || msg.isEmpty()) return msg;

        // 1. Handle Hex: &#([A-Fa-f0-9]{6})
        Pattern hexPattern = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = hexPattern.matcher(msg);
        StringBuilder buffer = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.of("#" + matcher.group(1)).toString());
        }
        msg = matcher.appendTail(buffer).toString();

        // 2. Handle Legacy: &
        // We use a simple replace because translateAlternateColorCodes can
        // sometimes break the hex sequence we just made.
        return msg.replace("&", "§");
    }

    public String formatNumber(double num) {
        return DECIMAL_FORMAT.format(num);
    }
}
