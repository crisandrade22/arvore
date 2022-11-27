package org.example;

public class NoDuplo {
    private int info;
    private NoDuplo filhoEsquerdo;
    private NoDuplo filhoDireito;

    public NoDuplo(int i) {
        setInfo(i);
        setFilhoDireito(null);
        setFilhoEsquerdo(null);
    }

    public int getInfo() {
        return info;
    }
    public NoDuplo getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public NoDuplo getFilhoDireito() {
        return filhoDireito;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setFilhoEsquerdo(NoDuplo filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public void setFilhoDireito(NoDuplo filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    @Override
    public String toString() {
        return "" + info;
    }
}
