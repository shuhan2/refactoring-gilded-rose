package cn.xpbootcamp.gilded_rose;

class GildedRose {

  private static final String AGED_BRIE = "Aged Brie";
  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final int MAX_QUALITY = 50;
  private static final int MIN_QUALITY = 0;

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void update_quality() {

    for (Item item : items) {
      if (item.isEqualsName(SULFURAS)) {
        continue;
      }
      item.sell_in = item.sell_in - 1;
      if (!item.isEqualsName(AGED_BRIE) && !item.isEqualsName(BACKSTAGE_PASSES)) {
        item.quality = getChangedQuality(item.quality, -1);
        if (item.sell_in < 0) {
          item.quality = getChangedQuality(item.quality, -1);
        }
      } else {
        if (item.isEqualsName(BACKSTAGE_PASSES)) {
          if (item.sell_in < 0) {
            item.quality = MIN_QUALITY;
          } else if (item.sell_in < 6) {
            item.quality = getChangedQuality(item.quality, 3);
          } else if (item.sell_in < 11) {
            item.quality = getChangedQuality(item.quality, 2);
          } else {
            item.quality = getChangedQuality(item.quality, 1);
          }
        } else {
          item.quality = getChangedQuality(item.quality, 1);
        }
      }
      if (item.quality > MAX_QUALITY) {
        item.quality = MAX_QUALITY;
      }
      if (item.quality < MIN_QUALITY) {
        item.quality = MIN_QUALITY;
      }
    }
  }

  private int getChangedQuality(int originalQuality, int changedValue) {
    return originalQuality + changedValue;
  }
}
