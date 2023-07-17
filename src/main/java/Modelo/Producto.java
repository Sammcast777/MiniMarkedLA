
package Modelo;

public class Producto {
    private int id;
    private String nom;
    private String estado;
    private double precio;
    private int stock;
    
    public Producto(){
    }

    public Producto(int id, String nom, String estado, double precio, int stock) {
        this.id = id;
        this.nom = nom;
        this.estado = estado;
        this.precio = precio;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
