package br.edu.qi.breduqiAppAgenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.qi.breduqiAppAgenda.model.Contato;
import br.edu.qi.breduqiAppAgenda.model.ContatoDao;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Button btGravar = (Button) findViewById(R.id.btGravar);
        EditText edNome = (EditText) findViewById(R.id.edNome);
        EditText edFone = (EditText) findViewById(R.id.edFone);

        btGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contato contato = new Contato(edNome.getText().toString(), edFone.getText().toString());

                ContatoDao dao = new ContatoDao(getBaseContext());

                if (dao.save(contato) ) {
                    Toast.makeText(getBaseContext(), "Gravação com sucesso", Toast.LENGTH_SHORT);
                    finish();;
                } else
                    Toast.makeText(getBaseContext(), "Falha na gravação", Toast.LENGTH_SHORT);

            }
        });
    }
}