import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
    }

    public static void updateQuality(List<Item> items) {
        for (Item item : items) {
            updateSellin(item);
            if (isAgedBrie(item) || isConcertTicket(item)) {
                if (isLessThenMaxQuality(item)) {
                    appreciateBrie(item);
                    appricateConcertTickets(item);
                }
            } else {
                depreciate(item);
                depreciatePastSellin(item);
                if (isConjured(item)) {
                    depreciate(item);
                }
            }
        }
    }

    private static void depreciatePastSellin(Item item) {
        if (item.getSellIn() < 0) {
            depreciate(item);
        }
    }

    private static boolean isConjured(Item item) {
        return "Conjured Mana Cake".equals(item.getName());
    }

    private static void appreciateBrie(Item item) {
        if (isAgedBrie(item)) {
            appreciate(item);
            if (item.getSellIn() < 0) {
                appreciate(item);
            }
        }
    }

    private static void updateSellin(Item item) {
        if (!isLegendaryItem(item)) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private static void appricateConcertTickets(Item item) {
        if (isConcertTicket(item)) {
            appreciate(item);
            if (item.getSellIn() >= 0 && item.getSellIn() <= 10) {
                appreciate(item);
                if (item.getSellIn() <= 5) {
                    appreciate(item);
                }
            } else {
                item.setQuality(item.getQuality() - item.getQuality());
            }
        }
    }

    private static boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.getName());
    }

    private static boolean isConcertTicket(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

    private static void appreciate(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    private static boolean isLessThenMaxQuality(Item item) {
        return item.getQuality() < 50;
    }

    private static void depreciate(Item item) {
        if (item.getQuality() > 0 && !isLegendaryItem(item)) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private static boolean isLegendaryItem(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.getName());
    }
}