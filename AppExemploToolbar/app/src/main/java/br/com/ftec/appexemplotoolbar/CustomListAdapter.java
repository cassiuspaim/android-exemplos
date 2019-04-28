package br.com.ftec.appexemplotoolbar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CASSIUS on 23/04/2017.
 */

class CustomListAdapter extends ArrayAdapter<Usuario> {
    private final Activity contexto;
    private final ArrayList<Usuario> usuarios;

    public CustomListAdapter(Activity contexto, ArrayList<Usuario> usuarios) {
        super(contexto, R.layout.layout_elemento_lista, usuarios);

        this.contexto = contexto;
        this.usuarios = usuarios;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout_elemento_lista, null,true);

        Usuario usuario = (Usuario) getItem(position);

        TextView txtNome = (TextView) rowView.findViewById(R.id.usuarioNome);
        TextView txtEmail = (TextView) rowView.findViewById(R.id.usuarioEmail);

        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());

        return rowView;

    };
}
