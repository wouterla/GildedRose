package org.geenz.gildedrose.cucumber;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.annotation.Pending;
import org.geenz.gildedrose.ItemFactory;
import org.geenz.gildedrose.StoreKeepingItem;

import static org.junit.Assert.*;

@SuppressWarnings({"UnusedDeclaration"})
public class BasicFeature {

    private StoreKeepingItem item = null;

    @Given ("^a Store Keeping Item with name \"([^\"]*)\"$")
    public void aStoreKeepingItemWithName(String name) {
        item = ItemFactory.create(name, 0, 0);
    }

    /**
     * Separate when clause to indicate initial state, since some items can't be changed after initial creation.
     */
    @Given ("^a Store Keeping Item with name \"([^\"]*)\" with a sellIn date of ([0-9]*), a quality of ([0-9]*)$")
    public void aStoreKeepingItemWithNameAndSellInDateAndQualityOf(String name, int sellIn, int quality) {
        item = ItemFactory.create(name, sellIn, quality);
    }

    @Given("^a sellIn date of ([0-9]*)$")
    public void aSellInDateOf(int sellIn) {
        item.setSellIn(sellIn);
    }

    @Given("^a quality of ([0-9]*)$")
    public void aQualityOf(int quality) {
        item.setQuality(quality);
    }

    @When("^the Item is updated$")
    public void theItemIsUpdated() {
        item.doDailyInventoryUpdate();
    }

    @Then("^the sellIn is (.*)$")
    public void theSellInIs(int expectedSellIn) {
        assertEquals(expectedSellIn, item.getSellIn());
    }

    @Then("^the quality is ([0-9]*)$")
    public void theQualityIs(int expectedQuality) {
        assertEquals(expectedQuality, item.getQuality());
    }
}