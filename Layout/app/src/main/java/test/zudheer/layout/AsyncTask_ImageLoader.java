package test.zudheer.layout;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nuventure on 1/4/16.
 */
public class AsyncTask_ImageLoader extends AsyncTask<Integer,Void,ArrayList<Integer>>{

    View view;
    ImageView Image1,Image2;
    Integer Res_id,position;
    TextView caption1,caption2;
    ArrayList<Integer> array = new ArrayList<>();

    public AsyncTask_ImageLoader(){

    }



    public AsyncTask_ImageLoader(View view,ImageView image1,ImageView image2, TextView textView1, TextView textView2
                                      , ArrayList<Integer> array, Integer position){
        this.view = view;
        this.Image1 = image1;
        this.Image2 = image2;
        this.caption1 = textView1;
        this.caption2 = textView2;
        this.array = array;
        this.position = position;

        caption1.setText(""+(position*2)+"");
        caption2.setText(""+((position*2)+1)+"");

    }
    @Override
    protected ArrayList<Integer> doInBackground(Integer... params) {
        ArrayList<Integer> array1 = new ArrayList<>();
        Integer pos = params[0];
        array1.add(array.get(pos*2));

        array1.add(array.get((pos*2)+1));

        return array1;
    }
    protected void onPostExecute(ArrayList<Integer> result){


        Image1.setImageResource(result.get(0));
        Image2.setImageResource(result.get(1));
    }
}
