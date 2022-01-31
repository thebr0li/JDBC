package tienda.persistencia;

import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO1{
    
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "INSERT INTO fabricante (codigo,nombre)"
                        + "VALUES('" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "')";
                
                insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }   
    }
}
