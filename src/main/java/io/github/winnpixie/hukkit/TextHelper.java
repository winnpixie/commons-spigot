package io.github.winnpixie.hukkit;

import net.md_5.bungee.api.ChatColor;

public class TextHelper {
    public static String formatColors(String text) {
        return toSpigotHex(ChatColor.translateAlternateColorCodes('&', text));
    }

    // Converts &#RRGGBB to &x&R&R&G&G&B&B
    private static String toSpigotHex(String text) {
        StringBuilder sb = new StringBuilder();

        for (var i = 0; i < text.length(); i++) {
            var c = text.charAt(i);

            if ((c == '\u00A7' || c == '&') && i + 7 < text.length() && text.charAt(i + 1) == '#') {
                var hex = text.substring(i + 2, i + 8);

                if (hex.matches("[a-fA-F0-9]{6}")) {
                    sb.append("\u00A7x");
                    for (int o = 0; o < hex.length(); o++) {
                        sb.append('\u00A7').append(hex.charAt(o));
                    }

                    i += 7;
                    continue;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
