/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Exame;
import Model.Lista;
import Model.Medico;
import Model.Paciente;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Damasceno Sampaio
 */
public class SistemaTest {
    Sistema sistema;
    Medico Pedro = new Medico("Pedro", "123");
    Medico Maria = new Medico("Maria", "456");
    Medico Joana = new Medico("Joana", "789");
    
    Paciente Roberto = new Paciente("Roberto","a3", false);
    Paciente Julia = new Paciente("Julia", "b12", false);
    Paciente Romeu = new Paciente ("Romeu", "c36", true);
    Paciente Ana = new Paciente("Ana","d87", true);
    
    
    
    public SistemaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sistema = new Sistema();
    
    }
    
    @After
    public void tearDown() {
    }
    
  
//==============================================================================

    /**
     * 2 Testes do quesito 1º
     */
    @Test
    public void testInsertMedico() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);      
        
        assertEquals(false, sistema.insertMedico(Pedro)); // Quesito 1 - Tentar inserir um médico o qual seu CRM já está cadastrado.
        assertEquals(true, sistema.insertMedico(Joana)); // Quesito 1 - Inserir um novo médico
    }

    /**
     * 2 Testes do quesito 1º
     */
    @Test
    public void testInsertPaciente() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);      
        assertEquals(true,sistema.insertPaciente(Roberto)); // Quesito 1 - Com médico disponivel deve ser possivel inserir um paciente na sua fila de atendimento (fila vazia  e prioritario false).
        assertEquals(true,sistema.insertPaciente(Romeu)); // Quesito 1 - Com médico disponivel deve ser possivel inserir um paciente na sua fila de atendimento (fila vazia e prioritario true).
    }


    /**
     * 3 Testes do quesito 2º.
     */
    @Test
    public void testEditarMedico() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);   
        
        assertEquals(Pedro,sistema.editarMedico("123", "Jessica")); // Quesito 2 - Alterando o nome de um médico e comparando se o médico retornado é o mesmo.
        assertEquals(null,sistema.editarMedico("aswef", "Cicero")); // Quesito 2 - Alterando o nome de um médico que não existe.
        Medico aux;
        aux = Pedro;
        assertEquals(Pedro.getNome(),"Jessica"); // Quesito 2 - Conferindo se realmente o nome foi alterado.
    }

    /**
     * 7 Testes do quesisto 3º
     */
    @Test
    public void testEncaminharPaciente() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);  
        
        sistema.encaminharPaciente(Roberto);
        assertEquals(Roberto,Maria.getFilaEspera().getPrimeiro().getData()); // Quesito 3 - Conferindo se o paciente foi realmente encaminhado.
        assertEquals(1,Maria.getFilaEspera().getQuantidade()); // Quesito 3 - Conferindo se foi incluido somente um paciente e se a quantidade na lista está certa.
        assertEquals(0,Pedro.getFilaEspera().getQuantidade()); // Quesito 3 - Conferindo se o outro médico não recebeu nenhuma paciente.
        sistema.encaminharPaciente(Julia);
        assertEquals(1,Maria.getFilaEspera().getQuantidade()); // Quesito 3 - Conferindo se o paciente foi encaminhado para o medico com menor fila. .
        assertEquals(1,Pedro.getFilaEspera().getQuantidade()); // Quesito 3 - Conferindo se o paciente foi encaminhado para o medico com menor fila.
        // Até o momento cada medico tem um paciente sem prioridade, será incluindo um paciente prioritario em cada para verificar se fica na frente não prioritários.
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        assertEquals(Romeu, Maria.getFilaEspera().getPrimeiro().getData()); // Quesito 3 - inserido prioridade deve passar a frente do paciente que não é prioridade.
        assertEquals(Ana, Pedro.getFilaEspera().getPrimeiro().getData()); // Quesito 3 - inserido prioridade deve passar a frente do paciente que não é prioridade.
        
    }

    /**
     * 3 Testes pro quesito 4º
     */
    @Test
    public void testListarPacientes() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);
        
        sistema.encaminharPaciente(Julia);
        sistema.encaminharPaciente(Roberto);
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        
        assertEquals("d87a3",sistema.listarPacientes("123")); // Quesito 4 - As matriculas retornadas se equivalem;
        assertEquals("c36b12",sistema.listarPacientes("456")); // Quesito 4 - As matriculas retornadas se equivalem;
        sistema.insertMedico(Joana);
        assertEquals("",sistema.listarPacientes("789")); // Quesito 4 - Como esse médico não tem nenhum paciente na sua fila o retorno é vazio.
        
    }

    /**
     * 4 Teste para o quesito 5º E 6 Testes para o quesito 6º.
     */
    @Test
    public void testRealizarAtendimento() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);
        
        sistema.encaminharPaciente(Julia);
        sistema.encaminharPaciente(Roberto);
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        
        sistema.realizarAtendimento("123", "S", "Sangue");// Realizando atendimento pelo o médico de CRM 123.
        
        assertEquals(1,Pedro.getFilaEspera().getQuantidade()); // Quesito 5 - Confirmando se um paciente foi removido da lista de atendimento do médico.
        assertEquals(null,Pedro.getFilaEspera().findPaciente("d87")); // Quesito 5 - Confirmando se o paciente correto foi removido.
        assertEquals(Ana,Pedro.getAtendidos().findPaciente("d87")); // Quesito 5 - Confirmando se o paciente foi incluso na lista de atendidos do medico.
        
        assertEquals(1,Ana.getExame().getQuantidade()); // Quesito 6 - Confirmando que solicitado o exame ele é atribuido a lista de exames do paciente.
        Exame aux = Ana.getExame().findExame("Sangue");
        assertEquals("Sangue", aux.getNome()); // Quesito 6 - Confirmando se o exame influso é o mesmo que o solicitado.
        assertEquals(Ana, sistema.getListaPacientesExames().findPaciente("d87")); //Quesito 6 - Verificando se o paciente está na lista geral aguardando realizar o exame.
        assertEquals(aux, sistema.getListaGeralExames().findExame("Sangue")); // Quesito 6 - Verificando se o exame foi incluido na lista geral de exames.
        sistema.realizarAtendimento("123", "S", "Sangue"); // Realizado outro atendimento com o mesmo tipo de exame.
        assertEquals(1,sistema.getListaGeralExames().getQuantidade()); // Quesito 6 - Confirmando que não se repete um mesmo tipo de exame sem necessidade.
        sistema.realizarAtendimento("456", "N", ""); // Realizar atendimento mas sem solicitar exame.
        assertEquals(1,Maria.getAtendidos().getQuantidade()); // Quesito 5 -  Confirmando se um paciente foi removido da lista de atendimento do médico (Testando outro medico agora).
        assertEquals(null,sistema.getListaPacientesExames().findPaciente("c36")); // Quesito 6- Verificando que como não foi passado nenhum exame para o cliente ele não se encontra na lista esperando realizar o mesmo.
        
        
    }

    /**
     * 3 Testes para o quesito 7º
     */
    @Test
    public void testListarExames() {
        Lista lista = new Lista();
        Paciente p1;
        Paciente p2;
        
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);
        
        sistema.encaminharPaciente(Julia);
        sistema.encaminharPaciente(Roberto);
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        
        sistema.realizarAtendimento("123", "S", "Sangue");
        sistema.realizarAtendimento("123", "S", "Urina");
        sistema.realizarAtendimento("456", "S", "Coração");
        sistema.realizarAtendimento("456", "S", "Sangue");
        
        lista = sistema.listarExames("Sangue");
        p1 = (Paciente)lista.removePrimeiro().getData(); // Pegando os  pacientes que estão dentro da lista retornada pela função, 
        p2 = (Paciente)lista.removePrimeiro().getData(); //que contém todos os pacientes aguardando pelo determinado exame
        
        assertEquals("Ana",p1.getNome()); // Quesito 7 - Comprova que dado o nome de um exame é retornado uma lista com todos os
        assertEquals("Julia",p2.getNome()); // Quesito 7 - pacientes que estão aguardando por ele.
        
        lista = sistema.listarExames("Urina");
        p1 = (Paciente)lista.removePrimeiro().getData();
        assertEquals("Roberto",p1.getNome()); // Quesito 7 - Testando outro tipo de exame.
        
        
    }

    /**
     * 3 Testes para o quesito 8º
     */
    @Test
    public void testListarPacientesAtendidos() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);
        
        sistema.encaminharPaciente(Julia);
        sistema.encaminharPaciente(Roberto);
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        
        sistema.realizarAtendimento("123", "S", "Sangue");
        assertEquals("Ana",sistema.listarPacientesAtendidos("123")); // Quesito 8 - O nome retornado se equivale.
        
        sistema.realizarAtendimento("123", "S", "Urina");
        
        assertEquals("AnaRoberto",sistema.listarPacientesAtendidos("123")); // Quesito 8 - Os nomes retornados se equivalem.
        
        assertEquals("",sistema.listarPacientesAtendidos("456")); // Quesito 8 - Como a medica Maria não realizou nenhum atendimento a String concatenada retornada pé vazia. 
   
        
        
    }

    /**
     * 3 Testes para o quesito 9º
     */
    @Test
    public void testExamesSolicitados() {
         sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);
        
        sistema.encaminharPaciente(Julia);
        sistema.encaminharPaciente(Roberto);
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        
        sistema.realizarAtendimento("123", "S", "Sangue");
        sistema.realizarAtendimento("123", "S", "Urina");
        sistema.realizarAtendimento("456", "S", "Coração");
        sistema.realizarAtendimento("456", "S", "Sangue");
        
        assertEquals("Sangue", sistema.examesSolicitados("d87")); // Quesito 9  - O exame retornado equivale.
        
        sistema.encaminharPaciente(Ana);
        sistema.realizarAtendimento("456", "S", "Urina");
        
        assertEquals("SangueUrina", sistema.examesSolicitados("d87")); // Quesito 9  - Os exames retornados se equivalem.
        
        Paciente Claudia = new Paciente("Claudia","11", true);
        sistema.encaminharPaciente(Claudia);
        
        assertEquals(null, sistema.examesSolicitados("11")); // Quesito 9 - Como ainda não foi solicitado nenhum exame, sua lista esta vazia, retornando assim um valor nulo .
        
    }

    /**
     * 5 Testes para o quesito 10º
     */
    @Test
    public void testRealizarExame() {
        sistema.insertMedico(Pedro);
        sistema.insertMedico(Maria);
        
        sistema.encaminharPaciente(Julia);
        sistema.encaminharPaciente(Roberto);
        sistema.encaminharPaciente(Romeu);
        sistema.encaminharPaciente(Ana);
        
        sistema.realizarAtendimento("123", "S", "Sangue");
        sistema.realizarAtendimento("123", "S", "Urina");
        sistema.realizarAtendimento("456", "S", "Coração");
        sistema.realizarAtendimento("456", "S", "Sangue");
        
        assertEquals(4,sistema.getListaPacientesExames().getQuantidade()); // Confirmando que os 4 pacientes foram solicitados exames.
     
        sistema.realizarExame("Sangue"); 
        assertEquals(3,sistema.getListaPacientesExames().getQuantidade()); // Quesito 10 - Confirmando que um paciente foi removido da lista geral de pacientes.
        assertEquals(null,sistema.getListaPacientesExames().findPaciente("d87")); // Quesito 10 - Comprovando que a paciente Ana, primeira na fila, com um único exame tipo sangue não consta mais na lista geral.
        assertEquals(Julia,sistema.getListaPacientesExames().findPaciente("b12")); // Quesito 10 - Confirmando que o outro paciente que tem o tipo exame sangue continua na lista geral, pois é atendido um paciente por vez.
        sistema.encaminharPaciente(Julia); // Encaminhando o mesmo paciente para um médico de novo.
        sistema.realizarAtendimento("456", "S", "Coração"); // Realizando seu atendimento.
        assertEquals(2,Julia.getExame().getQuantidade()); // Verificando que a paciente tem 2 exames para realiza.
        sistema.realizarExame("Coração"); //Realizando exame.
        assertEquals(2,Julia.getExame().getQuantidade()); // Quesito 10 - A posição do paciente não mudou mesmo apois realizar outro exame, sendo atendido outro paciente a frente dela que tinha como exame também coração.
        sistema.realizarExame("Coração"); 
        assertEquals(1,Julia.getExame().getQuantidade()); // Quesito 10 - Neste momento a paciente é atendida e realiza o exame.
        assertEquals(Julia,sistema.getListaPacientesExames().findPaciente("b12")); // Quesito 10- Mesmo realizado um exame a paciente continua na lista geral pois ainda falta realizar outro exame(Sangue).
    }
    
}
