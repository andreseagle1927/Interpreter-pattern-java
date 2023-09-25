package com.andres;

public abstract class Expresion {
    // Método abstracto para evaluar una expresión
    public abstract boolean evalua(String descripcion);

    // Parte para el análisis sintáctico
    protected static String fuente; // Almacena la expresión fuente que se va a analizar
    protected static int indice; // Índice de la posición actual en la fuente
    protected static String pieza; // Almacena la parte actual de la expresión

    // Método para avanzar a la siguiente pieza de la expresión
    protected static void siguientePieza()
    {
        // Avanzar el índice mientras se encuentren espacios en blanco
        while ((indice < fuente.length()) && (fuente.charAt(indice) == ' '))
            indice++;

        // Si llegamos al final de la fuente, no hay más piezas
        if (indice == fuente.length())
            pieza = null;
        else if ((fuente.charAt(indice) == '(') || (fuente.charAt(indice) == ')'))
        {
            // Si la siguiente pieza es un paréntesis, tomarlo como una pieza única
            pieza = fuente.substring(indice, indice + 1);
            indice++;
        }
        else
        {
            // Si la siguiente pieza es una palabra, tomarla completa
            int inicio = indice;
            while ((indice < fuente.length()) && (fuente.charAt(indice) != ' ') && (fuente.charAt(indice) != ')'))
                indice++;
            pieza = fuente.substring(inicio, indice);
        }
    }

    // Método estático para analizar una expresión completa
    public static Expresion analiza(String fuente) throws Exception
    {
        Expresion.fuente = fuente;
        indice = 0;
        siguientePieza();
        // Comienza el análisis sintáctico con el operador "O" (OperadorO)
        return OperadorO.parsea();
    }

    // Método para analizar una parte de la expresión (palabra clave o subexpresión entre paréntesis)
    public static Expresion parsea() throws Exception
    {
        Expresion resultado;
        if (pieza.equals("("))
        {
            // Si la pieza actual es un paréntesis abierto, analizar la subexpresión dentro de los paréntesis
            siguientePieza();
            resultado = OperadorO.parsea();
            if (pieza == null)
                throw new Exception("Error de sintaxis: Falta un paréntesis de cierre");
            if (!pieza.equals(")"))
                throw new Exception("Error de sintaxis: Se esperaba un paréntesis de cierre");
            siguientePieza(); // Avanzar después del paréntesis de cierre
        }
        else
        {
            // Si la pieza actual es una palabra clave, analizarla
            resultado = PalabraClave.parsea();
        }
        return resultado;
    }

}
