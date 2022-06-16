package View;

import Controller.Sistema;
import Model.Lista;
import Model.Medico;
import Model.Paciente;
import java.util.Scanner;

/**
 *A classe <b>Atendente</b> é responsável por obter as informações da classe <b>Menu</b> e devolver os dados solicitados por ela, através do <b>Sistema</b>.
 *  
 * @see Controller.Sistema
 * @see Menu
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 * 
 */
public class Atendente {
    
    /**
     * Esse método intãncia um novo <b>Paciente</b> e passa ele como parâmetro do método <b>encaminharPaciente</b> do <b>Sistema</b>.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     * @see Model.Paciente
     * @see Controller.Sistema
     */
    public void opcao1_1(Sistema sistema){
        String nome;
        String matricula;
        boolean prioridade;
        String aux;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do Paciente");
        System.out.print("Nome:");
        nome = sc.nextLine();
        System.out.println("Digite a matrícula do Paciente");
        System.out.print("Matrícula:");
        matricula = sc.nextLine();
        System.out.println("Este Paciente é prioritário {S/N}?");
        System.out.print("Prioridade:");
        aux = sc.nextLine();
 
        if("S".equals(aux) || "s".equals(aux)){
            prioridade = true;
        }
        else{
            prioridade = false;
        }
        
        Paciente paciente = new Paciente(nome,matricula,prioridade);
        sistema.encaminharPaciente(paciente);
        System.out.println("O Paciente " + nome + " foi encaminhado");
        System.out.println("[Enter para continuar]");
        sc.nextLine();
    
    }
    
