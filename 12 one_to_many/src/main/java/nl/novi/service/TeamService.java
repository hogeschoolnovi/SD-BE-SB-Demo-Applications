package nl.novi.service;

import nl.novi.exception.RecordNotFoundException;
import nl.novi.model.Speler;
import nl.novi.model.Team;
import nl.novi.repository.SpelerRepository;
import nl.novi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final SpelerRepository spelerRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, SpelerRepository spelerRepository) {
        this.teamRepository = teamRepository;
        this.spelerRepository = spelerRepository;
    }

    public Iterable<Team> findAll() {
        Iterable<Team> teams = teamRepository.findAll();
        return teams;
    }

    public Team findById(long nr) {
        Optional<Team> team = teamRepository.findById(nr);
        if (team.isPresent()) {
            return team.get();
        }
        else {
            throw new RecordNotFoundException("Team with id " + nr + " not found");
        }
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

    public void deleteById(long nr) {
        try {
            teamRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

    public Iterable<Speler> getTeamSpelers(long nr) {
        Optional<Team> team = teamRepository.findById(nr);
        if (team.isPresent()) {
            return team.get().getSpelers();
        }
        else {
            throw new RecordNotFoundException("Team with id " + nr + " not found");
        }
    }

}
