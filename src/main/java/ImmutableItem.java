
public class ImmutableItem extends StoreKeepingItem {

	public ImmutableItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}
	
	@Override
	public void setQuality(int quality) {}
	
	@Override
	public void setSellIn(int sellIn) {}
}
