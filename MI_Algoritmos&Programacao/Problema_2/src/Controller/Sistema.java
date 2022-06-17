package Controller;

import Model.Arvore;
import Model.Author;
import Model.Colecao;
import Model.Livro;
import Model.No;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A classe Sistema é o centro de operações desse programa, ela irá operar a árvore e fazer a leitura dos arquivos.<br><br>
 * A classe Sistema possui 3 árvores, uma para Livro,Auhtor e Colecao, fazendo assim um melhor proveito nas buscas.<br><br>
 * A classe Sistema responde as solicitações da Classe Blibiotecario.
 * 
 * @see Livro
 * @see Author
 * @see Colecao
 * @see Arvore
 * @author Rodrigo Damasceno, Rita Kassiane
 * @since Fev 2020
 * @version 1.0
 */
public class Sistema {
    private Arvore arvore_livro;
    private Arvore arvore_colecao;
    private Arvore arvore_author;
    
    /**
     * Construtor da Classe Sistema que inicializa as 3 ´árvores em seus atributos.
     */
    public Sistema() {
        this.arvore_livro =  new Arvore();
        this.arvore_colecao = new Arvore();
        this.arvore_author = new Arvore();
    
    }
//------------------------------------------------------------------------------

    /**
     * Esse método pega a árvore de livros e a retorna.<br><br>
     * @return Um objeto do tipo Arvore contendo todos os livros catálogados.
     */
    public Arvore getArvore_livro() {
        return arvore_livro;
    }

    /**
     * Esse método atualiza a árvore de livros.<br><br>
     * @param arvore_livro Um objeto do tipo Àrvore.
     */
    public void setArvore_livro(Arvore arvore_livro) {
        this.arvore_livro = arvore_livro;
    }

    /**
     *Esse método pega a Àrvore de coleções e a retorna.<br><br>
     * @return Um objeto do tipo Àrvore com todos os anos de publicação de um livro.
     */
    public Arvore getArvore_colecao() {
        return arvore_colecao;
    }

    /**
     * Esse método atualiza a Àrvore de coleçao .<br><br>
     * @param arvore_colecao Um objeto do tipo Àrvore.
     */
    public void setArvore_colecao(Arvore arvore_colecao) {
        this.arvore_colecao = arvore_colecao;
    }

    /**
     * Esse método pega a Àrvore de Author a retorna.<br><br>
     * @return Um objeto do tipo Àrvore contendo todos os autores que já publicaram algum livro.
     */
    public Arvore getArvore_author() {
        return arvore_author;
    }

    /**
     * Esse método atualiza a Àrvore de autores .<br><br>
     * @param arvore_author Um objeto do tipo Àrvore.
     */
    public void setArvore_author(Arvore arvore_author) {
        this.arvore_author = arvore_author;
    }
    
//------------------------------------------------------------------------------

