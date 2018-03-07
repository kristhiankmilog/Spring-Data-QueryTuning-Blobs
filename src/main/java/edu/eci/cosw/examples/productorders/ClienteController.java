/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.examples.productorders;

import edu.eci.cosw.examples.productorders.services.ApplicationServices;
import edu.eci.cosw.examples.productorders.services.ServicesException;
import edu.eci.cosw.samples.model.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2097687
 */
@RestController
@RequestMapping(path = "/clients")
public class ClienteController {
    
    @Autowired
    ApplicationServices services;    
    
    @RequestMapping(path="/{productPrice}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Cliente>> getAllCLientsByPrecioProducto(@PathVariable("productPrice") long productPrice) {
        try {
            return ResponseEntity.ok().body(services.getAllClientesByProductPrice(productPrice));
        } catch (ServicesException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}