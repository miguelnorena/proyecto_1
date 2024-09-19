import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Principal {

    
    public enum Rol {
        ADMINISTRADOR,
        EMPLEADO
    }

    
    public static class Usuario {
        private String usuario;
        private String contrasena;
        private Rol rol;

        public Usuario(String usuario, String contrasena, Rol rol) {
            this.usuario = usuario;
            this.contrasena = contrasena;
            this.rol = rol;
        }

        public String getUsuario() {
            return usuario;
        }

        public String getContrasena() {
            return contrasena;
        }

        public Rol getRol() {
            return rol;
        }
    }
    
    public static Usuario iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        
        for (Usuario usuarioRegistrado : usuariosRegistrados) {
            if (usuario.equals(usuarioRegistrado.getUsuario()) && contrasena.equals(usuarioRegistrado.getContrasena())) {
                System.out.println("Inicio de sesión exitoso. Bienvenido!");
                return usuarioRegistrado;
            }
        }

        System.out.println("Credenciales incorrectas. Acceso denegado.");
        return null;
    }

    
    private static List<Usuario> usuariosRegistrados = new ArrayList<>();

    
    static {
        usuariosRegistrados.add(new Usuario("admin", "1234", Rol.ADMINISTRADOR));
        usuariosRegistrados.add(new Usuario("empleado", "1234", Rol.EMPLEADO));
    }

    public static void main(String[] args) {
        
        Usuario usuario = iniciarSesion();
        if (usuario == null) {
            return;
        }

        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar nuevo producto");
            System.out.println("2. Actualizar cantidad de producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");

            if (usuario.getRol() == Rol.ADMINISTRADOR) {
                System.out.println("6. Crear nuevo usuario");
            }

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
               System.out.print("Ingrese codigo del producto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("ingrese precio del producto: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); 

                    Producto Producto = new Producto(codigo, nombre, cantidad, precio);
                    inventario.agregarProducto(Producto);
                    System.out.println("Producto agregado.");
                break;
                case 2:
                System.out.print("Ingrese codigo del producto: ");
                    String codigoActualizar = scanner.nextLine();
                    System.out.print("Ingrese nueva cantidad del producto: ");
                    int cantidadActualizar = scanner.nextInt();
                    scanner.nextLine(); 

                    inventario.actualizarCantidad(codigoActualizar, cantidadActualizar);
                    System.out.println("Cantidad de producto actualizado");
                    break;
                case 3:
                System.out.print("Ingrese codigo del producto: ");
                    String codigoEliminar = scanner.nextLine();
                    inventario.eliminarProducto(codigoEliminar);
                    System.out.println("producto eliminado con exito!!!");
                    break;
                case 4:
                System.out.println("Lista de inventario con los ultimos datos actualizados hasta el momento:");
                inventario.mostrarInventario();
                    break;
                case 5:
                    System.out.println("Saliendo... espera un momento");
                    return;
                case 6:
                    if (usuario.getRol() == Rol.ADMINISTRADOR) {
                        System.out.print("Ingrese nombre de usuario: ");
                        String nuevoUsuario = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        String nuevaContrasena = scanner.nextLine();
                        System.out.print("Ingrese rol (ADMINISTRADOR/EMPLEADO): ");
                        String nuevoRol = scanner.nextLine();

                        Rol rolNuevo = nuevoRol.equalsIgnoreCase("ADMINISTRADOR") ? Rol.ADMINISTRADOR : Rol.EMPLEADO;
                        usuariosRegistrados.add(new Usuario(nuevoUsuario, nuevaContrasena, rolNuevo));
                        System.out.println("Usuario creado exitosamente");
                    } else {
                        System.out.println("No tiene permiso para crear usuarios");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta. Por favor, seleccione una opcion correcta");
            }
        }
    }
}
