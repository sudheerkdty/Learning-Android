package test.zudheer.layout;

import android.os.AsyncTask;
import android.widget.Adapter;

/**
 * Created by nuventure on 1/4/16.
 */
public class AsyncTask_infinitescroll_listview extends AsyncTask<listadapter,Void, listadapter> {
    @Override
    protected listadapter doInBackground(listadapter... params) {
        listadapter adapter = params[0];
        Imageloc_arrayList.adddata();

        return adapter;
    }

    @Override
    protected void onPostExecute(listadapter adapter){
        adapter.notifyDataSetChanged();
    }



}
