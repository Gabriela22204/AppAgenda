package br.edu.qi.breduqiAppAgenda.model;

import android.content.ContentValues;
import android.content.Context;

public class ContatoDao {
    private static String TABLE_agenda = "AGENDA";
    private DBGateway dbG;

    public ContatoDao(Context ctx) {
        this.dbG = DBGateway.getInstance(ctx);

    }
    public  boolean save(Contato contato) {
        ContentValues cv = new ContentValues();

        cv.put("NOME", contato.getNome());
        cv.put("TELEFONE", contato.getTelefone());

        return this.dbG.getDatabase().insert(TABLE_agenda, null, cv) > 0 ;

    }
}
