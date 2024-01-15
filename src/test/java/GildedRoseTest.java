import org.example.GildedRose;
import org.example.Item;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

    @Test
    void testBrieOneDayPasses(){
        Item item1 = new Item("Aged Brie", 2, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 9;
        assert items[0].sellIn == 1;
    }

    @Test
    void testBrieExpired(){
        Item item1 = new Item("Aged Brie", -1, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 10;
        assert items[0].sellIn == -2;
    }

    @Test
    void testBrieMaxQuality(){
        Item item1 = new Item("Aged Brie", 2, 50);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 50;
        assert items[0].sellIn == 1;
    }

    @Test
    void testBackstagePassesTenOrLessDays(){
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 10;
        assert items[0].sellIn == 9;
    }

    @Test
    void testBackstagePassesFiveOrLessDays(){
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 11;
        assert items[0].sellIn == 4;
    }

    @Test
    void testBackstagePassesExpired(){
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 0;
        assert items[0].sellIn == -2;
    }

    @Test
    void testBackstagePassesMaxQuality(){
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 50;
        assert items[0].sellIn == 4;
    }

    @Test
    void testBackstagePassesMoreThan10Days(){
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 9;
        assert items[0].sellIn == 10;
    }

    @Test
    void testSulfuras(){
        Item item1 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item item2 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item[] items = new Item[] { item1, item2 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 80;
        assert items[0].sellIn == 0;
        assert items[1].quality == 80;
        assert items[1].sellIn == -1;
    }

    @Test
    void testConjuredOneDayPasses(){
        Item item1 = new Item("Conjured Mana Cake", 2, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 6;
        assert items[0].sellIn == 1;
    }

    @Test
    void testConjuredExpired(){
        Item item1 = new Item("Conjured Mana Cake", -1, 8);
        Item[] items = new Item[] { item1 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 4;
        assert items[0].sellIn == -2;
    }

    @Test
    void testOtherOneDayPasses(){
        Item item1 = new Item("Other", 2, 8);
        Item item2 = new Item("Other", 2, 0);
        Item item3 = new Item("Other", 2, 1);
        Item item4 = new Item("Other", 2, 50);

        Item[] items = new Item[] { item1, item2, item3, item4 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 7;
        assert items[0].sellIn == 1;
        assert items[1].quality == 0;
        assert items[1].sellIn == 1;
        assert items[2].quality == 0;
        assert items[2].sellIn == 1;
        assert items[3].quality == 49;
        assert items[3].sellIn == 1;
    }

    @Test
    void testOtherOneDayPassesExpired(){
        Item item1 = new Item("Other", -1, 8);
        Item item2 = new Item("Other", -1, 0);
        Item item3 = new Item("Other", -1, 1);
        Item item4 = new Item("Other", -1, 50);

        Item[] items = new Item[] { item1, item2, item3, item4 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 6;
        assert items[0].sellIn == -2;
        assert items[1].quality == 0;
        assert items[1].sellIn == -2;
        assert items[2].quality == 0;
        assert items[2].sellIn == -2;
        assert items[3].quality == 48;
        assert items[3].sellIn == -2;
    }

    @Test
    void mixedItemsTest() {
        Item item1 = new Item("Aged Brie", 2, 8);
        Item item2 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item item3 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item item4 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item item5 = new Item("Conjured Mana Cake", 2, 8);
        Item item6 = new Item("Conjured Mana Cake", -1, 8);
        Item item7 = new Item("Other", 2, 8);
        Item item8 = new Item("Other", -1, 8);

        Item[] items = new Item[] { item1, item2, item3, item4, item5, item6, item7, item8 };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assert items[0].quality == 9;
        assert items[0].sellIn == 1;
        assert items[1].quality == 21;
        assert items[1].sellIn == 14;
        assert items[2].quality == 80;
        assert items[2].sellIn == 0;
        assert items[3].quality == 80;
        assert items[3].sellIn == -1;
        assert items[4].quality == 6;
        assert items[4].sellIn == 1;
        assert items[5].quality == 4;
        assert items[5].sellIn == -2;
        assert items[6].quality == 7;
        assert items[6].sellIn == 1;
        assert items[7].quality == 6;
        assert items[7].sellIn == -2;
    }

}
