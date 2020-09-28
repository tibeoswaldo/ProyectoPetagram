package com.ogva.proyectopetagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import java.util.ArrayList;

public class MascotaAdaptador extends androidx.recyclerview.widget.RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFotoMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());

        holder.imgHuesoFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mascota.isFavorito()) {
                    Toast.makeText(activity, "SI es favorito", Toast.LENGTH_SHORT).show();
                    holder.imgHuesoFavorito.setImageResource(R.drawable.hueso_plomo);
                    mascota.setFavorito(true);
                } else {
                    Toast.makeText(activity, "NO es favorito" + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    holder.imgHuesoFavorito.setImageResource(R.drawable.hueso_azul);
                    mascota.setFavorito(false);
                }
            }
        });

        holder.imgHuesoLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addLikes = mascota.addLikes();
                holder.tvNumLikes.setText(String.valueOf(addLikes));
            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        private ImageView imgFotoMascota;
        private ImageView imgHuesoFavorito;
        private ImageView imgHuesoLikes;
        private TextView tvNombre;
        private TextView tvNumLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoMascota      = itemView.findViewById(R.id.imgFotoMascota);
            imgHuesoFavorito    = itemView.findViewById(R.id.imgHuesoFavorito);
            imgHuesoLikes       = itemView.findViewById(R.id.imgHuesoLikes);
            tvNombre            = itemView.findViewById(R.id.tvNombre);
            tvNumLikes          = itemView.findViewById(R.id.tvNumLikes);
        }
    }
}
