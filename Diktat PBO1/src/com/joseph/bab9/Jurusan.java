/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab9;

public class Jurusan {
    private int id;
    private String namaJurusan;

    public Jurusan() {
    }

    public Jurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public Jurusan(int id, String namaJurusan) {
        this.id = id;
        this.namaJurusan = namaJurusan;
    }

    public int getId() {
        return id;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    @Override
    public String toString() {
        return namaJurusan;
    }
}
