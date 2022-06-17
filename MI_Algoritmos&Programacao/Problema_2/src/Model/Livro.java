
package Model;

/**
 * A classe  Livro fica encarregada de guardar todos os dados de um livro com base no arquivo padrão CSV.<br><br>
 * Os atributos são bem explicativos quanto ao seu nome.<br><br>
 * 
 * @author Rodrigo Damasceno, Rita Kassiane.
 * @since Fev 2020.
 * @version 1.0.
 */
public class Livro {
    private String ebook;
    private String ano;
    private String mes;
    private String titulo;
    private String autor;
    private String link;

    /**
     * Construtor da classe Livro.<br><br>
     * @param ebook Uma String que equivale ao número do ebook.
     * @param titulo Uma String que equivale ao título do livro.
     * @param autor Uma String que equivale ao nome do autor.
     * @param mes Uma String que equivale ao mês de publicação.
     * @param ano Uma String que equivale ao ano de publicação.
     * @param link Uma String que equivale ao link de acesso do livro.
     */
    public Livro(String ebook, String titulo, String autor, String mes, String ano, String link) {
        this.ebook = ebook;
        this.ano = ano;
        this.mes = mes;
        this.titulo = titulo;
        this.autor = autor;
        this.link = link;
    }

    Livro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//------------------------------------------------------------------------------

    /**
     * Esse método pega o numero do ebook e o retorna .<br><br>
     * @return Uma String que equivale ao número do ebook.<br><br>
     */

    public String getEbook() {
        return ebook;
    }

    /**
     * Esse método atualiza o número de ebook do livro .<br><br>
     * @param ebook Uma String que será posto como número do ebook.<br><br>
     */
    public void setEbook(String ebook) {
        this.ebook = ebook;
    }

    /**
     * Esse método pega o ano de publicação do livro e o retorna.<br><br>
     * @return Uma String que equivale ao ano de publicação .<br><br>
     */
    public String getAno() {
        return ano;
    }

    /**
     * Esse método atualiza o ano de publicação do livro .<br><br>
     * @param ano Uma Strign que equivale ao ano de publicação do livro.<br><br>
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * Esse método pega o mês de publicação do livro e o retorna.<br><br>
     * @return Uma String que equivale ao mês de publicação do livro.<br><br>
     */
    public String getMes() {
        return mes;
    }

    /**
     * Esse método atualiza o mês de publicação do livro.<br><br>
     * @param mes Uma String que  que equivale ao mês de publicação
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Esse método pega o título do livro e o retorna.<br><br>
     * @return Uma String equivalente ao título do livro.<br><br>
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Esse método atualiza o título do livro.<br><br>
     * @param titulo Uma String que equivale ao título do livro.<br><br>
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Esse método pega o nome do autor e o retorna.<br><br>
     * @return Uma String que equivale ao nome do autor do livro.<br><br>
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Esse método atualiza o nome do autor do livro.<br><br>
     * @param autor Uma String que equivale ao nome do autor.<br><br>
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Esse método pega o link para acesso do livro e o retorna.<br><br>
     * @return Uma String que equivale ao link para acesso do livro.<br><br>
     */
    public String getLink() {
        return link;
    }

    /**
     * Esse método atualiza o link para acesso do livro.<br><br>
     * @param link Uma Strinf que equivale ao link para acesso do livro.<br><br>
     */
    public void setLink(String link) {
        this.link = link;
    }
 
//------------------------------------------------------------------------------
 
    
    
 
    
    
}