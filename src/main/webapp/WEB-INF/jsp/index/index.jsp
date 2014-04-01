<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<title>Login</title>
	 <script type="text/javascript">  
                   
            $( document ).on( "click", ".show-page-loading-msg", function() {
                $.mobile.loading( "show", {
                        text: "Carregando...",
                        textVisible: true,
                        theme: "a",
                        textonly: false,
                        html: ""
                });
            })
            
        </script>
</head>
<body>
	        
     <div data-role="header" data-theme="a" data-position="fixed">
         <h1>Login - Genial Estoque Mobile</h1>
     </div>
         
     <div data-role="content">
         <form action="${pageContext.request.contextPath}/" method="POST" id="fmlogin">
         	<br>
             <label for="login">Usuário:</label>
             <input type="text" id="login" name="user.login" placeholder="Usuário"/>
             <label for="senha">Senha:</label>
             <input type="password" name="user.senha" id="senha" value="" autocomplete="off" placeholder="Senha">
             <br>
             <button type="submit" class="ui-btn ui-btn-b ui-shadow ui-corner-all ui-btn-icon-right ui-icon-action show-page-loading-msg" data-textonly="false" data-textvisible="true" data-msgtext="Carregando..." data-inline="true">Entrar</button>
         </form>
     </div>           
	 
</body>