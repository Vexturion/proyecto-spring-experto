package com.project.experto.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;



//@RequestScope esta anotacion cambia nuestro componente de singleton a request, lo que hace que cada usuario que se 
// conecte tenga su propia factura. El objeto se construira con cada request.
//@SessionScope esta aotacion hace que el alcance del objeto sea lo mismo que dura una sesion, se cerrara despues 
//de un timeout o un cierre de sesion, todos los componentes que queramos guardar en sesion deberan de implementar
// serializable ya que cuando se almacena un objeto en java los objets entity se guardan en un contexto de persistencia
// ya que convierte los objetos a bytes que pueden ser transportados(json por ejemplo)
//@ApplicationScope es un singleton que se guarda en el servlet context y no en el application context de spring
@RequestScope
@Component
public class Factura {



    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> itemFacturas;

    @PostConstruct
    public void init(){
        cliente.setNombre(cliente.getNombre().concat(" ".concat("Alejandro")));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }

    @PreDestroy
    public void destruir(){
        System.out.println("La factura ".concat(descripcion) + " ha sido destruida");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItemFacturas() {
        return itemFacturas;
    }

    public void setItemFacturas(List<ItemFactura> itemFacturas) {
        this.itemFacturas = itemFacturas;
    }

}
