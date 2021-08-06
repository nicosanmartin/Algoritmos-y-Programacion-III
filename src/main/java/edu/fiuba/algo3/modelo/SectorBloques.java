package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Bloques.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SectorBloques implements Subject{

    private List<Observer> observadores;

    private HashMap<String, Bloque> menuBloquesAlgoritmo;

    public SectorBloques(){
        this.observadores = new ArrayList<>();

        this.menuBloquesAlgoritmo = new HashMap<>();
    }

    public Bloque seleccionarBloque(String nombreBloque){
        return this.menuBloquesAlgoritmo.get(nombreBloque);
    }

    public void guardarBloqueAlgoritmoPersonalizado(String nombreBloque, Bloque[] bloquesAlgoritmo){
        this.menuBloquesAlgoritmo.put(nombreBloque, new BloqueAlgoritmo(bloquesAlgoritmo));
        notifyObservers();
    }

    public Set<String> obtenerListaDeBloques(){
        return menuBloquesAlgoritmo.keySet();
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