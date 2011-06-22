import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	static List<StoreKeepingItem> items = null;
	
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = createTestSetOfItems();

        doDailyInventoryUpdateOnAllItems(items);
	}

	static List<StoreKeepingItem> createTestSetOfItems() {
		List<StoreKeepingItem> items = new ArrayList<StoreKeepingItem>();
        items.add(ItemFactory.create(ItemFactory.DEXTERITY_VEST, 10, 20));
        items.add(ItemFactory.create(ItemFactory.AGED_BRIE, 2, 0));
        items.add(ItemFactory.create(ItemFactory.ELIXIR, 5, 7));
        items.add(ItemFactory.create(ItemFactory.SULFURAS, 0, 80));
        items.add(ItemFactory.create(ItemFactory.BACKSTAGE_PASSES, 15, 20));
        items.add(ItemFactory.create(ItemFactory.MANA_CAKE, 3, 6));
        
        return items;
	}
	
    public static void doDailyInventoryUpdateOnAllItems(List<StoreKeepingItem> items)
    {
    	for (StoreKeepingItem item : items) {
			item.doDailyInventoryUpdate();
        }
    }
}