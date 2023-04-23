package edu.hanu.tut10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.core.os.HandlerCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import edu.hanu.tut10.model.Constant;


public class ProfileFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int id = getArguments().getInt("ID");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtEmail = view.findViewById(R.id.txtEmail);
        ImageView imageView= view.findViewById(R.id.avatar);
        Handler handler= HandlerCompat.createAsync(Looper.getMainLooper());
        Constant.executor.execute(new Runnable() {
            @Override
            public void run() {
                // do something takes time
                // load json from api
                // pass json for name and email
                String json= loadJson("https://jsonplaceholder.typicode.com/users/"+id);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // where you can interact with the ui

                        if(json == null){
                            Toast.makeText(getActivity(),"Oops! Failed to load json", Toast.LENGTH_LONG).show();
                        }else{
                            // parse json for name and email
                            // update ui with name and email
                            try {
                                JSONObject root = new JSONObject(json);
                                String name = root.getString("name");
//                                JSONObject company = root.getJSONObject("company");
//                               String name = company.getString("name");
                                String email = root.getString("email");

                                // update ui
                                txtName.setText(name);
                                txtEmail.setText(email);

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                });
            }
        });
        Constant.executor.execute(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap= downloadImage("https://robohash.org/"+id+"?set=set2");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(bitmap== null){
                            Toast.makeText(getActivity(), "Oops, failed to download the image", Toast.LENGTH_SHORT).show();
                        }else{
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        });
        return view;
    }
    public String loadJson(String link){
        URL url;
        HttpURLConnection urlConnection;
        try{
            // connect to url
            url= new URL(link);
            urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            // take input stream
            InputStream is= urlConnection.getInputStream();
            // read data as stream
            Scanner scanner= new Scanner(is);
            StringBuilder result = new StringBuilder();
            String line;
            while(scanner.hasNext()){
                line= scanner.nextLine();
                result.append(line);
            }
            Log.i("RESULT", "" + result);
            return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap downloadImage(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}