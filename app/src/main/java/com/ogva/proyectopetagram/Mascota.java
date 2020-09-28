package com.ogva.proyectopetagram;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {
    private int id;
    private String nombre;
    private int foto;
    private boolean favorito;
    private int likes;

    public Mascota(int id, String mascota, int foto) {
        this.id = id;
        this.nombre = mascota;
        this.foto = foto;
        this.favorito = false;
        this.likes = 0;
    }

    protected Mascota(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        foto = in.readInt();
        favorito = in.readByte() != 0;
        likes = in.readInt();
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int addLikes() { return ++this.likes; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeInt(foto);
        dest.writeByte((byte) (favorito ? 1 : 0));
        dest.writeInt(likes);
    }
}
