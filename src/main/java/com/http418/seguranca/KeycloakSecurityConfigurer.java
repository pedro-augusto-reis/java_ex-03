package com.http418.seguranca;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * Created by pedro on 2/6/18.
 */
@Configuration
@EnableWebSecurity
public class KeycloakSecurityConfigurer extends KeycloakWebSecurityConfigurerAdapter { /*a classe extende
    KeycloakWebSecurityConfigurerAdapter, que e uma classe que integra o Keycloak com o Spring Security */


    /* GERENCIADOR de AUTENTICACAO */
    @Bean
    public GrantedAuthoritiesMapper grantedAuthoritiesMapper() { // gerenciador de autenticacao
        SimpleAuthorityMapper mapper = new SimpleAuthorityMapper(); /* responsavel por converter o nome da role vinda do
        keycloak para atender o spring security */
        mapper.setConvertToUpperCase(true);
        return mapper;
    }

    /* GERENCIADOR de AUTENTICACAO */
    @Override
    protected KeycloakAuthenticationProvider keycloakAuthenticationProvider() {
        final KeycloakAuthenticationProvider provider = super.keycloakAuthenticationProvider();
        provider.setGrantedAuthoritiesMapper(grantedAuthoritiesMapper());
        return provider;
    }

    /* GERENCIADOR de AUTENTICACAO */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    /* NAO UTILIZAR SESSAO */
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() { /* para o exemplo, esta sendo criado um
    servico rest sem estado (stateless), nao sendo necessaria uma sessao*/
        return new NullAuthenticatedSessionStrategy();
    }

    /* CONFIGURACAO DE ACESSO */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        super.configure(http);
        http
                .authorizeRequests()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/user/*").hasRole("USER")
                .anyRequest().permitAll();
    }

    /* APONTAMENTO DE ARQUIVO DE CONFIGURACAO PARA CONEXAO COM O KEYCLOAK */
    @Bean
    KeycloakConfigResolver keycloakConfigResolver() { /* por padrao, a integracao keycloak spring security utiliza o
    arquivo de configuracao KEYCLOAK.JSON, porem, a configuracao abaixo transfere para as configuracoes do proprio
    springboot (src/main/resources/application.properties). Este metodo faz essa acao. */
        return new KeycloakSpringBootConfigResolver();
    }

    /* PREVENIR REGISTRO DUPLICADO */
    @Bean
    public FilterRegistrationBean keycloakAuthenticationProcessingFilterRegistrationBean(
            final KeycloakAuthenticationProcessingFilter filter) { // prevenir registro duplicado
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setEnabled(false);
        return registrationBean;
    }

    /* PREVENIR REGISTRO DUPLICADO */
    @Bean
    public FilterRegistrationBean keycloakPreAuthActionsFilterRegistrationBean(
            final KeycloakPreAuthActionsFilter filter) { // prevenir registro duplicado
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setEnabled(false);
        return registrationBean;
    }

}
