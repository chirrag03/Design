package coffeeMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredientStorage {

    Map<Ingredient, Integer> availableIngredients;

    public IngredientStorage(int coffeeBeansAmount, int hotWaterAmount, int steamedMilkAmount,
                             int chocolatePowderAmount, int whippedCreamAmount) {
        availableIngredients = new HashMap<>();

        availableIngredients.put(Ingredient.GROUND_COFFEE_BEANS, coffeeBeansAmount);
        availableIngredients.put(Ingredient.HOT_WATER, hotWaterAmount);
        availableIngredients.put(Ingredient.STEAMED_MILK, steamedMilkAmount);
        availableIngredients.put(Ingredient.CHOCOLATE_POWDER, chocolatePowderAmount);
        availableIngredients.put(Ingredient.WHIPPED_CREAM, whippedCreamAmount);
    }

    public synchronized boolean getIngredients(List<IngredientAmount> ingredients) {
        if (ingredientsAvailable(ingredients)) {
            for (IngredientAmount ingredient: ingredients) {
                availableIngredients.put(ingredient.ingredient, availableIngredients.get(ingredient.ingredient) - ingredient.unit);
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean ingredientsAvailable(List<IngredientAmount> ingredients) {
        for (IngredientAmount ingredient: ingredients) {
            if (availableIngredients.get(ingredient.ingredient) < ingredient.unit) {
                return false;
            }
        }
        return true;
    }

    public void addIngredient(IngredientAmount ingredient) {
        availableIngredients.put(ingredient.ingredient,
                availableIngredients.getOrDefault(ingredient.ingredient, 0) + ingredient.unit);
    }

}
