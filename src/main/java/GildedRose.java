import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            changeQuality(i);
            changeSellIn(i);
        }
    }

    private static void changeSellIn(int i) {
        reduceNonLegendaryItemSellIn(i);
        if (hasSellInExpired(i) && isNotAgedBrie(i)) {
            computeExpiredItemQuality(i);
        } else {
            increaseValueOfBrie(i);
        }
    }

    private static boolean hasSellInExpired(int i) {
        return items.get(i).getSellIn() < 0;
    }

    private static void increaseValueOfBrie(int i) {
        if (isLessThenMaxQuality(i)) {
            increaseQuality(i);
        }
    }

    private static void computeExpiredItemQuality(int i) {
        if (isBackstageTickets(i)) {
            setItemQualityToZero(i);
        } else {
            devalueStandardItem(i);
        }
    }

    private static void changeQuality(int i) {
        if (isNotAgedBrie(i) && !isBackstageTickets(i)) {
            devalueStandardItem(i);
        } else {
            if (isLessThenMaxQuality(i)) {
                increaseQuality(i);
                if (isBackstageTickets(i)) {
                    increaseTimelyItemsQuality(i);
                }
            }
        }
    }

    private static void increaseTimelyItemsQuality(int i) {
        if (items.get(i).getSellIn() < 11) {
            increaseQuality(i);
        }
        if (items.get(i).getSellIn() < 6) {
            increaseQuality(i);
        }
    }

    private static void reduceNonLegendaryItemSellIn(int i) {
        if (notLegendaryItem(i)) {
            reduceSellIn(i);
        }
    }

    private static void devalueStandardItem(int i) {
        if (isQualityGreaterThanMin(i) && notLegendaryItem(i)) {
            reduceQuality(i);
        }
    }

    private static void setItemQualityToZero(int i) {
        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
    }

    private static boolean isNotAgedBrie(int i) {
        return !"Aged Brie".equals(items.get(i).getName());
    }

    private static boolean isBackstageTickets(int i) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName());
    }

    private static boolean notLegendaryItem(int i) {
        return !"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName());
    }

    private static boolean isLessThenMaxQuality(int i) {
        return items.get(i).getQuality() < 50;
    }

    private static boolean isQualityGreaterThanMin(int i) {
        return items.get(i).getQuality() > 0;
    }

    private static void increaseQuality(int i) {
        items.get(i).setQuality(items.get(i).getQuality() + 1);
    }

    private static void reduceQuality(int i) {
        items.get(i).setQuality(items.get(i).getQuality() - 1);
    }

    private static void reduceSellIn(int i) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
    }
}