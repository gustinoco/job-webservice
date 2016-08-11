<%@page contentType="text/html" pageEncoding="UTF-8"%>

	<div class="container">
		<h1>TESTE</h1>

		<input class="form-control" id="nome" maxlength="10" type="text" /> 
		<input class="form-control" id="nota" maxlength="5" type="number" />

		<button onclick="insert()" id="add" class="btn ">Inserir</button>
		
		<a href="./" id="add" class="btn">Voltar</a>
	</div>

<script>
  function getJson() {
    var nome = $('#nome').val();
    var nota = $('#nota').val();
    var values = {};

    values['nome'] = nome;
    values['nota'] = parseFloat(nota);
    var json = JSON.stringify(values);
    return json;
  }

  function insert() {
    var json = getJson();
    $.ajax({
      url: 'http://localhost:8080/API/Usuario/Insert',
      type: 'POST',      
      dataType: 'json',
      data: json,
      contentType: "application/json",
      success: function(data) {
        if (data.status) {
          alert("Mensagem do WebService: " + data.descricao);
        }

      }
    });
  }
</script>