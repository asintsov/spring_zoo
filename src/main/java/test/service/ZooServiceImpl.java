package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;

    @Autowired
    public ZooServiceImpl(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public List<Animal> feed(Food food, List<Animal> feedAnimals) {
        List<Animal> angryAnimals = new ArrayList<>();
        for (Animal animal : feedAnimals) {
            animal.eat(food);
            if (animal.isAngry()) {
                angryAnimals.add(animal);
            }
        }
        System.out.println(angryAnimals);
        return angryAnimals;
    }

    public Zoo getZoo(){return this.zoo; }
}
