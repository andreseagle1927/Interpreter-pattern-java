package com.andres;

public class OperadorO extends OperadorBinario
{
    // Constructor que recibe los operandos izquierdo y derecho
    public OperadorO(Expresion operandoIzquierdo, Expresion operandoDerecho) {
        super(operandoIzquierdo, operandoDerecho);
    }

    // Método para evaluar la expresión con el operador "o"
    public boolean evalua(String descripcion)
    {
        // Evalúa el operando izquierdo y el operando derecho y realiza la operación "o" (OR) entre ellos
        return operandoIzquierdo.evalua(descripcion) || operandoDerecho.evalua(descripcion);
    }

    // Parte para el análisis sintáctico
    public static Expresion parsea() throws Exception
    {
        Expresion resultadoIzquierdo, resultadoDerecho;

        // Comienza el análisis sintáctico asumiendo que hay un operador "y" (OperadorY) en el inicio
        resultadoIzquierdo = OperadorY.parsea();

        // Mientras todavía haya piezas en la expresión y sean operadores "o"
        while ((pieza != null) && (pieza.equals("o")))
        {
            siguientePieza(); // Avanza a la siguiente pieza (puede ser otra "o")
            resultadoDerecho = OperadorY.parsea(); // Analiza el siguiente operando
            resultadoIzquierdo = new OperadorO(resultadoIzquierdo, resultadoDerecho); // Crea un nuevo nodo OperadorO
        }

        return resultadoIzquierdo; // Devuelve el resultado de la expresión con los operadores "o"
    }
}