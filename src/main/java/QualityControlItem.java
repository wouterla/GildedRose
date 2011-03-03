
public class QualityControlItem extends Item {

	private final static int MIN_QUALITY = 0;
	private final static int MAX_QUALITY = 50;
	final static int DEFAULT_QUALITY_CHANGE_PER_DAY = -1;
	int qualityChangePerDay;
	private boolean qualityZeroPassedSellIn = true; 
	
	public QualityControlItem(String name, int sellIn, int quality, int qualityChangePerDay, boolean qualityZeroPassedSellIn) {
		super(name, sellIn, quality);
		this.qualityChangePerDay = qualityChangePerDay;
		this.qualityZeroPassedSellIn = qualityZeroPassedSellIn;
	}

	public void decreaseSellIn() {
		setSellIn(getSellIn() - 1);
		if (qualityZeroPassedSellIn && (getSellIn() < 0)) {
			setQuality(0);
		} else {
			changeQuality(getQualityChangeForSellIn(getSellIn()));
		}
	}

	public void changeQuality(int amount) {
		int newQuality = getQuality() + amount;
		if ((newQuality > MIN_QUALITY) 
			&& (newQuality < MAX_QUALITY)) {
			setQuality(newQuality);
		}		
	}

	protected int getQualityChangeForSellIn(int sellIn) {
		if (sellIn < 0) {
			return 2 * qualityChangePerDay;
		} else {
			return qualityChangePerDay;
		}
	}	
}
