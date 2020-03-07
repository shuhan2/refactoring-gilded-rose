package cn.xpbootcamp.gilded_rose;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (isSulfuras()) {
        }
    }

    @Override
    protected void updateSellIn() {
        if (isSulfuras()) {
        }
    }

    @Override
    protected void updateQualityAfterExpired() {
        if (isSulfuras()) {
        }
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

}
