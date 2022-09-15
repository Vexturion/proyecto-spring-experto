package com.project.experto.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.experto.models.Usuario;

@Controller
@RequestMapping(value = "/app")
public class IndexController {

    // con las etiquetas value podemos indicarle a la aplicacion desde donde inyectara valores, en este caso a estos strings, lo que nos evita repetir codigo
    // SYNTAX: titulo.clase.metodo.atributo: valor a asignar en el atributo
    @Value("${texto.indexcontroller.index.titulo: Hola titulo con model!}")
    private String textoIndexTitulo;

    @Value("${texto.indexcontroller.index.perfil: Perfil del usuario: }")
    private String textoPerfil;

    @Value("${texto.indexcontroller.index.listar: Listado de usuarios}")
    private String textoListar;

    @GetMapping({ "/index", "/home" })
    public String index(Model model) {
        model.addAttribute("titulo", textoIndexTitulo);
        return "index";
    }

    @GetMapping(value = "/perfil")
    String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Pepe");
        usuario.setApellido("Lopez");
        usuario.setEmail("usuario@correo.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping(value = "/listar")
    String listar(Model model) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Silvio", "Rodriguez", "siro@correo.com"));
        usuarios.add(new Usuario("Jorge", "Campos", "campos@correo.com"));
        usuarios.add(new Usuario("Josue", "Vazquez", "vaz13@correo.com"));
        model.addAttribute("titulo", textoListar);

        /*
         * Tambien podemos hacerlo de esta manera, con el metodo asList del objeto Array
         * 
         * @GetMapping(value = "/listar")
         * String listar (Model model){
         * List<Usuario> usuarios = new Array.asList(new usuario("Silvio", "Rodriguez",
         * "siro@correo.com"),
         * new Usuario("Jorge", "Campos", "campos@correo.com"),
         * new Usuario("Josue", "Vazquez", "vaz13@correo.com"));
         * model.addAttribute("titulo", "Listado de usuarios");
         * model.addAttribute("usuarios", usuarios);
         * 
         */

        return "listar";
    }

    // este metodo es util cuando se van a usar datos de forma repetida en multiples
    // vistas, un formulario o varios campos
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
       return Arrays.asList(new Usuario("Silvio", "Rodriguez", "siro@correo.com"),
                new Usuario("Jorge", "Campos", "campos@correo.com"),
                new Usuario("Josue", "Vazquez", "vaz13@correo.com"));
    }

}
