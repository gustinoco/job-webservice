<%@ page contentType="text/html; charset=UTF-8"%>
<div class="main-div">
	<button class="btn button" onclick="register()">Nova nota</button>
	<button class="btn button btn-info" onclick="apresentacao()">Apresentação</button>


	<ul id="nav">
		<li id="notification_li"><span id="notification_count">1</span> <a
			href="#" id="notificationLink">Notificações</a>
			<div id="notificationContainer">
				<div id="notificationTitle">Envios</div>
				<div id="notificationsBody" class="notifications">
					<p>Conteudo aqui</p>


				</div>


			</div></li>
	</ul>
	<div class="">
		<table id="table" class="display">
			<thead>
				<tr>
					<th style="width: 40%">Aluno</th>
					<th style="width: 20%">Nota</th>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>

	<script>
    function apresentacao() {
      location = './Apresentacao';
    }
    
    
    function modelTable() {
      $('#table').dataTable({
        "sDom": '<"top"i>rt<"hidden"flp><"clear">',
        "scrollY": "300px",
        "scrollCollapse": true,
        "paging": false,
        "bRetrieve": true,
        "bDestroy": true,
        "responsive": true,
        "bInfo": false,
        "language": {
          "zeroRecords": "Adicione novos registros"
        },
      });
    }
    
    $(document).ready(
           
            $("#notificationLink").click(function ()
                    {
                        $("#notificationContainer").fadeToggle(300);
                        $("#notification_count").fadeOut("slow");
                        return false;
                    });

                    $(document).click(function ()
                    {
                        $("#notificationContainer").hide();
                    });

                    $("#notificationContainer").click(function ()
                    {
                        return false;
                    });

            

              $.ajax({
                url: "http://192.168.25.103:8080/API/Usuario/ListUsuario",
                type: "GET",
                contentType: "application/json",
                success: function(data) {
                  console.log(data);
                  if (data.status) {
                    $.each(data.usuarios, function() {
                      $('#tbody').append(
                              '<tr>' + '<td>' + this.nome + '</td>' + '<td >'
                                      + this.nota + '</td>' + '</tr>');
                    });
                    modelTable();
                  }

                }
              });
            });

    function register() {
      location = './Cadastro';
    }
  </script>