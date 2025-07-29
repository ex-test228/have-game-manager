// src/main/java/com/example/thymeleafdemo/controller/HelloController.java
package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// このクラスがSpring MVCのコントローラーであることを示すアノテーション
@Controller
public class HelloController {

    // HTTP GETリクエストが "/" パスに来たときにこのメソッドが実行される
    @GetMapping("/hello")
    public String hello(
            // リクエストパラメータ "name" を受け取る（省略可能、デフォルトは "Guest"）
            @RequestParam(name = "name", required = false, defaultValue = "Guest") String name,
            // HTMLテンプレートにデータを渡すためのModelオブジェクト
            Model model) {

        // "message" という名前でデータをModelに追加
        // このデータはHTMLテンプレートから参照できるようになる
        model.addAttribute("message", "Hello, " + name + "!");
        model.addAttribute("greeting", "Welcome to Thymeleaf Demo!");

        // リストデータも追加してみる
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        model.addAttribute("items", items);

        // "hello" という名前のHTMLテンプレートを返す
        // Spring Bootはデフォルトで src/main/resources/templates/hello.html を探す
        return "hello";
    }

    // 別のパス "/about" へのリクエストを処理するメソッド
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Us");
        model.addAttribute("content", "This is a simple demo application using Spring Boot and Thymeleaf.");
        return "about"; // src/main/resources/templates/about.html を表示
    }
}

