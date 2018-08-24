package com.example.lalit.eventit;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrgCardView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrgCardView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrgCardView extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // private OnFragmentInteractionListener mListener;
    ArrayList<String> tags = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();
    RecyclerView MyRecyclerView;
    // String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    // int  Images[] = {R.drawable.swoopzi,R.drawable.ic_google,R.drawable.swoopzi,R.drawable.swoopzi,R.drawable.swoopzi,R.drawable.swoopzi,R.drawable.swoopzi};
    MyAdapter madp;
    public FrgCardView() {
        // Required empty public constructor
        //  MyRecyclerView.setAdapter(madp);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrgCardView.
     */
    // TODO: Rename and change types and number of parameters
    public static FrgCardView newInstance(String param1, String param2) {
        FrgCardView fragment = new FrgCardView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getActivity().setTitle("Events");

//initializeList();
        //MyRecyclerView.setAdapter(madp);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_card_view, container, false);
        MyRecyclerView =  view.findViewById(R.id.cardView);

        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MyRecyclerView.setLayoutManager(MyLayoutManager);
        new HttpAsyncTask().execute("http://hmkcode.appspot.com/rest/controller/get.json");
//        try {
//            // get JSONObject from JSON file
////            JSONObject obj = new JSONObject(loadJSONFromAsset());
////            // fetch JSONArray named users
////            JSONArray userArray = obj.getJSONArray("articleList");
////            // implement for loop for getting users list data
//            JSONObject json = new JSONObject(loadJSONFromAsset()); // convert String to JSONObject
//            JSONArray articles = json.getJSONArray("articleList"); // get articles array
//            for (int i = 0; i < articles.length(); i++) {
//                // create a JSONObject for fetching single user data
////                JSONObject userDetail = userArray.getJSONObject(i);
////                // fetch email and name and store it in arraylist
////                tags.add(userDetail.getString("tags"));
////                // create a object for getting contact data from JSONObject
////                JSONObject contact = userDetail.getJSONObject("contact");
////                // fetch mobile number and store it in arraylist
////                mobileNumbers.add(contact.getString("mobile"));
//
//
//             //   articles.length(); // --> 2
////                articles.getJSONObject(0) // get first article in the array
////                articles.getJSONObject(0).names() // get first article keys [title,url,categories,tags]
//
//                tags.add(articles.getJSONObject(i).getString("tags"));
//                categories.add(articles.getJSONObject(i).getString("categories"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        //MyRecyclerView.setAdapter(new MyAdapter(listitems));
//        if (listitems.size()  > 0 & MyRecyclerView != null) {
//            MyRecyclerView.setAdapter(new MyAdapter(listitems));
//            // madp.notifyDataSetChanged();
//        }


        return view;
    }

    //    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//            InputStream is = getAssets().open("http://hmkcode.appspot.com/rest/controller/get.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, String,String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getContext(), "Received!", Toast.LENGTH_LONG).show();
//            try {
//                JSONObject json = new JSONObject(result);
//
//                String str = "";
//
//                JSONArray articles = json.getJSONArray("articleList");
//                str += "articles length = "+json.getJSONArray("articleList").length();
//                str += "\n--------\n";
//                str += "names: "+articles.getJSONObject(0).names();
//                str += "\n--------\n";
//                str += "url: "+articles.getJSONObject(0).getString("url");
//
//                etResponse.setText(str);
//                //etResponse.setText(json.toString(1));
//
//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            try{
                // get JSONObject from JSON file
//            JSONObject obj = new JSONObject(loadJSONFromAsset());
//            // fetch JSONArray named users
//            JSONArray userArray = obj.getJSONArray("articleList");
//            // implement for loop for getting users list data
                JSONObject json = new JSONObject(result); // convert String to JSONObject
                JSONArray articles = json.getJSONArray("articleList"); // get articles array
                for (int i = 0; i < articles.length(); i++) {
                    // create a JSONObject for fetching single user data
//                JSONObject userDetail = userArray.getJSONObject(i);
//                // fetch email and name and store it in arraylist
//                tags.add(userDetail.getString("tags"));
//                // create a object for getting contact data from JSONObject
//                JSONObject contact = userDetail.getJSONObject("contact");
//                // fetch mobile number and store it in arraylist
//                mobileNumbers.add(contact.getString("mobile"));


                    //   articles.length(); // --> 2
//                articles.getJSONObject(0) // get first article in the array
//                articles.getJSONObject(0).names() // get first article keys [title,url,categories,tags]

                    tags.add(articles.getJSONObject(i).getString("tags"));
                    categories.add(articles.getJSONObject(i).getString("categories"));
                }
                MyAdapter customAdapter = new MyAdapter(getContext(),tags, categories);
                MyRecyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



//        @Override
//        protected void onPostExecute(Void aVoid) {
//           madp.notifyDataSetChanged();
//        }
    }
    public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        //  private ArrayList<WonderModel> list;
        ArrayList<String> tags;
        ArrayList<String> categories;

        Context context;

        public MyAdapter(Context context, ArrayList<String> tags, ArrayList<String> categories) {
            this.context = context;
            this.tags=tags;
            this.categories=categories;
        }

