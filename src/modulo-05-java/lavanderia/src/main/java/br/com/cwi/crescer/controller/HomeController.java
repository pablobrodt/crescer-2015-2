package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.exception.Mensagem;
import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index(RedirectAttributes attr) {

        return new ModelAndView("index");
    }
}
