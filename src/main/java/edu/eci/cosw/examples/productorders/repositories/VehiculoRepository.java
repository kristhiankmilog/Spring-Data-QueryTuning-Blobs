/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.examples.productorders.repositories;

import edu.eci.cosw.samples.model.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 2097687
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, String>{
    
    @Query("select despacho.vehiculo from Despacho despacho  inner join despacho.pedidos as pedido  inner join pedido.detallesPedidos as detpedido inner join detpedido.producto as producto with producto.idproducto=?1")
    List<Vehiculo> VehiculosByIdProducto(int idProducto);
    
}
