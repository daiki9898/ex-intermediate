package com.example.util;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 色を表す列挙型.
 */
@Getter
public enum Color {
    RED("赤"),
    BLUE("青"),
    WHITE("白"),
    YELLOW("黄");

    private final String japanese;

    Color(String japanese) {
        this.japanese = japanese;
    }

    /**
     * 色の日本語名をキーとし、値にも同じ日本語名を持つマップを返す.
     * <p>
     * 例: {"赤"="赤", "青"="青", "白"="白", "黄"="黄"}
     *
     * @return 色の日本語名をキー・値とするマップ
     */
    public static Map<String, String> getColorMap() {
        Map<String, String> colorMap = new LinkedHashMap<>();
        for (Color color : Color.values()) {
            colorMap.put(color.getJapanese(), color.getJapanese());
        }
        return colorMap;
    }
}
