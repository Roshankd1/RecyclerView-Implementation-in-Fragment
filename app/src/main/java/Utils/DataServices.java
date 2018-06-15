package Utils;

import com.khadka.khadkaradio.model.Station;

import java.util.ArrayList;

public class DataServices {
    private static final DataServices ourInstance = new DataServices();

    public static DataServices getInstance() {
        return ourInstance;
    }

    private DataServices() {
    }

    public ArrayList<Station> getFeaturedStations() {
        //pretend we just downloaded stations from the internet

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel)", "flightplanmusic"));
        list.add(new Station("'Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jams (Music for Children)", "kidsmusic"));
        return list;

    }

    public ArrayList<Station> getRecentStations() {
        //pretend we just downloaded stations from the internet

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel)", "flightplanmusic"));
        list.add(new Station("'Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jams (Music for Children)", "kidsmusic"));
        return list;

    }

    public ArrayList<Station> getFunStations() {
        //pretend we just downloaded stations from the internet

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel)", "flightplanmusic"));
        list.add(new Station("'Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jams (Music for Children)", "kidsmusic"));
        return list;

    }
}
