import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void testAllItemsProcessed() {
		List<StoreKeepingItem> items = GildedRose.createTestSetOfItems();
		List<StoreKeepingItem> itemsComparison = GildedRose.createTestSetOfItems();
		GildedRose.doDailyInventoryUpdateOnAllItems(items);
		for (int i = 0; i < items.size(); i++) {
			if (!isImmutableItem(items.get(i))) {
				assertTrue(itemSellInDateDecreasedByOne(itemsComparison.get(i), items.get(i)));
			}
		}
	}

	private boolean itemSellInDateDecreasedByOne(StoreKeepingItem comparison, StoreKeepingItem processed) {
		return comparison.getSellIn() - 1 == processed.getSellIn();
	}
	private boolean isImmutableItem(StoreKeepingItem item) {
		return item instanceof ImmutableItem;
	}
}
