/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.examples.productorders.repositories;

import edu.eci.cosw.samples.model.Cliente;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 2097687
 */
public interface ClienteRepository {
    
    @Query("select pedido.cliente from Pedido pedido left join pedido.detallesPedidos as detpedido left join detpedido.producto as producto with producto.precio>?1")
    List<Cliente> ClienteByProductPrice(long price);
    
}
