/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cosw.examples.productorders;

import edu.eci.cosw.samples.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.cosw.examples.productorders.services.ApplicationServices;
import edu.eci.cosw.examples.productorders.services.ServicesException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(path = "/products")
public class ProductsController {
    
    @Autowired
    ApplicationServices services;    
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Producto>> getAllProds() {
        try {
            return ResponseEntity.ok().body(services.getAllProducts());
        } catch (ServicesException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
