package br.com.ftec.appexemplotoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarUsuariosActivity extends AppCompatActivity {

    private static final int ID_MENU_EDITAR_USUARIO = 1;
    private static final int ID_MENU_EXCLUIR_USUARIO = 2;
    private ListView lista_usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        lista_usuarios = (ListView) findViewById(R.id.lista_usuarios);

        registerForContextMenu(lista_usuarios);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista(){
        lista_usuarios.setAdapter(new CustomListAdapter(this, (ArrayList<Usuario>) DAO.getUsuarios()));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem menuEditar = menu.add(0, ID_MENU_EDITAR_USUARIO,
                10,
                R.string.editarUsuario);
        menuEditar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                AdapterView.AdapterContextMenuInfo info
                        = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Usuario usuario = (Usuario) lista_usuarios.getItemAtPosition(info.position);

                Intent it = new Intent(ListarUsuariosActivity.this,
                        TelaCadastroUsuarioActivity.class);
                it.putExtra("usuario", usuario);

                startActivity(it);

                return false;
            }
        });

        MenuItem menuExcluir = menu.add(0, ID_MENU_EXCLUIR_USUARIO, 10, R.string.excluirUsuario);
        menuExcluir.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info
                        = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Usuario usuario = (Usuario) lista_usuarios.getItemAtPosition(info.position);
                DAO.excluirUsuario(usuario);
                atualizarLista();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
