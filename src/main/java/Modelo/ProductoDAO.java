
package Modelo;

import java.sql.PreparedStatement;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProductoDAO {
    
    Connection con;
    Conexion cn = new Conexion();    
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
public Producto buscar(int id){
    Producto p=new Producto();
    String sql="SELECT * FROM producto WHERE idproducto= " +id;
    try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            p.setId(rs.getInt(1));
            p.setNom(rs.getString(2));
            p.setPrecio(rs.getDouble(3));
            p.setStock(rs.getInt(4));
            p.setEstado(rs.getString(5));
        }
    } catch (Exception e){  
    }
    return p;
}           


public int actualizarStock(int id, int stock){
    String sql="UPDATE producto SET Stock=? WHERE IdProducto = ?";
    try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        ps.setInt(1, stock);
        ps.setInt(2, id);
        ps.executeUpdate();        
    } catch (Exception e){  
    }
    return r;
}

    
    
    
    
 //Operaciones CRUD
    
public List listar(){
    String sql ="SELECT * FROM producto";
    List<Producto>lista=new ArrayList<>();
    try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            Producto pro=new Producto();
            pro.setId(rs.getInt(1));
            pro.setNom(rs.getString(2));
            pro.setPrecio(rs.getDouble(3));
            pro.setStock(rs.getInt(4));
            pro.setEstado(rs.getString(5));            
            lista.add(pro);
        }
    } catch (Exception e){             
    }
    return lista;
}    
    
 public int agregar(Producto pro){
        String sql="INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES(?, ?, ?, ?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);            
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());            
            ps.executeUpdate();        
        }catch (Exception e) {        
        }
        return r;
    }
     
    
    public Producto listarId(int id){
        Producto pro=new Producto();
        String sql="SELECT * FROM producto WHERE IdProducto= " + id;
         try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                pro.setId(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));                
            }
        }catch (Exception e) {        
        }
        return pro;
    }
     
    public int actualizar(Producto pro){
        String sql="UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto = ?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);            
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getId());            
            ps.executeUpdate();        
        }catch (Exception e) {        
        }
        return r;     
    }
     
     
    public void delete(int id){
         String sql="DELETE FROM producto WHERE IdProducto = " + id;
         try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);                        
            ps.executeUpdate();        
        }catch (Exception e) {        
        }
    }   
    
}
   
    
    
    
    
    