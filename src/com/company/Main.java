package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> dict = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        populateDict(dict);

        int padding = calculatePadding(dict);

        for (HashMap.Entry<String, String> entry : dict.entrySet()) {
            String formatted = formatKeyValuePair(entry.getKey(), entry.getValue(), padding);
            stringBuilder.append(formatted);
        }

        System.out.println(stringBuilder.toString());
    }

    private static void populateDict(HashMap<String, String> dict) {
        dict.put("Dog", "Perro");
        dict.put("Horse", "Caballo");
        dict.put("Sunglasses", "Gafas de sol");
        dict.put("Agglutination", "Aglutinación");
    }

    private static int calculatePadding(HashMap<String, String> dict) {
        int max = Integer.MIN_VALUE;

        for (HashMap.Entry<String, String> entry : dict.entrySet()) {
            String key = entry.getKey();
            int length = key.length();
            max = Math.max(max, length);
        }

        return max;
    }

    private static String formatKeyValuePair(String key, String value, int padding) {
        String paddedKey = padRight(key, padding);

        return String.format("%s %s\n", paddedKey, value);
    }

    private static String padRight(String s, int padding) {
        int realPadding = padding - s.length();
        int count = Math.max(realPadding, 0);

        return s + " ".repeat(count);
    }

}
