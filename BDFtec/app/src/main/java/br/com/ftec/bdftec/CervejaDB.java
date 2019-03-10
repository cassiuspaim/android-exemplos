package br.com.ftec.bdftec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CASSIUS on 18/05/2017.
 */

class CervejaDB extends SQLiteOpenHelper {

    private static final
        String NOME_BANCO_DE_DADOS = "sql_cerveja.sqlite";
    private static final int VERSAO_BANCO_DE_DADOS = 2;
    private static final String TAG = "CERVEJA_DB";

    public CervejaDB(Context context) {
        super(context,
                NOME_BANCO_DE_DADOS,
                null,
                VERSAO_BANCO_DE_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        Log.d(TAG, "Criando a Tabela CERVEJA...");
        sql = "CREATE TABLE CERVEJA(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOME VARCHAR(50), " +
                "QUANTIDADE INTEGER, "+
                "TIPO VARCHAR(40));";
        db.execSQL(sql);
        Log.d(TAG, "Tabela CERVEJA criada com sucesso.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        Log.d(TAG, "Chamando método onUpgrade");
    }

    public boolean salvar(Cerveja cerveja) {
        long id = cerveja.getId();
        // Retorna um banco de dados que escreve os dados
        SQLiteDatabase db = getWritableDatabase();

        try{
            //conjunto de chave e valor para os dados que
            //serão persistidos no banco de dados
            ContentValues values = new ContentValues();
            values.put("NOME", cerveja.getNome());
            values.put("QUANTIDADE", cerveja.getQuantidade() );
            values.put("TIPO", cerveja.getTipo());

            if (id != 0) {
                String _id = String.valueOf(cerveja.getId());
                String[] whereArgs = new String[]{_id};

                //update cerveja set values = ... where _id=?
                long registrosAfetados =
                        db.update("CERVEJA",
                                values,
                                "_ID = ?",
                                whereArgs);
                return registrosAfetados > 0;
            } else {
                // insert into cerveja values (...)
                return db.insert("CERVEJA", "", values) > 0;
            }

        } finally {
            db.close();
        }

    }

    public boolean excluir(Cerveja cerveja){
        // Retorna um banco de dados que escreve os dados
        SQLiteDatabase db = getWritableDatabase();

        try {
            //delete from cerveja where _id=?
            int registrosAfetados
                    = db.delete("CERVEJA",
                                "_ID=?",
                                new String[]{String.valueOf(cerveja.getId())});
            Log.i(TAG, "Excluiu [" + registrosAfetados + "] registro(s).");
            return registrosAfetados > 0;
        } finally {
            db.close();
        }
    }

    public List<Cerveja> retornaTodos(){
        SQLiteDatabase db = getReadableDatabase();
        try {
            //select * from cerveja
            Cursor c = db.query("CERVEJA",
                        null,
                        null,
                        null, null, null, null, null);

            return conversaoParaLista(c);
        } finally {
            db.close();
        }
    }

    private List<Cerveja> conversaoParaLista(Cursor c) {

        List<Cerveja> engradado = new ArrayList<Cerveja>();

        if (c.moveToFirst()) {
            do {
                Cerveja cerveja = new Cerveja();
                engradado.add(cerveja);

                //recupera os atributos da cerveja
                cerveja.setId(c.getLong(c.getColumnIndex("_ID")));
                cerveja.setNome(c.getString(c.getColumnIndex("NOME")));
                cerveja.setQuantidade(c.getInt(c.getColumnIndex("QUANTIDADE")) );
                cerveja.setTipo( c.getString( c.getColumnIndex("TIPO") ));

            } while(c.moveToNext() );
        }
        return engradado;
    }
}
