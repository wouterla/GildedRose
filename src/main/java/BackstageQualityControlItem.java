
public class BackstageQualityControlItem extends QualityControlItem {
	public BackstageQualityControlItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality, 1, true);
	}		

	// Override to use ranges for backstage passes
	public int getQualityChangeForSellIn(int sellIn) {
		int delta = qualityChangePerDay;
		
		if (sellIn < 0) {
			delta = 0;
		} else if (sellIn < 5)  {
			delta = 3 * qualityChangePerDay;
		} else if (sellIn < 10) {
			delta = 2 * qualityChangePerDay;
		}
		return delta;
	}
}
