package org.example;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items){
            handleAgedBrie(item);
            handleBackstagePass(item);
            handleConjured(item);
            handleOther(item);
        }
    }

    //--------------------------------------------------------------------------------
    //          HANDLERS
    //--------------------------------------------------------------------------------

    /**
     * Handles Aged Brie
     * "Aged Brie" actually increases in Quality the older it gets
     * @param item inventory item
     */
    private void handleAgedBrie(Item item) {
        boolean isAgedBrie = item.name.contains("Aged Brie");
        boolean isExpired = item.sellIn < 0;
        //if aged brie increase quality
        if(isAgedBrie){
            increaseQuality(item);
            decreaseSellIn(item);
        }
        //if aged brie and expired increase quality once more
        if(isAgedBrie && isExpired){
            increaseQuality(item);
        }
    }

    /**
     * Handles Conjured
     * "Conjured" items degrade in Quality twice as fast as normal items
     * @param item inventory item
     */
    private void handleConjured(Item item) {
        boolean isConjured = item.name.contains("Conjured");
        boolean isExpired = item.sellIn < 0;
        //if conjured decrease quality by 2
        if(isConjured){
            decreaseQuality(item, 2);
            decreaseSellIn(item);
        }
        //if conjured and expired decrease quality by 4
        if(isConjured && isExpired){
            decreaseQuality(item, 2);
        }
    }

    /**
     * Handles Backstage Pass
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     * @param item inventory item
     */
    private void handleBackstagePass(Item item) {
        boolean isBackstagePass = item.name.contains("Backstage passes");
        boolean isExpired = item.sellIn < 0;
        //if backstage pass
        if(isBackstagePass){
            increaseQuality(item);
            if(item.sellIn <= 10){
                increaseQuality(item);
            }
            if(item.sellIn <= 5){
                increaseQuality(item);
            }
            decreaseSellIn(item);
        }
        //if backstage pass and expired set quality to 0
        if(isBackstagePass && isExpired){
            item.quality = 0;
        }
    }

    /**
     * Handles Other
     * @param item inventory item
     */
    private void handleOther(Item item) {
        boolean isAgedBrie = item.name.contains("Aged Brie");
        boolean isBackstagePass = item.name.contains("Backstage passes");
        boolean isSulfuras = item.name.contains("Sulfuras");
        boolean isConjured = item.name.contains("Conjured");
        boolean isExpired = item.sellIn < 0;
        //if not aged brie, backstage pass, or sulfuras decrease quality
        if(!isAgedBrie && !isBackstagePass && !isSulfuras && !isConjured){
            decreaseQuality(item, 1);
            decreaseSellIn(item);
        }
        //if not aged brie, backstage pass, or sulfuras and expired decrease quality by 2
        if(!isAgedBrie && !isBackstagePass && !isSulfuras && !isConjured && isExpired){
            decreaseQuality(item, 1);
        }
    }

    //--------------------------------------------------------------------------------
    //          HELPERS
    //--------------------------------------------------------------------------------

    /**
     * Increases quality by 1
     * @param item inventory item
     */
    private void increaseQuality(Item item){
        if(item.quality < 50){
            item.quality++;
        }
    }

    /**
     * Decreases quality by amout
     * @param item inventory item
     * @param amount amount to decrease quality by
     */
    private void decreaseQuality(Item item, int amount){
        if(item.quality > 0){
            item.quality-=amount;
        }
    }

    /**
     * Decreases sellIn by 1
     * @param item inventory item
     */
    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }


}
