package sears.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lv1  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById( R.id.LV1 ) ;


        getCall( ) ;
    }


    public ArrayList < String [] > getCall( ) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url =  "http://itunes.apple.com/search?term=rock" ;

        ArrayList < String [] > ret = new ArrayList < String [] > () ;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null ;

                        // Display the first 500 characters of the response string.
                        System.out.println("Response is: \n" + (response.length() > 300 ? response.substring(0, 300) + "\n..." : response));

                        //Log.d("TAG", (response.length() > 50 ? response.substring(0, 50) : response)) ;

                        //Deserialization des = new Deserialization () ;
                        //des.execute( response ) ;

                        try {
                            j = new JSONObject(response);

                            JSONArray ja = j.getJSONArray( "results" ) ;

                            loadData ( ja ) ;

                        } catch ( Exception ex ) {
                            ex.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return ret ;
    }


    private void loadData ( JSONArray ja ) {
        ArrayList < String [ ] > al = new ArrayList <> ( ) ;

        for ( int i = 0 ; i < ja.length() ; i ++ ) {
            try {
                JSONObject j = ja.getJSONObject( i ) ;

                al.add(
                        new String[ ] {
                                j.getString( "artistName" ) ,
                                j.getString( "trackName" ) ,
                                j.getString( "artworkUrl100" )
                        }
                ) ;

            } catch ( Exception ex ) {
                ex.printStackTrace();
            }
        }

        //Setting adapter to show the items in the spinner
        this.lv1.setAdapter(new CustomAdapter ( this , R.layout.lvc , al ));

    }


    private class CustomAdapter extends  ArrayAdapter <String []> {

        private final Context c ;
        private List < String []> data ;

        public CustomAdapter ( Context c, int res, List<String [] > l ) {
            super( c , res , l );
            this.c = c ;
            this.data = l ;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)  this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.lvc, parent, false);

            TextView tv1 = (TextView) rowView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) rowView.findViewById(R.id.tv2);
            TextView tv3 = (TextView) rowView.findViewById(R.id.tv3);

            //ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

            tv1.setText( this.data.get ( position ) [ 0 ] );
            tv2.setText( this.data.get ( position ) [ 1 ] );
            tv3.setText( this.data.get ( position ) [ 2 ] );

            return rowView ;
        }
    }

    private class Deserialization  extends AsyncTask<String, Void, String> {


        public Deserialization( ) {

        }

        @Override
        protected String doInBackground(String... notUsed) {

            Gson gson = new Gson();

            String result = "" ;
            TrackInfo exa = null ;
            Results res = null ;

            try {
                res = gson.fromJson( notUsed [0], Results.class ) ;

                result = res.toString() ;

            } catch (Exception ex) {
                Log.v("TAG", "Error: " + ex.getMessage());
                result = "Error: " + ex.getMessage() ;
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {

        }

    }
}
