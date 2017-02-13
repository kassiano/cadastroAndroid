package br.com.helloworld.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {


    /*

        ALTERAÇÃO GIT 13/02/2017

     */

    EditText edit_login, edit_senha;

    SharedPreferences sharedPreferences;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context  = this;

        sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);

        edit_login = (EditText) findViewById(R.id.edit_login);
        edit_senha = (EditText) findViewById(R.id.edit_senha);
    }

    public void efetuarLogin(View view) {

        final String login = edit_login.getText().toString();
        final String senha = edit_senha.getText().toString();


        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                String url = "http://10.107.144.20/cadastroAndroid/login.php";

                HashMap<String, String> parametros = new HashMap<>();
                parametros.put("email", login);
                parametros.put("senha", senha);


                String retorno = Http.post(url, parametros);

                Log.d("efetuarLogin", retorno);


                Gson gson = new Gson();
                Usuario usuarioLogado = gson.fromJson(retorno, Usuario.class);

                Log.d("efetuarLogin", usuarioLogado.getNome());



                //Sessao.usuarioLogado = usuarioLogado;

                sharedPreferences.edit()
                        .putString("emailUsuario",usuarioLogado.getEmail())
                        .apply();

                sharedPreferences.edit()
                        .putString("nomeUsuario",usuarioLogado.getNome())
                        .apply();

                Intent intent = new Intent(context, HomeActivity.class);

                /*intent.putExtra("nomeUsuario", usuarioLogado.getNome());
                intent.putExtra("emailUsuario", usuarioLogado.getEmail());

                ;intent.putExtra("usuarioLogado", usuarioLogado);
                */
                startActivity(intent);


                return null;
            }
        }.execute();

    }

    public void telaCadastro(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
