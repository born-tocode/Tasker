package pl.borntocode.crud;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Game {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int minNumbOfPlayers;
    private int minAgeOfPlayer;

}
