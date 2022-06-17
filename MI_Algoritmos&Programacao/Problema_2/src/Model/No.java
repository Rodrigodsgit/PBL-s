
package Model;

/**
 * Classe No que contém a refência de outro No a sua direita e a sua esquerda.<br><br>
 * Também guarda um Objeto, que nesse caso pode ser tanto um Livro, Author ou Colecao.<br><br>
 * Uma String que será utilizado como chave de identificação, e um inteiro que equivale a sua altura na arvóre.<br><br>
 * O No é o objeto que compõe a árvore.
 * 
 * @see Livro
 * @see Author
 * @see Colecao
 * @author Rodrigo Damasceno, Rita Kassiane
 * @since Fev 2020
 * @version 1.0
 */
public class No {
    private Object objeto;
    private No esquerdo;
    private No direito;
    private int altura;
    private String key;
    
    /**
     * Construtor da classe No. <br><br>
     * @param objeto È o qualquer elemento Object que será guardado no No.
     * @param key È uma String que servirá como identificador do No.
     */
    public No(Object objeto,String key){
        this.objeto = objeto;
        this.key = key;
        this.altura = 1;
    }

    
//------------------------------------------------------------------------------    

    /**
     * Esse método pega o objeto armazenado no No e o retorna.<br><br>
     * @return O objeto (Object) armazenado.<br><br>
     */
    public Object getObjeto(){
        return objeto;
    
    }

    /**
     * Esse método atualiza o objeto guardado no No.<br><br>
     * @param objeto È o novo objeto que será guardado.<br><br>
     */
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    /**
     * Esse método pega a referência do No á esquerda e o retorna.<br><br>
     * @return Uma referência do tipo No.<br><br>
     */
    public No getEsquerdo() {
        return esquerdo;
    }

    /**
     * Esse método atualiza o No á esquerda.<br><br>
     * @param esquerdo È um objeto do tipo No que será colocado á esquerda do No em questão.<br><br> 
     */
    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    /**
     * 
     * Esse método pega a referência do No á direita e o retorna.<br><br>
     * @return Uma referência do tipo No.<br><br>
     */
    public No getDireito() {
        return direito;
    }

    /**
     *
     * 
     * Esse método atualiza o No á direita.<br><br>
     * @param direito È um objeto do tipo No que será colocado á direita do No em questão.<br><br> 
     */
    public void setDireito(No direito) {
        this.direito = direito;
    }

    /**
     * Esse método pega e retorna a altura do No.<br><br> 
     * @return Um inteiro que equivale a altura do No.<br><br> 
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Esse método atualiza a altura do No.<br><br> 
     * @param altura Um inteiro que irá substituir a altura do No.<br><br> 
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Esse método pega o identificado do No e o retorna.<br><br> 
     * @return Uma String que identifica o No.<br><br> 
     */
    public String getKey() {
        return key;
    }

    /**
     * Esse método atualiza a chave identificadora do No.<br><br> 
     * @param key Uma String que será colocada como identificador do No.<br><br> 
     */
    public void setKey(String key) {
        this.key = key;
    }
        
//------------------------------------------------------------------------------
    
    
}
