import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class GildedRoseRegressionTest {

	/* Helpers */
	private List<Item> createListWithItem(Item itemUnderTest) {
		List<Item> items = new ArrayList<Item>();
		items.add(itemUnderTest);
		return items;
	}

	private void setItemInGildedRose(Item item) {
		GildedRose.resetItems();
		GildedRose.setItems(createListWithItem(item));		
	}
	
	/* Test Methods */	
	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Test
	public void testThatSellInValueIsDecreased() {
		Item itemUnderTest = new Item("Item under test", 10, 0);
		setItemInGildedRose(itemUnderTest);
		
		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getSellIn() == 9);
	}

	@Test
	public void testThatQualityValueIsDecreased() {
		Item itemUnderTest = new Item("Item under test", 1, 10);
		setItemInGildedRose(itemUnderTest);
		
		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 9);
	}
	
	@Test
	public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
		Item itemUnderTest = new Item("Item under test", 0, 10);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 8);
	}
	
	@Test 
	public void testThatQualityIsNeverNegative() {
		Item itemUnderTest = new Item("Item under test", 0, 0);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 0);		
	}
	
	@Test
	public void testAgedBrieIncreasesQualityWithAge() {
		Item itemUnderTest = new Item("Aged Brie", 5, 1);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 2);				
	}
	
	@Test
	public void testQualityNeverIncreasesPastFifty() {
		Item itemUnderTest = new Item("Aged Brie", 5, 50);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 50);						
	}

	@Test
	public void testSulfurasNeverChanges() {
		Item itemUnderTest = new Item("Sulfuras, Hand of Ragnaros", 0, 25);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 25);
		assertTrue(itemUnderTest.getSellIn() == 0);		
	}

	@Test
	public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
		Item itemUnderTest = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 21);
	}

	@Test
	public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
		Item itemUnderTest = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 22);						
	}

	@Test
	public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
		Item itemUnderTest = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 23);						
	}
	
	@Test
	public void testBackstagePassLosesValueAfterSellByPasses() {
		Item itemUnderTest = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 0);						
	}
	
	@Test
	@Ignore
	public void testConjuredItemsLoseDoubleQualityBeforeSellBy() {
		Item itemUnderTest = new Item("Conjured Mana Cake", 5, 20);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 18);						
	}

	@Test
	@Ignore
	public void testConjuredItemsLoseDoubleQualityAfterSellBy() {
		Item itemUnderTest = new Item("Conjured Mana Cake", 0, 20);
		setItemInGildedRose(itemUnderTest);

		GildedRose.updateQuality();
		
		assertTrue(itemUnderTest.getQuality() == 16);						
	}
}
