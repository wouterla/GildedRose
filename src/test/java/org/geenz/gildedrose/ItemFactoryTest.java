package org.geenz.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemFactoryTest {

	@Test
	public void testSulfurasItemIsAlwaysImmutable() {
		Item item = ItemFactory.create(ItemFactory.SULFURAS, 0, 80);
		assertTrue(item instanceof ImmutableItem);
	}

	@Test
	public void testOtherItemIsNotImmutable() {
		Item item = ItemFactory.create(ItemFactory.DEXTERITY_VEST, 4, 10);
		assertFalse(item instanceof ImmutableItem);
	}
	
	@Test
	public void testValuatingStoreKeepingItemIsReturned() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.AGED_BRIE, 5, 5);
		assertEquals(1, item.getQualityDelta());
	}
	
	@Test
	public void testConjuredItemsHaveQualityDeltaOfTwo() {
		StoreKeepingItem item = ItemFactory.create(ItemFactory.MANA_CAKE, 5, 5);
		assertEquals(-2, item.getQualityDelta());		
	}
}
