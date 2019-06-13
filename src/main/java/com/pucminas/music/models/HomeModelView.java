package com.pucminas.music.models;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class HomeModelView extends ModelAndView {

    public HomeModelView() {
        super("teste");
        //super("home");
    }

    public HomeModelView setUsername(String username) {
        addObject("username", username);
        return this;
    }

    public HomeModelView setToken(String t) {
        addObject("token", t);
        return this;
    }
    
    public HomeModelView setArtistaConsulta(String a) {
        addObject("artistaConsulta", a);
        return this;
    }
    

}