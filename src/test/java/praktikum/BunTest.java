package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String expectedName;
    private float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getBunData() {
        return new Object[][] {
                { "Краторная булка", 1500},
                { "12345", 12},
                {"test", 25},
                {"@#@@#@", 0},
                {"", 10}
        };
    }

    @Test
    public void shouldHasName() {
        Bun bun = new Bun(expectedName, expectedPrice);
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldHasPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
