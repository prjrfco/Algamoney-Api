package com.algaworks.algamoneyapi.event;


import org.springframework.context.ApplicationEvent;
import javax.servlet.http.HttpServletResponse;

//Classe que utiliza um recurso do Spring que criar eventos "ApplicationEvent"
//Neste caso sempre que quiser adicionar o set Header Location, precisa passar esse evento
public class RecursoCriadoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;

    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}
