package praktikum;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BunTest{

    private final String name = "Краторная булка";
    private final float price = 100;

    private final Bun bun = new Bun(name, price);

    @Test
    public void getNameBun() {
        Assert.assertEquals("Сравниваем наименование булок",name, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("Сравниваем полученную и объявленную цену",price, bun.getPrice(),0f);
    }
}