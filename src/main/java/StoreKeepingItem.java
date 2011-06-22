public class StoreKeepingItem extends Item {

	public int qualityDelta = -1;
	public int afterSalesDateFactor = 2;
	public int lowQualityLimit = 0;
	public int highQualityLimit = 50;
	
	public StoreKeepingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public StoreKeepingItem(String name, int sellIn, int quality, int qualityDelta) {
		super(name, sellIn, quality);
		this.qualityDelta = qualityDelta;
	}

	public void increaseQuality() {
		if (getQuality() < 50) {
			setQuality(getQuality() + 1);
		}
	}
	
	public void decreaseQuality() {
		if (getQuality() > 0) {
			setQuality(getQuality() - 1);
		}
	}
	
	public void decreaseSellIn() {
		setSellIn(getSellIn() - 1);
	}

	public int getQualityDelta() {
		if (isAfterSalesDate()) {
			return qualityDelta * afterSalesDateFactor;
		}
		return qualityDelta;
	}

	public boolean isAfterSalesDate() {
		return getSellIn() <= 0;
	}

	public void doDailyInventoryUpdate() {
		changeQuality(getQualityDelta());
		setSellIn(getSellIn() - 1);
	}

	public void changeQuality(int delta) {
		int newQuality = getQuality() + delta;
		if (inValidQualityRange(newQuality)) {
			setQuality(newQuality);
		}
	}

	boolean inValidQualityRange(int newQuality) {
		return (newQuality >= lowQualityLimit) && (newQuality <= highQualityLimit);
	}
	
	
}