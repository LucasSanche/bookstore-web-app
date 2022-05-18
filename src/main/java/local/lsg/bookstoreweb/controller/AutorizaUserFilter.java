

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.lsg.bookstoreweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import local.lsg.bookstoreweb.model.bean.User;

/**
 *
 * @author devsys-b
 */
@WebFilter(filterName = "AutorizaUserFilter", urlPatterns = {"/bstore/*", "/bsuser/*"})
public class AutorizaUserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
                "AutorizaUserFilter Iniciado!!!");
    }

    @Override
    public void destroy() {
        Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
                "AutorizaUserFilter Destruido!!!");
        

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        //Carrega a session caso exista
        HttpSession session = httpRequest.getSession(false);
        boolean isUsuarioLogado = (session != null && session.getAttribute("user") != null);

        if (isUsuarioLogado) {
            //Tudo ok!Usuario com session autorizado e segue requisição
            User userLogado = (User) session.getAttribute("user");
            Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
                    "Usuario autenticado: {0}", userLogado.getEmail());

            Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
                    "Carrega proximo Filtro ou Servlet - chain.doFilter()");

            chain.doFilter(request, response);

        } else {
            //Ops...Usuario não autenticado:Redirecionar para pagina de Login
            Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
                    "Usuario NÃO autenticado");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginPage.jsp");
            dispatcher.forward(request, response);
        }

        Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
                "*** Pos-Filtro ***");

    }

    

    
}
