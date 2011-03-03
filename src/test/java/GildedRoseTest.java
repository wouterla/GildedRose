import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest {

	/* Helpers */
	private List<QualityControlItem> createListWithItem(QualityControlItem itemUnderTest) {
		List<QualityControlItem> items = new ArrayList<QualityControlItem>();
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
		QualityControlItem itemUnderTest = ItemFactory.createItem("QualityControlItem under test", 10, 0);
		
		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getSellIn() == 9);
	}

	@Test
	public void testThatQualityValueIsDecreased() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("QualityControlItem under test", 1, 10);
		
		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 9);
	}
	
	@Test
	public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("QualityControlItem under test", 0, 10);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 8);
	}
	
	@Test 
	public void testThatQualityIsNeverNegative() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("QualityControlItem under test", 0, 0);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 0);		
	}
	
	@Test
	public void testAgedBrieIncreasesQualityWithAge() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Aged Brie", 5, 1);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 2);				
	}
	
	@Test
	public void testQualityNeverIncreasesPastFifty() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Aged Brie", 5, 50);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 50);						
	}

	@Test
	public void testSulfurasNeverChanges() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 25);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 25);
		assertTrue(itemUnderTest.getSellIn() == 0);		
	}

	@Test
	public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 11, 20);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 21);
	}

	@Test
	public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 6, 20);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 22);						
	}

	@Test
	public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 23);						
	}
	
	@Test
	public void testBackstagePassLosesValueAfterSellByPasses() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 0);						
	}
	
	@Test
	public void testConjuredItemsLoseDoubleQualityBeforeSellBy() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Conjured Mana Cake", 5, 20);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 18);						
	}

	@Test
	public void testConjuredItemsLoseDoubleQualityAfterSellBy() {
		QualityControlItem itemUnderTest = ItemFactory.createItem("Conjured Mana Cake", 0, 20);

		GildedRose.updateQuality(createListWithItem(itemUnderTest));
		
		assertTrue(itemUnderTest.getQuality() == 16);						
	}
	
}
