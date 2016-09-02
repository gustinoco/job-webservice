<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
<br><br><br>
		<div id="miolo" class="center"></div>



	<div id="botao" class="input-group">
		<div class="input-group-btn">
			<a onclick="buscaAnterior()" class="btn btn-danger">Anterior</a>
		</div>
		<div class="input-group-btn">
			<input class="form-control" value="1" id="input" style="width: 100px;text-align:center;" />
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
		});
	});
	
	function buscaAnterior(){
	  var pagina = $('#input').val();
	  pagina = parseInt(pagina -1);
	  $('#ap'+pagina).remove();
	  $('#input').val(pagina);
	}

	function busca() {
		var pagina = $('#input').val();
		var finalSlide = 4;
		if(parseInt(pagina) >0 && parseInt(pagina) < finalSlide){
		$.ajax({
			url : 'http://localhost:8080/API/Apresentacao/Get/' + pagina,
			type : 'GET',
			contentType : "application/json",
			success : function(data) {
				if (data.status.status) {
					if(data.apresentacoes.imagem != ""){
						$('#miolo').append('<div class="center" style="text-align: justify;" id="ap'+data.apresentacoes.id+'"><h1><b>'+data.apresentacoes.titulo+'</b></h1><br><h3>'+data.apresentacoes.descricao+'</h3><br><img src="<%=request.getContextPath()%>/resources/img/'+data.apresentacoes.imagem+'"/></div>');	
					}else{
					$('#miolo').append('<div class="center" style="text-align: justify;" id="ap'+data.apresentacoes.id+'"><h1><b>'+data.apresentacoes.titulo+'</b></h1><br><h3>'+data.apresentacoes.descricao+'</h3></div>');
					}
					$('#input').val( parseInt(pagina) + 1 );
				}
				

			}
		});
		}else{
			$('#miolo').html('<h1>FIM</h1>');
			$('#botao').hide();
		}
	}
</script>