package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;


    @Test
    public void shouldAddIngredients() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Ингредиент не добавляется", 1, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredients() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        Assert.assertEquals("Ингредиент не удаляется", 1, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredients() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не заменяется", 2, burger.ingredients.size());
    }

    @Test
    public void getBurgerPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float price = 2;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        float expectedPrice = 6;
        float actualPrice = burger.getPrice();
        Assert.assertEquals("Цена рассчитана неправильно", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getBurgerReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float price = 2;
        Mockito.when(bun.getName()).thenReturn("краторная булка");
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        String expectedReceipt = "(==== краторная булка ====)\r\n= sauce sauce =\r\n(==== краторная булка ====)\r\n\r\nPrice: 6,000000\r\n";
        String actualReceipt = burger.getReceipt();
        assertThat("Чек сгенерирован неправильно", expectedReceipt, equalTo(actualReceipt));
    }
}
