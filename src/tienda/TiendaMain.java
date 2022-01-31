package tienda;

import java.util.Scanner;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class TiendaMain {

    public static void main(String[] args) throws Exception {

        FabricanteServicio fservicio = new FabricanteServicio();
        ProductoServicio pservicio = new ProductoServicio();
        
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        
        //Menu 
        while(!salir){
            System.out.println("a - Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("b - Lista los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("c - Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("d - Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("e - Listar el nombre y el precio del producto más barato.");
            System.out.println("f - Ingresar un producto a la base de datos.");
            System.out.println("g - Ingresar un fabricante a la base de datos.");
            System.out.println("h - Editar un producto con datos a elección.");
            System.out.println("i - salir.");
            
            System.out.println("Elija una opción: ");
            String rta = sc.next();
            
            switch(rta){
                case "a":
                    pservicio.mostrarProductoxNombre();
                    break;
                case "b":
                    pservicio.nombresYprecios();
                    break;
                case "c":
                    pservicio.entrePrecio();
                    break;
                case "d":
                    pservicio.portatil();
                case "e":
                    pservicio.barato();
                    break;
                case "f":
                    pservicio.ingresar();
                    break;
                case "g":
                    fservicio.ingresarFabricante();
                    break;
                case "h":
                    pservicio.UPDATE();
                    break;
                case "i":
                    salir = true;
                    break;
                default:
                    System.out.println("Elige una de las opciones señaladas");
            }
        } 
    }
}
