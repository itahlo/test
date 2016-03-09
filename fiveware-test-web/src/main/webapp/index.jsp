<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - Cadastro</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js"></script>
<script>
$(function() {
	$("form[name=fiveware]").on("submit", function(e) {
		e.preventDefault();
		var data = {};
		data = $(this).serialize();
		$.ajax({
			type: $(this).attr('method'),
			url: $(this).attr('action'),
			dataType: 'json',
			data: data,
			async: false,
			success: function(data) {
				$("#response").html("<pre>"+JSON.stringify(data)+"</pre>");
				console.log(data);
			}
		});
	});
});
</script>
</head>

<body>
<h2>Cadastro de Usuário</h2>
<a href="home">Exibir entidade Usuario</a>
<form method="post" name="fiveware" action="cadastrarUsuario">
	<label>Nome:</label><br>
	<input type="text" name="nome">
	<br>
	<label>Email:</label><br>
	<input type="text" name="email">
	<br>
	<label>Sexo:</label><br>
	<select name="sexo">
		<option value="MASCULINO">Masculino</option>
		<option value="FEMININO">Feminino</option>
	</select>
	<br>
	<label>Trabalhando atualmente?</label><br>
	<input type="radio" name="empregado" value="true">Sim<br>
	<input type="radio" name="empregado" value="false">Não
	
	<input type="submit" value="Enviar">
</form>
<div id="response"></div>
</body>
</html>
