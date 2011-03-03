public class ImmutableQualityControlItem extends QualityControlItem {

	public ImmutableQualityControlItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality, 0, false);
	}		

	// Empty method implementations, so we don't change anything after contruction
	public void decreaseSellIn() {}
}
