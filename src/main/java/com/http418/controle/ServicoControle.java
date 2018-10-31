package com.http418.controle;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pedro on 2/6/18.
 */
@RestController
public class ServicoControle {

    private static final Logger log = LoggerFactory.getLogger(ServicoControle.class);

    // requisicao 01. A requisicao estara disponivel apenas para os usuarios com a role ROLE_ADMIN
    @GetMapping("/req/requisicao01")
    @Secured("ROLE_ADMIN")
    public String requisicao01() {
        // A chamada para os metodos negociais estarao aqui.
        log.trace("*** TRACE - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.debug("*** DEBUG - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.info("*** INFO - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.warn("*** WARN - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.error("*** ERROR - requisicao01 solicitada"); // log para registro de solicitacao de servico
        return "Requisi\u00E7\u00E3o 01 retornada com sucesso!";
    }


    // requisicao 02. A requisicao estara disponivel apenas para os usuarios com a role ROLE_USER
    @GetMapping("/req/requisicao02")
    @Secured("ROLE_USER")
    public String requisicao02() {
        // A chamada para os metodos negociais estarao aqui.
        log.trace("*** TRACE - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.debug("*** DEBUG - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.info("*** INFO - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.warn("*** WARN - requisicao01 solicitada"); // log para registro de solicitacao de servico
        log.error("*** ERROR - requisicao01 solicitada"); // log para registro de solicitacao de servico
        return "Requisi\u00E7\u00E3o 02 retornada com sucesso!";
    }

}
