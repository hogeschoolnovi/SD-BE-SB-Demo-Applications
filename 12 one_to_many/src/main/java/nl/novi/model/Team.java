package nl.novi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "teams")
public class Team {

    // attributen

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;
    private String land;
    private int jaar;

    @OneToMany(mappedBy = "team",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Speler> spelers;

    // getters and setters

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    // methoden
    void addSpeler(Speler speler) {
        this.spelers.add(speler);
    }

}
