package com.andres;

public class PalabraClave extends Expresion
{
    protected String palabraClave; // Almacena la palabra clave que representa esta expresión

    // Constructor de la clase que recibe la palabra clave como parámetro
    public PalabraClave(String palabraClave)
    {
        this.palabraClave = palabraClave;
    }

    // Método para evaluar si la descripción contiene la palabra clave
    public boolean evalua(String descripcion)
    {
        // Utiliza el método indexOf para verificar si la palabra clave está presente en la descripción
        return descripcion.indexOf(palabraClave) != -1;
    }

    // Parte para el análisis sintáctico
    public static Expresion parsea() throws Exception
    {
        Expresion resultado;

        // Crea una nueva instancia de PalabraClave utilizando la pieza actual como palabra clave
        resultado = new PalabraClave(pieza);

        // Avanza al siguiente componente de la expresión
        siguientePieza();

        return resultado; // Devuelve la instancia de PalabraClave creada
    }
}
