package org.geenz.gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableItemTest {
	
	@Test
	public void testImmutableItemCreation() {
		ImmutableItem iitem = new ImmutableItem("A Name", 0, 60);
		assertNotNull(iitem);
	}

	@Test
	public void testImmutableQuality() {
		ImmutableItem iitem = new ImmutableItem("A Name", 0, 60);
		iitem.setQuality(30);
		assertEquals(60, iitem.getQuality());
	}
	
	@Test
	public void testImmutableSellIn() {
		ImmutableItem iitem = new ImmutableItem("A Name", 0, 60);
		iitem.setSellIn(10);
		assertEquals(0, iitem.getSellIn());		
	}
	
	@Test
	public void testQualityNotDecreasedForSulfuras() {
		StoreKeepingItem item = new ImmutableItem(ItemFactory.SULFURAS, 0, 80);
		item.decreaseQuality();
		assertEquals(80, item.getQuality());
	}
}
