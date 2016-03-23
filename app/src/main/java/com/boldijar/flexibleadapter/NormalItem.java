package com.boldijar.flexibleadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.flexibleadapter.items.ISectionable;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by BoldijarPaul on 23/03/16.
 */
public class NormalItem extends AbstractHeaderItem<NormalItem.ViewHolder>
        implements ISectionable<NormalItem.ViewHolder, HeaderItem> {

    private int mId;
    private HeaderItem mHeaderItem;

    public NormalItem(int id, HeaderItem headerItem) {
        mId = id;
        mHeaderItem = headerItem;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NormalItem) {
            NormalItem item = (NormalItem) o;
            return item.getId() == mId;
        }
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_normal;
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
        NormalItem item = (NormalItem) adapter.getItem(position);
        holder.text.setText("Item #" + item.getId());
    }

    @Override
    public HeaderItem getHeader() {
        return mHeaderItem;
    }

    @Override
    public IFlexible setHeader(HeaderItem header) {
        mHeaderItem = header;
        return header;
    }

    public class ViewHolder extends FlexibleViewHolder {
        TextView text;

        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            text = (TextView) view.findViewById(R.id.text);
        }
    }

}
