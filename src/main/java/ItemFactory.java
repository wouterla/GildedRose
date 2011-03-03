public class ItemFactory {

	public static QualityControlItem createItem(String name, int sellIn, int quality) {
		if ("Sulfuras, Hand of Ragnaros".equals(name)) {
			return new ImmutableQualityControlItem(name, sellIn, quality);			
		} else if ("Aged Brie".equals(name)) {
			return new QualityControlItem(name, sellIn, quality, 1, false);
		} else if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
			return new BackstageQualityControlItem(name, sellIn, quality);
		} else if ("Conjured Mana Cake".equals(name)) {
			return new QualityControlItem(name, sellIn, quality, 2 * QualityControlItem.DEFAULT_QUALITY_CHANGE_PER_DAY, false);
		} else {
			return new QualityControlItem(name, sellIn, quality, QualityControlItem.DEFAULT_QUALITY_CHANGE_PER_DAY, false);
		}		
	}

}
