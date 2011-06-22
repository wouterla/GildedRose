import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StoreKeepingItemTest {
	
	private StoreKeepingItem item = null;

	@Before
	public void createDefaultTestItem() {
		item = ItemFactory.create(ItemFactory.DEXTERITY_VEST, 3, 5);		
	}
	
	@Test
	public void testIncreaseItemQuality() {
		item.setQuality(5);
		item.increaseQuality();
		assertEquals(6, item.getQuality());
	}

	@Test
	public void testDecreaseItemQuality() {
		item.setQuality(5);
		item.decreaseQuality();
		assertEquals(4, item.getQuality());
	}

	@Test
	public void testQualityIncreaseNotAboveFifty() {
		item.setQuality(50);
		item.increaseQuality();
		assertEquals(50, item.getQuality());		
	}
	
	@Test
	public void testQualityDecreaseNotBelowZero() {
		item.setQuality(0);
		item.decreaseQuality();
		assertEquals(0, item.getQuality());
	}
	
	@Test 
	public void testSellInDecreases() {
		item.setSellIn(3);
		item.decreaseSellIn();
		assertEquals(2, item.getSellIn());
	}
	
	@Test
	public void testDetermineQualityDeltaForPositiveSellIn() {
		item.setSellIn(1);
		assertEquals(-1, item.getQualityDelta());
	}
	
	@Test
	public void testDetermineQualityDeltaForNegativeSellIn() {
		item.setSellIn(-1);
		assertEquals(-2, item.getQualityDelta());
	}
	
	@Test
	public void testDetermineQualityDeltaForSellInZero() {
		item.setSellIn(0);
		assertEquals(-2, item.getQualityDelta());		
	}
	
	@Test
	public void testAfterSalesDate() {
		item.setSellIn(-1);
		assertTrue(item.isAfterSalesDate());
	}
	
	@Test
	public void testNotAfterSalesDate() {
		item.setSellIn(1);
		assertFalse(item.isAfterSalesDate());		
	}

	@Test
	public void testQualityChangesAfterDoDailyInventoryUpdate() {
		item.setQuality(5);
		item.doDailyInventoryUpdate();
		assertEquals(4, item.getQuality());
	}
	
	@Test
	public void testSellInChangesAfterDoDailyInventoryUpdate() {
		item.setSellIn(3);
		item.doDailyInventoryUpdate();
		assertEquals(2, item.getSellIn());
	}

	@Test
	public void testChangeQualityWithPositiveDelta() {
		item.setQuality(5);
		item.changeQuality(1);
		assertEquals(6, item.getQuality());
	}

	@Test
	public void testChangeQualityWithNegativeDelta() {
		item.setQuality(5);
		item.changeQuality(-1);
		assertEquals(4, item.getQuality());
	}
	
	@Test
	public void testInValidQualityRangeWithValidValue() {
		assertTrue(item.inValidQualityRange(5));
	}
	
	@Test
	public void testInValidQualityRangeWithValueBelowZero() {
		assertFalse(item.inValidQualityRange(-1));
	}
	
	@Test
	public void testInValidQualityRangeWithValueZero() {
		assertTrue(item.inValidQualityRange(0));
	}
	
	@Test 
	public void testInvalidQualityRangeWithValueAboveFifty() {
		assertFalse(item.inValidQualityRange(51));
	}
	
	@Test
	public void testCreateItemWithSpecificQualityDelta() {
		StoreKeepingItem item = new StoreKeepingItem("test", 5, 6, 4);
		assertEquals(4, item.getQualityDelta());
	}
}
