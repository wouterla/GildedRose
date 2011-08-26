package org.geenz.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;



public class BackstagePassStoreKeepingItemTest {

	@Test
	public void testCreationOfBackstagePassStoreKeepingItem() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.BACKSTAGE_PASSES, 15, 20);
		assertTrue(item instanceof BackstagePassStoreKeepingItem);
	}
	
	@Test
	public void testQualityDeltaForMoreThenTenDaysLeft() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.BACKSTAGE_PASSES, 15, 20);
		assertEquals(1, item.getQualityDelta());
	}
	
	@Test
	public void testQualityDeltaForBetweenFiveAndTenDaysLeft() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.BACKSTAGE_PASSES, 8, 20);
		assertEquals(2, item.getQualityDelta());
	}

	@Test
	public void testQualityDeltaForBelowFiveLeft() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.BACKSTAGE_PASSES, 3, 20);
		assertEquals(3, item.getQualityDelta());
	}
	
	@Test
	public void testQualityDeltaForNoDaysLeft() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.BACKSTAGE_PASSES, -1, 20);
		assertEquals(0 - item.getQuality(), item.getQualityDelta());
	}
}
