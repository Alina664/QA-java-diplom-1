package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredientCopy;

    private final Burger burger = new Burger();
    private final String bunName = "white bun";
    private final float bunPrice = 200;
    private final String ingredientName = "cutlet";
    private final float ingredientPrice = 400;
    private final IngredientType ingredientType = IngredientType.FILLING;

    private final String receipt = String.format("(==== %s ====)%n"
            + "= %s %s =%n"
            + "(==== %s ====)%n"
            +"%n"
    +"Price: %f%n",bunName,ingredientType.toString().toLowerCase(),ingredientName,bunName,ingredientPrice + bunPrice*2);

    @Test
    public void setBuns() {
        Bun bun = new Bun(bunName, bunPrice);
        burger.setBuns(bun);
        Assert.assertNotNull("Проверяем, что булка добавлена в бургер",burger.bun.getName());
    }

    @Test
    public void addIngredient() {
        int firstSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Проверяем, что количество ингредиентов увеличилось",firstSize + 1,burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int firstSize = burger.ingredients.size();
        burger.removeIngredient(1);
        Assert.assertEquals("Проверяем, что количество ингредиентов уменьшилось",firstSize -1,burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientCopy);
        burger.moveIngredient(1,0);
        Assert.assertEquals("Проверяем, что теперь второй ингридиент - первый", ingredientCopy, burger.ingredients.get(0));
    }

    @Test
    public void getBunPrice() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Assert.assertEquals("Проверяем, что цена булки посчитана верно",bunPrice*2, burger.getPrice(), 0f);
    }


    @Test
    public void getBunAndIngredientPrice() {
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Assert.assertEquals("Проверяем, что цена ингредиентов и булки посчитана верно",ingredientPrice + bunPrice*2, burger.getPrice(), 0f);
    }

    @Test
    public void getReceipt() {
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Assert.assertEquals("Проверяем, что рецепт и его цена записаны верно",receipt, burger.getReceipt());

    }
}