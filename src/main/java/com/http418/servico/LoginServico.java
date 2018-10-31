package com.http418.servico;

/**
 * Created by pedro on 2/8/18.
 */

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginServico {

    private static final Logger log = LoggerFactory.getLogger(LoginServico.class);
    public String validateUser(String userid, String password) {

        try{
            HttpResponse<JsonNode> response = Unirest.post("http://173.173.0.15:9001/auth/realms/spring-security-example/protocol/openid-connect/token")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cache-Control", "no-cache")
                    .body("grant_type=password&client_id=curl&username="+userid+"&password="+password)
                    .asJson();
            if(response.getStatus() == 200){
                JSONObject obj = response.getBody().getObject();
                return obj.getString("access_token");
            }
            else{
                log.error("problema conexao com o servidor keycloak - linha 37");
                return "Ocorreu um erro :(";
            }
        }
        catch(Exception e){
            log.error("problema conexao com o servidor keycloak - linha 42"+e.toString());
            return "Ocorreu um erro :(";
        }

    }
}
