
package Model;

/**
 * Cada objeto da classe <b>Medico</b>  é responsável por conter sua própria fila 
 * de atendimento e sua lista com todos os <b>Paciente</b> já atendidos pelo o mesmo.
 * 
 * @see Lista
 * @see Paciente
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 * 
 */
public class Medico {
    private String nome;
    private String CRM;
    private Lista filaEspera;
    private Lista atendidos;

    /**
     ** Construtor da classe <b>Medico</b><br><br>.
     * <b>Uso:</b><br>
     * Medico medico = new Medico(nome,CRM)<br><br>
     * <b>Onde:</b><br>
     * @param nome È uma String que corresponde ao nome do novo <b>Médico</b>.
     * @param CRM È uma String que se refere ao número de identificação único do <b>Médico</b> 
     * (A sigla equivale a Consellho Regional de Medicina)
     */
    public Medico(String nome, String CRM) {
        this.nome = nome;
        this.CRM = CRM;
        this.filaEspera = new Lista();
        this.atendidos = new Lista();
    }
    
//------------------------------------------------------------------------------

    /**
     * Esse metódo acessa o atributo nome do objeto <b>Medico</b> e o retorna.
     * @return Uma String que equivale ao nome do <b>Médico</b>.
     * 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Esse metódo acessa o atributo nome do objeto <b>Medico</b> e o altera.
     * @param nome È uma String equivalente ao novo nome do <b>Medico</b> que deseja alterar.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Esse metódo acessa o atributo CRM do objeto <b>Medico</b> e o retorna.
     * @return Uma String que equivale ao CRM do <b>Médico</b>.
     * 
     */
    public String getCRM() {
        return CRM;
    }

    /**
     * Esse metódo acessa o atributo CRM do objeto <b>Medico</b> e o altera.
     * @deprecated Esse método não é utilizado pois o CRM do <b>Médico</b> é único e inalteravél.
     * @param CRM È uma String equivalente ao novo CRM do <b>Medico</b> que deseja alterar.
     * 
     */
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    /**
     * Esse metódo acessa o atributo filaEspera do objeto <b>Medico</b> e o retorna.
     * @return Um objeto da classe <b>Lista</b> que equivale a fila de  <b>Pacientes</b> do <b>Médico</b>  que aguardam atendimento.
     * 
     */
    public Lista getFilaEspera() {
        return filaEspera;
    }

    /**
     * Esse metódo acessa o atributo filaEspera do objeto <b>Medico</b> e o altera.
     * @param filaEspera È um obejto do tipo <b>Lista</b> equivalente a fila de  <b>Pacientes</b> do <b>Médico</b>  que aguardam atendimento.
     * 
     */
    public void setFilaEspera(Lista filaEspera) {
        this.filaEspera = filaEspera;
    }

    /**
     * Esse metódo acessa o atributo atendidos do objeto <b>Medico</b> e o retorna.
     * @return Um objeto da classe <b>Lista</b> que equivale a lista de  <b>Pacientes</b> atendidos pelo <b>Médico</b>.
     */
    public Lista getAtendidos() {
        return atendidos;
    }

    /**
     * Esse metódo acessa o atributo filaEspera do objeto <b>Medico</b> e o altera.
     * @param atendidos È um obejto do tipo <b>Lista</b> equivalente a lista de  <b>Pacientes</b> atendidos pelo <b>Médico</b>.
     */
    public void setAtendidos(Lista atendidos) {
        this.atendidos = atendidos;
    }
    
//------------------------------------------------------------------------------

    /**
     *Esse método tem como função imprimir na tela todos os atributos do objeto <b>Médico</b>.
     */
    
    public void display() {
        System.out.println("Médico:" + nome + " CRM:" + CRM );
        this.filaEspera.display();

    }     
}
