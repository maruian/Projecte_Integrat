package com.example.paco.projecte_integrat;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.paco.projecte_integrat.Fragments.LoginFragment;

public class MainActivity extends AppCompatActivity  {
    private Button botonAcceder;
    private EditText nombreUsuario;
    private EditText contraseñaUsuario;
    private ImageButton registroFacebook;
    private ImageButton registroGmail;

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Añadimos comentario prueba


        //Cargamos el fragmento de login
        lanzarFragmentLogin();

    }

    private void lanzarFragmentLogin(){
        fm = getSupportFragmentManager();

        ft = fm.beginTransaction();

        ft.add(R.id.espaiFragment, LoginFragment.newInstance());

        ft.commit();
    }


}
