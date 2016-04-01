package test.zudheer.layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nuventure on 1/4/16.
 */
public class HomeActivityFragment extends Fragment {
    ListView list;
    View rootView;
    listadapter adapter;
    public HomeActivityFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("fragment","started");
        rootView = inflater.inflate(R.layout.activity_main_fragment,container,false);


        return rootView;
    }
    @Override
    public void onResume(){
        super.onResume();

    }
    public void initializeList(){


        list = (ListView)rootView.findViewById(R.id.list);
        //lists = new Imageloc_arrayList();
        adapter = new listadapter(getActivity(),Imageloc_arrayList.imagedata);
        list.setAdapter(adapter);


        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            //useless here, skip!
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            //dumdumdum
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                //what is the bottom iten that is visible
                int lastInScreen = firstVisibleItem + visibleItemCount;
                //is the bottom item visible & not loading more already ? Load more !
                if (((lastInScreen) == totalItemCount)) {

                    new AsyncTask_infinitescroll_listview().execute(adapter);
                    //adapter.notifyDataSetInvalidated();
                    //list.notifyAll();
                    //adapter.notifyDataSetChanged();
                }
            }
        });

    }


}

