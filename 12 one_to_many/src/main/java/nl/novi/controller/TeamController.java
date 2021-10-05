package nl.novi.controller;

import nl.novi.model.Speler;
import nl.novi.service.TeamService;
import nl.novi.model.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(value = "/teams")
    public ResponseEntity getTeams() {
        Iterable<Team> teams;
        teams = teamService.findAll();
        return ResponseEntity.ok(teams);
    }

    @GetMapping(value = "/teams/{nr}")
    public ResponseEntity getTeam(@PathVariable long nr) {
        Team team = teamService.findById(nr);
        return ResponseEntity.ok(team);
    }

    @PostMapping(value = "/teams")
    public ResponseEntity addTeam(@RequestBody Team team) {
        teamService.save(team);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/teams/{nr}")
    public ResponseEntity deleteTeam(@PathVariable long nr) {
        teamService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/teams/{nr}")
    public ResponseEntity updateTeam(@PathVariable long nr, @RequestBody Team team) {
        return ResponseEntity.ok("Aangepast");
    }

    @GetMapping(value = "/teams/{nr}/spelers")
    public ResponseEntity getTeamSpelers(@PathVariable long nr) {
        Iterable<Speler> teamSpelers = teamService.getTeamSpelers(nr);
        return ResponseEntity.ok(teamSpelers);
    }

}
