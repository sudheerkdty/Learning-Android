package test.zudheer.layout;

import java.util.ArrayList;

/**
 * Created by nuventure on 1/4/16.
 */
public class Imageloc_arrayList extends ArrayList<Integer> {

    static public ArrayList<Integer> imagedata = new ArrayList<Integer>();

    static {
        imagedata.add(R.drawable.img1);
        imagedata.add(R.drawable.img2);
        imagedata.add(R.drawable.img3);
        imagedata.add(R.drawable.img4);
        imagedata.add(R.drawable.img5);
        imagedata.add(R.drawable.img6);

    }
    public Imageloc_arrayList(){

    }
    public static void adddata(){

        ArrayList<Integer> imagedata1 = new ArrayList<Integer>();

        imagedata1.add(R.drawable.img1);
        imagedata1.add(R.drawable.img2);
        imagedata1.add(R.drawable.img3);
        imagedata1.add(R.drawable.img4);
        imagedata1.add(R.drawable.img5);
        imagedata1.add(R.drawable.img6);

        imagedata.addAll(imagedata1);

    }

}
