package Model;

/**
 * Classe <b>Paciente</b>  que um objeto nos seus molde será posteriomente encaminhado pela 
 * a <b>Atendente</b> com auxílio do <b>Sistema</b> para a menor fila de atendimento de um dos <b>Médicos</b>.
 * 
 * @see Lista
 * @see View.Atendente
 * @see Controller.Sistema
 * @see Medico
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 * 
 */
public class Paciente {
    private String nome;
    private String matricula;
    private boolean prioridade;
    private Lista exame;

    /**
     * Construtor da classe <b>Paciente</b><br><br>.
     * <b>Uso:</b><br>
     * Paciente paciente = new Paciente(nome,CRM, prioridade)<br><br>
     * <b>Onde:</b><br>
     * 
     * @param nome È uma String que corresponde ao nome do <b>Paciente</b>.
     * @param matricula È uma String que corresponde identificador único desse <b>Paciente</b>.
     * @param prioridade È um boolean que diz se o <b>Paciente</b> é uma pessoa que necessita de atendimento prioritário ou não.
     */
    public Paciente(String nome, String matricula, boolean prioridade) {
        this.nome = nome;
        this.matricula = matricula;
        this.prioridade = prioridade;
        this.exame = new Lista();
    }
    
//------------------------------------------------------------------------------

    /**
     * Esse metódo acessa o atributo nome do objeto <b>Paciente</b>  e o retorna.
     * @return Uma String que equivale ao nome do <b>Paciente</b>.
     * 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Esse metódo acessa o atributo nome do objeto <b>Paciente</b> e o altera.
     * @param nome È uma String equivalente ao novo nome do <b>Paciente</b> que deseja alterar.
     * 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Esse metódo acessa o atributo matricula do objeto <b>Paciente</b>  e o retorna.
     * @return Uma String que equivale a matricula do <b>Paciente</b>.
     * 
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Esse metódo acessa o atributo matricula do objeto <b>Paciente</b> e o altera.
     * @deprecated Esse método não é utilizado pois a matricula do <b>Paciente</b> é única e imutável.
     * @param matricula È uma String equivalente a nova matricula do <b>Paciente</b> que deseja alterar.
     * 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Esse metódo acessa o atributo prioridade do objeto <b>Paciente</b>  e o retorna.
     * @return Um boolean que corresponde se o  <b>Paciente</b> é ou não prioritario.
     * 
     */
    public boolean isPrioridade() {
        return prioridade;
    }

    /**
     * Esse metódo acessa o atributo prioridade do objeto <b>Paciente</b> e o altera.
     * @param prioridade È um boolean que corresponde se o  <b>Paciente</b> é ou não prioritario.
     * 
     */
    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * Esse metódo acessa o atributo exame do objeto <b>Paciente</b>  e o retorna.
     * @return Uma <b>Lista</b> que corresponde aos exames que o <b>Paciente</b> precisa realizar.
     * 
     */
    public Lista getExame() {
        return exame;
    }

    /**
     * Esse metódo acessa o atributo exame do objeto <b>Paciente</b>  e o altera.
     * @param exame Corresponde a uma <b>Lista</b> de <b>Exame</b> que o <b>Paciente</b> precisa realizar.
     *
     */
    public void setExame(Lista exame) {
        this.exame = exame;
    }
//-----------------------------------------------------------------------------

    /**
     * Esse método tem como função imprimir na tela todos os atributos do objeto <b>Paciente</b>.
     */
    public void display() {
         System.out.println("Paciente:" + nome + " Matricula:" + matricula + " Prioridade:" + prioridade);
         this.exame.display();

    }
    
    /**
     * Esse método tem como função imprimir na tela a matrícula do <b>Paciente</b>.
     */
    public void dispMatricula(){
        System.out.println("Matrícula: " + matricula);
    }
    
    /**
     * Esse método tem como função imprimir na tela o nome do <b>Paciente</b>.
     */
    public void dispNome(){
        System.out.println("Nome: " + nome);
    }
  
    
}
