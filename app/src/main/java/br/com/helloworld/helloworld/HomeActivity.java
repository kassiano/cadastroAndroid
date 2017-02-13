package br.com.helloworld.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView text_nome_usuario, text_email_usuario;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        text_nome_usuario = (TextView) findViewById(R.id.text_nome_usuario);
        text_email_usuario = (TextView) findViewById(R.id.text_email_usuario);

        String nomeUsuario = sharedPreferences.getString("nomeUsuario", "");
        String emailUsuario = sharedPreferences.getString("emailUsuario","");

        Intent intent = getIntent();

        /*
        String nomeUsuario = intent.getStringExtra("nomeUsuario");
        String emailUsuario = intent.getStringExtra("emailUsuario");

        Usuario usuarioLogado = (Usuario)intent.getSerializableExtra("usuarioLogado");
        */
        text_nome_usuario.setText(nomeUsuario);
        text_email_usuario.setText(emailUsuario);
    }
}
