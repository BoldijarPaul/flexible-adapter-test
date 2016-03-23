package com.boldijar.flexibleadapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

/**
 * Created by BoldijarPaul on 23/03/16.
 */
public class MyFlexibleAdapter extends FlexibleAdapter<AbstractFlexibleItem> {

    private List<HeaderItem> mHeaders = new ArrayList<>();
    private static Random random = new Random();
    private int itemIds = 0;

    public MyFlexibleAdapter() {
        super(new ArrayList<AbstractFlexibleItem>());
    }

    /* add 10 headers */
    public void addHeaders() {
        for (int i = 1; i <= 10; i++) {
            mHeaders.add(new HeaderItem(i));
        }

    }

    /* add random items */
    public void addItems() {
        for (HeaderItem headerItem : mHeaders) {
            int itemsCount = random.nextInt(12);
            for (int i = 1; i <= itemsCount; i++) {
                itemIds++;
                NormalItem item = new NormalItem(itemIds, headerItem);
                addItem(getItemCount(), item);
            }
        }
    }
}
