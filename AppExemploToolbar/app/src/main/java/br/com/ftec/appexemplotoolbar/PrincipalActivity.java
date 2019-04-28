package br.com.ftec.appexemplotoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle(getResources().getString(R.string.menu_principal));
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater(); //Retorna o inflater de menu
        menuInflater.inflate(R.menu.menu, menu);       //Atribui ao menu(res/menu/menu.xml) a view
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:

                startActivity(new Intent(PrincipalActivity.this,
                        TelaCadastroUsuarioActivity.class));
                return true;
            case R.id.menu_list:
                startActivity(new Intent(PrincipalActivity.this,
                        ListarUsuariosActivity.class));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
