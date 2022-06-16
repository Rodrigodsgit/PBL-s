
package Model;

/**
 * Classe <b>No</b>  que guarda um dado e referencia outro objeto <b>No</b>.
 * È o objeto que compõe a <b>Lista</b>,e jutamente com ela será utilizado para guardar todos os <b>Paciente</b>, <b>Medico</b> e <b>Exame</b>.
 * 
 * @see Lista
 * @see Medico
 * @see Paciente
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 * 
 */
public class No {
    private Object data;
    private No proximo;
    
    /**
     * Construtor da classe <b>No</b><br><br>.
     * <b>Uso:</b><br>
     * No no = new No(objeto)<br><br>
     * <b>Onde:</b><br>
     * 
     * @param objeto È um Object genérico, assumindo assim qualquer objeto.
     */
    public No (Object objeto){
        data = objeto;
        proximo = null;
        
    }
    
    //-------------------------------------------------------------

    /**
     * Esse metódo acessa o atributo data do objeto <b>No</b>  e o retorna.
     * @return Um Object que equivale ao objeto que foi inserido naquele <b>No</b>.
     * 
     */
    public Object getData() {
        return data;
    }

    /**
     * Esse metódo acessa o atributo data do objeto <b>No</b> e o altera.
     * @param data È um Object que estará guardado no <b>No</b>.
     * 
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Esse metódo acessa o atributo proximo do objeto <b>No</b>  e o retorna.
     * @return Um <b>No</b> que equivale a referencia que "aponta" para o próximo<b>No</b>.
     * 
     */
    public No getProximo() {
        return proximo;
    }

    /**
     * Esse metódo acessa o atributo data do objeto <b>No</b> e o altera.
     * @param proximo È um objeto do tipo <b>No</b>.
     * 
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
    //--------------------------------------------------------------

    /**
     * Esse método tem como função imprimir na tela todos os atributos do objeto <b>No</b>.
     * @param inf Int que informa no caso do <b>Paciente</b> qual atributo será mostrado.
     */
    
    public void display (int inf){
        if(data instanceof Medico){
            Medico aux = (Medico) data ;
            aux.display();
        }
       else if(data instanceof Paciente){
            switch (inf) {
                case 1:
                    {
                        Paciente aux = (Paciente) data ;
                        aux.dispNome();
                        break;
                    }
                case 2:
                    {
                        Paciente aux = (Paciente) data ;
                        aux.dispMatricula();
                        break;
                    }
                default:
                    {
                        Paciente aux = (Paciente) data ;
                        aux.display();
                        break;
                    }
            }
        }
        else if(data instanceof Exame){
            Exame aux = (Exame) data ;
            aux.display();
        }
          
    }
    
    
}
