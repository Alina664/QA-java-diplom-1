package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest{
    Database database = new Database();

    @Test
    public void checkBunSizeIsGreaterThanZero() {
        Assert.assertNotEquals("Проверяем, что количество булок больше 0", 0,database.availableBuns().size());
    }

    @Test
    public void checkIngredientsSizeIsGreaterThanZero() {
        Assert.assertNotEquals("Проверяем, что количество ингредиентов больше 0", 0,database.availableIngredients().size());
    }
}
