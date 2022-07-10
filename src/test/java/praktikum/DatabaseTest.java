package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest{
    Database database = new Database();

    @Test
    public void availableBunsSize() {
        Assert.assertNotEquals("проверяемя, что количество булок больше 0", 0,database.availableBuns().size());
    }

    @Test
    public void availableIngredients() {
        Assert.assertNotEquals("проверяемя, что количество ингредиентов больше 0", 0,database.availableIngredients().size());
    }
}
