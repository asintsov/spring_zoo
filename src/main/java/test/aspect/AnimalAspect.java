package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import test.Animal;
import test.dto.Food;
import test.dto.FoodType;
import test.exceptions.AngryAnimalException;

import java.time.LocalDateTime;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* test.Animal.eat(..))")
    public void eatPoint() {
    }

    @Around(value = "eatPoint() && args(food)")
    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food)  {
        String target = proceedingJoinPoint.getTarget().getClass().toString();
        if (LocalDateTime.now().isAfter(food.getExpirationDate())){
            return false;
        }
        try{
            System.out.println(target + " start eat");
            Object object = proceedingJoinPoint.getTarget();
            Animal animal;
            if (object instanceof Animal) {
                animal = (Animal) object;
            }
            else{
                return false;
            }
            boolean rightFood = false;
            for (FoodType foodType:animal.getPossibleFeedTypes()) {
                if (foodType.equals(food.getFoodType())){
                    rightFood = true;
                    break;
                }
            }
            if (rightFood == false){
                throw new AngryAnimalException();
            }

            Object result = proceedingJoinPoint.proceed();
            System.out.println(target + " eat success");
            System.out.println(target + " end eat");
            return result;
        } catch (AngryAnimalException aaex){
            System.out.println(target + " eat failed: "+aaex.getMessage());
            return false;
        }
        catch (Throwable e) {
            System.out.println(target + " eat failed");
            return false;
        }
    }
}
