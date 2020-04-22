package com.algaworks.algamoneyapi.cors;

import com.algaworks.algamoneyapi.config.property.AlgamoneyApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// CORS é responsável por permitir acesso ao servidor a partir de outros dominios

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Autowired
    private AlgamoneyApiProperty algamoneyApiProperty;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Origin", algamoneyApiProperty.getOriginPermitida());//permite a origem em originPermitida
        response.setHeader("Access-Control-Allow-Credentials", "true");//responsável por enviar o cookie

        //analisando se é uma requisição options e se a origem permitida veio do browser
        if ("OPTIONS".equals(request.getMethod()) && algamoneyApiProperty.getOriginPermitida().equals(request.getHeader("Origin"))){
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");//métodos http que serão permitidos
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");//os Headers que serão permitidos
            response.setHeader("Access-Control-Max-Age","3600");//O tempo em que browser fará a próxima requisição

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
