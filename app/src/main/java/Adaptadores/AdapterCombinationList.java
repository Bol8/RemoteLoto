package Adaptadores;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.app.oscar.pruebadescargafichero.R;

/**
 * Created by Oscar on 20/10/2016.
 */

public class AdapterCombinationList extends SimpleCursorAdapter {


    public AdapterCombinationList(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);




    }



    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);

        ViewHolder holder = (ViewHolder) view.getTag();
        if(holder == null){
            holder = new ViewHolder();
           // holder.listTab = view.findViewById(R.id.row_text);
            view.setTag(holder);
        }

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }


    static class ViewHolder{
        //almacena el indx de la columna
        int colImp;

        //store the view
        View listTab;
    }
}
