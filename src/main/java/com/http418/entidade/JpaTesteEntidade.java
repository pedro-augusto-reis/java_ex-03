package com.http418.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by pedro on 2/20/18.
 */
@Entity
@Table(schema = "SEGWEB_FNDE", name = "S_GRUPO")
public class JpaTesteEntidade {

    @Id
    private Long nu_seq_grupo;

    private String ds_grupo;

    private java.sql.Date dt_expiracao;

    private String no_grupo;

    private Long nu_seq_aplicacao;

//    GETTERS SETTERS
    public Long getNu_seq_grupo() {
        return nu_seq_grupo;
    }

    public void setNu_seq_grupo(Long nu_seq_grupo) {
        this.nu_seq_grupo = nu_seq_grupo;
    }

    public String getDs_grupo() {
        return ds_grupo;
    }

    public void setDs_grupo(String ds_grupo) {
        this.ds_grupo = ds_grupo;
    }

    public java.sql.Date getDt_expiracao() {
        return dt_expiracao;
    }

    public void setDt_expiracao(java.sql.Date dt_expiracao) {
        this.dt_expiracao = dt_expiracao;
    }

    public String getNo_grupo() {
        return no_grupo;
    }

    public void setNo_grupo(String no_grupo) {
        this.no_grupo = no_grupo;
    }

    public Long getNu_seq_aplicacao() {
        return nu_seq_aplicacao;
    }

    public void setNu_seq_aplicacao(Long nu_seq_aplicacao) {
        this.nu_seq_aplicacao = nu_seq_aplicacao;
    }
}
