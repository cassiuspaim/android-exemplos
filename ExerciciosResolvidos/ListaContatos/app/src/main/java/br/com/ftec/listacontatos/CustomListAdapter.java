package br.com.ftec.listacontatos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CASSIUS on 23/04/2017.
 */

class CustomListAdapter extends ArrayAdapter<Contato> {
    private final Activity contexto;
    private final Contato[] contatos;

    public CustomListAdapter(Activity contexto, Contato[] contatos) {
        super(contexto, R.layout.mylist, contatos);

        this.contexto = contexto;
        this.contatos = contatos;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null,true);

        Contato contato = getItem(position);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nomeExibicao);
        TextView extratxt = (TextView) rowView.findViewById(R.id.profissao);
        ImageView ivTrofeu = (ImageView) rowView.findViewById(R.id.trofeu);

        ivTrofeu.setVisibility(View.INVISIBLE);
        if (contato.hasTrofeu()){
            ivTrofeu.setVisibility(View.VISIBLE);
        }
        txtTitle.setText(contato.getUltimoNome() + ", " + contato.getPrimeiroNome());
        extratxt.setText("Contato: " + contato.getProfissao());
        return rowView;

    };
}
