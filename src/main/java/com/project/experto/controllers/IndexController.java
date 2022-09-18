package com.project.experto.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.experto.models.Usuario;
import com.project.experto.models.services.IServicio;

@Controller
@RequestMapping(value = "/app")
public class IndexController {

    // utilizaremos la anotacion autowired que nos provee spring para la inyeccion de dependencias, lo que nos evita el crear
    // repetidas instancias de una clase, asi solo lo haremos una vez. Ademas, se debera de hacer importando la interfaz
    // ya que es mucho mas generica que la clase MiServicio, que puede cambiar. Lo que hacce que dependa de algo generico
    // y no de algo especifico
    @Autowired
    @Qualifier("miServicioComplex") // despues, debajo de autowired colocamos qualifier y el nombre del servicio
    private IServicio servicio;

    @GetMapping("/example")
    public String indexAmple(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

    
    //Tambien podemos inyectar dependencias ya sea desde el constructor o el metodo set de nuestra interface
    // destacar que al hacerlo desde el constructor podemos omitir el @autowired si este tiene parametros y es un componente
    //@Autowired
    // public void setServicio(IServicio servicio) {
    //    this.servicio = servicio;
    //}

    //@Autowired
    //public IndexController(IServicio servicio) {
    //    this.servicio = servicio;
    //}





    // con las etiquetas value podemos indicarle a la aplicacion desde donde inyectara valores, en este caso a estos strings, lo que nos evita repetir codigo
    // SYNTAX: titulo.clase.metodo.atributo: valor a asignar en el atributo
    @Value("${texto.indexcontroller.index.titulo: Hola titulo con model!}")
    private String textoIndexTitulo;

    @Value("${texto.indexcontroller.index.perfil: Perfil del usuario: }")
    private String textoPerfil;

    @Value("${texto.indexcontroller.index.listar: Listado de usuarios}")
    private String textoListar;

    @Value("${texto.indexcontroller.index.encabezado: titulo}")
    private String titulo;

    @GetMapping({ "/index", "/home" })
    public String index(Model model) {
        model.addAttribute(titulo, textoIndexTitulo);
        return "index";
    }

    @GetMapping(value = "/perfil")
    String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Pepe");
        usuario.setApellido("Lopez");
        usuario.setEmail("usuario@correo.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute(titulo, textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping(value = "/listar")
    String listar(Model model) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Silvio", "Rodriguez", "siro@correo.com"));
        usuarios.add(new Usuario("Jorge", "Campos", "campos@correo.com"));
        usuarios.add(new Usuario("Josue", "Vazquez", "vaz13@correo.com"));
        model.addAttribute(titulo, textoListar);

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
