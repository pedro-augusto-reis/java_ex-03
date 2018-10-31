<html>
    <head>
        <title>Teste Servi&ccedil;o</title>
        <script type="text/javascript">
            function requisitar(tipo) {
                var data = null;
                var xhr = new XMLHttpRequest();
                xhr.withCredentials = true;
                xhr.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        alert(this.responseText);
                    }
                    if (this.status == 403) {
                        xhr.onreadystatechange = null;
                        alert("Http 403 - Acesso negado.");
                    }
                }
                xhr.open("GET", "http://${host}/req/requisicao"+tipo);
                xhr.setRequestHeader("Authorization", "bearer ${token}");
                xhr.setRequestHeader("Cache-Control", "no-cache");
                xhr.send(data);
            }

            function testarJpa(){
                var data = null;
                var xhr = new XMLHttpRequest();
                xhr.withCredentials = true;
                xhr.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        alert(this.responseText);
                    }
                    if (this.status == 403) {
                        xhr.onreadystatechange = null;
                        alert("Http 403 - Acesso negado.");
                    }
                }
                xhr.open("GET", "http://${host}/jpa/grupo");
                xhr.setRequestHeader("Cache-Control", "no-cache");
                xhr.send(data);
            }
        </script>
    </head>
    <body>
        <h1 style="text-align: center">Usu&aacute;rio: ${name}</h1>
        <div style="border-style: dotted">
            <p><h4>Token</h4></p>
            <p style="word-break: break-all;color: darkred">${token}</p>
        </div></br>
        <div style="border-style: dotted">
            <p><h4>Servi&ccedil;os</h4></p>
            <div style="border-style: dotted; margin-left: 10px; margin-right: 10px">
                <p><h4>Teste requisi&ccedil;&otilde;es</h4></p>
                <p><input type="button" value="Requisitar 01" onclick="requisitar('01')"> - <input type="button" value="Requisitar 02" onclick="requisitar('02')"></p>
            </div></br>
            <div style="border-style: dotted; margin-left: 10px; margin-right: 10px">
                <p><h4>Teste Persist&ecirc;ncia</h4></p>
                <p><input type="button" value="Testar JPA" onclick="testarJpa()"></p>
            </div></br>
        </div>
    </body>
</html>