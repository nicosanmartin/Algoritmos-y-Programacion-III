package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.Excepciones.SinBloquesADevolverException;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Subject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BloqueContenedor implements Bloque, Subject {
    LinkedList<Bloque> bloques;
    List<Observer> observadores;

    public BloqueContenedor(){
        bloques = new LinkedList<>();
        observadores = new ArrayList<>();
    }

    public void agregarBloque(Bloque unBloque){
        bloques.addLast(unBloque);
        notifyObservers();
    }

    public void removerBloque(){
        bloques.removeLast();
    }

    public Bloque obtenerUltimoBloque(){
        return bloques.getLast();
    }

    public Bloque[] obtenerBloques() throws SinBloquesADevolverException {
        if (bloques.isEmpty()) throw new SinBloquesADevolverException();
        return bloques.toArray(new Bloque[0]);
    }

    public boolean estaVacio(){
        return this.bloques.isEmpty();
    }

    public void vaciarContenedor(){ this.bloques.clear(); }

    @Override
    public String obtenerID() {
        return this.getClass().getSimpleName();
    }


    @Override
    public void ejecutarSobre(Personaje personaje) {
        for (Bloque bloque : bloques) bloque.ejecutarSobre(personaje);
    }

    @Override
    public void ejecutarInversoSobre(Personaje personaje) {
        for (Bloque bloque : bloques) bloque.ejecutarInversoSobre(personaje);
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
