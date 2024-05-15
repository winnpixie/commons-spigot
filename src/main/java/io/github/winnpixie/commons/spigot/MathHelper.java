package io.github.winnpixie.commons.spigot;

import java.util.concurrent.ThreadLocalRandom;

public class MathHelper {
    private static final ThreadLocalRandom LOCAL_RANDOM = ThreadLocalRandom.current();

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            // Lazy throw
            return false;
        }

        return true;
    }

    public static int clampInt(int n, int min, int max) {
        if (max < min) {
            int swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static int absInt(int n) {
        return n < 0 ? -n : n;
    }

    public static int getRandomInt(int min, int max) {
        return LOCAL_RANDOM.nextInt(min, max);
    }

    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException e) {
            // Lazy throw
            return false;
        }

        return true;
    }

    public static float clampFloat(float n, float min, float max) {
        if (max < min) {
            float swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static float absFloat(float n) {
        return n < 0 ? -n : n;
    }

    public static int floorFloat(float n) {
        int i = (int) n;
        return i < n ? i : i - 1;
    }

    public static int ceilFloat(float n) {
        int i = (int) n;
        return i > n ? i : i + 1;
    }

    public static float getRandomFloat(float min, float max) {
        return LOCAL_RANDOM.nextFloat(min, max);
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            // Lazy throw
            return false;
        }

        return true;
    }

    public static double clampDouble(double n, double min, double max) {
        if (max < min) {
            double swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static double absDouble(double n) {
        return n < 0 ? -n : n;
    }

    public static int floorDouble(double n) {
        int i = (int) n;
        return i < n ? i : i - 1;
    }

    public static int ceilDouble(double n) {
        int i = (int) n;
        return i > n ? i : i + 1;
    }

    public static double getRandomDouble(double min, double max) {
        return LOCAL_RANDOM.nextDouble(min, max);
    }
}
