
package br.com.api.controller;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UsuarioController {
   
   @RequestMapping(value = "/", method = RequestMethod.GET)   
   public String UsuarioController(){
       return "listaUsuarios";
   }
	
    @RequestMapping(value = "/Cadastro", method = RequestMethod.GET)
    public String cadastrar(){
        return "cadastrar";
    }

}
