package com.http418.servico;

import com.http418.controle.ServicoControle;
import com.http418.dao.JpaTesteDao;
import com.http418.entidade.JpaTesteEntidade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by pedro on 2/20/18.
 */

@Service
public class JpaTesteServico {

    private static final Logger log = LoggerFactory.getLogger(ServicoControle.class);

    @Autowired
    private JpaTesteDao dao;

    public JpaTesteEntidade buscar() {

        JpaTesteEntidade grupo = new JpaTesteEntidade();
        try{
            List<JpaTesteEntidade> lista = dao.findByDs_grupoEquals("ouvidoria_usuario");
            Iterator<JpaTesteEntidade> iterator = lista.iterator();
            grupo = iterator.next();
            log.info("Id consultada: " + grupo.getNu_seq_grupo());
        }
        catch(Exception e){
            log.error(e.toString());
        }
        finally {
            return grupo;
        }
//        List<JpaTesteEntidade> lista = dao.findByDs_grupoEquals("ouvidoria_usuario");
//        Iterator<JpaTesteEntidade> iterator = lista.iterator();
//        JpaTesteEntidade grupo;
//        grupo = iterator.next();
//        log.info("Id consultada: " + grupo.getNu_seq_grupo());
//        return grupo;
    }
}
