package com.project.experto;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.project.experto.models.domain.ItemFactura;
import com.project.experto.models.domain.Producto;

@Configuration
public class AppConfig {
    
    @Primary
    @Bean
    public List<ItemFactura> registrarItemsDeportes(){
        Producto producto1 = new Producto("balon", 500.00);
        Producto producto2 = new Producto("camara gopro", 500.00);
        Producto producto3 = new Producto("bicicleta", 500.00);

        ItemFactura linea1 = new ItemFactura(producto1, 3);
        ItemFactura linea2 = new ItemFactura(producto2, 1);
        ItemFactura linea3 = new ItemFactura(producto3, 2);

        return Arrays.asList(linea1, linea2, linea3);

    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor ASUS", 5500.00);
        Producto producto2 = new Producto("Silla Corsair", 4500.00);
        Producto producto3 = new Producto("Escritorio RGB", 7500.00);
        Producto producto4 = new Producto("Impresora con scanner", 7500.00);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 1);
        ItemFactura linea3 = new ItemFactura(producto3, 1);
        ItemFactura linea4 = new ItemFactura(producto4, 1);

        return Arrays.asList(linea1, linea2, linea3, linea4);
    }

}