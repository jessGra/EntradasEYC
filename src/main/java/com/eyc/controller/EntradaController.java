package com.eyc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eyc.model.Entrada;
import com.eyc.service.EntradaService;

@Controller
@RequestMapping("/entrada")
public class EntradaController {
	
	@Autowired
	EntradaService entradaService;
	
	@GetMapping
	public ModelAndView listaTodos() {
		ModelAndView mv = new ModelAndView("entrada/lista-todos");
		List<Entrada> lista = entradaService.optenerEntradaLista();
		mv.addObject("entradasTodos", lista);
		return mv;
	}
	
	@GetMapping("/por-entregar")
	public ModelAndView listaEntregar() {
		ModelAndView mv = new ModelAndView("entrada/por-entregar");
		List<Entrada> lista = entradaService.optenerEntradaPorEntregado("no");
		mv.addObject("entradasPorEntregar", lista);
		return mv;
	}
	
	@GetMapping("/detalle/{id}")
    public ModelAndView detalle(@PathVariable("id") long id){
        if(!entradaService.existePorIdEntrada(id))
            return new ModelAndView("redirect:/entrada");
        ModelAndView mv = new ModelAndView("/entrada/detalle");
        Entrada entrada = entradaService.optenerEntradaPorId(id).get();
        mv.addObject("entrada", entrada);
        return mv;
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/nueva")
    public String nueva(Map<String, Entrada> model){
		Entrada entrada = new Entrada();
		model.put("entrada", entrada);
        return "entrada/nueva";
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/crear")
	public ModelAndView crear(@Valid Entrada entrada, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()){
			mv.setViewName("entrada/nueva");
			return mv;
		}
		if(entradaService.existePorNumeroEntrada(entrada.getNumeroEntrada())){
			mv.addObject("error", "Ya existe una entrada con ese numero");
            mv.setViewName("entrada/nueva");
            return mv;
		}
		String fechaCreacion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		entrada.setFechaEntrada(fechaCreacion);
		entradaService.guardar(entrada);
		mv.setViewName("redirect:/entrada");
		return mv;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") long id){
        if(!entradaService.existePorIdEntrada(id))
            return new ModelAndView("redirect:/entrada");
        ModelAndView mv = new ModelAndView("/entrada/editar");
        Entrada entrada = entradaService.optenerEntradaPorId(id).get();
        
        mv.addObject("entrada", entrada);
        return mv;
    }
		
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/actualizar")
	public ModelAndView actualizar(@Valid Entrada entrada, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()){
			mv.addObject("id", entrada.getId());
			mv.setViewName("entrada/editar");
			return mv;
		}
		entradaService.guardar(entrada);
		mv.setViewName("redirect:/entrada");
		return mv;
	}
}
