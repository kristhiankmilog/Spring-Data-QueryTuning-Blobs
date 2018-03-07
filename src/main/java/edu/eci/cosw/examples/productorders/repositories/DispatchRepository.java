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
package edu.eci.cosw.examples.productorders.repositories;

import edu.eci.cosw.examples.productorders.services.ServicesException;
import edu.eci.cosw.samples.model.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author hcadavid
 */
public interface DispatchRepository extends JpaRepository<Despacho, Integer>{
    
    @Query("SELECT u from Despacho u where u.iddespacho=?1")
    public Despacho QRdispatchByID(Integer id) throws ServicesException;
    
}
