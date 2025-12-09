package com.rodfood.system;

public class Platillo {
    private Long id;
    private String nombre;
    private Double precio;
    private String ingredientes;

    public Platillo() {}

    public Platillo(String nombre, Double precio, String ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getIngredientes() { return ingredientes; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }
}
