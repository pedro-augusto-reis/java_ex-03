package com.http418.dao;


import com.http418.entidade.JpaTesteEntidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by pedro on 2/20/18.
 */
public interface JpaTesteDao extends CrudRepository<JpaTesteEntidade, Long> {

    @Query("select c from JpaTesteEntidade c where c.no_grupo = :no_grupo")
    List<JpaTesteEntidade> findByDs_grupoEquals(@Param("no_grupo") String no_grupo);

}