//        public MyAdapter(ArrayList<WonderModel> Data) {
//            list = Data;
//        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_frg_recycle_view, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            holder.titleTextView.setText(tags.get(position));
            holder.dateTextView.setText(categories.get(position));
            // holder.coverImageView.setImageResource(list.get(position).getImageResourceId());
            //holder.coverImageView.setTag(list.get(position).getImageResourceId());
            // holder.likeImageView.setTag(R.drawable.ic_like);

        }

        @Override
        public int getItemCount() {
            return tags.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView titleTextView;
            public TextView dateTextView;
            public ImageView coverImageView;
            public ImageView viewImageView;
            public ImageView editImageView;
            public ImageView analysisImageView;
            public ImageView memberImageView;
            public ImageView notifyImageView;
            public ImageView deleteImageView;
            public MyViewHolder(View v) {
                super(v);
                titleTextView = (TextView) v.findViewById(R.id.titleTextView);
                dateTextView=v.findViewById(R.id.dateTextView);
                coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
                viewImageView = (ImageView) v.findViewById(R.id.viewImageView);
                editImageView = (ImageView) v.findViewById(R.id.editImageView);
                analysisImageView=(ImageView)v.findViewById(R.id.analysisImageView);
               memberImageView=v.findViewById(R.id.memberImageView);
               notifyImageView=v.findViewById(R.id.notifyImageView);
               deleteImageView=v.findViewById(R.id.deleteImageView);

                viewImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getActivity()," View",Toast.LENGTH_SHORT).show();
//                    int id = (int)likeImageView.getTag();
//                    if( id == R.drawable.ic_view){
//
//                        //likeImageView.setTag(R.drawable.ic_liked);
//                        //likeImageView.setImageResource(R.drawable.ic_liked);
//
//                        Toast.makeText(getActivity(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();
//
//                    }else if(id == R.drawable.ic_edit){
//
//                        //likeImageView.setTag(R.drawable.ic_like);
//                        //likeImageView.setImageResource(R.drawable.ic_like);
//                        Toast.makeText(getActivity(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();
//
//
//                    }
                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgCreatedEvents()).addToBackStack(null).commit();
                    }
                });



                editImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Toast.makeText(getActivity()," Edit",Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgEditEvent()).commit();
//                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
//                            "://" + getResources().getResourcePackageName(coverImageView.getId())
//                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
//
//
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
                    }
                });

                analysisImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Toast.makeText(getActivity()," Analysis",Toast.LENGTH_SHORT).show();
//                        getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgEditEvent()).commit();
//                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
//                            "://" + getResources().getResourcePackageName(coverImageView.getId())
//                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
//
//
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));

// By Vishant

                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgAnalytic()).commit();
                    }
                });

                memberImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Toast.makeText(getActivity()," Member",Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgAddMemebers()).commit();
                        //getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgEditEvent()).commit();
//                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
//                            "://" + getResources().getResourcePackageName(coverImageView.getId())
//                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
//
//
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
                    }
                });

                notifyImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Toast.makeText(getActivity()," notify",Toast.LENGTH_SHORT).show();
                        showNotifyDialog();
                        //getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgEditEvent()).commit();
//                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
//                            "://" + getResources().getResourcePackageName(coverImageView.getId())
//                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
//
//
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
                    }
                });

                deleteImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Toast.makeText(getActivity()," Delete",Toast.LENGTH_SHORT).show();
                      //  getFragmentManager().beginTransaction().replace(R.id.rlMain,new FrgEditEvent()).commit();
//                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
//                            "://" + getResources().getResourcePackageName(coverImageView.getId())
//                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
//
//
//                    Intent shareIntent = new Intent();
//                    shareIntent.setAction(Intent.ACTION_SEND);
//                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
//                    shareIntent.setType("image/jpeg");
//                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
                    }
                });

            }
        }
    }


//    public void initializeList() {
//        listitems.clear();
//
//        for(int i =0;i<7;i++){
//
//
//            WonderModel item = new WonderModel();
//            item.setCardName(Wonders[i]);
//            item.setImageResourceId(Images[i]);
//            item.setIsfav(0);
//            item.setIsturned(0);
//            listitems.add(item);
//
//        }
    //Add notify code
protected void showNotifyDialog() {

    // get prompts.xml view
    LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
    View promptView = layoutInflater.inflate(R.layout.announce_dialog_main, null);
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
    alertDialogBuilder.setView(promptView);


    final EditText etAddAnnounce=promptView.findViewById(R.id.etAddAnnounce);

    // setup a dialog window
    alertDialogBuilder.setCancelable(false)
            .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(getActivity(), etAddAnnounce.getText(), Toast.LENGTH_SHORT).show();


                }
            })
            .setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

    // create an alert dialog
    AlertDialog alert = alertDialogBuilder.create();
    alert.show();
}
    //add notify code
}
// TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }


