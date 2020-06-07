package test.dto;

import java.time.LocalDateTime;

public class Food {
    private FoodType foodType;
    private LocalDateTime expirationDate;

    public FoodType getFoodType() {
        return foodType;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
