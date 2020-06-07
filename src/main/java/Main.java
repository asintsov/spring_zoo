import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.Animal;
import test.configuration.AnnotationConfiguration;
import test.dto.Food;
import test.dto.FoodType;
import test.service.ZooService;

import java.time.LocalDateTime;
import java.util.List;

public class  Main {

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        Food food = new Food();
        List <Animal> feedAnimals = service.getZoo().getAnimals();
        for (FoodType ft: FoodType.values()) {
            food.setFoodType(ft);
            food.setExpirationDate(LocalDateTime.now().plusHours(6));
            feedAnimals = service.feed(food, feedAnimals);
            if (feedAnimals.isEmpty()) {
                break;
            }
        }
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
