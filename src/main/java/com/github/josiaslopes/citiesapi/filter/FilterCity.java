package com.github.josiaslopes.citiesapi.filter;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

//serve para filtar as requisições
@Component
public class FilterCity implements Filter {

    //podemos criar um logger
    private Logger loger = LoggerFactory.getLogger(FilterCity.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        loger.info("Inicou a execução");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Enumeration<String> headerNames = request.getHeaderNames();
        //pega uma lista de headerNames
        //transforma em stream e usa o metodo collect pra trazer um mapa
        //com a chave e valor de cada item
        Map<String, String> mapHeaders = Collections.list(headerNames).
                stream().collect(Collectors.toMap(it->it,request::getHeader));
        //aqui vamos uzar um header de autorizacao
        //esse foi pra ferificar se o header authorization existe


        if(mapHeaders.containsKey("authorization")) {
            if (mapHeaders != null && mapHeaders.get("authorization").equals("123456")) {

                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendError(404);
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
        loger.info("Terminou a execução");
    }


}
