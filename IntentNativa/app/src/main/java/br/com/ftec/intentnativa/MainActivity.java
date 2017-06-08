package br.com.ftec.intentnativa;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int SELECIONAR_CONTATO = 10;
    private static final int VISUALIZAR_NOME_CONTATO = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btAbrirURL = (Button) findViewById(R.id.btAbrirURL);
        btAbrirURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Representa o endereço que se deseja abrir
                Uri uri = Uri.parse("http://code.google.com/android/");
                //Cria a intent com o endereço
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                //Envia a mensagem ao Android
                startActivity(it);
            }
        });

        Button btLigar = (Button) findViewById(R.id.btLigar);
        btLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Representa o número que deve ser ligado.
                Uri uri = Uri.parse("tel:9988888");
                //Cria a Intent com o telefone
                Intent it = new Intent(Intent.ACTION_CALL, uri);
                //Enviar a mensagem ao Android
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(it);

            }
        });

        Button btVisualizarContato = (Button) findViewById(R.id.btVisualizarContato);
        btVisualizarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Visualizar o contato de id 1 na lista de contatos.
                Uri uri = Uri.parse("content://com.android.contacts/contacts/1");
                //Cria a Intent com o telefone
                Intent it = new Intent(Intent.ACTION_VIEW , uri);
                //Envia mensagem
                startActivity(it);
            }
        });

        Button btVisualizarTodosContatos = (Button) findViewById(R.id.btVisualizarTodosContatos);
        btVisualizarTodosContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Visualizar todos os contato
                Uri uri = Uri.parse("content://com.android.contacts/contacts/");
                //Cria a Intent com o telefone
                Intent it = new Intent(Intent.ACTION_PICK, uri);
                //Envia mensagem para abrir o contato selecionado
                startActivityForResult(it, SELECIONAR_CONTATO);
            }
        });

        Button btVisualizarNomeDoContato = (Button) findViewById(R.id.btVisualizarNomeDoContato);
        btVisualizarNomeDoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Visualizar todos os contato
                Uri uri = Uri.parse("content://com.android.contacts/contacts/");
                //Cria a Intent com o telefone
                Intent it = new Intent(Intent.ACTION_PICK, uri);
                //Envia mensagem para abrir o contato selecionado
                startActivityForResult(it, VISUALIZAR_NOME_CONTATO);
            }
        });

        Button btSolicitarBuscaMapa = (Button) findViewById(R.id.btSolicitarBuscaMapa);
        btSolicitarBuscaMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriGeo = Uri.parse("geo:0,0?q=Ipiranga,+Porto+Alegre");
                Intent it = new Intent(Intent.ACTION_VIEW, uriGeo);
                startActivity(it);
            }
        });

        Button btBuscaCoordenadaEspecifica = (Button) findViewById(R.id.btBuscaCoordenadaEspecifica);
        btBuscaCoordenadaEspecifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriGeo = Uri.parse("geo:-30.035891, -51.214403");
                Intent it = new Intent(Intent.ACTION_VIEW, uriGeo);
                startActivity(it);
            }
        });

        Button btRotaEntreDoisPontos = (Button) findViewById(R.id.btRotaEntreDoisPontos);
        btRotaEntreDoisPontos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String partida = "-30.035891,-51.214403";
                String destino = "-30.025711,-51.220057";
                String url = "http://maps.google.com/maps?f=d&saddr="+partida+"&daddr="+destino+"&hl=pt";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url) ));
            }
        });

        Button btAbrirAudio = (Button) findViewById(R.id.btAbrirAudio);
        btAbrirAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("https://nerdcast.jovemnerd.com.br/nerdcast_559_tecnologias_do_futuro_3.mp3");
                Intent it = new Intent(Intent.ACTION_VIEW, link);
                it.setDataAndType(link, "audio/*");
                startActivity(it);
            }
        });


    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent intent) {
        Uri uri = intent.getData();
        if (codigo == SELECIONAR_CONTATO){
            //Exibe a uri do contato selecionado
            Toast.makeText(MainActivity.this, "Contato: " + uri, Toast.LENGTH_SHORT).show();
            //Abre o Contato pesquisado
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } else if (codigo == VISUALIZAR_NOME_CONTATO) {
            //Busca o contato no banco de dados utilizando a uri do contato selecionado
            Cursor c = getContentResolver().query(uri,null,null,null,null);
            //Posiciona o cursor
            c.moveToNext();
            //Recupera o nome do contato
            int nameColumn = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String nome = c.getString(nameColumn);
            Toast.makeText(this, "Nome: " + nome, Toast.LENGTH_SHORT).show();
            c.close();
        }


    }
}
