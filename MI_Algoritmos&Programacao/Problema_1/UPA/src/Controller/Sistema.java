package Controller;

import Model.Lista;
import Model.No;
import Model.Exame;
import Model.Medico;
import Model.Paciente;

/**
 *A classe <b>Sistema</b> é responsável por contém todos os objetos dos tipos <b>Paciente</b>, <b>Médico</b> e <b>Exame</b>.
 * Manipulando seus respectivos dados e retornando essas informações, que são solicitadas, para classe Atendente
 * 
 * @see View.Atendente
 * @see Model.Paciente
 * @see Model.Medico
 * @see Model.Exame
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 */
public class Sistema {
    private Lista listaMedicos;
    private Lista listaGeralExames;
    private Lista listaPacientesExames;

    /**
     *Construtor default da classe <b>No</b>.<br><br>
     * <b>Uso:</b><br>
     * Sistema sistema = new Sistema()<br><br>
     */
    public Sistema() {
        this.listaMedicos = new Lista();
        this.listaGeralExames = new Lista();
        this.listaPacientesExames = new Lista ();
    }
//------------------------------------------------------------------------------

    /**
     * Esse metódo acessa o atributo listaMedicos do objeto <b>Sistema</b>  e o retorna.
     * @return Uma <b>Lista</b> que corresponde a todos os <b>Medico</b> cadastrados.
     * 
     */
    public Lista getListaMedicos() {
        return listaMedicos;
    }

