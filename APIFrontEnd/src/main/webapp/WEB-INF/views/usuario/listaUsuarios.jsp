<%@ page contentType="text/html; charset=UTF-8" %>
<div class="main-div">           
                <button class="btn button" onclick="register()">Nova nota</button>
            </div>
            <div class="">
                <table id="table" class="display">
                    <thead>
                        <tr>
                            <th style="width: 40%">Aluno</th>
                            <th style="width: 20%" >Nota</th>                                                                                   
                        </tr>
                    </thead>
                    <tbody id="tbody">
                        <!-- table body -->
                    </tbody>
                </table>
            </div>
    
<script>
function modelTable(){
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
    $(document).ready(function(){
      
      
        $.ajax({
            url: "http://localhost:8080/API/Usuario/ListUsuario",            
            type: "GET",
            contentType: "application/json",
            success: function (data) {
                console.log(data);
                if(data.status){
                  $.each(data.usuarios, function () {
                    $('#tbody').append('<tr>' +
                            '<td>' + this.nome + '</td>' +
                            '<td >' + this.nota + '</td>' +                                                    
                          '</tr>');  
                  });
                 modelTable(); 
                }
             
            }
        });  
    });
          
    function register(){
        location ='./Cadastro';
    }
    
</script>