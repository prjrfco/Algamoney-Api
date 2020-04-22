package com.algaworks.algamoneyapi.event.listener;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

//Listener publica os eventos dentro do codigo
// precisa instanciar um publisher com o autowired nos codigo em que vai ser usado

@Component //assinando essa clase como componente do Spring
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent){
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();

        adicionarHeaderLocation(response, codigo);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}").buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
