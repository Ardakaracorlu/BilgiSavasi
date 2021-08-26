package com.example.projem1;

public class Model {
    private String Sorular,cevap,secenek1,secenek2,secenek3,secenek4;

    public Model(String sorular, String cevap, String secenek1, String secenek2, String secenek3, String secenek4) {
        Sorular = sorular;
        this.cevap = cevap;
        this.secenek1 = secenek1;
        this.secenek2 = secenek2;
        this.secenek3 = secenek3;
        this.secenek4 = secenek4;
    }

    public Model(){}

    public String getSorular() {
        return Sorular;
    }

    public void setSorular(String sorular) {
        Sorular = sorular;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getSecenek1() {
        return secenek1;
    }

    public void setSecenek1(String secenek1) {
        this.secenek1 = secenek1;
    }

    public String getSecenek2() {
        return secenek2;
    }

    public void setSecenek2(String secenek2) {
        this.secenek2 = secenek2;
    }

    public String getSecenek3() {
        return secenek3;
    }

    public void setSecenek3(String secenek3) {
        this.secenek3 = secenek3;
    }

    public String getSecenek4() {
        return secenek4;
    }

    public void setSecenek4(String secenek4) {
        this.secenek4 = secenek4;
    }
}
