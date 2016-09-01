<%@page contentType="text/html" pageEncoding="UTF-8"%>

	<div class="container">
		

		
		
		
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
      url: 'http://192.168.25.103:8080/API/Usuario/Insert',
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