package fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khadka.khadkaradio.R;

import Utils.DataServices;
import adapter.StationsAdapter;
import holders.StationsViewHolder;

public class StationsFragment extends Fragment {
    private static final String ARG_STATION_TYPE = "station_type";

    private int stationType;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_FUN = 2;

    public StationsFragment() {
        // Required empty public constructor
    }

    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stations, container, false);

        RecyclerView view = v.findViewById(R.id.content_recycler);
        view.setHasFixedSize(true);
        StationsAdapter adapter;
        if (stationType == STATION_TYPE_FEATURED) {
            adapter = new StationsAdapter(DataServices.getInstance().getFeaturedStations());
        } else if (stationType == STATION_TYPE_RECENT) {
            adapter = new StationsAdapter(DataServices.getInstance().getRecentStations());
        } else {
            adapter = new StationsAdapter(DataServices.getInstance().getFunStations());
        }
        view.addItemDecoration(new HorizontalSpaceItemDecorator(30));

        view.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);

        return v;
    }

    class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {
        private final int spacer;

        public HorizontalSpaceItemDecorator(int spacer) {
            this.spacer = spacer;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = spacer;
        }
    }

}
