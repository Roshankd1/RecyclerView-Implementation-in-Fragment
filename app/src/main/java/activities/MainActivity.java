package activities;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.khadka.khadkaradio.R;
import com.khadka.khadkaradio.model.Station;

import fragments.DetailsFragment;
import fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity activity) {
        mainActivity = activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment fragment = (MainFragment) fm.findFragmentById(R.id.frame_container);
        if (fragment == null) {
            fragment = MainFragment.newInstance("param", "param");
            fm.beginTransaction().add(R.id.frame_container, fragment).commit();
        }


    }

    public void loadDetailsScreen(Station selectedStation) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }


}
