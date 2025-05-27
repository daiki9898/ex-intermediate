package com.example.util;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public enum Gender {
    MAN(0, "Man"),
    WOMAN(1, "Woman");

    private final Integer value;
    private final String japanese;

    Gender(Integer value, String japanese) {
        this.value = value;
        this.japanese = japanese;
    }

    /**
     * 性別の数値と, 表示名を対応付けたマップを返す.
     * <p>
     * 例: {0=Man, 1=Woman}
     *
     * @return 性別を表す数値と, 表示名のマップ
     */
    public static Map<Integer, String> getGenderMap() {
        Map<Integer, String> genderMap = new LinkedHashMap<>();
        for (Gender gender : Gender.values()) {
            genderMap.put(gender.getValue(), gender.getJapanese());
        }
        return genderMap;
    }
}
