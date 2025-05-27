package com.example.controller;

import com.example.domain.Hotel;
import com.example.form.HotelSearchInput;
import com.example.service.HotelService;
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
 * ホテル情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    /**
     * ホテル検索画面を表示する.
     *
     * @param hotelSearchInput ホテル情報
     * @return 検索画面
     */
    @GetMapping("/search")
    public String index(HotelSearchInput hotelSearchInput) {
        return "hotel/search";
    }

    /**
     * 入力された価格以下のホテル一覧を検索する(未入力の場合、全件検索を行う）.
     *
     * @param hotelSearchInput ホテル情報
     * @param bindingResult    エラー情報
     * @param model            モデル
     * @return 検索画面
     */
    @PostMapping("/search")
    public String search(@Validated HotelSearchInput hotelSearchInput, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return index(hotelSearchInput);
        }
        List<Hotel> hotels = hotelService.searchByLessThanPrice(hotelSearchInput.getPrice());
        model.addAttribute("hotels", hotels);

        if (hotels.isEmpty()) {
            model.addAttribute("notExistsMessage", "該当するホテルはありません");
        }
        return index(hotelSearchInput);
    }
}
