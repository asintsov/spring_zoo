package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    private final Animal dog;
    private final Animal cat;
    private final Animal fish;
    private final Animal snake;
    private final String name;
    private final List<Animal> animals;

    @Autowired
    public Zoo(
            Animal dog,
            Animal cat,
            Animal fish,
            Animal snake,
            @Value("${zoo.name}") String name,
            List<Animal> animals
    ) {
        this.dog = dog;
        this.cat = cat;
        this.fish = fish;
        this.snake = snake;
        this.name = name;
        this.animals = animals;
    }

    public Animal getDog() {
        return dog;
    }

    public Animal getCat() {
        return cat;
    }

    public Animal getFish() { return fish; }

    public Animal getSnake() { return snake;}

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

}
