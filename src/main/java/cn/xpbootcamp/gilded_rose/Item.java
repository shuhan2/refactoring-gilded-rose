package cn.xpbootcamp.gilded_rose;

public class Item {
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void update() {
        updateQuality();

        updateSellIn();

        updateQualityAfterExpired();
    }

    private void updateQuality() {
        if (isAgedBrie()) {
            if (quality < 50) {
                quality = quality + 1;
            }
            return;
        }
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
            return;
        }
        if (isSulfuras()) {
            return;
        }

        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private void updateSellIn() {
        if (isSulfuras()) {
            return;
        }
        sellIn = sellIn - 1;
    }

    private void updateQualityAfterExpired() {
        if (isAgedBrie()) {
            if (sellIn < 0) {
                increaseQuality();
            }
            return;
        }
        if (isBackstagePass()) {
            if (sellIn < 0) {
                quality = 0;
            }
            return;
        }
        if (isSulfuras()) {
            return;

        }
        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }

    private void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
}
