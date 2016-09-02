<%@ page contentType="text/html; charset=UTF-8"%>
<div class="main-div">
<br><br><br>
	<button class="btn button" style="width:30%"onclick="register()">Nova nota</button> 	
	<br><br><br>
	


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
	</div>

	<script>    
    
    
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
    
    $(document).ready(function()
    		{
           
            $(document).click(function ()
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
                url: "http://localhost:8080/API/Usuario/ListUsuario",
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