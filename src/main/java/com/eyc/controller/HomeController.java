package com.eyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eyc.model.Entrada;
import com.eyc.service.EntradaService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	EntradaService entradaService;
	
	@GetMapping
	public ModelAndView listaTodos() {
		ModelAndView mv = new ModelAndView("entrada/lista-todos");
		List<Entrada> lista = entradaService.optenerEntradaLista();
		mv.addObject("entradasTodos", lista);
		return mv;
	}

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }

}
