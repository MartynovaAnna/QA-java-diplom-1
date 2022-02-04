package praktikum;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {

    @Test
    public void shouldHasSauce() {
        assertThat(IngredientType.valueOf("SAUCE"), CoreMatchers.is(notNullValue()));
    }

    @Test
    public void shouldHasFilling() {
        assertThat(IngredientType.valueOf("FILLING"), CoreMatchers.is(notNullValue()));
    }
 }