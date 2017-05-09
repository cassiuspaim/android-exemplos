package br.com.ftec.cadusuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by CASSIUS on 06/05/2017.
 */

public class ListaUsuariosActivity extends AppCompatActivity{

    private int ID_MENU_EDITAR = 1;
    private int ID_MENU_EXCLUIR = 2;

    ListView listViewUsuarios;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_usuarios);

        //Configurações de Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle(getResources().getString(R.string.tela_lista_usuarios));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Captura list view
        listViewUsuarios = (ListView) findViewById(R.id.listViewUsuarios);

        //Registro o menu de contexto na list view
        registerForContextMenu(listViewUsuarios);

    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem menuEditar = menu.add(0, ID_MENU_EDITAR, 10, R.string.menu_editar);
        menuEditar.setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info
                        = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Usuario usuario = (Usuario) listViewUsuarios.getItemAtPosition(info.position);

                Intent it = new Intent(ListaUsuariosActivity.this, TelaCadastroUsuarioActivity.class);
                it.putExtra("usuario", usuario);
                startActivity(it);

                return false;
            }
        });

        MenuItem menuExcluir = menu.add(0, ID_MENU_EXCLUIR, 20, R.string.menu_excluir);
        menuExcluir
                .setOnMenuItemClickListener(
                        new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info
                        = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Usuario usuario = (Usuario) listViewUsuarios.getItemAtPosition(info.position);
                DAO.excluirUsuario(usuario);
                atualizarLista();
                return false;
            }

        });
    }

    private void atualizarLista() {
        //Cria um adapter
        UsuariosAdapter usuariosAdapter = new UsuariosAdapter(ListaUsuariosActivity.this, DAO.getListaDeUsuarios());
        //Configura o list view com o adapter
        listViewUsuarios.setAdapter(usuariosAdapter);
    }
}
