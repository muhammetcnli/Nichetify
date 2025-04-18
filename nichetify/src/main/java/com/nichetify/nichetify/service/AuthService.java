package com.nichetify.nichetify.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

@Service
public class AuthService {

    // get the clientID securely with @Value
    @Value("${spotify.client.id}")
    private String clientId;

    @Value("${spotify.redirect.uri}")
    private String redirectUri;

    // get the clientSecret securely with @Value
    @Value("${spotify.client.secret}")
    private String clientSecret;

    private SpotifyApi spotifyApi;

    // initialize Spotify API
    // use PostConstruct to use method when created
    @PostConstruct
    public void init(){
        // initiate the redirectURI
        URI redirectURI = SpotifyHttpManager.makeUri(redirectUri);

        spotifyApi = new SpotifyApi.Builder()
                .setRedirectUri(redirectURI)
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
    }

    // returns spotify user login page
    public String getLoginUri(){
        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
                .scope("user-read-private, user-read-email, user-top-read") // get user's private, email, and top data's
                .show_dialog(true)
                .build();

        return authorizationCodeUriRequest.execute().toString();
    }

    public String handleCallback(String code) throws Exception{
        // make a authorization code request
        AuthorizationCodeRequest request = spotifyApi.authorizationCode(code).build();
        AuthorizationCodeCredentials credentials = request.execute();

        // Set access and refresh token for further "spotifyApi" usage
        spotifyApi.setAccessToken(credentials.getAccessToken());
        spotifyApi.setRefreshToken(credentials.getRefreshToken());

        // return access token
        return credentials.getAccessToken();
    }

    public String getDisplayName() throws Exception{
        return spotifyApi.getCurrentUsersProfile().build().execute().toString();
    }

    public Track[] getTopArtists() throws Exception{
        return spotifyApi.getUsersTopTracks().build().execute().getItems();
    }
}
