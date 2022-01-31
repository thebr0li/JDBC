package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {
    
    private ProductoDAO dao;
    Scanner sc = new Scanner(System.in);
    
    public ProductoServicio(){
    this.dao = new ProductoDAO();
    }
    
    public void mostrarProductoxNombre() throws Exception{
        Collection<Producto> productos = dao.mostrarNombreProductos();
        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }
    }
    
    public void nombresYprecios() throws Exception{
        Collection<Producto> productos = dao.mostrarNombreYPrecio();
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + "----" + producto.getPrecio());
        }
    }
    
    public void entrePrecio() throws Exception{        
        Collection<Producto> productos = dao.mostrarEntrePrecios();
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    
    public void portatil() throws Exception{
        Collection<Producto> productos = dao.mostrarPortatil();
        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }
    }
    
    public void barato() throws Exception{
        Collection<Producto> productos = dao.productoBarato();
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + "----" + producto.getPrecio());
        }
    }
    
    public void ingresar() throws Exception{
        Scanner sc = new Scanner(System.in);
        Producto p = new Producto();
        
        System.out.println("Nombre del producto");
        String n = sc.next();
        System.out.println("Precio del producto");
        double pre = sc.nextDouble();
        System.out.println("Codigo de fabricante");
        int cod = sc.nextInt();
        
        p.setNombre(n);
        p.setPrecio(pre);
        p.setCodigoFabricante(cod);
        
        dao.guardarProducto(p);
    }
    
    public void UPDATE() throws Exception{
    Scanner sc = new Scanner(System.in);
    Producto p = new Producto();
    
        System.out.println("Nuevo nombre");
        String n = sc.next();
        System.out.println("Nuevo precio");
        double pre = sc.nextDouble();
        System.out.println("Nuevo codigo de creador");
        int cod = sc.nextInt();
        
        p.setNombre(n);
        p.setPrecio(pre);
        p.setCodigoFabricante(cod);
        
        dao.modificarProducto(p);
}
    
}
