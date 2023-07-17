
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
  
   Empleado em=new Empleado();
   EmpleadoDAO edao=new EmpleadoDAO();
   int ide;
   
   Producto pro=new Producto();
   ProductoDAO pdao=new ProductoDAO();
   int idp;
   
   Cliente cli=new Cliente();
   ClienteDAO cdao=new ClienteDAO();
   int idc;
      
   Venta v = new Venta();
   List<Venta>lista = new ArrayList();
   int item;
   int cod;
   String descripcion;
   double precio;
   int cant;
   double subtotal;
   double totalPagar;
   
   String numeroserie;
   VentaDAO vdao=new VentaDAO();
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        String menu=request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        
        if (menu.equals("Empleado")) {
            switch (accion){            
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);                    
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String est=request.getParameter("txtEstado");
                    String user=request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTel");
                    String est1=request.getParameter("txtEstado");
                    String user1=request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        
        if (menu.equals("Cliente")) {
            
           switch (accion){            
                case "Listar":
                    List lista=cdao.listar();
                    request.setAttribute("clientes", lista);                    
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String dir=request.getParameter("txtDir");
                    String est=request.getParameter("txtEstado");                    
                    cli.setDni(dni);
                    cli.setNom(nom);
                    cli.setDir(dir);
                    cli.setEstado(est);                    
                    cdao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    Cliente c=cdao.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String dir1=request.getParameter("txtDir");
                    String est1=request.getParameter("txtEstado");                    
                    cli.setDni(dni1);
                    cli.setNom(nom1);
                    cli.setDir(dir1);
                    cli.setEstado(est1);                    
                    cli.setId(idc);
                    cdao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
           
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);            
        }
        
        if (menu.equals("Producto")) {
            switch (accion){            
                case "Listar":
                    List lista=pdao.listar();
                    request.setAttribute("productos", lista);                    
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombres");
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    Integer stock = Integer.parseInt(request.getParameter("txtStock"));
                    String est=request.getParameter("txtEstado");                    
                    pro.setNom(nom);
                    pro.setPrecio(precio);
                    pro.setStock(stock);
                    pro.setEstado(est);                    
                    pdao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    Producto p=pdao.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombres");
                    double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    Integer stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1=request.getParameter("txtEstado");                    
                    pro.setNom(nom1);
                    pro.setPrecio(precio1);
                    pro.setStock(stock1);
                    pro.setEstado(est1);
                    pro.setId(idp);
                    pdao.actualizar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
             request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        
        
        
        
        if (menu.equals("NuevaVenta")) {
            switch (accion){            
                case "BuscarCliente":
                    String dni=request.getParameter("codigocliente");                    
                    cli.setDni(dni);
                    cli=cdao.buscar(dni);                    
                    request.setAttribute("c", cli);
                    request.setAttribute("nserie", numeroserie);
                    break;               
                
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    pro=pdao.listarId(id);
                    request.setAttribute("c", cli);
                    request.setAttribute("producto", pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    request.setAttribute("c", cli);
                    totalPagar = 0.0;
                    item = item+1;
                    cod=pro.getId();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cantidad"));
                    subtotal=precio*cant;
                    v =new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;  
                
                case "GenerarVenta":
                    //Actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pr=aO.buscar(idproducto);
                        int sac=pr.getStock()-cantidad;
                        aO.actualizarStock(idproducto, sac);                        
                    }

                    //Guardar Venta
                    v.setIdcliente(cli.getId());
                    v.setIdempleado(2);
                    v.setNumserie(numeroserie);
                    v.setFecha("2023-05-08");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                                        
                    //Guardar Detalle venta
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    break;
                    
                default:                        
                    v=new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar=0.0;
                    
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie==null) {
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }
                    else{
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs=new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);                    
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);                    
            }
            
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
