package io.github.winnpixie.commons.spigot;

import java.util.concurrent.ThreadLocalRandom;

public class MathHelper {
    private static final ThreadLocalRandom LOCAL_RANDOM = ThreadLocalRandom.current();

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) { // Lazy catch
            return false;
        }
    }

    public static int clamp(int n, int min, int max) {
        if (max < min) {
            int swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static int abs(int n) {
        return n < 0 ? -n : n;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int getRandomInt(int min, int max) {
        return LOCAL_RANDOM.nextInt(min, max);
    }

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) { // Lazy catch
            return false;
        }
    }

    public static long clamp(long n, long min, long max) {
        if (max < min) {
            long swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static long abs(long n) {
        return n < 0 ? -n : n;
    }

    public static long min(long a, long b) {
        return a < b ? a : b;
    }

    public static long max(long a, long b) {
        return a > b ? a : b;
    }

    public static long getRandomLong(long min, long max) {
        return LOCAL_RANDOM.nextLong(min, max);
    }

    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) { // Lazy catch
            return false;
        }
    }

    public static float clamp(float n, float min, float max) {
        if (max < min) {
            float swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static float abs(float n) {
        return n < 0 ? -n : n;
    }

    public static float min(float a, float b) {
        return a < b ? a : b;
    }

    public static float max(float a, float b) {
        return a > b ? a : b;
    }

    public static int floor(float n) {
        int i = (int) n;
        return i < n ? i : i - 1;
    }

    public static int ceil(float n) {
        int i = (int) n;
        return i > n ? i : i + 1;
    }

    public static float getRandomFloat(float min, float max) {
        return LOCAL_RANDOM.nextFloat(min, max);
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) { // Lazy catch
            return false;
        }
    }

    public static double clamp(double n, double min, double max) {
        if (max < min) {
            double swp = max;
            max = min;
            min = swp;
        }

        return n < min ? min : n > max ? max : n;
    }

    public static double abs(double n) {
        return n < 0 ? -n : n;
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static int floor(double n) {
        int i = (int) n;
        return i < n ? i : i - 1;
    }

    public static int ceil(double n) {
        int i = (int) n;
        return i > n ? i : i + 1;
    }

    public static double getRandomDouble(double min, double max) {
        return LOCAL_RANDOM.nextDouble(min, max);
    }
}
