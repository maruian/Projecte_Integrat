package com.example.paco.projecte_integrat.Model;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by Paco on 07/01/2018.
 */

public class DBControl {




    private Context context;
   // private interfazLogin comunicacionLogin;


    private FirebaseStorage storage;
    private FirebaseAuth auth;
    private StorageReference imagesRef, nameRef;
    private UploadTask uploadTask;


    //En el constructor obtenemos contexto de la actividad por si se necesita
    public DBControl(Context c){
        context = c;
    }

    /*
     *   Métodos
     */


    //Método para registrar un usuario
    public void registrarUsuario(String correo, String pass){

        //Obtenemos instancia de FireBaseAuth
        auth = FirebaseAuth.getInstance();

        //Registramos al usuario
        auth.createUserWithEmailAndPassword(correo, pass).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    //No queremos que se quede logueado el usuario, por lo que desautenticaremos
                    auth.signOut();

                    Toast.makeText(context, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "No se ha podido registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Método para loguear un usuario
    public void loginUsuario(String correo, String pass){
        //Obtenemos instancia
        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(correo, pass)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Si se loguea correctamente

                            //comunicarnos con el activity
                        } else {
                            //Si no se loguea correctamente

                            //comunicarnos con el activity
                        }
                    }
                });


    }

    //Método para guardar una imagen de la galería
    public void guardarImagen(Uri file){

        //Inicializamos objetos necesarios
        storage = FirebaseStorage.getInstance();
        imagesRef = storage.getReference().child("imagenesProductos");       //Referencia a "directorio" imágenes para guardarlas ahí

        nameRef = imagesRef.child(file.getLastPathSegment());

        uploadTask = nameRef.putFile(file);

        //Con esto comprobamos si se ha añadido con éxito o no
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //Si no se ha podido almacenar
                Toast.makeText(context, "No se ha podido guardar la imagen", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //Si se ha subido correctamente
                Toast.makeText(context, "Imagen almacenada con éxito", Toast.LENGTH_SHORT).show();
            }
        });
    }

   /* public void getLoginContext(Context c){
        comunicacionLogin = (interfazLogin) c;
    }

    public interface interfazLogin{
        void loginCorrecto();
        void loginIncorrecto();
        void sendUsername(String username);
    }
    */

}
