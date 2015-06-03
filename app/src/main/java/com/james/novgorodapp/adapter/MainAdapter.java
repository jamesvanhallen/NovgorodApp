package com.james.novgorodapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.james.novgorodapp.R;
import com.james.novgorodapp.pojos.MyItem;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainAdapter extends BaseAdapter {
    private List<MyItem> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public MyItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder h;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_view, parent, false);

            h = new ViewHolder(convertView);
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        h.bind(parent.getContext(), getItem(position));

        return convertView;
    }

    public void setItems(List<MyItem> myItems) {
        mItems = myItems;
        notifyDataSetChanged();
    }

    public static class ViewHolder {

        @InjectView(R.id.company_name)
        TextView tvName;
        @InjectView(R.id.company_address)
        TextView tvAddress;
        @InjectView(R.id.image)
        ImageView mImage;
        @InjectView(R.id.iv_mask_op)
        ImageView mBack;

        public ViewHolder(View v) {
            ButterKnife.inject(this, v);
        }

        public void bind(Context context, MyItem item) {
            tvName.setText(item.getShortName());
            tvAddress.setText(item.getAddress());

            Picasso.with(context)
                    .load("http://basis.seldon.ru/Content/img/okved-sub-categories/112/"
                            + item.getOkvedId()
                            + ".png")
                    .into(mImage);
            Log.d("tag", item.getColor());
            mBack.setColorFilter(Color.parseColor(item.getColor()));
        }
    }
}
