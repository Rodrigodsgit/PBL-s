package Model;

import java.util.ArrayList;

/**
 * A classe Colecao possui como atributo uma lista contendo todos os Livros do ano.<br><br>
 * 
 * @see Livro
 * @author Rodrigo Damasceno, Rita Kassiane.<br><br>
 * @since Fev 2020.<br><br>
 * @version 1.0.<br><br>
 */
public class Colecao {
    
    private ArrayList livros;
   
    /**
     * Construtor da classe Colecao.<br><br>
     * Assim que instânciada ela instância um ArrayList que será armazenado os objetos do tipo Livro.<br><br>
     * 
     */
    public Colecao() {
        this.livros = new ArrayList();
    
    }
//------------------------------------------------------------------------------
 
    /**
     * Esse método pega a lista de Livros e a retorna.<br><br>
     * @return Um ArrayList contendo os Livros da Colecao.
     */
    public ArrayList getLivros() {
        return livros;
    }

    /**
     * Esse método atualiza a lista de Livros.<br><br>
     * @param livros Um ArrayList contendo os livros da Colecao.<br><br>
     */
    public void setLivros(ArrayList livros) {
        this.livros = livros;
    }

//------------------------------------------------------------------------------
    

}
