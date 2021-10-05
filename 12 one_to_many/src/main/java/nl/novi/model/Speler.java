package nl.novi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

@Entity
@Table(name = "spelers")
public class Speler {

    // attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rugnummer;
    private String naam;
    private String positie;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    @JsonManagedReference
    private Team team;

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRugnummer() {
        return rugnummer;
    }

    public void setRugnummer(int rugnummer) {
        this.rugnummer = rugnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPositie() {
        return positie;
    }

    public void setPositie(String positie) {
        this.positie = positie;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
