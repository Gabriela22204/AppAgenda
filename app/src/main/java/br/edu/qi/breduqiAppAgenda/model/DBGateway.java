package br.edu.qi.breduqiAppAgenda.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBGateway {
    private static DBGateway dbG;
    private SQLiteDatabase db;

    private DBGateway (Context ctx) {
        DBHelper helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();


    }
    public static DBGateway getInstance(Context ctx) {
        if (dbG == null)
            dbG = new DBGateway(ctx);
        return dbG;

    }
    public SQLiteDatabase getDatabase() {
        return this.db;
    }
}