    /**
     * Esse metódo acessa o atributo listaMedicos do objeto <b>Sistema</b>  e o altera.
     * @param listaMedicos Corresponde a uma <b>Lista</b> com todos os <b>Medico</b> cadastrados.
     */
    public void setListaMedicos(Lista listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    /**
     * Esse metódo acessa o atributo listaGeralExames do objeto <b>Sistema</b>  e o retorna.
     * @return Uma <b>Lista</b> que corresponde a todos os <b>Exames</b> cadastrados.
     */
    public Lista getListaGeralExames() {
        return listaGeralExames;
    }

    /**
     * Esse metódo acessa o atributo listaGeralExames do objeto <b>Sistema</b>  e o altera.
     * @param listaGeralExames Corresponde a uma <b>Lista</b> com todos os <b>Exames</b> cadastrados.
     */
    public void setListaGeralExames(Lista listaGeralExames) {
        this.listaGeralExames = listaGeralExames;
    }

    /**
     * Esse metódo acessa o atributo listaPacientesExames do objeto <b>Sistema</b>  e o retorna.
     * @return Uma <b>Lista</b> que corresponde a todos os <b>Pacientes</b> esperando realizar um <b>Exame</b>.
     */
    public Lista getListaPacientesExames() {
        return listaPacientesExames;
    }

    /**
     * Esse metódo acessa o atributo listaPacientesExames do objeto <b>Sistema</b>  e o altera.
     * @param listaPacientesExames Corresponde a uma <b>Lista</b> com todos os  <b>Pacientes</b> esperando realizar um <b>Exame</b>.
     */
    public void setListaPacientesExames(Lista listaPacientesExames) {
        this.listaPacientesExames = listaPacientesExames;
    }
//------------------------------------------------------------------------------
    
    /**
     * Esse método tem como função imprimir na tela todos os atributos da <b>Lista Geral de Médicos</b>.
     */
    public void displayListaMedico(){
        listaMedicos.display(0);
    }
    
    /**
     * Esse método tem como função imprimir na tela todos os atributos da <b>Lista Geral de Exames</b>.
     */
    public void displayListaGeralExames(){
        listaGeralExames.display(0);
    }
    
    /**
     *Esse método tem como função imprimir na tela todos os atributos da <b>Lista Geral de Pacientes</b> aguardando realizar um <b>Exame</b>.
     */
    public void displayListaPacientesExame(){
        listaPacientesExames.display(1);
    }
    
//------------------------------------------------------------------------------

    /**
     * Esse método insere um <b>Medico</b> na lista geral de <b>Medico</b>.
     * @param medico È referente a um objeto do tipo <b>Medico</b>.
     * @return Um boolean para saber se o <b>Medico</b> foi inserido ou não.
     */
    public boolean insertMedico(Medico medico){
        if(this.listaMedicos.findMedico(medico.getCRM()) == null){
            this.listaMedicos.insertFirst(medico);
            return true;
        }
        return false;
    }
    
    /**
     * Esse método insere um <b>Paciente</b> na lista geral de <b>Paciente</b> que aguardam por realizar seus <b>Exame</b>.
     * @param paciente È referente a um objeto do tipo <b>Paciente</b>.
     * @return Um boolean para saber se o <b>Paciente</b> foi inserido ou não.
     */
    public boolean insertPaciente(Paciente paciente){
        if(this.listaPacientesExames.findPaciente(paciente.getMatricula())== null){
            this.listaPacientesExames.insertLast(paciente);
            return true;
        }
        return false;
    }
    
    /**
     * Esse método insere um <b>Exame</b> na lista geral de <b>Exame</b>.
     * @param exame È referente a um objeto do tipo <b>Exame</b>.
     */
    public void insertExame(Exame exame){
        if (this.listaGeralExames.findExame(exame.getNome()) == null){
        this.listaGeralExames.insertFirst(exame);
        }
    }
    
//------------------------------------------------------------------------------

    /**
     * Dado o CRM de um <b>Medico</b> esse método altera o nome do mesmo.
     * @param CRM È uma String que será a chave para a busca do <b>Medico</b>.
     * @param nome È uma String que será o novo nome no <b>Medico</b>.
     * @return O prório obejeto <b>Medico</b>
     */
    public Medico editarMedico(String CRM, String nome){
        Medico aux;
        aux = this.listaMedicos.findMedico(CRM);
        if  (aux != null){
            aux.setNome(nome);
            return aux;
        }
        return null;
        
        
    }
    
    /**
     * Esse método insere um novo <b>Paciente</b> no menor fila dos <b>Medicos</b> disponivéis para atendimento.
     * @param paciente È um objeto da classe <b>Paciente</b>.
     */
    public void encaminharPaciente(Paciente paciente){
        No aux = this.listaMedicos.getPrimeiro();
        Medico compara = (Medico)aux.getData();
        Medico menorFila = (Medico)this.listaMedicos.getPrimeiro().getData(); // Pega o objeto médico que está na primeira posição.
        int menorQuat = menorFila.getFilaEspera().getQuantidade(); // Pega a quantidade de elementos que tem na lista de espera do médico.
        
        while(aux != null){
            compara = (Medico) aux.getData();
            if (menorQuat > compara.getFilaEspera().getQuantidade() ){
                menorFila = (Medico) aux.getData();
                menorQuat =  menorFila.getFilaEspera().getQuantidade();
            }
            aux = aux.getProximo();
        }
        if(paciente.isPrioridade()){
            menorFila.getFilaEspera().insertPrioridade(paciente);
        }
        else{
            menorFila.getFilaEspera().insertLast(paciente);
        }
        
    }
    
    /**
     * Dado o CRM do <b>Medico</b> é impresso na tela todos os <b>Pacientes</b> a espera de ser atendido  por ele.
     * @param CRM È uma String que sera a chave de busca para localizar o <b>Medico</b>.
     * @return Uma String concatenada com todas as matriculas dos <b>Pacientes</b>.
     */
    public String listarPacientes(String CRM){
        Medico aux;
        String resultado = "";
        No no;
        Paciente paciente;
        
        aux = this.listaMedicos.findMedico(CRM);
        aux.getFilaEspera().display(2);
        no = aux.getFilaEspera().getPrimeiro();
        while(no != null){
            paciente = (Paciente) no.getData();
            resultado += paciente.getMatricula();
            no = no.getProximo();
        }
        return resultado;
        
    }
      
    /**
     * Dado um CRM do <b>Medico</b> esse método atende o primeiro <b>Paciente</b> da fila de espera do <b>Medico</b>.
     * Ainda é requisitado se o <b>Medico</b> deseja ou não solicitar um <b>Exame</b>.
     * Caso o <b>Exame</b> seja solicitado ele é criado e adicionado a lista de <b>Exame</b> do <b>Paciente</b>.
     * Este <b>Paciente</b> por sua vez é encaminhado para fila para aguardar a realização do <b>Exame</b>.
     * @param CRM È uma String que sera a chave de busca para localizar o <b>Medico</b>.
     * @param resposta È uma String {Sim/Nao} para saber se é necessário solicitar um <b>Exame</b>.
     * @param tipoExame È uma String que ditará o tipo de <b>Exame</b>, caso esse seja solicitado.
     */
    public void realizarAtendimento(String CRM, String resposta, String tipoExame) {
        Medico medico;
        medico = this.listaMedicos.findMedico(CRM);
        Paciente paciente;
        if (medico.getFilaEspera().isEmpty()){
            return;
        }
        paciente = (Paciente) medico.getFilaEspera().removePrimeiro().getData();
        if ("S".equals(resposta)) {
            Exame novoExame = new Exame(tipoExame);
            if (this.listaPacientesExames.findPaciente(paciente.getMatricula()) == null) {
                paciente.getExame().insertLast(novoExame);
                this.listaPacientesExames.insertLast(paciente);
            } else {
                Paciente pacienteEncontrado;
                pacienteEncontrado = this.listaPacientesExames.findPaciente(paciente.getMatricula());
                pacienteEncontrado.getExame().insertLast(novoExame);
            }
            if (medico.getAtendidos().findPaciente(paciente.getMatricula()) == null) {
                medico.getAtendidos().insertLast(paciente);
            }
            if (this.listaGeralExames.findExame(tipoExame) == null) {
                this.listaGeralExames.insertLast(novoExame);
            }

        } 
        else {
            if (medico.getAtendidos().findPaciente(paciente.getMatricula()) == null) {
                medico.getAtendidos().insertLast(paciente);
            }

        }

    }
    
    /**
     * Dado um tipo de <b>Exame</b> é buscado na lista geral de <b>Paciente</b> todos os <b>Paciente</b> que estão aguardando relizar 
     * este <b>Exame</b>, depois é impresso na tela todos esses <b>Paciente</b>.
     * @param exame Uma String que será a chave de busca.
     * @return Uma <b>Lista</b> que contém todos esses <b>Paciente</b>..
     */
    public Lista listarExames(String exame){
         Lista listaAuxiliar = new Lista();
         No atual = this.listaPacientesExames.getPrimeiro();
         Paciente paciente = (Paciente) atual.getData();
         if (this.listaPacientesExames.isEmpty()){
             return null;
         }
         else{
            while(atual != null){
                if(paciente.getExame().findExame(exame)!= null){
                    listaAuxiliar.insertLast(paciente);
                }
                if (atual.getProximo()== null){
                    return listaAuxiliar;
                }
                atual = atual.getProximo();
                paciente = (Paciente) atual.getData();
            }
            return listaAuxiliar;
         } 
    }
    
    /**
     * Dado o CRM do <b>Medico</b> é impresso na tela todos os <b>Pacientes</b> que ja foram atendidos por ele.
     * @param CRM È uma String que sera a chave de busca para localizar o <b>Medico</b>.
     * @return Uma String concatenada com todos os nomes dos <b>Pacientes</b>.
     */
    public String listarPacientesAtendidos (String CRM){
        Medico aux;
        String resultado = "";
        No no;
        Paciente paciente;
        
        aux = this.listaMedicos.findMedico(CRM);
        aux.getAtendidos().display(1);
        no = aux.getAtendidos().getPrimeiro();
        while(no != null){
            paciente = (Paciente) no.getData();
            resultado += paciente.getNome();
            no = no.getProximo();
        }
        return resultado;
    
    }
    
    /**
     ** Dado a matricula do <b>Paciente</b> é impresso na tela todos os <b>Exames</b> que esse <b>Paciente</b> precisa realizar.
     * @param matricula È uma String que sera a chave de busca para localizar o <b>Paciente</b>.
     * @return Uma String concatenada com os <b>Exames</b> do <b>Pacientes</b>.
     */
    public String examesSolicitados (String matricula){
        Paciente paciente;
        paciente = this.listaPacientesExames.findPaciente(matricula);
        if (paciente != null){
            paciente.getExame().display(0);
            Exame aux;
            String resultado = "";
            No no;
            no = paciente.getExame().getPrimeiro();
            while(no != null){
                aux = (Exame) no.getData();
                resultado += aux.getNome();
                no = no.getProximo();
            }
            return resultado;
            
        }
        return null;
    
    }
    
    /**
     * Dado o tipo de um <b>Exame</b> é buscado na lista geral de  <b>Paciente</b> o primeiro <b>Paciente</b> que precisa realizar esse <b>Exame</b>.
     * Se ele não tiver mais nenhum <b>Exame</b>  a espera ele é removido imediatamente da lista, caso contrário continua na mesma posição. 
     * @param exame
     * @return
     */
    public boolean realizarExame(String exame){
        No atual = this.listaPacientesExames.getPrimeiro();
        Paciente paciente = (Paciente) atual.getData();
        while (paciente.getExame().findExame(exame) == null){
            if(atual.getProximo() == null){
                return false ;
            }
            atual = atual.getProximo();
            paciente = (Paciente) atual.getData();
        }
        paciente.getExame().remove(exame);
        if (paciente.getExame().isEmpty() == true){
            this.listaPacientesExames.remove(paciente.getMatricula());
        }
        return true;
    }
    
//------------------------------------------------------------------------------   
     

}

   

