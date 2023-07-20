package io.github.winnpixie.hukkit;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Pattern;

public class TextHelper {
    private static final Pattern HEX_PATTERN = Pattern.compile("#[a-f0-9]{6}", Pattern.CASE_INSENSITIVE);
    private static final String[][] TAG_TO_CODE = { // Jesus Christ
            {"black", "0"},
            {"dark_blue", "1"}, {"darkblue", "1"},
            {"dark_green", "2"}, {"darkgreen", "2"},
            {"dark_aqua", "3"}, {"darkaqua", "3"},
            {"dark_red", "4"}, {"darkred", "4"},
            {"dark_purple", "5"}, {"darkpurple", "5"},
            {"gold", "6"},
            {"gray", "7"}, {"grey", "7"},
            {"dark_gray", "8"}, {"darkgray", "8"}, {"dark_grey", "8"}, {"darkgrey", "8"},
            {"blue", "9"},

            {"green", "a"},
            {"aqua", "b"},
            {"red", "c"},
            {"light_purple", "d"}, {"lightpurple", "d"}, {"purple", "d"}, {"magenta", "d"},
            {"yellow", "e"},
            {"white", "f"},

            {"obfuscated", "k"}, {"random", "k"},
            {"bold", "l"},
            {"strikethrough", "m"},
            {"underline", "n"}, {"underlined", "n"},
            {"italic", "o"},
            {"reset", "r"},
    };

    public static String formatText(String text) {
        return convertHexColors(convertFormatTags(convertFormatCodes(text)));
    }

    public static String convertFormatTags(String text) {
        for (String[] codes : TAG_TO_CODE) {
            text = text.replace(String.format("<%s>", codes[0]), String.format("\u00A7%s", codes[1]));
        }

        return text;
    }

    public static String convertFormatCodes(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    // Converts #RRGGBB to &x&R&R&G&G&B&B
    public static String convertHexColors(String text) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char chr = text.charAt(i);
            String hex = "";

            switch (chr) {
                case '\u00A7':
                case '&':
                    if (i + 7 < text.length()) {
                        hex = text.substring(i + 1, i + 8);
                    }

                    break;
                case '<':
                    if (i + 8 < text.length() && text.charAt(i + 8) == '>') {
                        hex = text.substring(i + 1, i + 8);
                    }

                    break;
            }

            if (HEX_PATTERN.matcher(hex).matches()) {
                output.append("\u00A7x");

                for (char hexChar : hex.toCharArray()) {
                    output.append('\u00A7').append(hexChar);
                }

                i += chr == '<' ? 8 : 7;
            } else {
                output.append(chr);
            }
        }

        return output.toString();
    }
}
