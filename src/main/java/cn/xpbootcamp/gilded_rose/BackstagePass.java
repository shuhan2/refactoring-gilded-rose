package cn.xpbootcamp.gilded_rose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (isBackstagePass()) {
            if (quality < 50) {
                quality = quality + 1;
                if (sellIn < 11) {
                    increaseQuality();
                }
                if (sellIn < 6) {
                    increaseQuality();
                }
            }
        }
    }

    @Override
    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    protected void updateQualityAfterExpired() {
        if (isBackstagePass()) {
            if (sellIn < 0) {
                quality = 0;
            }
        }
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}
