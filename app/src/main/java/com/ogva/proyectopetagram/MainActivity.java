package com.ogva.proyectopetagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Bella Grande", R.drawable.mascota1));
        mascotas.add(new Mascota(2,"Gemelos", R.drawable.mascota2));
        mascotas.add(new Mascota(3,"Peque Flaco", R.drawable.mascota3));
        mascotas.add(new Mascota(4,"Manchis", R.drawable.mascota4));
        mascotas.add(new Mascota(5,"Timido", R.drawable.mascota5));
        mascotas.add(new Mascota(6,"Coqueta", R.drawable.mascota6));
        mascotas.add(new Mascota(7,"Almoada", R.drawable.mascota7));
        mascotas.add(new Mascota(8,"Calladito", R.drawable.mascota8));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion_favorito:
                Intent intent = new Intent(MainActivity.this, FavoritoActivity.class);
                intent.putParcelableArrayListExtra("listMascotas", (ArrayList<? extends Parcelable>) mascotas);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}