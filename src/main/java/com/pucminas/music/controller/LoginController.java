package com.pucminas.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pucminas.music.config.SpotifyConfigConstants;
import com.wrapper.spotify.SpotifyApi;

@Controller
public class LoginController {

    @Autowired
    private SpotifyApi spotify;
	
    private static String AUTH_BASE_URI = "oauth2/authorization/" + SpotifyConfigConstants.REGISTRATION_ID;
    
    @GetMapping("/login")
    public String login(Model model, Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
        	
        	System.out.println(spotify.getAccessToken());
        	
            return "redirect:/";
        }
        model.addAttribute("authorizationUrl", AUTH_BASE_URI);
        return "login";
    }

}