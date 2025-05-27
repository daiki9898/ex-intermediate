package com.example.controller;

import com.example.domain.Clothes;
import com.example.form.ClothesSearchInput;
import com.example.service.ClothesService;
import com.example.util.Color;
import com.example.util.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 衣類情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/clothes")
@RequiredArgsConstructor
public class ClothesController {
    private final ClothesService clothesService;

    /**
     * 衣類検索画面を表示する.
     *
     * @param clothesSearchInput 衣類情報
     * @param model モデル
     * @return 検索画面
     */
    @GetMapping("/search")
    public String index(ClothesSearchInput clothesSearchInput, Model model) {
        model.addAttribute("genderMap", Gender.getGenderMap());
        model.addAttribute("colorMap", Color.getColorMap());
        return "clothes/search";
    }

    /**
     * 指定された条件に応じて衣類を検索する.
     *
     * @param clothesSearchInput 衣類情報
     * @param bindingResult エラーメッセージ一覧
     * @param model モデル
     * @return 検索結果
     */
    @PostMapping("/search")
    public String search(@Validated ClothesSearchInput clothesSearchInput, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return index(clothesSearchInput, model);
        }
        List<Clothes> clothesList = clothesService.searchByGenderAndColor(clothesSearchInput.getGender(), clothesSearchInput.getColor());
        model.addAttribute("clothesList", clothesList);

        if (clothesList.isEmpty()) {
            model.addAttribute("notExistsMessage", "条件に一致する衣類はありません");
        }

        return index(clothesSearchInput, model);
    }
}
