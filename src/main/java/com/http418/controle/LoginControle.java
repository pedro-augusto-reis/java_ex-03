package com.http418.controle;

/**
 * Created by pedro on 2/8/18.
 */

import com.http418.servico.LoginServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Iterator;
import java.util.List;

@Controller
@SessionAttributes("name")
public class LoginControle {

    private static final Logger log = LoggerFactory.getLogger(LoginControle.class);

    @Autowired
    LoginServico servico;

    @Autowired
    private Environment env;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        String isValidUser = servico.validateUser(name, password);

        if (isValidUser == null || isValidUser.length() < 19) {
            model.put("errorMessage", isValidUser);
            return "login";
        }
        String host = env.getProperty("host.servico") + env.getProperty("server.context-path");
        log.info("Usuário " +  name + " logado.");
        model.put("name", name);
        model.put("token", isValidUser);
        model.put("host", host);

        return "welcome";
    }
}
