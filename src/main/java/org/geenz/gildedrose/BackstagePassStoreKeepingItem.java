package org.geenz.gildedrose;

public class BackstagePassStoreKeepingItem extends StoreKeepingItem {

	public BackstagePassStoreKeepingItem(String typeName, int sellIn, int quality, int qualityDelta) {
		super(typeName, sellIn, quality, qualityDelta);
	}
	
	@Override
	public int getQualityDelta() {
		int delta = super.getQualityDelta();
		if (getSellIn() <= 10) {
			delta = delta + 1;
		}
		if (getSellIn() <= 5) {
			delta = delta + 1;
		}
		if (isAfterSalesDate()) {
			delta = 0 - getQuality();
		}
		return delta;
	}
}
