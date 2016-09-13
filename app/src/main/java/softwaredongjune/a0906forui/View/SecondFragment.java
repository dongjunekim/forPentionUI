package softwaredongjune.a0906forui.View;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import softwaredongjune.a0906forui.ViewProcess.GridViewAdapter;
import softwaredongjune.a0906forui.R;

/**
 * Created by 김동준 on 2016-09-06.
 */
public class SecondFragment extends android.support.v4.app.Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private TextView datetxt;
    private GridView gridView;
    private ArrayList<String> dataList;
    private Calendar calendar;
    private GridViewAdapter gridViewAdapter;

    public SecondFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SecondFragment newInstance(int sectionNumber) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);
        init(rootView);
        countingDate();
        return rootView;
    }

    private void init(View v) {
        datetxt = (TextView) v.findViewById(R.id.date);
        gridView = (GridView) v.findViewById(R.id.gridview);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < 10) {

                } else {
                    Toast.makeText(getContext(), (position - 10) + " 일", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void countingDate() {
        Long now = System.currentTimeMillis();
        final Date date = new Date(now);
        SimpleDateFormat yearFormet = new SimpleDateFormat("yyyy", Locale.KOREA);
        SimpleDateFormat monthFormet = new SimpleDateFormat("MM", Locale.KOREA);

        datetxt.setText(yearFormet.format(date) + "/" + monthFormet.format(date));
        dataList = new ArrayList<String>();
        dataList.add("일");
        dataList.add("월");
        dataList.add("화");
        dataList.add("수");
        dataList.add("목");
        dataList.add("금");
        dataList.add("토");

        calendar = Calendar.getInstance();

        calendar.set(Integer.parseInt(yearFormet.format(date)), Integer.parseInt(monthFormet.format(date)) - 1, 1);
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i < dayNum; i++) {
            dataList.add("");
        }
        setCalendarDate(calendar.get(Calendar.MONTH) + 1);

        gridViewAdapter = new GridViewAdapter(getContext(), dataList);

        gridView.setAdapter(gridViewAdapter);
    }


    private void setCalendarDate(int month) {
        calendar.set(Calendar.MONTH, month - 1);
        for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dataList.add("" + (i + 1));
        }
    }

}
