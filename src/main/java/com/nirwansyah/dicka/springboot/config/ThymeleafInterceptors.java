/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirwansyah.dicka.springboot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author dickajava
 */
public class ThymeleafInterceptors extends HandlerInterceptorAdapter{
    
    private static final String DEFAULT_LAYOUT = "nasabah/layout";
    private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,  Object handler, ModelAndView modelAndView) throws Exception {
      if(modelAndView==null || !modelAndView.hasView()){
          return;
      }
      String originalViewName = modelAndView.getViewName();
      modelAndView.addObject("title");
      modelAndView.setViewName(DEFAULT_LAYOUT);
      modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, originalViewName);
    }
    
}
