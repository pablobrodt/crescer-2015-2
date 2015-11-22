package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {

        String mensagem = "Bem Vindo, Lavanderia Crescer";

        model.addAttribute("mensagem", mensagem);

        return "index";
    }
}
