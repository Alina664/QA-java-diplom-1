package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest{

    private final String name = "Краторная булка";
    private final float price = 100;

    private final Bun bun = new Bun(name, price);

    @Test
    public void checkNameBun() {
        Assert.assertEquals("Сравниваем наименование булок",name, bun.getName());
    }

    @Test
    public void checkPrice() {
        Assert.assertEquals("Сравниваем полученную и объявленную цену",price, bun.getPrice(),0f);
    }
}