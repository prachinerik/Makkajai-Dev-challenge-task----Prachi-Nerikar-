package test;

import main.Item;
import main.ItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemFactoryTest {
    String line;
    Item expectedItem;

    ItemFactory itemFactory = new ItemFactory();

    @Before
    public void  populateStringAndItem()   {
        line = "1 imported box of chocolates at 10.00";
        expectedItem = new Item(1,"imported box of chocolates", 10.00F, false,true);
    }
    @Test
    public void generateItemTestQuantity() {
        Item actualItem = ItemFactory.generateItem(line);
        Assert.assertEquals(actualItem.getQuantity(), expectedItem.getQuantity());
    }

    @Test
    public void generateItemTestName() {
        Item actualItem = ItemFactory.generateItem(line);
        Assert.assertEquals(actualItem.getName(), expectedItem.getName());
    }

    @Test
    public void generateItemTestPrice() {
        Item actualItem = ItemFactory.generateItem(line);
        Assert.assertEquals(actualItem.getPrice(), expectedItem.getPrice(), 0.05);
    }

    @Test
    public void generateItemTestIfSalesTaxIsApplicable() {
        Item actualItem = ItemFactory.generateItem(line);
        Assert.assertEquals(actualItem.isSalesTaxApplicable(), expectedItem.isSalesTaxApplicable());
    }

    @Test
    public void generateItemTestIsItemImported() {
        Item actualItem = ItemFactory.generateItem(line);
        Assert.assertEquals(actualItem.isImportDutyApplicable(), expectedItem.isImportDutyApplicable());
    }
}
