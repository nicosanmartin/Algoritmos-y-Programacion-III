package edu.fiuba.algo3.modelo.DireccionesDeMovimiento;

public class DireccionAbajo implements Direccion{

    @Override
    public int cambioEnX() { return 0; }

    @Override
    public int cambioEnY() { return -1; }
}