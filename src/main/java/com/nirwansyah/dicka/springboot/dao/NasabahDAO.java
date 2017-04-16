/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.dicka.springboot.dao;

import com.nirwansyah.dicka.springboot.entities.Nasabah;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dickajava
 */
public interface NasabahDAO extends CrudRepository<Nasabah, Integer>{
    
}
