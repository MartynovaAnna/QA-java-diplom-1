package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    IngredientType type;
    String expectedName = "Соус традиционный галактический";
    float expectedPrice = 15;

    @Test
    public void shouldHasName() {
        Ingredient ingredient = new Ingredient(type, expectedName, expectedPrice);
        String actualName = ingredient.getName();
        assertEquals("Название ингредиента не возвращается", expectedName, actualName);
    }

    @Test
    public void shouldHasPrice() {
        Ingredient ingredient = new Ingredient(type, expectedName, expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена ингредиента не возвращается", expectedPrice, actualPrice, 0);
    }

    @Test
    public void shouldHasType() {
        Ingredient ingredient = new Ingredient(type, expectedName, expectedPrice);
        IngredientType actualType = ingredient.getType();
        assertEquals("Тип ингредиента не возвращается", type, actualType);
    }
}
