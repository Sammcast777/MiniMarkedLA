
package Modelo;

import java.sql.PreparedStatement;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String dni){
        Cliente c=new Cliente();
        String sql="SELECT * FROM cliente WHERE Dni=" +dni;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));                
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        }catch (Exception e){
        }
        return c;
    }
    
    
    
   //Operaciones CRUD
    
    public List listar(){
        String sql ="SELECT * FROM cliente";
        List<Cliente>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Cliente cli=new Cliente();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));                
                lista.add(cli);
            }
        } catch (Exception e){             
        }
        return lista;
    }
    
    
    public int agregar(Cliente cli){
        String sql="INSERT INTO cliente(Dni, Nombres, Direccion, Estado) VALUES(?, ?, ?, ?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);            
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getEstado());            
            ps.executeUpdate();        
        }catch (Exception e) {        
        }
        return r;
    }
     
    
    public Cliente listarId(int id){
        Cliente cli=new Cliente();
        String sql="SELECT * FROM cliente WHERE IdCliente= " + id;
         try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));                
            }
        }catch (Exception e) {        
        }
        return cli;
    }
     
    public int actualizar(Cliente cli){
        String sql="UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente = ?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);            
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getEstado());            
            ps.setInt(5, cli.getId());
            ps.executeUpdate();        
        }catch (Exception e) {        
        }
        return r;     
    }
     
     
    public void delete(int id){
         String sql="DELETE FROM cliente WHERE IdCliente = " + id;
         try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);                        
            ps.executeUpdate();        
        }catch (Exception e) {        
        }
    }
    
    
}

