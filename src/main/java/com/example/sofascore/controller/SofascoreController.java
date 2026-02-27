package com.example.sofascore.controller;

import com.example.sofascore.service.SofascoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sofascore")
public class SofascoreController {

    private final SofascoreService sofascoreService;

    public SofascoreController(SofascoreService sofascoreService) {
        this.sofascoreService = sofascoreService;
    }

    @GetMapping("/scheduled/{sport}/{date}")
    public Mono<ResponseEntity<String>> getScheduledEvents(
            @PathVariable String sport,
            @PathVariable String date) {
        return sofascoreService.getScheduledEvents(sport, date);
    }

    @GetMapping("/live/{sport}")
    public Mono<ResponseEntity<String>> getLiveEvents(@PathVariable String sport) {
        return sofascoreService.getLiveEvents(sport);
    }

    @GetMapping("/match/{matchId}")
    public Mono<ResponseEntity<String>> getMatchById(@PathVariable Long matchId) {
        return sofascoreService.getMatchById(matchId);
    }

    @GetMapping("/match/{matchId}/statistics")
    public Mono<ResponseEntity<String>> getMatchStatistics(@PathVariable Long matchId) {
        return sofascoreService.getMatchStatistics(matchId);
    }

    @GetMapping("/match/{matchId}/incidents")
    public Mono<ResponseEntity<String>> getMatchIncidents(@PathVariable Long matchId) {
        return sofascoreService.getMatchIncidents(matchId);
    }

    @GetMapping("/match/{matchId}/h2h")
    public Mono<ResponseEntity<String>> getHeadToHead(@PathVariable Long matchId) {
        return sofascoreService.getHeadToHead(matchId);
    }

    @GetMapping("/match/{matchId}/lineups")
    public Mono<ResponseEntity<String>> getLineups(@PathVariable Long matchId) {
        return sofascoreService.getLineups(matchId);
    }

    @GetMapping("/team/{teamId}/performance")
    public Mono<ResponseEntity<String>> getTeamPerformance(@PathVariable Long teamId) {
        return sofascoreService.getTeamPerformance(teamId);
    }

    @GetMapping("/match/{matchId}/odds")
    public Mono<ResponseEntity<String>> getMatchOdds(@PathVariable Long matchId) {
        return sofascoreService.getMatchOdds(matchId);
    }

    @GetMapping("/match/{matchId}/details")
    public Mono<ResponseEntity<String>> getMatchDetails(@PathVariable Long matchId) {
        return sofascoreService.getMatchDetails(matchId);
    }

    @GetMapping("/match/{matchId}/player-stats")
    public Mono<ResponseEntity<String>> getMatchPlayerStats(@PathVariable Long matchId) {
        return sofascoreService.getMatchPlayerStats(matchId);
    }

    @GetMapping("/player/{playerId}")
    public Mono<ResponseEntity<String>> getPlayerDetails(@PathVariable Long playerId) {
        return sofascoreService.getPlayerDetails(playerId);
    }

    @GetMapping("/player/{playerId}/transfers")
    public Mono<ResponseEntity<String>> getPlayerTransferHistory(@PathVariable Long playerId) {
        return sofascoreService.getPlayerTransferHistory(playerId);
    }

    @GetMapping("/match/{matchId}/pregame-form")
    public Mono<ResponseEntity<String>> getPregameForm(@PathVariable Long matchId) {
        return sofascoreService.getPregameForm(matchId);
    }

    @GetMapping("/categories/{sport}")
    public Mono<ResponseEntity<String>> getCategories(@PathVariable String sport) {
        return sofascoreService.getCategories(sport);
    }

    @GetMapping("/team/{teamId}/players")
    public Mono<ResponseEntity<String>> getTeamPlayers(@PathVariable Long teamId) {
        return sofascoreService.getTeamPlayers(teamId);
    }

    @GetMapping("/team/{teamId}")
    public Mono<ResponseEntity<String>> getTeamDetails(@PathVariable Long teamId) {
        return sofascoreService.getTeamDetails(teamId);
    }

    @GetMapping("/team/{teamId}/lastnext")
    public Mono<ResponseEntity<String>> getTeamLastNext(@PathVariable Long teamId) {
        return sofascoreService.getTeamLastNext(teamId);
    }

    @GetMapping("/manager/{managerId}")
    public Mono<ResponseEntity<String>> getManagerDetails(@PathVariable Long managerId) {
        return sofascoreService.getManagerDetails(managerId);
    }

    @GetMapping("/category/{categoryId}/tournaments")
    public Mono<ResponseEntity<String>> getCategoryUniqueTournaments(
            @PathVariable Long categoryId) {
        return sofascoreService.getCategoryUniqueTournaments(categoryId);
    }

    @GetMapping("/tournament/{tournamentId}/seasons")
    public Mono<ResponseEntity<String>> getTournamentSeasons(
            @PathVariable Long tournamentId) {
        return sofascoreService.getTournamentSeasons(tournamentId);
    }

    @GetMapping("/tournament/{tournamentId}/season/{seasonId}/top-players")
    public Mono<ResponseEntity<String>> getTournamentTopPlayers(
            @PathVariable Long tournamentId,
            @PathVariable Long seasonId) {
        return sofascoreService.getTournamentTopPlayers(tournamentId, seasonId);
    }

    @GetMapping("/tournament/{tournamentId}/season/{seasonId}/standings")
    public Mono<ResponseEntity<String>> getTournamentStandings(
            @PathVariable Long tournamentId,
            @PathVariable Long seasonId) {
        return sofascoreService.getTournamentStandings(tournamentId, seasonId);
    }

    @GetMapping("/tournament/{tournamentId}/season/{seasonId}/events")
    public Mono<ResponseEntity<String>> getTournamentEvents(
            @PathVariable Long tournamentId,
            @PathVariable Long seasonId) {
        return sofascoreService.getTournamentEvents(tournamentId, seasonId);
    }
}