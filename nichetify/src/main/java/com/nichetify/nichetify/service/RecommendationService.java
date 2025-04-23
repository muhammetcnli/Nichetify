package com.nichetify.nichetify.service;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecommendationService {

    private AuthService authService;
    private SpotifyApi spotifyApi;

    public RecommendationService(AuthService authService) {
        this.authService = authService;
         this.spotifyApi = authService.getSpotifyApi();
    }

    // get user's top songs
    public Track[] getTopSongs() {
        try {
            return spotifyApi.getUsersTopTracks().build().execute().getItems();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new Track[0];
        }
    }
    // ToDo - Make a method that gets the user's top songs, returns track array

    // get array of tracks, get that tracks top artists, return artist array
    public Artist[] getTopArtists(Track[] track) {
        Set<Artist> artists = new HashSet<>();

        try {
            for(Track t : track) {
                ArtistSimplified[] artistSimplified = t.getArtists();
                for(ArtistSimplified a : artistSimplified) {
                    String artistId = a.getId();
                    Artist fullArtist = spotifyApi.getArtist(artistId).build().execute();
                    artists.add(fullArtist);
                }
            }
            return artists.toArray(new Artist[0]);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new Artist[0];
        }
    }
    // ToDo - Make a method that gets a list of tracks, returns list of artists

    public Track[] getRecommended(Artist[] artists, int limit) {
        for (Artist a : artists) {
            String artistId = a.getId();
        }
    }
    // ToDo - Make a method that gets a artists top songs, with top songs or playlists, method requires a artist list - returns songs
    // Todo - Make a method that loops through 2 methods, takes an int for loop range, returns recommendation results


}
