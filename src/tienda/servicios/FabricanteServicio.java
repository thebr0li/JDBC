package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {
    
    private FabricanteDAO dao;
    
    Scanner sc = new Scanner(System.in);
    
    public FabricanteServicio(){
        this.dao = new FabricanteDAO();
    }
    
    public void ingresarFabricante() throws Exception{
        Scanner sc = new Scanner(System.in);
        Fabricante p = new Fabricante();
        
        System.out.println("Nombre del fabricante");
        String n = sc.next();
        
        p.setNombre(n);
        
        dao.guardarFabricante(p);
    }
    
}
