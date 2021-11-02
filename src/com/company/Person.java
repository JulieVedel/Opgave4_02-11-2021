package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    private int nr;
    private String navn;
    private float tal;

    public Person(int nr, String navn, float tal) {
        this.nr = nr;
        this.navn = navn;
        this.tal = tal;
    }

    public static void main(String[] args) {

    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public float getTal() {
        return tal;
    }

    public void setTal(float tal) {
        this.tal = tal;
    }
}
