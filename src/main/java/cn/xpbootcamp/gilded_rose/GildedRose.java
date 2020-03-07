package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
    private List<Item> items = new ArrayList<>();

    public GildedRose(Item... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void updateQuality() {
        items.forEach(Item::update);
    }
}
