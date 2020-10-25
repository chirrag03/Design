package coffeeMachine;

import java.util.List;
import java.util.Objects;

public class CoffeeMaker {

    Recipe recipe;
    IngredientStorage ingredientStorage;

    public CoffeeMaker() {
        this.recipe = new Recipe();
        this.ingredientStorage = new IngredientStorage(5, 10, 10,
                10, 10);
    }

    public boolean makeBeverage(Beverage beverage) {

        List<IngredientAmount> ingredients = recipe.getRecipe(beverage);

        if (Objects.isNull(ingredients)) {
            System.out.println("Error!! Unknown Beverage!!");
            return false;
        }

        if (!ingredientStorage.getIngredients(ingredients)) {
            System.out.println("Error!! Out of ingredients!! Could not prepare " + beverage.toString());
            return false;
        }

        System.out.println("Dispensing " + beverage.toString());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void addIngredient(Ingredient ingredient, int unit) {
        System.out.println(String.format("Refilling Ingredient %s by %s units", ingredient.toString(), unit));
        ingredientStorage.addIngredient(new IngredientAmount(ingredient, unit));
    }
}
