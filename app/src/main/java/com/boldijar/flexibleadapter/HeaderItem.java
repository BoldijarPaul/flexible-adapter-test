package com.boldijar.flexibleadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by BoldijarPaul on 23/03/16.
 */
public class HeaderItem extends AbstractHeaderItem<HeaderItem.ViewHolder> {

    private int mId;

    public HeaderItem(int id) {
        mId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HeaderItem) {
            HeaderItem item = (HeaderItem) o;
            return item.getId() == mId;
        }
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_header;
    }

    public int getId() {
        return mId;
    }

    @Override
    public ViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new ViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ViewHolder holder, int position, List payloads) {
        HeaderItem item = (HeaderItem) adapter.getItem(position);
        holder.text.setText("Header #" + item.getId());
    }

    public class ViewHolder extends FlexibleViewHolder {
        TextView text;

        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            text = (TextView) view.findViewById(R.id.text);
        }
    }

}