    /**
     * Dado um tipo de <b>Exame</b> esse método mostra a <b>Lista</b> com todos os <b>Paciente</b> aguardando realizá-lo. 
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao1_2(Sistema sistema){
        Scanner sc = new Scanner(System.in);
        if (sistema.getListaPacientesExames().isEmpty()){
            System.out.println("Ainda não há nenhum Paciente aguardando exames");
        }
        else{
            Lista lista = new Lista();
            String exame;
            System.out.println("Digite o nome do Exame que deseja buscar");
            System.out.print("Exame De:");
            exame = sc.nextLine();
            lista = sistema.listarExames(exame);
            System.out.println("Esses são os Pacientes aguardando este exame");
            System.out.println("============================================");
            lista.display(1);
            System.out.println("No total são " + lista.getQuantidade()+ " Pacientes aguardando");           
        }
        System.out.println("[Enter para continuar]");
        sc.nextLine();
    }
    
    /**
     * Esse método instãncia um novo <b>Medico</b> e o insere na lista geral de <b>Medico</b> do <b>Sistema</b>.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao2_1(Sistema sistema){
        String nome;
        String CRM;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do Médico");
        System.out.print("Nome:");
        nome = sc.nextLine();
        System.out.println("Digite o CRM desse Médico");
        System.out.print("CRM:");
        CRM = sc.nextLine();
        
        Medico medico = new Medico(nome,CRM);
        sistema.insertMedico(medico);
        System.out.println("O Médico " + nome + " foi incluído");
        System.out.println("[Enter para continuar]");
        sc.nextLine();
        
    
    }
    
    /**
     * Dado um CRM do <b>Medico</b> esse método, através do <b>Sistema</b>, altera o nome do <b>Medico</b> encontrado.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao2_2(Sistema sistema) {
        String CRM;
        String nome;
        Scanner sc = new Scanner(System.in);
        String resposta = "S";
        

        do {
            System.out.println("Digite o CRM do Médico que deseja alterar");
            System.out.print("CRM:");
            CRM = sc.nextLine();
            if (sistema.getListaMedicos().findMedico(CRM) == null) {
                System.out.println("Desculpe, mas esse CRM não está ligado a nenhum Médico");
                System.out.println("Gostaria de tentar novamente? {S/N}");
                System.out.print("===>>");
                resposta = sc.nextLine();
            } else {
                Medico medico;
                System.out.println("Digite o novo nome desse Médico");
                System.out.print("Nome:");
                nome = sc.nextLine();
                medico = sistema.editarMedico(CRM, nome);
                System.out.println("Alteração concluida no Médico " + nome);
                System.out.println("[Enter para continuar]");
                sc.nextLine();
                return;
            }
        }while ("S".equals(resposta)|| "s".equals(resposta));


    }
    
    /**
     * Dado um CRM do <b>Medico</b> esse método, através do <b>Sistema</b>, mostra todos os <b>Paciente</b> que estão na fila deste <b>Medico</b>.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao2_3(Sistema sistema){
        String CRM;
        String  resposta;
        Scanner sc = new Scanner(System.in);
        
        
        do {
            System.out.println("Digite o CRM do Médico que deseja olhar");
            System.out.print("CRM:");
            CRM = sc.nextLine();
            if (sistema.getListaMedicos().findMedico(CRM) == null) {
                System.out.println("Desculpe, mas esse CRM não está ligado a nenhum Médico");
                System.out.println("Gostaria de tentar novamente? {S/N}");
                System.out.print("===>>");
                resposta = sc.nextLine();
            } else {
                if(sistema.getListaMedicos().findMedico(CRM).getFilaEspera().isEmpty()){
                    System.out.println("Não há Pacientes na fila deste Médico");
                }
                else{
                    sistema.listarPacientes(CRM);
                }
                System.out.println("[Enter para continuar]");
                sc.nextLine();
                return;
            }
        }while ("S".equals(resposta)|| "s".equals(resposta));         
    }
    
    /**
     * Dado um CRM do <b>Medico</b> esse método, através do <b>Sistema</b>, mostra todos os <b>Paciente</b> que já foram atendidos por esse <b>Medico</b>.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao2_4(Sistema sistema){
        String CRM;
        String  resposta;
        Scanner sc = new Scanner(System.in);
        
        
        do {
            System.out.println("Digite o CRM do Médico que deseja olhar");
            System.out.print("CRM:");
            CRM = sc.nextLine();
            if (sistema.getListaMedicos().findMedico(CRM) == null) {
                System.out.println("Desculpe, mas esse CRM não está ligado a nenhum Médico");
                System.out.println("Gostaria de tentar novamente? {S/N}");
                System.out.print("===>>");
                resposta = sc.nextLine();
            } else {
                if(sistema.getListaMedicos().findMedico(CRM).getAtendidos().isEmpty()){
                    System.out.println("Esse Médico ainda não atendeu nenhum Paciente");
                }
                else{
                    sistema.listarPacientesAtendidos(CRM);
                }
                System.out.println("[Enter para continuar]");
                sc.nextLine();
                return;
            }
        }while ("S".equals(resposta)|| "s".equals(resposta));   
    
    
    }
    
    /**
     * Dado um CRM do <b>Medico</b> esse método, através do <b>Sistema</b>, atende o primeiro <b>Paciente</b> da fila de espera do <b>Medico</b>.
     * Ainda é requisitado se o <b>Medico</b> deseja ou não solicitar um <b>Exame</b>.
     * Caso o <b>Exame</b> seja solicitado ele é criado e adicionado a lista de <b>Exame</b> do <b>Paciente</b>.
     * Este <b>Paciente</b> por sua vez é encaminhado para fila para aguardar a realização do <b>Exame</b>.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao2_5(Sistema sistema){
        Scanner sc = new Scanner (System.in);
        String CRM;
        Medico medico;
        String resposta;
        String exame;
        
        
        System.out.println("Digite o CRM do Médico que irá atender");
        System.out.print("CRM:");
        CRM = sc.nextLine();
        medico = sistema.getListaMedicos().findMedico(CRM);
        if (medico != null && medico.getFilaEspera().isEmpty() == false){
            System.out.println("Deseja solicitar Exame? {S/N}");
            System.out.print("===>>");
            resposta = sc.nextLine().toUpperCase();
            if ("S".equals(resposta)){
                System.out.println("Qual o nome de Exame?");
                System.out.print("Exame De:");
                exame = sc.nextLine();
                sistema.realizarAtendimento(CRM, "S", exame);
                System.out.println("O paciente foi antendido e seu exame de " + exame+ " foi solicitado");
                System.out.println("[Enter para continuar]");
                sc.nextLine();
            }
            else{
                sistema.realizarAtendimento(CRM, "N", "");
                System.out.println("O Paciente foi atendido, mas não houve solicatação de exame");
                System.out.println("[Enter para continuar]");
                sc.nextLine();
                
            }
        }
        else{
            System.out.println("Esse CRM não está associado ao um Mèdico ou ele não tem Paciente para ser atendido ");
            System.out.println("[Enter para continuar]");
            sc.nextLine();
        }
        
    }
    
    /**
     * Dado um tipo de <b>Exame</b>  esse método, através do <b>Sistema</b>, encontra o primeiro <b>Paciente</b> na fila de espera de <b>Exame</b>
     * que pretende realizar esse <b>Exame</b>, relizando-o. Caso o <b>Paciente</b> não tenha mais <b>Exame</b> a ser realizados ele é removido da fila.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao2_6(Sistema sistema){
        Scanner sc = new Scanner(System.in);
        
        if (sistema.getListaPacientesExames().isEmpty()){
            System.out.println("Não existe Pacientes para realizar algum exame");
            
        }
        else{
            String exame;
            System.out.println("Digite o nome do Exame que deseja realizar");
            System.out.print("Exame De:");
            exame = sc.nextLine();
            if(sistema.realizarExame(exame)){
                System.out.println("Exame de " + exame + " realizado");  
            }
            else{
                System.out.println("Não há nenhuma Paciente com esse exame para fazer");
            }
        }
        System.out.println("[Enter para continuar]");
        sc.nextLine();
            
    
    }
    
    /**
     * Dado uma matrícula de um <b>Paciente</b> esse método, através do <b>Sistema</b>, mostra todos os <b>Exames</b> aguardando serem realizados desse <b>Paciente</b>.
     * @param sistema È um objeto da classe <b>Sistema</b> para que seja possível obter os dados requisistados.
     */
    public void opcao3_1(Sistema sistema){
        Scanner sc = new Scanner(System.in);
        String matricula;
        
        System.out.println("Digite a matrícula do Paciente");
        System.out.print("Matrícula:");
        matricula= sc.nextLine();
        if (sistema.getListaPacientesExames().findPaciente(matricula)== null){
            System.out.println("Não há exames para esse Paciente");
        }
        else{
            sistema.examesSolicitados(matricula);
        }
        System.out.println("[Enter para continuar]");
        sc.nextLine();
        
    }
    
}
