package com.example.tpo2moviles.ui.detalle;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo2moviles.modelo.Libro;

public class DetalleViewModel extends AndroidViewModel {

    private MutableLiveData<Libro> mutableLibro;

    public DetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getMutableLibro(){
        if(mutableLibro == null){
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }

    public void cargarDatosLibro(Intent intent){
        Libro libro =(Libro) intent.getSerializableExtra("libro");
        if(libro != null){
            mutableLibro.setValue(libro);
        }
    }

}
