package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public class ProductoDAO extends DAO1 {
    

    public void modificarProducto(Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception ("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE producto SET"
                    + "'codigo = '" + producto.getCodigo() + "' WHERE nombre = '" + producto.getNombre();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Collection<Producto> mostrarNombreProductos() throws Exception{
        try {
            //inicializo el objeto Producto en nulo
            Producto producto = null;
            
            consultarBase("SELECT nombre FROM producto");
            
            //nace la collection
            Collection<Producto> productos = new ArrayList();
            
            while(re.next()){
                //hago nacer el objeto Producto
                producto = new Producto();
                //añado los atributos de las columnas
                producto.setNombre(re.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
            
            throw e;
        }finally{
            desconectarBase();
        }
        
    }
    
    public Collection<Producto> mostrarNombreYPrecio() throws Exception{
        try {
            Producto producto = null;
            
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);
            
            Collection<Producto> productos = new ArrayList();
            
            while(re.next()){
                producto = new Producto();
                producto.setNombre(re.getString(1));
                producto.setPrecio(re.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> mostrarEntrePrecios() throws Exception{
        
        try {
            Producto producto = null;
        
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            consultarBase(sql);
            
            Collection<Producto> productos = new ArrayList();
            
            while(re.next()){
                producto = new Producto();
                producto.setCodigo(re.getInt(1));
                producto.setNombre(re.getString(2));
                producto.setPrecio(re.getDouble(3));
                producto.setCodigoFabricante(re.getInt(4));
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> mostrarPortatil() throws Exception{
        try {
            Producto producto = null;
            
            String sql = "SELECT * FROM producto WHERE nombre LIKE 'Portatil%';";
            consultarBase(sql);
            
            Collection<Producto> productos = new ArrayList();
            
            while(re.next()){
                producto = new Producto();
                producto.setCodigo(re.getInt(1));
                producto.setNombre(re.getString(2));
                producto.setPrecio(re.getDouble(3));
                producto.setCodigoFabricante(re.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> productoBarato() throws Exception{
        try {
            Producto producto = null;
            
            String sql = "SELECT nombre, MIN(precio) FROM producto;";
            consultarBase(sql);
            
            Collection<Producto> productos = new ArrayList();
            
            while(re.next()){
                producto = new Producto();
                producto.setNombre(re.getString(1));
                producto.setPrecio(re.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public void guardarProducto(Producto producto) throws Exception{
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO producto (codigo,nombre,precio,codigoFabricante)"
                        + "VALUES('" + producto.getCodigo() + "' , '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , '" + producto.getCodigoFabricante() + "')";
                
                insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }   
    }
    
}
