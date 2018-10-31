package com.http418.controle;

import com.http418.entidade.JpaTesteEntidade;
import com.http418.servico.JpaTesteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pedro on 2/20/18.
 */
@RestController
public class JpaTesteControle {

    @Autowired
    private JpaTesteServico servico;

    @RequestMapping(value="/jpa/grupo", method = RequestMethod.GET)
    public JpaTesteEntidade buscar() {
        return servico.buscar();
    }
}
