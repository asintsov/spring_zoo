package test;

import org.springframework.stereotype.Component;
import test.Animal;
import test.dto.Food;
import test.dto.FoodType;

import java.util.ArrayList;
import java.util.List;

@Component
public class Snake implements Animal {
    private boolean angry = true;

    @Override
    public void voice() {
        System.out.println("Shshsh");
    }

    @Override
    public boolean eat(Food food) {
        angry = false;
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes(){
        List<FoodType> possibleFeedTypes = new ArrayList<>();
        possibleFeedTypes.add(FoodType.FISH);
        return possibleFeedTypes;
    }
}
