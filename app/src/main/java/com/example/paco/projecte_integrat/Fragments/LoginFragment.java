package com.example.paco.projecte_integrat.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.paco.projecte_integrat.Model.DBControl;
import com.example.paco.projecte_integrat.R;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText cajaCorreo, cajaPassword;
    private Button botonAcceso, botonRegistro;
    private ImageButton botonFacebook, botonGmail;

    private DBControl dbControl;

    //Es necesario un constructor vacío
    public LoginFragment() {

    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

        //Bundle args = new Bundle();    -- No necesitamos parámetros
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Aquí recuperaríamos datos en caso de que fuera necesario
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflamos el layout
        return inflater.inflate(R.layout.fragment_login, container, false);


    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        //Recuperamos elementos del layout
        cajaCorreo = (EditText)view.findViewById(R.id.cajaCorreo);
        cajaPassword = (EditText)view.findViewById(R.id.cajaContrasenya);
        botonAcceso = (Button)view.findViewById(R.id.botonAcceder);
        botonRegistro = (Button)view.findViewById(R.id.botonRegistrar);
        botonFacebook = (ImageButton)view.findViewById(R.id.imageButtonFacebook);
        botonGmail = (ImageButton)view.findViewById(R.id.imageButtonGmail);

        dbControl = new DBControl(getActivity().getApplicationContext());

        botonAcceso.setOnClickListener(this);
        botonRegistro.setOnClickListener(this);
        botonFacebook.setOnClickListener(this);
        botonGmail.setOnClickListener(this);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    //Evento onClick para los botones
    public void onClick(View v) {
        if(v.getId() == R.id.botonAcceder){

        }
        else if(v.getId() == R.id.botonRegistrar){

        }
        else if(v.getId() == R.id.imageButtonFacebook){

        }
        else if(v.getId() == R.id.imageButtonGmail){

        }
    }

}
