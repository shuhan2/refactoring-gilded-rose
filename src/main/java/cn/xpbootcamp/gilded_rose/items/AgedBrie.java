package cn.xpbootcamp.gilded_rose.items;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void updateSellIn() {
        sellIn = decreaseSellIn();
    }

    @Override
    protected void updateQualityAfterExpired() {
        increaseQuality();
    }
}
