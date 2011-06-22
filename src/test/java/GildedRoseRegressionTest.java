import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


public class GildedRoseRegressionTest {

	/* Helpers */
	private List<StoreKeepingItem> createListWithItem(StoreKeepingItem itemUnderTest) {
		List<StoreKeepingItem> items = new ArrayList<StoreKeepingItem>();
		items.add(itemUnderTest);
		return items;
	}
	
	/* Test Methods */	
	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Test
	public void testThatSellInValueIsDecreased() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Item under test", 10, 0);
		
		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(9, itemUnderTest.getSellIn());
	}

	@Test
	public void testThatQualityValueIsDecreased() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Item under test", 1, 10);
		
		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(9, itemUnderTest.getQuality());
	}
	
	@Test
	public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Item under test", 0, 10);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(8, itemUnderTest.getQuality());
	}
	
	@Test 
	public void testThatQualityIsNeverNegative() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Item under test", 0, 0);
		
		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(0, itemUnderTest.getQuality());		
	}
	
	@Test
	public void testAgedBrieIncreasesQualityWithAge() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Aged Brie", 5, 1);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(2, itemUnderTest.getQuality());				
	}
	
	@Test
	public void testQualityNeverIncreasesPastFifty() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Aged Brie", 5, 50);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(50, itemUnderTest.getQuality());						
	}

	@Test
	public void testSulfurasNeverChanges() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Sulfuras, Hand of Ragnaros", 0, 25);
		
		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(25, itemUnderTest.getQuality());
		assertEquals(0, itemUnderTest.getSellIn());		
	}

	@Test
	public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 11, 20);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(21, itemUnderTest.getQuality());
	}

	@Test
	public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 6, 20);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(22, itemUnderTest.getQuality());						
	}

	@Test
	public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 5, 20);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(23, itemUnderTest.getQuality());						
	}
	
	@Test
	public void testBackstagePassLosesValueAfterSellByPasses() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 0, 20);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(0, itemUnderTest.getQuality());						
	}
	
	@Test
	public void testConjuredItemsLoseDoubleQualityBeforeSellBy() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Conjured Mana Cake", 5, 20);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(18, itemUnderTest.getQuality());						
	}

	@Test
	public void testConjuredItemsLoseDoubleQualityAfterSellBy() {
		StoreKeepingItem itemUnderTest = ItemFactory.create("Conjured Mana Cake", 0, 20);

		GildedRose.doDailyInventoryUpdateOnAllItems(createListWithItem(itemUnderTest));
		
		assertEquals(16, itemUnderTest.getQuality());						
	}
}
