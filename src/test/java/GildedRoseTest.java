import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private List<Item> items;

    @Before
    public void setup() {
        items = new ArrayList<Item>();
    }

    @Test
    public void shouldDegradeConjureedItemsByTwo() {
        items.add(new Item("Conjured Mana Cake", 3, 6));

        GildedRose.updateQuality(items);

        assertEquals(4, items.get(0).getQuality());
    }

    @Test
    public void shouldDecreaseQualityByTwoIfPastSellinDate() {
        items.add(new Item("Elixir of the Mongoose", 0, 6));

        GildedRose.updateQuality(items);

        assertEquals(4, items.get(0).getQuality());
    }

    @Test
    public void shouldNotIncreaseQualityOverFifty() {
        items.add(new Item("Aged Brie", 1, 50));

        GildedRose.updateQuality(items);

        assertEquals(50, items.get(0).getQuality());
    }

    @Test
    public void shouldIncreaseValueOfTicketsByTwoWhenLessThanTenSellinDays() {
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10));

        GildedRose.updateQuality(items);

        assertEquals(12, items.get(0).getQuality());
    }

    @Test
    public void shouldIncreaseValueOfTicketsByThreeWhenLessThanFiveSellinDays() {
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10));

        GildedRose.updateQuality(items);

        assertEquals(13, items.get(0).getQuality());
    }

    @Test
    public void shouldRemoveValueOfTicketsWhenPastSellinDate() {
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10));

        GildedRose.updateQuality(items);

        assertEquals(0, items.get(0).getQuality());
    }

    @Test
    public void shouldUpdateBrieQualityInversely() {
        items.add(new Item("Aged Brie", 2, 0));

        GildedRose.updateQuality(items);

        assertEquals("Quality: ", 1, items.get(0).getQuality());
    }

    @Test
    public void shouldUpdateBrieSellinNormally() {
        items.add(new Item("Aged Brie", 2, 0));

        GildedRose.updateQuality(items);

        assertEquals("Sellin", 1, items.get(0).getSellIn());
    }

    @Test
    public void shouldUpdateBrieQualityByTwo() {
        items.add(new Item("Aged Brie", 0, 0));

        GildedRose.updateQuality(items);

        assertEquals("Sellin", 2, items.get(0).getQuality());
    }

    @Test
    public void shouldNotUpdateLegendaryItems() {
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

        GildedRose.updateQuality(items);

        assertEquals("Quality", 80, items.get(0).getQuality());
        assertEquals("Sellin", 0, items.get(0).getSellIn());
    }

}
