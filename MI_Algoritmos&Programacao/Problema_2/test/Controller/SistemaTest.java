/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Arvore;
import Model.Author;
import Model.Colecao;
import Model.Livro;
import Model.No;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mestre
 */

public class SistemaTest {
    Sistema sistema;
    Livro livro = new Livro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online");
    
    public SistemaTest() {
        
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sistema = new Sistema();
        
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of leituraArq method, of class Sistema.
     */
    @Test
    public void teste1() throws Exception {
        assertEquals(true,sistema.leituraArq()); 
        // - Testa se o catalogo padrão está sendo lido
    }

    /**
     * Test of leituraArqQualquer method, of class Sistema.
     */
    @Test
    public void teste2() throws Exception {
        assertEquals(true,sistema.leituraArqQualquer("arquivo")); 
        // - Testa se dado o nome de um arquivo existente a leitura é feita
    }
    
       /**
     * Test of leituraArqQualquer method, of class Sistema.
     * @throws java.lang.Exception
     */
    @Test
    public void teste3() throws Exception {
        assertEquals(false,sistema.leituraArqQualquer("arquivo_nao_existente")); 
        //- Testa se dado um arquivo que não exista é negada a leitura
    }
    
        /**
     * Test of cadastrarLivro method, of class Sistema.
     */
    @Test
    public void teste4() {
        
        assertEquals(sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online").getObjeto().getClass(),livro.getClass());
        //- Testa se um novo livro realmente foi cadastrado e inserido um livro na arvore
        
    }

    /**
     * Test of cadastrarLivro method, of class Sistema.
     */
    @Test
    public void teste5() {
   
        assertEquals(sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online"),sistema.getArvore_livro().find("12345"));
        //- Testa se o livro adicionado é o mesmo digitado pelo usuario
        
    }
    
    /**
     * Test of cadastrarLivro method, of class Sistema.
     */
    @Test
    public void teste6() {
        sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online");
        assertEquals(sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online"),null);
        //- Testa, se caso já exista um livro com o mesmo ebook registrado, é rejeitado o cadastramento do livro
        
    }
    
    /**
     * Test of cadastrarLivro method, of class Sistema.
     */
    @Test
    public void teste7() {
        Author aux = new Author();
        No noAux = sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online");
        Livro livro = (Livro) noAux.getObjeto();
        sistema.cadastrarAutor("William Shakespeare",livro );
        
        assertEquals(sistema.getArvore_author().find("William Shakespeare").getObjeto().getClass(),aux.getClass());
        //- Testa se quando o livro foi adicionado se a arvore de autores foi atualizada com ele.
        
    }
    
    /**
     * Test of cadastrarLivro method, of class Sistema.
     */
    @Test
    public void teste8() {
        Colecao aux = new Colecao();
        No noAux = sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online");
        Livro livro = (Livro) noAux.getObjeto();
        sistema.cadastrarColecao("1840", livro);
        
        assertEquals(sistema.getArvore_colecao().find("1840").getObjeto().getClass(),aux.getClass());
        //- Testa se quando o livro foi adicionado a arvore de coleções é atualizado com o novo livro.
        
    }
    
    /**
     * Test of criarCSV method, of class Sistema.
     */
    @Test
    public void teste9() throws IOException {
        sistema.leituraArq();
        sistema.listar_Ano("2019");
        assertEquals(true,sistema.leituraArqQualquer("2019"));
        // - Testa se é gerado um arquivo csv após a listagem por ano
        
    }
    
    /**
     * Test of criarCSV method, of class Sistema.
     */
    @Test
    public void teste10() throws IOException {
        sistema.leituraArq();
        sistema.listar_Livro_Autor("Rex Beach");
        assertEquals(true,sistema.leituraArqQualquer("Rex Beach"));
        // - Testa se é gerado um arquivo csv após a listagem por autor
        
    }
    
    /**
     * Test of criarCSV method, of class Sistema.
     */
    @Test
    public void teste11() throws IOException {
        sistema.leituraArq();
        sistema.buscarLivro("190063");
        assertEquals(true,sistema.leituraArqQualquer("190063"));
        //- Testa se é gerado um arquivo csv após a busca em um livro
        
    }
    
    /**
     * Test of criarCSV method, of class Sistema.
     */
    @Test
    public void teste12() throws IOException {
        sistema.leituraArq();
        sistema.listar_Quant_Autor();
        assertEquals(true,sistema.leituraArqQualquer("Todos os Autores"));
        //- Testa se é gerado um arquivo csv após a listagem de todos os autores
        
    }
    
    /**
     * Test of criarCSV method, of class Sistema.
     */
    @Test
    public void teste13() throws IOException {
        sistema.leituraArq();
        sistema.listar_Quantidade_Livros();
        assertEquals(true,sistema.leituraArqQualquer("Todos os livros"));
        // - Testa se é gerado um arquivo csv após a busca em um livro
        
    }
    
    /**
     * Test of criarCSV method, of class Sistema.
     */
    @Test
    public void teste14() throws IOException {
        sistema.leituraArq();
        sistema.buscarLivro("190063");
        assertEquals(false,sistema.leituraArqQualquer("190063uyuas"));
        //- Testa a caso da função não entrar em error caso o arquivo não exista
        
    }
    
    @Test
    public void teste15() throws IOException{
        sistema.leituraArq();
        Livro livro1 = this.livro;
        assertEquals(sistema.excluir("190007").getObjeto().getClass(),livro.getClass());
        // Testa se foi removido um objeto tipo livro da arvore geral de livros
    }
    
    @Test
    public void teste16() throws IOException{
        sistema.leituraArq();
        sistema.excluir("190007");
        assertEquals(sistema.getArvore_livro().find("190007"),null);
        // Testa se o livro em questão realmente foi removido da arvore de livros
    }
    
    @Test
    public void teste17() throws IOException{
        sistema.leituraArq();
        Author autor;
        Livro livro;
        livro = (Livro) sistema.excluir("190007").getObjeto();
        No aux;
        aux = sistema.getArvore_author().find("Carlton Dawe");
        autor = (Author) aux.getObjeto();
        assertEquals(autor.getLivros().contains(livro),false);
        // Testa se o livro em questão realmente foi removido da arvore de autores
    }
    
    @Test
    public void teste18() throws IOException{
        sistema.leituraArq();
        Livro livro;
        livro = (Livro) sistema.excluir("190007").getObjeto();
        No aux;
        Colecao colec;
        aux =sistema.getArvore_colecao().find("2019");
        colec = (Colecao) aux.getObjeto();
        assertEquals(colec.getLivros().contains(livro),false);
        // Testa se o livro em questão realmente foi removido da arvore de coleções
    }
    
    @Test
    public void teste19() throws IOException{
        int num;
        sistema.leituraArq();
        num = sistema.getArvore_livro().contar(sistema.getArvore_livro().getRaiz());
        assertEquals(num,1526);
        // Testa se a quantidade de livros contabilizados do arquivo padrão está correto
        
    }
    
    @Test
    public void teste20() throws IOException{
        int num;
        sistema.leituraArq();
        num = sistema.getArvore_author().contar(sistema.getArvore_author().getRaiz());
        assertEquals(num,236);
        // Testa se a quantidade de autores contabilizados do arquivo padrão está correto
    }
    
    @Test
    public void teste21() throws IOException{
        int num;
        sistema.leituraArq();
        num = sistema.getArvore_colecao().contar(sistema.getArvore_colecao().getRaiz());
        assertEquals(num,18);
        // Testa se a quantidade de coleções contabilizados do arquivo está correto
        
    }
    
    @Test
    public void teste22(){
        No aux = sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online");
        No aux2 = sistema.buscarLivro("12345");
        assertEquals(aux, aux2);
        // Testa se o metodo buscarLivro retorna exatamente o livro em questão, dado seu numero de ebook
    }
    
    @Test
    public void teste23() throws IOException{
        sistema.leituraArq();
        sistema.cadastrarLivro("12345","Rei Lear","William Shakespeare","jun","1840","Https//livros.online");
        int num;
        num = sistema.getArvore_livro().contar(sistema.getArvore_livro().getRaiz());
        assertEquals(num,1527);
        // Testa se após a inclusão de um novo livro o número de livros na árvore geral de livros é atualizada
        
    }
    @Test
    public void teste24() throws IOException{
        sistema.leituraArq();
        sistema.excluir("190111");
        int num;
        num = sistema.getArvore_livro().contar(sistema.getArvore_livro().getRaiz());
        assertEquals(num,1525);
        // Testa se após a exclusão de um livro o número de livros na árvore geral de livros é atualizada.
        
    }
    
    @Test
    public void teste25() throws IOException{
        sistema.leituraArq();
        sistema.cadastrarAutor("William", livro);
        
        int num;
        num = sistema.getArvore_author().contar(sistema.getArvore_author().getRaiz());
        assertEquals(num,237);
        //Testa se após o cadastramento de um novo author a árvore geral de autores é atulizada em sua quantidade de elemento.
        
    }
    @Test
    public void teste26() throws IOException{
        sistema.leituraArq();
        sistema.cadastrarColecao("2020", livro);
        int num;
        num = sistema.getArvore_colecao().contar(sistema.getArvore_colecao().getRaiz());
        assertEquals(num,19);
        
    }
    
    @Test
    public void teste27() throws IOException{
        sistema.leituraArq();
        int num;
        No aux;
        Author aut;
        aux = sistema.getArvore_author().find("Ernest Haycox");
        aut = (Author) aux.getObjeto();
        num = aut.getLivros().size();
        assertEquals(num,26);
        // Testa se a quantidade de livros na lista do Auhor é realmente a quantidade de livros por ele publicado.
        
    }
    
    @Test
    public void teste28() throws IOException{
        sistema.leituraArq();
        int num;
        No aux;
        Colecao colec;
        aux = sistema.getArvore_colecao().find("2005");
        colec= (Colecao) aux.getObjeto();
        num = colec.getLivros().size();
        assertEquals(num,18);
    }

}
