
package Modelo;

import java.sql.PreparedStatement;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;

public class VentaDAO {
   
    Connection con;
    Conexion cn = new Conexion();    
    PreparedStatement ps;
    ResultSet rs;    
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="SELECT MAX(NumeroSerie) FROM ventas";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                numeroserie=rs.getString(1);                
            }
        }catch (Exception e){
        }
        return numeroserie;
    }
     
    
    public String IdVentas(){
        String idventas="";
        String sql="SELECT MAX(IdVentas) FROM ventas";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                idventas=rs.getString(1);
            }
        }catch (Exception e){
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql="INSERT INTO ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) VALUES(?,?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getPrecio());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();            
        }catch (Exception e){
        }    
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql="INSERT INTO detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) VALUES(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());            
            ps.executeUpdate();            
        }catch (Exception e){
        }    
        return r;
    }
    
    
    
}
