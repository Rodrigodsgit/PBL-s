package Model;

/**
 * A classe <b>Exame</b>  é responsável por especificar um tipo de exame que o paciente terá que realizar.
 * Esse exame pode ou não ser solicitado (instânciado) através de uma consulta entre o
 * <b>Paciente</b>  e o <b>Médico</b>, feita através do <b>Sistema</b>.
 * 
 * @see Paciente
 * @see Medico
 * @see Controller.Sistema
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 */
public class Exame {
    private String nome;

    /**
     * Construtor da classe <b>Exame</b><br><br>.
     * <b>Uso:</b><br>
     * Exame exame = new Exame(nome)<br><br>
     * <b>Onde:</b><br>
     * @param nome È uma String  que se refere ao tipo de exame que está sendo solicitado.
     */
    public Exame(String nome) {
        this.nome = nome;  
    }
//-----------------------------------------------------------------------------

    /**
     * Esse metódo acessa o atributo nome do objeto <b>Exame</b> e o retorna.
     * @return Uma String que identifica o tipo de <b>Exame</b>
     * 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Esse metódo acessa o atributo nome do objeto <b>Exame</b> e o altera.
     * @param nome È uma String equivalente ao novo nome do tipo de <b>Exame</b> que deseja alterar.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

//------------------------------------------------------------------------------

    /**
     * Esse método tem como função imprimir na tela o tipo do <b>Exame</b>.
     */
    public void display() {
        System.out.println("Exame:"  + nome );
    }
}
