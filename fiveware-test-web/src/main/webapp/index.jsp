<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - Cadastro</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script>
$(function() {
	$("#getEmpregados").on('click', function(e) {
		e.preventDefault();
		$.ajax({
			type: "POST",
			url: $(this).attr('href'),
			async:false,
			success: function(response) {
				var str = "";
				$.each(response, function(key, user) {
					str += user.nome + " | " + user.email + "<br>";
				});
				console.log(response);
				$("#userEmpregados").html(str);
			}
		});
	});
	
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
			
			success: function(resp) {
				console.log(resp);
				$("#response").html('<div class="alert alert-success" role="alert">'+resp.mensagem+'</div>');
			}
		});
	});
});
</script>
</head>

<body>
<div class="container">
<h2>Cadastro de Usuário</h2>
<div class="row">
<div class="col-md-5">
	<div id="response"></div>
</div>
<div class="col-md-9">
	<form method="post" name="fiveware" action="cadastrarUsuario">
	  <div class="form-group">
	    <label for="nome">Nome:</label>
	    <input type="text" required class="form-control" name="nome" placeholder="Nome">
	  </div>
	  <div class="form-group">
	    <label for="email">Email</label>
	    <input type="text" required class="form-control" name="email" placeholder="Email">
	  </div>
	  <div class="form-group">
	    <label for="sexo">Sexo</label>
	    <select name="sexo" class="form-control">
			<option value="MASCULINO">Masculino</option>
			<option value="FEMININO">Feminino</option>
		</select>
	    
	  </div>
	  
	  <div class="form-group">
	  	<label for="empregado">Empregado?</label>
	      <div class="checkbox">
	        <label>
	          <input type="radio" value="true" name="empregado">Sim
	         </label>
	         <label>
	          <input type="radio" value="false" name="empregado">Não
	        </label>
	      </div>
	  </div>
	  
	  <div class="form-group">
	  	<label for="empregado">Seus Skills</label>
	      <div class="checkbox">
	        <label>
	          <input type="checkbox" value="1" name="skillcheck">Pro ativo
	         </label>
	         <label>
	          <input type="checkbox" value="2" name="skillcheck">Criativo
	        </label>
	        <label>
	          <input type="checkbox" value="3" name="skillcheck">Dinamico
	        </label>
	      </div>
	      <p class="help-block">Escolha uma ou mais opçôes</p>
	  </div>
	  
	  
	  <button type="submit" class="btn btn-default">Cadastrar</button>
	</form>
	</div>
	<div class="col-md-12">
		<a href="usuariosEmpregados" id="getEmpregados" class="btn btn-default">Listar usuarios empregados</a>
		
	</div>
	<div id="userEmpregados" class="col-md-12"></div>
</div>
</div>


</body>
</html>
