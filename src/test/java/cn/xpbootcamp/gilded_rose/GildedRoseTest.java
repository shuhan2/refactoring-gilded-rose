package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellInForOneDay();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality).isEqualTo(4);
        assertThat(app.items[0].sell_in).isEqualTo(0);
    }

    @Test
    void should_increase_1_when_update_given_backstage_and_sell_in_is_11() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellInForOneDay();
        assertThat(app.items[0].quality).isEqualTo(21);

    }


  @Test
  void should_increase_2_when_update_given_backstage_and_sell_in_is_6() {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)};
    GildedRose app = new GildedRose(items);
    app.updateQualityAndSellInForOneDay();
    assertThat(app.items[0].quality).isEqualTo(22);
  }

  @Test
  void should_quality_0_when_update_given_backstage_and_sell_in_is_0() {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
    GildedRose app = new GildedRose(items);
    app.updateQualityAndSellInForOneDay();
    assertThat(app.items[0].quality).isEqualTo(0);
  }
}
