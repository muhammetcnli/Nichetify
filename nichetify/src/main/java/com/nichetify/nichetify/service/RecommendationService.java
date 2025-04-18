package com.nichetify.nichetify.service;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    private AuthService authService;

    public RecommendationService(AuthService authService) {
        this.authService = authService;
    }

    // ToDo - Make a method that gets the user's top songs
    // ToDo - Make a method that gets a list of songs, returns list of artists
    // ToDo - Make a method that gets a artists top songs, with top songs or playlists, method requires a artist list - returns songs
    // Todo - Make a method that loops through 2 methods, takes an int for loop range, returns recommendation results


}
