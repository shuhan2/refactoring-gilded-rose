package cn.xpbootcamp.gilded_rose;

class GildedRose {

  private static final String AGED_BRIE = "Aged Brie";
  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  private static final int MAX_QUALITY = 50;
  private static final int MIN_QUALITY = 0;

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void update_quality() {

    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
        items[i].sell_in = items[i].sell_in - 1;
      }
      if (!items[i].name.equals(AGED_BRIE)
          && !items[i].name.equals(BACKSTAGE_PASSES)) {
        if (items[i].quality > MIN_QUALITY) {
          if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {

        items[i].quality = items[i].quality + 1;

        if (items[i].name.equals(BACKSTAGE_PASSES)) {
          if (items[i].sell_in < 11) {
            items[i].quality = items[i].quality + 1;
          }
          if (items[i].sell_in < 6) {

            items[i].quality = items[i].quality + 1;

          }
        }

      }

      if (items[i].sell_in < 0) {
        if (!items[i].name.equals(AGED_BRIE)) {
          if (!items[i].name.equals(BACKSTAGE_PASSES)) {
            if (items[i].quality > MIN_QUALITY) {
              if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].quality = items[i].quality - 1;
              }
            }
          } else {
            items[i].quality = MIN_QUALITY;
          }
        } else {
          items[i].quality = items[i].quality + 1;

        }
      }
      if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS) && items[i].quality > MAX_QUALITY) {
        items[i].quality = MAX_QUALITY;
      }
    }
  }
}
