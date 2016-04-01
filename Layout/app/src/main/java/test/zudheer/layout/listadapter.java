package test.zudheer.layout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nuventure on 1/4/16.
 */
public class listadapter extends ArrayAdapter<Integer> {

    Activity activity;
    Context context;
    ArrayList<Integer> arrayList;
    ImageView image1, image2;
    TextView caption1, caption2;

    public listadapter(Activity activity,ArrayList<Integer> arrayList) {
        super(activity,R.layout.listview_adapter);
        this.activity = activity;
        this.arrayList = arrayList;
    }
    @Override
    public View getView(int position,View view, ViewGroup parent){
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_adapter,null,true);

        image1 = (ImageView) rowView.findViewById(R.id.imageview1);
        image2 = (ImageView) rowView.findViewById(R.id.imageview2);
        caption1 = (TextView) rowView.findViewById(R.id.textvew1);
        caption2 = (TextView) rowView.findViewById(R.id.textvew2);

        AsyncTask_ImageLoader asyncTask_imageLoader = new AsyncTask_ImageLoader(rowView,image1,image2,caption1,caption2,arrayList,position);
        asyncTask_imageLoader.execute(position);

        //caption1.setText(""+(position*2)+"");
        //caption2.setText(""+((position*2)+1)+"");
        //image1.setImageResource(arrayList.get(position * 2));
        //image2.setImageResource(arrayList.get(position*2)+1);

        return rowView;
    }


    @Override
    public int getCount() {

        return arrayList.size() / 2;

    }

}

