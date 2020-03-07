package cn.xpbootcamp.gilded_rose.items;

public class RegularItem extends Item {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
    }

    @Override
    protected void updateSellIn() {
        sellIn = decreaseSellIn();
    }

    @Override
    protected void updateQualityAfterExpired() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }
}