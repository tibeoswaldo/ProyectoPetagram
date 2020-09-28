package com.ogva.proyectopetagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoritoActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    ArrayList<Mascota> listMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotas = new ArrayList<Mascota>();

        Intent intent = getIntent();
        listMascotas = intent.getParcelableArrayListExtra("listMascotas");

        //Solo se muestra los 5 favoritos
        int num = 0;
        for (Mascota value : listMascotas) {
            if(value.isFavorito() && num<5)
            //if(value.isFavorito())
                mascotas.add(value);
            num++;
            //Toast.makeText(FavoritoActivity.this, "datos: " + value.getNombre(), Toast.LENGTH_SHORT).show();
        }

        listaMascotas = findViewById(R.id.rvMascotasFavoritos);
        LinearLayoutManager llm = new LinearLayoutManager(FavoritoActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
}