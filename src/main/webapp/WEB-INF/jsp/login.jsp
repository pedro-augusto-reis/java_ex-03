<html>
    <head>
        <title>Teste Servi&ccedil;o</title>
    </head>
    <body>
        <h1 style="text-align: center">Teste Servi&ccedil;o</h1>
        <div style="border-style: dotted">
            <p><h4>Usu&aacute;rio de Teste Servi&ccedil;o 01</h4></p>
            <p>Usu&aacute;rio: joe_admin</p>
            <p>Senha: admin</p>
            <p><h4>Usu&aacute;rio de Teste Servi&ccedil;o 02</h4></p>
            <p>Usu&aacute;rio: jim_user</p>
            <p>Senha: admin</p>
        </div></br>
        <div style="border-style: dotted">
            <form method="post">
                <p><h4>Login</h4></p>
                Usu&aacute;rio : <input type="text" name="name">
                Senha : <input type="password" name="password">
                <input type="submit">
                <p style="color: red">${errorMessage}</p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </body>
</html>
