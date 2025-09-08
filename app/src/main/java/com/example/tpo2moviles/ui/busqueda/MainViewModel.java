package com.example.tpo2moviles.ui.busqueda;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo2moviles.R;
import com.example.tpo2moviles.modelo.Libro;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutableMensaje;
    private MutableLiveData<Libro> mLibro;
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public MainViewModel(@NonNull Application application) {
        super(application);

        Libro principito = new Libro("El Principito", "Antoine de Saint-Exupéry",
                120,1943,"Es un cuento poético y filosófico que narra la " +
                "historia de un pequeño príncipe que viaja desde su diminuto planeta a la Tierra, " +
                "encontrándose con distintos personajes que representan aspectos de la vida adulta: " +
                "el rey, el vanidoso, el bebedor, el hombre de negocios, entre otros." ,
                R.drawable.elprincipito);
        Libro anillos = new Libro("El Señor de los anillos","J. R. R. Tolkien",
                1200,1955,"Narra la misión de destruir el Anillo Único, " +
                "creado por Sauron, que amenaza con sumir a toda la Tierra Media en la oscuridad. " +
                "Protagonizada por Frodo Bolsón, acompañado por un grupo de héroes muy distintos " +
                "entre sí, la obra explora la lucha entre el bien y el mal, la amistad, la esperanza" +
                " y el sacrificio.", R.drawable.anillos);
        Libro cien = new Libro("Cien años de soledad", "Gabriel García Marquez",
                500, 1967,"Una obra maestra del realismo mágico que cuenta " +
                "la historia de la familia Buendía a lo largo de siete generaciones en el pueblo " +
                "ficticio de Macondo. La novela combina lo real y lo fantástico para explorar temas " +
                "como el destino, el poder, el amor, la soledad y la historia de América Latina.",
                R.drawable.cienanios);
        Libro harry = new Libro("Harry Potter y la piedra filosofal", "J. K. Rowling",
                300,1997,"Primer libro de la saga de Harry Potter. " +
                "Narra cómo un niño huérfano descubre en su undécimo cumpleaños que es un mago y " +
                "que está destinado a enfrentarse al mago oscuro Lord Voldemort. Mezcla fantasía, " +
                "aventuras y amistad en un mundo mágico que ha cautivado a generaciones enteras.",
                R.drawable.harry);
        Libro divina = new Libro("La Divina Comedia", "Dante Alighieri", 800,
                1308,"Poema épico en tres partes (Infierno, Purgatorio y Paraíso) " +
                "donde el protagonista viaja por el más allá guiado por Virgilio y Beatriz. Es una " +
                "reflexión sobre la justicia, la redención y la condición humana.", R.drawable.divinacomedia);

        listaLibros.add(principito);
        listaLibros.add(anillos);
        listaLibros.add(cien);
        listaLibros.add(harry);
        listaLibros.add(divina);

    }

    public LiveData<Libro> getMLibro() {
        if (mLibro == null){
            mLibro = new MutableLiveData<>();
        }
        return mLibro;
    }
    public LiveData<String> getMutableMensaje() {
        if(mutableMensaje == null){
            mutableMensaje = new MutableLiveData<>();
        }
        return mutableMensaje;
    }

    public void buscandoLibro(String titulo){
        int i = 0;
        Libro encontrado = null ;
        while(i < listaLibros.size() && encontrado == null){
            if(titulo.equalsIgnoreCase(listaLibros.get(i).getTitulo())){
                mLibro.setValue(listaLibros.get(i));
                encontrado = listaLibros.get(i);
            }
            i++;
        }
        if(encontrado == null){
            mutableMensaje.setValue("Libro no encontrado");
        }

    }

}
