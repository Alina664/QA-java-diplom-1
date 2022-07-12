package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {


    //разные типы ингредиентов
    //наименование ингредиента пустое, null, либо наименование заполнено
    //цена отрицательная, положительная, нулевая
    private final String nameFilling = "Котлета";
    private final float price = 100;
    private final IngredientType typeFilling = IngredientType.FILLING;
    private final IngredientType typeSauce = IngredientType.SAUCE;

    private final Ingredient ingredientFilling = new Ingredient(typeFilling, nameFilling, price);
    private final Ingredient ingredientSauce = new Ingredient(typeSauce, "Кетчуп", 99);

    @Test
    public void checkPriceIngredient() {
        Assert.assertEquals("Сравниваем полученную и объявленную цену",price, ingredientFilling.getPrice(),0f);
    }

    @Test
    public void checkNameIngredient() {
        Assert.assertEquals("Сравниваем наименование ингредиентов",nameFilling, ingredientFilling.getName());
    }

    @Test
    public void checkTypeIngredientFilling() {
        Assert.assertEquals("Сравниваем тип ингредиента: Начинка", typeFilling, ingredientFilling.getType());
    }

    @Test
    public void checkTypeIngredientSauce() {
        Assert.assertEquals("Сравниваем тип ингредиента: Соус", typeSauce, ingredientSauce.getType());
    }

}
