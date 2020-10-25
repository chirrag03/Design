package coffeeMachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe {

    Map<Beverage, List<IngredientAmount>> beverageRecipe;

    public Recipe() {

        beverageRecipe = new HashMap<>();

        beverageRecipe.put(Beverage.AMERICANO,
                Arrays.asList(new IngredientAmount(Ingredient.GROUND_COFFEE_BEANS, 1),
                        new IngredientAmount(Ingredient.HOT_WATER, 2)));

        beverageRecipe.put(Beverage.BLACK,
                Arrays.asList(new IngredientAmount(Ingredient.GROUND_COFFEE_BEANS, 2),
                        new IngredientAmount(Ingredient.HOT_WATER, 1)));

        beverageRecipe.put(Beverage.CAPPUCCINO,
                Arrays.asList(new IngredientAmount(Ingredient.GROUND_COFFEE_BEANS, 1),
                        new IngredientAmount(Ingredient.HOT_WATER, 1),
                        new IngredientAmount(Ingredient.STEAMED_MILK, 2),
                        new IngredientAmount(Ingredient.WHIPPED_CREAM, 2),
                        new IngredientAmount(Ingredient.CHOCOLATE_POWDER, 1)));

        beverageRecipe.put(Beverage.LATTE,
                Arrays.asList(new IngredientAmount(Ingredient.GROUND_COFFEE_BEANS, 1),
                        new IngredientAmount(Ingredient.HOT_WATER, 1),
                        new IngredientAmount(Ingredient.STEAMED_MILK, 4),
                        new IngredientAmount(Ingredient.WHIPPED_CREAM, 1)));

        beverageRecipe.put(Beverage.MOCHA,
                Arrays.asList(new IngredientAmount(Ingredient.GROUND_COFFEE_BEANS, 2),
                        new IngredientAmount(Ingredient.HOT_WATER, 1),
                        new IngredientAmount(Ingredient.STEAMED_MILK, 1),
                        new IngredientAmount(Ingredient.WHIPPED_CREAM, 2),
                        new IngredientAmount(Ingredient.CHOCOLATE_POWDER, 1)));
    }


    public List<IngredientAmount> getRecipe(Beverage beverage) {
        if (beverageRecipe.containsKey(beverage)) {
            return beverageRecipe.get(beverage).stream().collect(Collectors.toList());
        }
        return null;
    }

    public void updateOrAddRecipe(Beverage beverage, List<IngredientAmount> ingredientAmounts) {
        if (beverageRecipe.containsKey(beverage)) {
            beverageRecipe.put(beverage, ingredientAmounts);
            System.out.println("Beverage Recipe for " + beverage.toString() + " updated.");
        } else {
            beverageRecipe.put(beverage, ingredientAmounts);
            System.out.println("Beverage Recipe for " + beverage.toString() + " added.");
        }
    }
}
