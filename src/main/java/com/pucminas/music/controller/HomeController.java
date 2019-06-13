package com.pucminas.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pucminas.music.config.oauth2.SpotifyOAuth2User;
import com.pucminas.music.models.HomeModelView;
import com.wrapper.spotify.SpotifyApi;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private SpotifyApi spotify;
    
    @GetMapping
    public ModelAndView home(Authentication auth) throws Exception {
        var user = (SpotifyOAuth2User) auth.getPrincipal();
        String a = "http://localhost:8085/artistas?token=BQAjIahBtGQHo8OqqAsIxFxiBzHG0QrLV7jOUIJTCkXg_NfaIEHS2XvC178X3looUlcrbNG5qGHIl8FZPve1JkKBzsjRdEqg3I0QqwjJFMwmbUX9zalF1Lg29r1eUHETPWhKwQzJpNXW2Sv5HTqNgd5P1gaSnYB2I57bSbDuQfZ-LocZ5SxGUOjAAK6bT2yp08FtTWk0d_ZNtK7xodFL0_MbF1HmWBtnma5_LK4";

        return new HomeModelView()
                .setUsername(user.getName())
                .setArtistaConsulta(a)
                .setToken(spotify.getAccessToken());
    }
}