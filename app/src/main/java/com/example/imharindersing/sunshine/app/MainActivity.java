package com.example.imharindersing.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //create dummy data for Listview
            String[] forecastArray = {
                    "Today - Sunny - 88/63",
                    "Tommorow - Foggy - 70/40",
                    "Wednesday - Cloudy - 72/63",
                    "Thursday - Asteroids - 75/65",
                    "Friday - Heavy Rain - 65/56",
                    "Saturday - HELP TRAPPED IN WEATHERSTATION - 60/51",
                    "Sunday - Sunny - 80/61"
            };

            List<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray));

            //now that we have some dummy forecast data, create an ArrayAdapter.
            //the ArrayAdapter will take data from a source(like our dummy forecast)
            //and use it to populate the ListView it's attached to.

            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(
                    //The current context
                    getActivity(),
                    //ID of list item layout
                    R.layout.list_item_forecast,
                    //ID of the textview to populate
                    R.id.list_item_forecast_textview,
                    //Forecast data
                    weekForecast
            );

            ListView listView = (ListView) rootView.findViewById(
                    R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
