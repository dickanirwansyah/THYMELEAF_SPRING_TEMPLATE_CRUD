/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.dicka.springboot.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dickajava
 */
@Controller
@RequestMapping(value = "/data")
public class ControllerHome {
    
    @RequestMapping(value = "/home")
    public String index(Model model){
        
        model.addAttribute("title", "Home");
        model.addAttribute("tanggal", new Date());
        return "nasabah/home";
    }
}
