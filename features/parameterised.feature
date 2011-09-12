Feature: Quality changes with sell-in date Feature
        In order to keep track of quality of items in stock
        As a ShopKeeper
        I want quality to change as the sell-in date decreases

        Scenario Outline: Changing Quality of an Item
                Given a Store Keeping Item with name "<item name>"
                And a sellIn date of <sell in>
                And a quality of <quality>
                When the Item is updated
                Then the sellIn is <expected sell in>
                And the quality is <expected quality>
                
		Examples:
		| item name			| sell in	| quality	| expected sell in	| expected quality	|
		| +5 Dexterity Vest	| 5			| 7			| 4					| 6					|
		| +5 Dexterity Vest	| 0			| 10		| -1				| 8					|
		| +5 Dexterity Vest	| 0			| 0			| -1				| 0					|
		| Aged Brie			| 5			| 1			| 4					| 2					|
		| Aged Brie			| 5			| 50		| 4					| 50				|
		| Backstage passes to a TAFKAL80ETC concert	| 11 | 20 | 10		| 21				|
		| Backstage passes to a TAFKAL80ETC concert	| 6  | 20 | 5		| 22				|
		| Backstage passes to a TAFKAL80ETC concert	| 5  | 20 | 4		| 23				|
		| Backstage passes to a TAFKAL80ETC concert	| 0  | 20 | -1		| 0					|
		| Conjured Mana Cake| 5			| 20		| 4					| 18				|
		| Conjured Mana Cake| 0			| 20		| -1				| 16				|
		
        Scenario: Quality and SellIn of a Sulfuras item does not change
                Given a Store Keeping Item with name "Sulfuras, Hand of Ragnaros" with a sellIn date of 5, a quality of 7
                When the Item is updated
                Then the sellIn is 5
                And the quality is 7
		