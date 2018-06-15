package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khadka.khadkaradio.R;
import com.khadka.khadkaradio.model.Station;

import java.util.ArrayList;

import activities.MainActivity;
import holders.StationsViewHolder;

public class StationsAdapter extends RecyclerView.Adapter<StationsViewHolder> {

    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @NonNull
    @Override
    public StationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station, parent, false);

        return new StationsViewHolder(stationCard);
    }

    @Override
    public void onBindViewHolder(@NonNull StationsViewHolder holder, final int position) {
        final Station station = stations.get(position);
        holder.updateUI(station);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadDetailsScreen(station);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
