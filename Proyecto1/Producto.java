    public class Producto{
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;
    public Producto(String codigo, String nombre, int cantidad, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    // mano aca esta el get y set de cada una delas variables 
    public String getcodigo(){
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;}
    //nombre
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre = nombre;}
    //cantidad
    public int getcantidad(){
        return cantidad;
    }
    public void setcantidad(int cantidad){
        this.cantidad = cantidad;}
      //precio
      public double getprecio(){
        return precio;}
        public void setprecio(double precio){
            this.precio = precio;    }  
          }