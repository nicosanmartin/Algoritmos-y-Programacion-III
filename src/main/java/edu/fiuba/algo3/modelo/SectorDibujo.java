package edu.fiuba.algo3.modelo;

import java.util.*;

public class SectorDibujo implements Subject {
    private List<Observer> observadores;

    private final HashMap<Posicion, HashSet<Posicion>> trazos;

    public SectorDibujo(){
        this.trazos = new HashMap<>();
        this.observadores = new ArrayList<>();
    }

    public void agregarTrazo (Posicion inicio, Posicion fin){
        trazos.putIfAbsent(inicio, new HashSet<>());
        trazos.putIfAbsent(fin, new HashSet<>());

        trazos.get(inicio).add(fin);
        trazos.get(fin).add(inicio);
        notifyObservers();
    }

    public HashMap<Posicion, HashSet<Posicion>> obtenerTrazos(){
        return this.trazos;
    }

    public void restablecerDibujo(){
        this.trazos.clear();
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorDibujo that = (SectorDibujo) o;
        return Objects.equals(trazos, that.trazos);
    }

    @Override
    public void addObserver(Observer obs) {
        observadores.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observadores.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observadores) obs.update();
    }

}