    /**
     * Esse método faz a leitura do arquivo padrão CSV disponibilizado, através da classe BufferedReader cada linha do arquivo é adicionada em um vetor.<br><br>
     * Esse vetor por sua vez é repartido nas informações que serão passadas pra classe Livro.<br><br>
     * Esse método adiciona os Livros na árvore livro, na árvore de coleções e de autores.<br><br>
     * @return Um boolean que será true caso o arquivo tenha sido lido sem erros.
     * @throws IOException
     */
    public boolean leituraArq () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("arquivo.csv"));
        String linha = "";
        
        try{
            br.readLine();
            br.readLine();
       
            while((linha = br.readLine()) != null ){
       
                String[] palavra = linha.split(";");
                if(palavra.length > 5){
                    Livro novo = new Livro(palavra[0],palavra[1],palavra[2],palavra[3],palavra[4],palavra[5]);
                    No aux = new No(novo,palavra[0]);
                    this.arvore_livro.insercaoInt(aux);
                    No aux2 = this.cadastrarAutor(palavra[2], novo);
                    if(aux2!= null){
                        System.out.println("Lista de livros do Author " + palavra[2] + " atualizado");
                    }
                    No aux3 = this.cadastrarColecao(palavra[4], novo);
                    if (aux3 != null){
                        System.out.println("Colecão do ano " + palavra[4] + " atualizada" );
                        }
        
                }   
            }
             br.close();
            return true;
        }
        catch (IOException e) {
            System.out.println("Erro ao abrir arquivo");
             br.close();
             return false;
            
            
        }
           
       
    }
    
    /**
     * Esse método faz a leitura de um arquivo existente informado pelo usuário, utilizando da mesma forma do método leituraArq.<br><br>
     * @param arquivo Uma String que equivale ao nome do arquivo CSV que deve ser lido.
     * @return Um boolea que será true caso o arquivo tenha sido lido sem erros.
     * @throws IOException
     */
    public boolean leituraArqQualquer (String arquivo) throws IOException {
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(arquivo + ".csv"));
            String linha = "";
            br.readLine();
            br.readLine();
       
            while((linha = br.readLine()) != null ){
       
                String[] palavra = linha.split(";");
                if(palavra.length > 5){
                    Livro novo = new Livro(palavra[0],palavra[1],palavra[2],palavra[3],palavra[4],palavra[5]);
                    No aux = new No(novo,palavra[0]);
                    this.arvore_livro.insercaoInt(aux);
                    No aux2 = this.cadastrarAutor(palavra[2], novo);
                    if(aux2!= null){
                        System.out.println("Lista de livros do Author " + palavra[2] + " atualizado");
                    }
                    No aux3 = this.cadastrarColecao(palavra[4], novo);
                    if (aux3 != null){
                        System.out.println("Colecão do ano " + palavra[4] + " atualizada" );
                        }
        
                }
                
                           
            }
            
        br.close();
        return true;
        }
        catch (IOException e) {
            System.out.println("Erro ao abrir arquivo");
            return false;
        }
           
        
    }
    
    /**
     * Esse método cadastra um novo Livro e o inseri nas árvores de de livros, coleções e autores.<br><br>
     * @param ebook Uma String que corresponde ao número do ebook.
     * @param titulo Uma String que corresponde ao título do livro.
     * @param autor Uma String que corresponde ao nome do autor.
     * @param mes Uma String que corresponde ao mês de publicação.
     * @param ano Uma String que corresponde ao ano de publicação.
     * @param link Uma Strign que corresponde ao link de acesso para o livro.
     * @return
     */
    public No cadastrarLivro(String ebook, String titulo, String autor, String mes, String ano, String link){
        Livro novo = new Livro(ebook,titulo,autor,mes,ano,link);
        return addLivro(novo);
    }
    
    private No addLivro(Livro livro){
        No aux = new No(livro,livro.getEbook());
        No teste = this.arvore_livro.find(livro.getEbook());
        if(teste == null){
            this.arvore_livro.insercaoInt(aux);
            
            return aux;
        }
        return null;
    }
    
    /**
     * Esse método cadastra um novo autor, esse método é chamado no mesmo momento que um novo livro é adicionado, inserindo assim o autor em sua árvore.<br><br>
     * @param key Uma String correspondente ao nome do autor.
     * @param livro Um objeto do tipo Livro que será adicionado.
     * @return O objeto do tipo No correspondente ao autor em sua árvore.
     */
    public No cadastrarAutor(String key, Livro livro){
        No aux = this.arvore_author.find(key);
        if (aux == null){
            Author autor = new Author();
            autor.getLivros().add(livro);
            No novo = new No(autor, key);
            this.arvore_author.insercaoStr(novo);
            return novo;
        }
        else{
            Author autorAux = (Author) aux.getObjeto();
            if (autorAux.getLivros().contains(livro)){
                System.out.println("Livro já cadastrado");
                return null;
            }
            else{
                autorAux.getLivros().add(livro);
                return aux;
            
            }
            
        }
    
    }
    
    /**
     * Esse método cadatra uma nova colecao, esse métod é chamado no mesmo momento que um novo livro é adicionado, inserindo assim a coleção do ano em sua árvore.<br><br>
     * @param key Uma Strign correspondente ao ano de publicação.
     * @param livro Um objeto do tipo Livro que será adicionado.
     * @return O objeto do tipo No correspondente a coleção em sua árvore.
     */
    public No cadastrarColecao(String key, Livro livro){
        No aux = this.arvore_colecao.find(key);
        if (aux == null){
           Colecao colec = new Colecao();
            colec.getLivros().add(livro);
            No novo = new No(colec, key);
            this.arvore_colecao.insercaoInt(novo);
            return novo;
        }
        else{
            Colecao colecAux = (Colecao) aux.getObjeto();
            if (colecAux.getLivros().contains(livro)){
                System.out.println("Livro já cadastrado");
                return null;
            }
            else{
                colecAux.getLivros().add(livro);
                return aux;
            
            }
            
        }
   
    }
    
    private ArrayList listarQtAut (No raiz, ArrayList lista){        
        if(raiz != null){
            Author aux = (Author) raiz.getObjeto();
            int livros = aux.getLivros().size();
            lista.add(raiz);
            System.out.println("O autor " + raiz.getKey() + " Tem " +aux.getLivros().size()+ " livros catalogados." );       
            listarQtAut(raiz.getEsquerdo(), lista);
            listarQtAut(raiz.getDireito(), lista);
            
            return lista ;
        }
        return lista;

    
    }
    
    /**
     * Esse método lista todos os autores catalogados e as quantidades de livros produzidos por cada um, e chama a funçao de criar CSV para registrar esse aquivo.<br><br>
     */
    public void listar_Quant_Autor (){
       ArrayList lista = new ArrayList();
       this.criarCSVAut("Todos os Autores",this.listarQtAut(this.getArvore_author().getRaiz(), lista));
    
    }
    
    /**
     * Esse método informa todos os livros publicados por um dado autor, depois chama a funcao que gera um arquivo CSV com todas essas informações.<br><br>
     * @param key Uma String correspondente ao nome do autor.
     * @return O objeto do tipo No que corresponde ao autor encontrado.
     */
    public No listar_Livro_Autor (String key){
        No aux;
        aux = this.arvore_author.find(key);
        if (aux != null){
            ArrayList lista = new ArrayList();
            System.out.println("O autor " +key+ " Escreveu o(s) seguinte(s) livro(s)");
            Author aut = (Author) aux.getObjeto();
            for( int i = 0; i < aut.getLivros().size(); i++){
            System.out.println("----------------------------------------------");
            Livro li = (Livro) aut.getLivros().get(i);
            lista.add(li);
            System.out.println("Nº Ebook: " +li.getEbook());
            System.out.println("Título: " +li.getTitulo());
            System.out.println("Mês/Ano de publicação: " +li.getMes()+"/"+ li.getAno());
            System.out.println("Link para acesso: " +li.getLink());
            } 
            this.criarCSV(key, lista);
            
        }
        return aux;
    }    
    
    private ArrayList listarQtLiv(No raiz, ArrayList lista){
        if(raiz != null){
            Livro li = (Livro) raiz.getObjeto();
            lista.add(li);
            System.out.println("----------------------------------------------");
            System.out.println("Nº Ebook: " +li.getEbook());
            System.out.println("Autor: " + li.getAutor());
            System.out.println("Título: " +li.getTitulo());
            System.out.println("Mês/Ano de publicação: " +li.getMes()+"/"+ li.getAno());
            System.out.println("Link para acesso: " +li.getLink());
            
            listarQtLiv(raiz.getEsquerdo(),lista);
            listarQtLiv(raiz.getDireito(), lista);
            return lista;
        }
        return lista;
       
    }
    
    /**
     *Esse método lista todos os livros catalogados no sistema, mostrando todas suas informações e depois chama a função para escrever um arquivo CSV com essas informações .<br><br>
     */
    public void listar_Quantidade_Livros(){
        ArrayList lista = new ArrayList();
        this.criarCSV("Todos os livros",listarQtLiv(this.arvore_livro.getRaiz(),lista));
    }
    
    /**
     * Esse método busca um dado livro pelo seu número de ebook, e caso encontrado retorna todas as suas informações, posteriomente é chamado a função para escrever um arquivo CSV com essas informações.<br><br>
     * @param key Uma String que corresponde ao número de ebook do livro.
     * @return O objeto do tipo No que equivale ao Livro encontrado.
     */
    public No buscarLivro(String key){
        No aux = this.arvore_livro.find(key);
        if(aux != null){
            Livro li = (Livro) aux.getObjeto();
            System.out.println("----------------------------------------------");
            System.out.println("Link para acesso: " +li.getLink());
           
            ArrayList lista = new ArrayList();
            lista.add(li);  
            this.criarCSV(key, lista);
      
        }
        else{
            System.out.println("Desculpe mas o livro com Nº de ebook: "+ key+ " não consta no nosso banco de dados" );
        }
        return aux;
    }
    
    /**
     * Esse método mostra todos os livros publicados em um dado ano, depois é chamado a função para criar um arquivo CSV com essas informações.<br><br>
     * @param key Uma String correspondente ao ano de publicação.
     * @return O objeto do tipo No que corresponde a Coleção de livros por ano.
     */
    public No listar_Ano(String key){
        No aux;
        aux = this.arvore_colecao.find(key);
        if (aux != null){
            System.out.println("No ano de " +key+ " foram publicados o(s) seguinte(s) livro(s):");
            Colecao colec = (Colecao) aux.getObjeto();
             ArrayList lista = new ArrayList();
            for( int i = 0; i < colec.getLivros().size(); i++){
                System.out.println("----------------------------------------------");
                Livro li = (Livro) colec.getLivros().get(i);
                System.out.println("Nº Ebook: " +li.getEbook());
                System.out.println("Título: " +li.getTitulo());
                System.out.println("Autor: " + li.getAutor());
                System.out.println("Mês/Ano de publicação: " +li.getMes()+"/"+ li.getAno());
                System.out.println("Link para acesso: " +li.getLink());
                lista.add(li);                    
            }
            this.criarCSV(key, lista);
        
        }
        return aux;      
    }
    
    /**
     * Esse método exclui um Livro solicitado em todo seu programa, tanto na árvore de livros como na de autores e coleções.<br><br>
     * @param key Uma String que corresponde ao número de ebook do livro.
     * @return o objeto do tipo No que foi excluido.
     */
    public No excluir(String key){
        No aux = this.arvore_livro.find(key);
        if(aux != null){
            Livro li = (Livro) aux.getObjeto();
            String keyAutor = li.getAutor();
            String keyColecao = li.getAno();
          
            this.arvore_livro.deletarInt(key);
            
            Author aut = (Author)this.arvore_author.find(keyAutor).getObjeto();
            aut.getLivros().remove(li);
            
            Colecao colec = (Colecao) this.arvore_colecao.find(keyColecao).getObjeto();
            colec.getLivros().remove(li);  
        }   
        return aux;
    }
    
    /**
     * Esse método cria um arquivo .CSV na mémoria da máquina que estiver rodando, fazendo o procedimento reverso do de leitura de arquivo, pegando dados de uma lista e escrevendo em um arquivo.<br><br>
     * @param arquivo Uma String que equivale ao nome do arquivo que será salvo no computador.
     * @param lista Um objeto da classe ArrayList que contém todas as informações que serão transpostas no arquivo.
     * @return Um boolean true caso a criação do arquivo tenha sido concluida com exito.
     */
    public boolean criarCSV(String arquivo, ArrayList lista){
        return escreverCSV(arquivo, lista);
    
    }
    
    private boolean escreverCSV(String arquivo, ArrayList lista){
        try
        {
            FileWriter writer = new FileWriter(arquivo+".csv");
            for(int i = 0; i < lista.size(); i++){
                Livro livro = (Livro) lista.get(i);
                writer.append(livro.getEbook());
                writer.append(';');
                writer.append(livro.getTitulo());
                writer.append(';');
                writer.append(livro.getAutor());
                writer.append(';');
                writer.append(livro.getMes());
                writer.append(';');
                writer.append(livro.getAno());
                writer.append(';');
                writer.append(livro.getLink());
                writer.append('\n');
            }

            writer.flush();
            writer.close();
            return true;

        }
        catch(IOException e)
        {
             return false;
        } 

    }
    
    /**
     *
     * Esse método cria um arquivo .CSV, para casos especificos de autores, na mémoria da máquina que estiver rodando, fazendo o procedimento reverso do de leitura de arquivo, pegando dados de uma lista e escrevendo em um arquivo.<br><br>
     * @param arquivo Uma String que equivale ao nome do arquivo que será salvo no computador.
     * @param lista Um objeto da classe ArrayList que contém todas as informações que serão transpostas no arquivo.
     * @return Um boolean true caso a criação do arquivo tenha sido concluida com exito.
     */
    public boolean criarCSVAut(String arquivo, ArrayList lista){
        return escreverCSVAutor(arquivo,lista);
    }
    
    private boolean escreverCSVAutor(String arquivo, ArrayList lista){
        try
        {
            FileWriter writer = new FileWriter(arquivo+".csv");
            for(int i = 0; i < lista.size(); i++){
                No aux = (No) lista.get(i);
                Author autor = (Author) aux.getObjeto();
                String str = new String();
                str = Integer.toString(autor.getLivros().size());
                
                writer.append(aux.getKey());
                writer.append(';');
                writer.append(str);
                writer.append('\n');
            }

            writer.flush();
            writer.close();
            return true;

        }
        catch(IOException e)
        {
             return false;
        } 

    }
    
    
    
}
    
    


