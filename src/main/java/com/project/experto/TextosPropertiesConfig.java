package com.project.experto;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// tambien podemos definir un archivo properties, adicional al application.properties(que como tal define las propiedades del aplicativo
// entre las que se enecuentran el puerto, configuracion de la base de datos etc
@Configuration
@PropertySource("classpath:textos.properties")
public class TextosPropertiesConfig {
    
}