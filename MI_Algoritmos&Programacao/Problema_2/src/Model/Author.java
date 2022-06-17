package Model;

import java.util.ArrayList;

/**
 * A classe Author contém como atributo uma lista com todos os seus livros publicados.<br><br>
 * 
 * @see Livro
 * @author Rodrigo Damasceno, Rita Kassiane
 * @since Fev 2020
 * @version 1.0
 */
public class Author {
    private  ArrayList livros;

    /**
     * Classe constrtuora do classe Author.<br><br>
     * Assim que instânciada ela instância um ArrayList que será armazenado os objetos do tipo Livro.<br><br>
     * 
     */
    public Author() {
        this.livros = new ArrayList();
    }
    
//------------------------------------------------------------------------------

    /**
     * Esse método pega a lista de livros e a retorna.<br><br>
     * @return Um ArrayList contendo os Livros do Author.<br><br>
     */

    public ArrayList getLivros() {
        return livros;
    }

    /**
     * Esse método atualiza a ArrayList do Author.<br><br>
     * @param Livros È um ArrayList contendo os Livros do Author.<br><br>
     */
    public void setLivros(ArrayList Livros) {
        this.livros = Livros;
    }
    
//------------------------------------------------------------------------------
    
    
}
