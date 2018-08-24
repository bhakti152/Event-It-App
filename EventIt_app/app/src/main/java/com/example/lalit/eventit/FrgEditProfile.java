package com.example.lalit.eventit;


import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgEditProfile extends Fragment {
    UserSessionManager session;
    ImageView ivOrgProfileImage;
    EditText fname;
    EditText lname;
    EditText num;
    EditText aadhar;
    EditText address;
    EditText city;
    EditText country;

    public FrgEditProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_edit_profile, container, false);
        ivOrgProfileImage = view.findViewById(R.id.ivOrgProfileImage);
        fname = view.findViewById(R.id.etOrgFirstName);
        lname = view.findViewById(R.id.etOrgLastName);
        num = view.findViewById(R.id.etOrgNumber);
        aadhar = view.findViewById(R.id.etOrgAadharCardNumber);
        address = view.findViewById(R.id.etOrgResidence);
        city = view.findViewById(R.id.etOrgCity);
        country = view.findViewById(R.id.etOrgCountry);
        ivOrgProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Horha h Click", Toast.LENGTH_SHORT).show();
            }
        });
//bhakti
//        if(isConnected()){
//            Toast.makeText(getContext(), "You are connected", Toast.LENGTH_SHORT).show();
//
//        }
//        else{
//            Toast.makeText(getContext(), "You are not connected", Toast.LENGTH_SHORT).show();
//        }


        // call AsynTask to perform network operation on separate thread
        //new HttpAsyncTask().execute("http://event-it-api.herokuapp.com/api/user/2");

        new AsyncTaskParseJson().execute();

//bhakti
        return view;
    }

    public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

        final String TAG = "AsyncTaskParseJson.java";

        // set your json string url here
        String yourJsonStringUrl = "http://event-it-api.herokuapp.com/api/user/2";

        // contacts JSONArray
        JSONArray dataJsonArr = null;

        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... arg0) {
//
//            try {

                // instantiate our json parser
                JsonParser jParser = new JsonParser();

                // get json string from url
                JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);
                    Log.e("TAG","JSON: "+json.toString());
                // get the array of users

//                String firstname =  json.getString("user_first_name");
//                Log.e(TAG, "firstname: " + firstname);
//                dataJsonArr = json.getJSONArray("data");

                // loop through all users
//                for (int i = 0; i < dataJsonArr.length(); i++) {
//
//                    JSONObject c = dataJsonArr.getJSONObject(i);
//
//                    // Storing each json item in variable
//                    String firstname = c.getString("user_first_name");
//                    String lastname = c.getString("user_last_name");
//                  //  String username = c.getString("username");
//
//                    // show the values in our logcat
//                    Log.e(TAG, "firstname: " + firstname
//                            + ", lastname: " + lastname
//                            );
//
//                }

//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {
            
        }
    }
}



//bhakti
//public static String GET(String url){
//    InputStream inputStream = null;
//    String result = "";
//    try {
//
//        // create HttpClient
//        HttpClient httpclient = new DefaultHttpClient();
//
//        // make GET request to the given URL
//        HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
//
//        // receive response as inputStream
//        inputStream = httpResponse.getEntity().getContent();
//
//        // convert inputstream to string
//        if(inputStream != null)
//            result = convertInputStreamToString(inputStream);
//        else
//            result = "Did not work!";
//
//    } catch (Exception e) {
//        Log.d("InputStream", e.getLocalizedMessage());
//    }
//
//    return result;
//}
//
//    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
//        String line = "";
//        String result = "";
//        while((line = bufferedReader.readLine()) != null)
//            result += line;
//
//        inputStream.close();
//        return result;
//
//    }
//
////    public boolean isConnected(){
////       // ConnectivityManager connMgr = (ConnectivityManager) getSystemService(getActivity().CONNECTIVITY_SERVICE.toString());
////        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
////        if (networkInfo != null && networkInfo.isConnected())
////            return true;
////        else
////            return false;
////    }
//
//    private Object getSystemService(String connectivityService) {
//        return getActivity().CONNECTIVITY_SERVICE;
//    }
//
//    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... urls) {
//
//            return GET(urls[0]);
//        }
//        // onPostExecute displays the results of the AsyncTask.
//        @Override
//        protected void onPostExecute(String result) {
//            Toast.makeText(getContext(), "Received!", Toast.LENGTH_LONG).show();
//            try {
////                profileDetails pd=new profileDetails();
////                JSONObject json = new JSONObject(result);
//
////                String str = "";
////
////                JSONArray data = json.getJSONArray("data");
////                str += "articles length = "+json.getJSONArray("articleList").length();
////                str += "\n--------\n";
////                str += "names: "+articles.getJSONObject(0).names();
////                str += "\n--------\n";
////                str += "url: "+articles.getJSONObject(0).getString("url");
////                pd.setfName(json.getString("user_first_name").toString());
////                pd.setlName(json.getString("user_last_name").toString());
////                pd.setPhoneNumber(json.getLong("user_phone_number"));
////                pd.setaadharCardNum(json.getLong("user_aadhar_card_number"));
////                pd.setprofilePic(json.getString("user_profile_picture").toString());
////                pd.setuserAbout(json.getString("user_about").toString());
////                pd.setuserResidence(json.getString("user_residence").toString());
////                pd.setuserCity(json.getString("user_city").toString());
////                pd.setuserCountry(json.getString("user_country").toString());
////                etResponse.setText(str);
//                //etResponse.setText(json.toString(1));
//
////                Log.d("fname",json.getString("user_first_name").toString());
////                fname.setText((json.getString("user_first_name").toString()));
////                lname.setText(pd.getlName());
////                num.setText(pd.getPhoneNumber().toString());
////                aadhar.setText(pd.getaadharCardNum().toString());
////                address.setText(pd.getuserResidence());
////                city.setText(pd.getuserCity());
////                country.setText(pd.getuserCountry());
//
////                JSONArray data = json.getJSONArray("data");
////
////                fname.setText(data.getJSONObject(0).getString("user_first_name"));
////                Log.d("fname",data.getJSONObject(0).getString("user_first_name"));
//
//
//                JSONObject json = new JSONObject(result); // convert String to JSONObject
//                JSONArray data = json.getJSONArray("data"); // get articles array
//                for (int i = 0; i < data.length(); i++) {
//                    //tags.add(articles.getJSONObject(i).getString("tags"));
//                  //  fname.setText(data.getJSONObject(i).getString("user_first_name"));
//                    //Log.d("fname",data.getJSONObject(i).getString("user_first_name"));
//                    JSONObject jb1 = data.getJSONObject(i);
//                    fname.setText( jb1.getString("user_first_name"));
//                }
//
//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//}
// bhakti

