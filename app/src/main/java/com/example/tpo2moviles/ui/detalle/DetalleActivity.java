package com.example.tpo2moviles.ui.detalle;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2moviles.R;
import com.example.tpo2moviles.databinding.ActivityDetalleBinding;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding2;
    private DetalleViewModel dVModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding2 = ActivityDetalleBinding.inflate(getLayoutInflater());
        dVModel = new ViewModelProvider(this).get(DetalleViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(binding2.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dVModel.getMutableLibro().observe(this, libro -> {

            binding2.tvTitulo.setText(libro.getTitulo());
            binding2.tvAutor.setText(libro.getAutor());
            binding2.tvAnio.setText(String.valueOf(libro.getAnio()));
            binding2.tvPaginas.setText(String.valueOf(libro.getPaginas()));
            binding2.tvDescripcion.setText(libro.getDescripcion());
            binding2.imageView.setImageResource(libro.getImagen());

        });

        dVModel.cargarDatosLibro(getIntent());

    }
}