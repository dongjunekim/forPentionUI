package softwaredongjune.a0906forui.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import softwaredongjune.a0906forui.R;
import softwaredongjune.a0906forui.ViewProcess.RecyclerAdapter;
import softwaredongjune.a0906forui.ViewProcess.RecyclerItem;

/**
 * Created by 김동준 on 2016-09-06.
 */
public class FirstFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private RecyclerView recyclerView;

    public FirstFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FirstFragment newInstance(int sectionNumber) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.first_fragment, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<RecyclerItem> items = new ArrayList<>();
        String[] name = getResources().getStringArray(R.array.pention_name);
        for (int i = 0; i < 5; i++) {
            items.add(new RecyclerItem(name[0]));
            items.add(new RecyclerItem(name[1]));
            items.add(new RecyclerItem(name[2]));
        }
        recyclerView.setAdapter(new RecyclerAdapter(getContext(), items, R.layout.first_fragment));

    }

}
