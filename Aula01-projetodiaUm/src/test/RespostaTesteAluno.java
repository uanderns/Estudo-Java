package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entity.Aluno;

public class RespostaTesteAluno {

	//duas palavras importantes (antes e depois)
	//before()
	//after()
	//todo metodo de teste tem void
	//traz o aluno
	
	 Aluno aluno;
	 //espaÃ§o de mem (obj)
	 //necessito alimentar meu atributos
	 //try e catch
	 //throws Throwable (ERROR de teste)
	 @Before
	 public void inicio() throws Throwable {
		  this.aluno = new Aluno();
	      this.aluno.setId(10l);
	      this.aluno.setNome("luciana");
	      this.aluno.setNota2(10.);
	 }
	  //Veririficando se lança a excessão ou Nao ...
     @Test(expected=Exception.class)
     public void  testeNotasInvalidas() throws Throwable{
    	    this.aluno.setNota1(-1.);
    	   this.aluno.gerarMedia().gerarSituacao();
     }
     
     @Test
     public void testeResultadoMedia() throws Throwable{
	      this.aluno.setNota1(8.);
    	   this.aluno.gerarMedia().gerarSituacao();
    	 assertTrue(this.aluno.getMedia().equals(9.));
     }
	 
     @Test
     public void testeSituacao() throws Throwable{
	      this.aluno.setNota1(8.);
    	   this.aluno.gerarMedia().gerarSituacao();
    	 assertEquals("aprovado" ,  this.aluno.getSituacao());
     }
	 
     
     
     
     
     
     
     
     
     
	
	
	
	
}
