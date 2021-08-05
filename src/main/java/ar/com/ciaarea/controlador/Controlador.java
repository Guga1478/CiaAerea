package ar.com.ciaarea.controlador;

import ar.com.ciaaerea.model.Flota;
import ar.com.ciaaerea.model.FlotaDAO;
import ar.com.ciaaerea.model.Vuelos;
import ar.com.ciaaerea.model.VuelosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Flota fl = new Flota();
    FlotaDAO fdao = new FlotaDAO();
    Vuelos vu = new Vuelos();
    VuelosDAO vdao = new VuelosDAO();
    
    int idv;
    int idf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Flota")) {
            switch (accion) {
                case "Listar":
                    List lista = fdao.listar();
                    request.setAttribute("flotas", lista);
                    break;
                case "Agregar":
                    String mod = request.getParameter("txtModelo");
                    String cap = request.getParameter("txtCapacidad");
                    String mxv = request.getParameter("txtMaxVenta");
                    fl.setModelo(mod);
                    fl.setCapacidad(cap);
                    fl.setMaxVenta(mxv);
                    fdao.agregar(fl);
                    request.getRequestDispatcher("Controlador?menu=Flota&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idf = Integer.parseInt(request.getParameter("id"));
                    Flota flo = fdao.listarId(idf);
                    request.setAttribute("flota", flo);
                    request.getRequestDispatcher("Controlador?menu=Flota&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String mod1 = request.getParameter("txtModelo");
                    String cap1 = request.getParameter("txtCapacidad");
                    String mxv1 = request.getParameter("txtMaxVenta");
                    fl.setModelo(mod1);
                    fl.setCapacidad(cap1);
                    fl.setMaxVenta(mxv1);
                    fl.setId(idf);
                    fdao.actualizar(fl);
                    request.getRequestDispatcher("Controlador?menu=Flota&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idf = Integer.parseInt(request.getParameter("id"));
                    fdao.delete(idf);
                    request.getRequestDispatcher("Controlador?menu=Flota&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
                    
            }
            request.getRequestDispatcher("Flota.jsp").forward(request, response);
        }
        if (menu.equals("Vuelos")){
            switch(accion){
                case "Listar":
                    List lista = vdao.listar();
                    request.setAttribute("vuelo", lista);
                    break;    
                case "Agregar":
                    String num = request.getParameter("txtNumero");
                    int avid = Integer.parseInt(request.getParameter("txtAvionId"));
                    String or = request.getParameter("txtOrigen");
                    String de = request.getParameter("txtDestino");
                    String ho = request.getParameter("txtHorario");
                    vu.setNumero(num);
                    vu.setAvionId(avid);
                    vu.setOrigen(or);
                    vu.setDestino(de);
                    vu.setHorario(ho);
                    vdao.agregar(vu);                                        
            request.getRequestDispatcher("Controlador?menu=Vuelos&accion=Listar").forward(request, response);
                break;  
                case "Editar":
                    idv = Integer.parseInt(request.getParameter("id"));
                    Vuelos vue = vdao.listarId(idv);
                    request.setAttribute("vuelos", vue);
                    request.getRequestDispatcher("Controlador?menu=Vuelos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String num1 = request.getParameter("txtNumero");
                    int avid1 = Integer.parseInt(request.getParameter("txtAvionId"));
                    String or1 = request.getParameter("txtOrigen");
                    String de1 = request.getParameter("txtDestino");
                    String ho1 = request.getParameter("txtHorario");
                    vu.setNumero(num1);
                    vu.setAvionId(avid1);
                    vu.setOrigen(or1);
                    vu.setDestino(de1);
                    vu.setHorario(ho1);
                    vu.setIdVuelo(idv);
                    vdao.actualizar(vu);
                    request.getRequestDispatcher("Controlador?menu=Vuelos&accion=Listar").forward(request, response);
                    break;
            default:
                    throw new AssertionError();
                        
            }
            request.getRequestDispatcher("Vuelos.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
