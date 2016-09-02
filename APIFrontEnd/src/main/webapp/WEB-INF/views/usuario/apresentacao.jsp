<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

		<div id="miolo"></div>



	<div id="botao" class="input-group">
		<div class="input-group-btn">
			<a onclick="buscaAnterior()" class="btn btn-danger">Anterior</a>
		</div>
		<div class="input-group-btn">
			<input class="form-control" value="1" id="input" style="width: 100px" />
		</div>
		<div class="input-group-btn">
			<a onclick="busca()" class="btn btn-success" id="proximo">Próximo</a>
		</div>
	</div>
	

</div>

<script>
	$(document).ready(function() {
		busca();
		$("#botao").scrollToFixed({
			bottom : 0
		//fixa na parte inferior
		});
	});

	function busca() {
		var pagina = $('#input').val();
		var finalSlide = 3;
		if(parseInt(pagina) >0 && parseInt(pagina) <= finalSlide){
		$.ajax({
			url : 'http://localhost:8080/API/Apresentacao/Get/' + pagina,
			type : 'GET',
			contentType : "application/json",
			success : function(data) {
				if (data.status) {
					if(data.apresentacoes.imagem != ""){
						$('#miolo').append('<div id"'+data.apresentacoes.id+'"><h2>'+data.apresentacoes.titulo+'</h2><br><h4>'+data.apresentacoes.descricao+'</h4><br><img src="'+data.apresentacoes.imagem+'"/>"</div>');	
					}else{
					$('#miolo').append('<div id"'+data.apresentacoes.id+'"><h2>'+data.apresentacoes.titulo+'</h2><br><h4>'+data.apresentacoes.descricao+'</h4></div>');
					}
				}
				$('#input').val( parseInt(pagina) + 1 );

			}
		});
		}else{
			$('#miolo').html('<h1>FIM</h1>');
		}
	}
</script>