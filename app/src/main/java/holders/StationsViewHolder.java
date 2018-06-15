package holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khadka.khadkaradio.R;
import com.khadka.khadkaradio.model.Station;

public class StationsViewHolder extends RecyclerView.ViewHolder {

    private ImageView mainImage;
    private TextView mainText;

    public StationsViewHolder(View itemView) {
        super(itemView);
        this.mainImage = itemView.findViewById(R.id.main_image);
        this.mainText = itemView.findViewById(R.id.main_title);

    }

    public void updateUI(Station station) {
        String uri = station.getImageUri();
        int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);
        mainText.setText(station.getStationTitle());

    }
}
