package com.example.tpo2moviles.ui.busqueda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2moviles.R;
import com.example.tpo2moviles.databinding.ActivityMainBinding;
import com.example.tpo2moviles.ui.detalle.DetalleActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);


        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel.getMutableMensaje().observe(this, mensaje->{
            binding.tvMensaje.setText(mensaje);
        });

        viewModel.getMLibro().observe(this,libro -> {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("libro", libro);
            startActivity(intent);
        });

        binding.btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.buscandoLibro(binding.etBusqueda.getText().toString());
            }
        });


    }
}