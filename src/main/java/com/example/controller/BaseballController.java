package com.example.controller;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 野球チーム情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/baseball/teams")
@RequiredArgsConstructor
public class BaseballController {
    private final BaseballService baseballService;

    /**
     * チーム一覧画面を表示する.
     *
     * @param model モデル
     * @return チーム一覧画面
     */
    @GetMapping
    public String showTeams(Model model) {
        model.addAttribute("teams", baseballService.findAll());
        return "baseball/teams";
    }


    /**
     * チーム詳細画面を表示する.
     *
     * @param id id
     * @return 詳細画面
     */
    @GetMapping("{id}")
    public String showDetail(@PathVariable String id, Model model) {
        BaseballTeam team = baseballService.findById(Integer.parseInt(id));
        model.addAttribute("team", team);
        return "baseball/detail";
    }
}
