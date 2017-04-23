package br.com.ftec.customlistviewimagetext;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CASSIUS on 18/04/2017.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity contexto;
    private final String[] items;
    private final Integer[] imagens;

    public CustomListAdapter(Activity context,
                             String[] items,
                             Integer[] imagens) {

        super(context, R.layout.mylist, items);
        // TODO Auto-generated constructor stub

        this.contexto = context;
        this.items = items;
        this.imagens = imagens;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(items[position]);
        imageView.setImageResource(imagens[position]);
        extratxt.setText("Description "+ items[position]);
        return rowView;

    };
}
