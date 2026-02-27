package com.example.sofascore.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class SofascoreService {

    private final WebClient webClient;
    private final WebClient mobileWebClient;

    public SofascoreService(WebClient webClient, WebClient mobileWebClient) {
        this.webClient = webClient;
        this.mobileWebClient = mobileWebClient;
    }

    // Scheduled events
    public Mono<ResponseEntity<String>> getScheduledEvents(String sport, String date) {
        return webClient.get()
                .uri("/api/v1/sport/{sport}/scheduled-events/{date}", sport, date)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Live events
    public Mono<ResponseEntity<String>> getLiveEvents(String sport) {
        return webClient.get()
                .uri("/api/v1/sport/{sport}/events/live", sport)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Match by ID
    public Mono<ResponseEntity<String>> getMatchById(Long matchId) {
        return webClient.get()
                .uri("/api/v1/event/{matchId}", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Match statistics
    public Mono<ResponseEntity<String>> getMatchStatistics(Long matchId) {
        return mobileWebClient.get()
                .uri("/event/{matchId}/statistics", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Match incidents
    public Mono<ResponseEntity<String>> getMatchIncidents(Long matchId) {
        return webClient.get()
                .uri("/api/v1/event/{matchId}/incidents", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Head to head
    public Mono<ResponseEntity<String>> getHeadToHead(Long matchId) {
        return mobileWebClient.get()
                .uri("/event/{matchId}/head2head", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Lineups
    public Mono<ResponseEntity<String>> getLineups(Long matchId) {
        return mobileWebClient.get()
                .uri("/event/{matchId}/lineups", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Team performance
    public Mono<ResponseEntity<String>> getTeamPerformance(Long teamId) {
        return mobileWebClient.get()
                .uri("/team/{teamId}/performance", teamId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Match odds
    public Mono<ResponseEntity<String>> getMatchOdds(Long matchId) {
        return mobileWebClient.get()
                .uri("/event/{matchId}/odds", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Match details
    public Mono<ResponseEntity<String>> getMatchDetails(Long matchId) {
        return mobileWebClient.get()
                .uri("/event/{matchId}/details", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Player statistics for match
    public Mono<ResponseEntity<String>> getMatchPlayerStats(Long matchId) {
        return mobileWebClient.get()
                .uri("/event/{matchId}/player-statistics", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Player details
    public Mono<ResponseEntity<String>> getPlayerDetails(Long playerId) {
        return mobileWebClient.get()
                .uri("/player/{playerId}/details", playerId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Player transfer history
    public Mono<ResponseEntity<String>> getPlayerTransferHistory(Long playerId) {
        return mobileWebClient.get()
                .uri("/player/{playerId}/transfer-history", playerId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Pregame form
    public Mono<ResponseEntity<String>> getPregameForm(Long matchId) {
        return webClient.get()
                .uri("/api/v1/event/{matchId}/pregame-form", matchId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Categories
    public Mono<ResponseEntity<String>> getCategories(String sport) {
        return webClient.get()
                .uri("/api/v1/sport/{sport}/categories", sport)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Team players
    public Mono<ResponseEntity<String>> getTeamPlayers(Long teamId) {
        return mobileWebClient.get()
                .uri("/team/{teamId}/players", teamId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Team details
    public Mono<ResponseEntity<String>> getTeamDetails(Long teamId) {
        return mobileWebClient.get()
                .uri("/team/{teamId}/details", teamId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Team past and next matches
    public Mono<ResponseEntity<String>> getTeamLastNext(Long teamId) {
        return mobileWebClient.get()
                .uri("/team/{teamId}/lastnext", teamId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Manager details
    public Mono<ResponseEntity<String>> getManagerDetails(Long managerId) {
        return mobileWebClient.get()
                .uri("/manager/{managerId}/details", managerId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Category unique tournaments
    public Mono<ResponseEntity<String>> getCategoryUniqueTournaments(Long categoryId) {
        return webClient.get()
                .uri("/api/v1/category/{categoryId}/unique-tournaments", categoryId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Tournament seasons
    public Mono<ResponseEntity<String>> getTournamentSeasons(Long tournamentId) {
        return mobileWebClient.get()
                .uri("/unique-tournament/{tournamentId}/seasons", tournamentId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Tournament top players
    public Mono<ResponseEntity<String>> getTournamentTopPlayers(
            Long tournamentId, Long seasonId) {
        return mobileWebClient.get()
                .uri("/unique-tournament/{tournamentId}/season/{seasonId}/top-players", 
                     tournamentId, seasonId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Tournament standings
    public Mono<ResponseEntity<String>> getTournamentStandings(
            Long tournamentId, Long seasonId) {
        return mobileWebClient.get()
                .uri("/unique-tournament/{tournamentId}/season/{seasonId}/standings", 
                     tournamentId, seasonId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }

    // Tournament events/matches
    public Mono<ResponseEntity<String>> getTournamentEvents(
            Long tournamentId, Long seasonId) {
        return mobileWebClient.get()
                .uri("/unique-tournament/{tournamentId}/season/{seasonId}/events", 
                     tournamentId, seasonId)
                .retrieve()
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(500).body("{\"error\": \"" + e.getMessage() + "\"}")
                ));
    }
}