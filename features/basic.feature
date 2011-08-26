Feature: Quality changes with sell-in date Feature
        In order to keep track of quality of items in stock
        As a ShopKeeper
        I want quality to change as the sell-in date decreases

        Scenario: Decreasing Quality of a Basic Item
                Given a Store Keeping Item with name "+5 Dexterity Vest"
                And a sellIn date of 5
                And a quality of 7
                When the Item is updated
                Then the sellIn is 4
                And the quality is 6

        Scenario: Quality decrease doubles after sell-in has passed
                Given a Store Keeping Item with name "+5 Dexterity Vest"
                And a sellIn date of 0
                And a quality of 10
                When the Item is updated
                Then the sellIn is -1
                And the quality is 8

        Scenario: Quality never becomes negative
                Given a Store Keeping Item with name "+5 Dexterity Vest"
                And a sellIn date of 0
                And a quality of 0
                When the Item is updated
                Then the sellIn is -1
                And the quality is 0

        Scenario: Quality of Aged Brie increases with age
                Given a Store Keeping Item with name "Aged Brie"
                And a sellIn date of 5
                And a quality of 1
                When the Item is updated
                Then the sellIn is 4
                And the quality is 2

        Scenario: Quality of Aged Brie never increases past 50
                Given a Store Keeping Item with name "Aged Brie"
                And a sellIn date of 5
                And a quality of 50
                When the Item is updated
                Then the sellIn is 4
                And the quality is 50

        Scenario: Quality of Backstage Passes increases by 1 if sell-in is greater than 10
                Given a Store Keeping Item with name "Backstage passes to a TAFKAL80ETC concert"
                And a sellIn date of 11
                And a quality of 20
                When the Item is updated
                Then the quality is 21

        Scenario: Quality of Backstage Passes increases by 2 if sell-in is less than 10 but more than 5
                Given a Store Keeping Item with name "Backstage passes to a TAFKAL80ETC concert"
                And a sellIn date of 6
                And a quality of 20
                When the Item is updated
                Then the quality is 22

        Scenario: Quality of Backstage Passes increases by 3 if sell-in is 5 or less but more than 0
                Given a Store Keeping Item with name "Backstage passes to a TAFKAL80ETC concert"
                And a sellIn date of 5
                And a quality of 20
                When the Item is updated
                Then the quality is 23

        Scenario: Quality of Backstage Passes is 0 after the concert (sell-in) passes
                Given a Store Keeping Item with name "Backstage passes to a TAFKAL80ETC concert"
                And a sellIn date of 0
                And a quality of 20
                When the Item is updated
                Then the quality is 0

        Scenario: Quality and SellIn of a Sulfuras item does not change
                Given a Store Keeping Item with name "Sulfuras, Hand of Ragnaros" with a sellIn date of 5, a quality of 7
                When the Item is updated
                Then the sellIn is 5
                And the quality is 7

        Scenario: Quality of Conjured items goes down twice as fast as a normal item before sell-in
                Given a Store Keeping Item with name "Conjured Mana Cake"
                And a sellIn date of 5
                And a quality of 20
                When the Item is updated
                Then the quality is 18

        Scenario: Quality of Conjured items goes down twice as fast as a normal item after sell-in
                Given a Store Keeping Item with name "Conjured Mana Cake"
                And a sellIn date of 0
                And a quality of 20
                When the Item is updated
                Then the quality is 16
