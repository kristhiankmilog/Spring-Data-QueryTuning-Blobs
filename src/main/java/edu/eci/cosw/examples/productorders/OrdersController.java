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

import edu.eci.cosw.samples.model.Despacho;
import edu.eci.cosw.samples.model.Pedido;
import edu.eci.cosw.samples.model.Producto;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.eci.cosw.examples.productorders.services.ApplicationServices;
import edu.eci.cosw.examples.productorders.services.ServicesException;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(path = "/orders")
public class OrdersController {

    @Autowired
    ApplicationServices services;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Pedido>> getAllOrders() {
        try {
            return ResponseEntity.ok().body(services.getAllOrders());
        } catch (ServicesException ex) {            
            Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Pedido> getorderById(@PathVariable("id") int id) {        
        try {
            return ResponseEntity.ok().body(services.orderById(id));
        } catch (ServicesException ex) {
            Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
