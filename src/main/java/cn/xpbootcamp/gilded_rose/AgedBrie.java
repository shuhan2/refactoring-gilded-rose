package cn.xpbootcamp.gilded_rose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (isAgedBrie()) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    @Override
    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    protected void updateQualityAfterExpired() {
        if (isAgedBrie()) {
            if (sellIn < 0) {
                increaseQuality();
            }
        }
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
}
