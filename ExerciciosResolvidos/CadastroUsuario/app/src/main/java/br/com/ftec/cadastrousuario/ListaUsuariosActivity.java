package br.com.ftec.cadastrousuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaUsuariosActivity extends AppCompatActivity {

    private static final int ID_MENU_EDITAR_USUARIO = 1;
    private static final int ID_MENU_EXCLUIR_USUARIO = 2;
    private ListView lista_contatos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle(getResources().getString(R.string.tela_lista_usuarios));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista_contatos = (ListView) findViewById(R.id.lista_contatos);

        // Registra o menu de contexto
        registerForContextMenu(lista_contatos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista(){
        lista_contatos.setAdapter(new CustomListAdapter(this, (ArrayList<Usuario>) DAO.getUsuarios()));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem menuEditar = menu.add(0, ID_MENU_EDITAR_USUARIO, 10, R.string.editarUsuario);
        menuEditar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                AdapterView.AdapterContextMenuInfo info
                        = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Usuario usuario = (Usuario) lista_contatos.getItemAtPosition(info.position);

                Intent it = new Intent(ListaUsuariosActivity.this, TelaCadastroUsuario.class);
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
                Usuario usuario = (Usuario) lista_contatos.getItemAtPosition(info.position);
                DAO.excluirUsuario(usuario);
                atualizarLista();
                return false;
            }
        });
    }

}
