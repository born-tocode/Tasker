package pl.borntocode.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    private final GameRepository gameRepository;

    public CrudController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value = "/allgames", produces = "application/json")
    public List<Game> retrieveAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping(value = "/game/{id}", produces = "application/json")
    public Optional<Game> getOneById(@PathVariable long id){
        return gameRepository.findById(id);
    }

}
