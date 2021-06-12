/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab9;

public class Student {
    private String noUnik;
    private String namaOrang;
    private String gender;
    private Jurusan jurusan;

    public Student() {
    }

    public Student(String noUnik, String namaOrang, String gender, Jurusan jurusan) {
        this.noUnik = noUnik;
        this.namaOrang = namaOrang;
        this.gender = gender;
        this.jurusan = jurusan;
    }

    public String getNoUnik() {
        return noUnik;
    }

    public String getNamaOrang() {
        return namaOrang;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public String getGender() {
        return gender;
    }

    public void setNoUnik(String noUnik) {
        this.noUnik = noUnik;
    }

    public void setNamaOrang(String namaOrang) {
        this.namaOrang = namaOrang;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Student : "+'\n'+"noUnik = " + noUnik + '\n' + "namaOrang = " + namaOrang + '\n' +  "gender = " + gender + '\n' +  "jurusan = " + jurusan;
    }
}
