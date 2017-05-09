package br.com.ftec.cadusuario;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CASSIUS on 06/05/2017.
 */

public class UsuariosAdapter extends ArrayAdapter<Usuario>{

    AppCompatActivity contexto;

    public UsuariosAdapter(AppCompatActivity contexto,
                           List<Usuario> listaDeUsuarios) {
        super(contexto,
              R.layout.layout_de_linha_para_cada_usuario,
              listaDeUsuarios);

        this.contexto = contexto;

    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView =
                inflater.inflate(
                        R.layout.layout_de_linha_para_cada_usuario, null,true);

        Usuario usuario = (Usuario) getItem(position);

        TextView txtNome = (TextView) rowView.findViewById(R.id.usuarioNome);
        TextView txtEmail = (TextView) rowView.findViewById(R.id.usuarioEmail);

        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());

        return rowView;

    };
}
