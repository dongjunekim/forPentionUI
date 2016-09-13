package softwaredongjune.a0906forui.ViewProcess;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import softwaredongjune.a0906forui.R;

/**
 * Created by 김동준 on 2016-09-06.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<RecyclerItem> items;
    private ViewPagerAdapter viewPagerAdapter;
    private int index = 0;
    private static int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;


    public RecyclerAdapter(Context context, List<RecyclerItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_recycler, parent, false);
            return new HeaderViewHolder(v);
        } else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecycler, parent, false);
            return new ViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            viewPagerAdapter = new ViewPagerAdapter(context);
            headerViewHolder.viewPager.setAdapter(viewPagerAdapter);
        } else if (holder instanceof ViewHolder) {
            final RecyclerItem currentitem = items.get(position - 1);
            ViewHolder VHholder = (ViewHolder) holder;
            Glide.with(context).load("file:///android_asset/pention_" + (++index) + ".jpg").into(VHholder.image);
            if (index == 3) {
                index = 0;
            }
            VHholder.title.setText(currentitem.getTitle());
            VHholder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, currentitem.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return this.items.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.mimage);
            title = (TextView) itemView.findViewById(R.id.mtitle);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        ViewPager viewPager;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.viewpager);
        }
    }

}
