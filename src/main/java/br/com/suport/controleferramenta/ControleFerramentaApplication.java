package br.com.suport.controleferramenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ControleFerramentaApplication {

	@GetMapping
	public String getHomeTeste(){
		return "API SUPORT-FERRAMENTA TESTE";
	}


	public static void main(String[] args) {
		SpringApplication.run(ControleFerramentaApplication.class, args);
	}
}
