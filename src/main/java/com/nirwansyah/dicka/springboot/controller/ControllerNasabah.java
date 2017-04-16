/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.dicka.springboot.controller;

import com.nirwansyah.dicka.springboot.dao.NasabahDAO;
import com.nirwansyah.dicka.springboot.entities.Nasabah;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dickajava
 */
@Controller
@RequestMapping(value = "/data")
public class ControllerNasabah extends HttpServlet{
    
    @Autowired
    private NasabahDAO nasabahDAO;
    
    @RequestMapping(value = "/Nasabah", method = RequestMethod.GET)
    public String index(Model model){
        
        model.addAttribute("title", "Data Nasabah");
        model.addAttribute("listnasabah", nasabahDAO.findAll());
        return "nasabah/index";
    }
    
    @RequestMapping(value = "/NasabahInsert", method = RequestMethod.GET)
    public String insert(Model model){
        
        model.addAttribute("title", "Insert Nasabah");
        return "nasabah/insert";
    }
    
    @RequestMapping(value = "/NasabahUpdate", method = RequestMethod.GET)
    public String update(@RequestParam(value = "idnasabah")int idnasabah, Model model){
        
        model.addAttribute("title", "Update Nasabah");
        Nasabah nasabah=nasabahDAO.findOne(idnasabah);
        model.addAttribute("nasabahs", nasabah);
        return "nasabah/update";
    }
    
    @RequestMapping(value = "/NasabahUpdate", method = RequestMethod.POST)
    public String prosesupdate(HttpServletRequest request)
            throws ServletException, IOException{
        
        Nasabah nasabah=new Nasabah();
        String idnasabah=request.getParameter("idnasabah");
        nasabah.setIdnasabah(Integer.parseInt(idnasabah));
        nasabah.setNama(request.getParameter("nama"));
        nasabah.setAlamat(request.getParameter("alamat"));
        nasabah.setNotelp(request.getParameter("notelp"));
        nasabahDAO.save(nasabah);
        return "redirect:/data/Nasabah";
    }
    
    @RequestMapping(value = "/NasabahDelete", method = RequestMethod.GET)
    public String prosesdelete(@RequestParam(value = "idnasabah")int idnasabah){
        
        Nasabah nasabah=nasabahDAO.findOne(idnasabah);
        nasabahDAO.delete(nasabah);
        return "redirect:/data/Nasabah";
    }
    
    @RequestMapping(value = "/NasabahInsert", method = RequestMethod.POST)
    public String prosesinsert(HttpServletRequest request)
            throws ServletException, IOException{
        
        Nasabah nasabah=new Nasabah();
        nasabah.setNama(request.getParameter("nama"));
        nasabah.setAlamat(request.getParameter("alamat"));
        nasabah.setNotelp(request.getParameter("notelp"));
        nasabahDAO.save(nasabah);
        return "redirect:/data/Nasabah";
    }
}
