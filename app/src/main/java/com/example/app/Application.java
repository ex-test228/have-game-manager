package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Application {

  @GetMapping("/")
  public String main(@RequestParam(name = "name", required = false, defaultValue = "Guest") String game,
      org.springframework.ui.Model model) {

    String[] games = { "game 1", "game 2", "game 3", "game 4" };
    model.addAttribute("games", games);

    return "main";
  }

  // @PostMapping("/add")
  // public String submitForm(@ModelAttribute("formData") FormData formData,
  // org.springframework.ui.Model model) {

  // // フォームデータを処理するロジックをここに追加
  // String gameName = formData.getName();
  // // 例えば、ゲーム名をリストに追加するなどの処理

  // // モデルにゲーム名を追加
  // model.addAttribute("gameName", gameName);

  // System.out.println(gameName);

  // // メインページにリダイレクト
  // return "redirect:/";
  // }

  @PostMapping("/add")
  @ResponseBody // HTMLを返さずに文字列を直接ブラウザに表示
  public String handleSubmitForm(@RequestParam("name") String name,
      @RequestParam("number") String number) {

    // 受け取ったデータを処理
    System.out.println(name);
    System.out.println(number);

    String text = name + " " + number;

    return "ゲーム名 '" + text + "' が追加されました。";

  }
}
