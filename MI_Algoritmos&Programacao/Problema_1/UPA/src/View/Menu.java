/**
 ****************************************************************************************
 *Autor: Rodrigo Damasceno Sampaio
 *Componente Curricular: MI- Programação
 *Concluido em: 23/11/2019
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ******************************************************************************************
*/
package View;

import Controller.Sistema;
import Model.Medico;
import java.util.Scanner;

/**
 * A classe <b>Menu</b> contém a main e ela irá fazer a interação com o usuário.
 * Ela disponibiliza de um quadro menu com as informações que podem ser acessada.
 * São divididos em 3 grandes tópicos e cada um desses tem seus próprios sub-tópicos.
 * A classe <b>Menu</b> irá receber os dados informados pelo usuário e passar para classe <b>Atendente</b>.
 *  
 * @see Atendente
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 * 
 */
public class Menu {
    
    /**
     *Construtor da classe <b>Menu</b>.
     * È inicializada diretamente pelo programa.
     */
    public static void main(String[] args){
        Atendente atendente = new Atendente();
        
        Sistema sistema = new Sistema();
        Medico Ragnar = new Medico("Ragnar","12345");
        Medico Loki = new Medico ("Loki","6789");
        sistema.insertMedico(Ragnar);
        sistema.insertMedico(Loki);

        String resposta = "N";
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("###Unidade de Pronto  Atendimento (UPA)-UEFS###");
        System.out.println("===============================================");
        do{
            System.out.println("===============================================");
            System.out.println("----------Escolha uma da opções abaixo----------");
            System.out.println("------------Ou digite {S} para sair------------");
            System.out.println("===============================================");
            System.out.println("#1-Para acessar informações da Atendente-------");
            System.out.println("----------[Encaminhar novo Paciente]-----------");
            System.out.println("------[Listar pacientes aguardando exame]------");
            System.out.println("===============================================");
            System.out.println("#2-Para acessar informações dos Médicos--------");
            System.out.println("-----------[Incluir novo Médico]---------------");
            System.out.println("----------[Editar nome do Médico]--------------");
            System.out.println("--[Mostrar pacientes que devem ser atendidos]--");
            System.out.println("-----[Mostrar todos pacientes atendidos ]------");
            System.out.println("-----[Atender paciente e solicitar exames]-----");
            System.out.println("--------------[Realizar exame]-----------------");
            System.out.println("===============================================");
            System.out.println("#3 Para acessar informações dos Pacientes------");
            System.out.println("----------[Mostrar exames solicitados]---------");
            System.out.println("===============================================");
            System.out.print("=======>>");
            resposta = sc.nextLine();
            switch (resposta){
                case "1":
                    opcao1(atendente,sistema);
                    break;
                case "2":
                    opcao2(atendente,sistema);
                    break;
                case "3":
                    opcao3(atendente,sistema);
                    break;
                default:
                    break;
            }
            System.out.println("Deseja sair do programa? {S/N}");
            System.out.print("=======>>");
            resposta = sc.nextLine();
            resposta = resposta.toUpperCase();
            
        }while(!"S".equals(resposta));
        sc.close();
        
    }
    
    /**
     * Esse método leva o usuário para o 1º quadro de menu sobre <b>Exame</b> onde será disponibilizado novas opções de acesso.
     * @param atendente È um objeto da classe <b>Atendente</b> inicializada na main do <b>Menu</b>.
     * @param sistema È um objeto da classe  <b>Sistema</b> inicilizado na main do <b>Menu</b>.
     */
    public static void opcao1(Atendente atendente,Sistema sistema){       
        String resposta = "N";
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("###########Informações da Atendente############");
        System.out.println("===============================================");
        do {
            System.out.println("===============================================");
            System.out.println("----------Escolha uma da opções abaixo----------");
            System.out.println("------------Ou digite {S} para sair------------");
            System.out.println("===============================================");
            System.out.println("#1-Encaminhar novo Paciente--------------------");
            System.out.println("#2-Listar pacientes aguardando exame-----------");
            System.out.println("===============================================");
            System.out.print("=======>>");
            resposta = sc.nextLine();
            switch (resposta) {
                case "1":
                    atendente.opcao1_1(sistema);
                    break;
                case "2":
                    atendente.opcao1_2(sistema);
                    break;
                default:
                    break;
            }
            resposta = resposta.toUpperCase();

        } while (!"S".equals(resposta));

    }
    
    /**
     * Esse método leva o usuário para o 2º quadro de menu sobre <b>Medico</b> onde será disponibilizado novas opções de acesso.
     * @param atendente È um objeto da classe <b>Atendente</b> inicializada na main do <b>Menu</b>.
     * @param sistema È um objeto da classe  <b>Sistema</b> inicilizado na main do <b>Menu</b>.
     */
    public static void opcao2(Atendente atendente,Sistema sistema){
        String resposta = "N";
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("#############Informações do Médico#############");
        System.out.println("===============================================");
        do {
            System.out.println("===============================================");
            System.out.println("----------Escolha uma da opções abaixo----------");
            System.out.println("------------Ou digite {S} para sair------------");
            System.out.println("===============================================");
            System.out.println("#1-Incluir novo Médico-------------------------");
            System.out.println("#2-Editar nome do Médico-----------------------");
            System.out.println("#3-Mostrar pacientes que devem ser atendidos---");
            System.out.println("#4-Mostrar todos pacientes atendidos ----------");
            System.out.println("#5-Atender paciente e solicitar exames---------");
            System.out.println("#6-Realizar exame------------------------------");
            System.out.println("===============================================");
            System.out.print("=======>>");
            resposta = sc.nextLine();
            switch (resposta) {
                case "1":
                    atendente.opcao2_1(sistema);
                    break;
                case "2":
                    atendente.opcao2_2(sistema);
                    break;
                case "3":
                    atendente.opcao2_3(sistema);
                    break;
                case "4":
                    atendente.opcao2_4(sistema);
                    break;
                case "5":
                    atendente.opcao2_5(sistema);
                    break;
                case "6":
                    atendente.opcao2_6(sistema);
                    break; 
                default:
                    break;
            }
            resposta = resposta.toUpperCase();

        } while (!"S".equals(resposta));
    
    }
    
    /**
     * Esse método leva o usuário para o 3º quadro de menu sobre <b>Paciente</b> onde será disponibilizado novas opções de acesso.
     * @param atendente È um objeto da classe <b>Atendente</b> inicializada na main do <b>Menu</b>.
     * @param sistema È um objeto da classe  <b>Sistema</b> inicilizado na main do <b>Menu</b>.
     */
    public static void opcao3(Atendente atendente,Sistema sistema){
        String resposta = "N";
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("###########Informações do Paciente############");
        System.out.println("===============================================");
        do {
            System.out.println("===============================================");
            System.out.println("----------Escolha uma da opções abaixo----------");
            System.out.println("------------Ou digite {S} para sair------------");
            System.out.println("===============================================");
            System.out.println("#1-Mostrar exames solicitados------------------");
            System.out.println("===============================================");
            System.out.print("=======>>");
            resposta = sc.nextLine();
            switch (resposta) {
                case "1":
                    atendente.opcao3_1(sistema);
                    break;
                default:
                    break;
            }
            resposta = resposta.toUpperCase();

        } while (!"S".equals(resposta));


    
    }
}

