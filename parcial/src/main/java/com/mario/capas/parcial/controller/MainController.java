package com.mario.capas.parcial.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mario.capas.parcial.domain.Categoria;
import com.mario.capas.parcial.domain.Libro;
import com.mario.capas.parcial.service.CategoriaService;
import com.mario.capas.parcial.service.LibroService;

import javassist.expr.NewArray;

@Controller
public class MainController {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	LibroService libroService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/ingresarCategoria")
	public ModelAndView insertCat() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("iCategoria");
		return mav;
	}

	@RequestMapping("/ingresarCategoriaValid")
	public ModelAndView insertCatV(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("iCategoria");
		} else {
			try {
				categoriaService.insert(categoria);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("condition", new Integer(1));
			mav.setViewName("index");
		}
		return mav;
	}

	@RequestMapping("/ingresarLibro")
	public ModelAndView insertLibro() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> categorias = categoriaService.findAll();

		mav.addObject("libro", libro);
		mav.addObject("categorias", categorias);
		mav.setViewName("iLibro");

		return mav;
	}

	@RequestMapping("/ingresarLibroValid")
	public ModelAndView insertLibroV(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			List<Categoria> categorias = categoriaService.findAll();
			mav.addObject("categorias", categorias);
			mav.setViewName("iLibro");
		} else {
			try {
				libro.setFecha(new Date());
				libroService.insert(libro);
				mav.addObject("condition", new Integer(2));
				mav.setViewName("index");
			} catch (Exception e) {
				mav.setViewName("iLibro");
				e.printStackTrace();
			}
		}
		return mav;
	}

	@RequestMapping("/verLibros")
	public ModelAndView verLibros() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = libroService.findAll();
		mav.addObject("libros", libros);
		mav.setViewName("Libros");
		return mav;
	}

}
