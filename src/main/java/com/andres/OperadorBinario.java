package com.andres;

public abstract class OperadorBinario extends Expresion
{
    protected Expresion operandoIzquierdo, operandoDerecho;

    // Constructor de la clase que recibe los dos operandos
    public OperadorBinario(Expresion operandoIzquierdo, Expresion operandoDerecho)
    {
        this.operandoIzquierdo = operandoIzquierdo;
        this.operandoDerecho = operandoDerecho;
    }
}