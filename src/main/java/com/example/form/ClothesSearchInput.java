package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 衣類情報を保持するフォーム.
 */
@Getter
@Setter
@ToString
public class ClothesSearchInput {
    /**
     * 性別
     */
    @NotNull(message = "性別を選択してください")
    private Integer gender;
    /**
     * 色
     */
    @NotBlank(message = "色を選択してください")
    private String color;
}
