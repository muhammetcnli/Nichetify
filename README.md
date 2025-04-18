# Nichetify
Discover your niche, discover your sound.

## Technologies
- Java 21
- Spring Boot 3.4.4
- Maven
- Spring Web
- OAuth2
- Lombok
- Spring Reactive Web
- Spring Configuration Processor

# TODO
- [x] Initialize Spring Boot project
- [x] Connect with Spotify API
  - [x] Make a client for Spotify API
  - [x] Get the spotify token
    - [x] Get the necessary data's from config file
    - [x] Get Spotify Access Token
- [ ] Authenticate user with OAuth2
  - [ ] Start OAuth2 authentication with Spring Security
  - [ ] Make a page for "Login with spotify"
- [ ] Make the niche music finder algorithm
  - [ ] Get user's favourite artists and songs and put it into a list
  - [ ] Get artist value for those songs
  - [ ] Get that artist's favorite songs
  - [ ] Make the loop go to a certain degree
- [ ] Frontend
  - [ ] Make a basic web ui
    - [ ] Make a login page
    - [ ] Make a page for user to see the found songs
- [ ] Improve API and Test
  - [ ] Make a API endpoint for song recommendations, with depth
  - [ ] Make a list out of recommendations
- [ ] Security and User Authorization
  - [ ] Make API's available for Authorized users
  - [ ] Save users data securely
- [ ] Tests
  - [ ] Code unit tests
- [ ] Deployment
  - [ ] Deploy project to a cloud platform or a server
  - [ ] Make a docker container for Spring Boot
- [ ] Docs, README etc.
  - [ ] Well document the project