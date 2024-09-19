import java.util.List;
import java.util.ArrayList;
          public class Inventario {
            private List<Producto> Productos;
            public Inventario(){
                this.Productos = new ArrayList<>();
            } 
            public void agregarProducto(Producto Producto){
                Productos.add(Producto);
            }
            public void actualizarCantidad(String codigo, int cantidad){
                for (Producto Producto : Productos) {
                    if (Producto.getcodigo().equals(codigo)){
                        Producto.setcantidad(cantidad);
                    break;}
                    }
                }
            
            public void eliminarProducto(String codigo){
                Productos.removeIf(Producto -> Producto.getcodigo().equals(codigo));
            }
            public void mostrarInventario(){
                for (Producto Producto : Productos){
                    System.out.println("codigo:" + Producto.getcodigo());
                    System.out.println("nombre:" + Producto.getnombre());
                    System.out.println("cantidad:" + Producto.getcantidad());
                    System.out.println("precio: $" + Producto.getprecio());
    
                }
            }
        }