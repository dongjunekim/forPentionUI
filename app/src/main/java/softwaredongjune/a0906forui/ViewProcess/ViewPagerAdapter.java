package softwaredongjune.a0906forui.ViewProcess;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import softwaredongjune.a0906forui.R;

/**
 * Created by 김동준 on 2016-09-06.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private int index = 0;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View viewItem = inflater.inflate(R.layout.viewpageritem, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.img_viewpager_childimage);
        Glide.with(context).load("file:///android_asset/pention_" + (++index) + ".jpg").into(imageView);
        ((ViewPager) container).addView(viewItem);
        return viewItem;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }
}
