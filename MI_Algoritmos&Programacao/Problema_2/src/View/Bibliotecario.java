package View;

import Controller.Sistema;
import Model.Livro;
import Model.No;
import java.io.IOException;
import java.util.Scanner;

/**
 * A classe Bibliotecario é um mediador entre o Sistema e o menu (Biblioteca).<br><br>
 * A classe tem como finalidade, chamar os métodos equivalentes da classe Sistema para com as opções escolhidas, apresentando os resultados corretamente e tratando erros caso seja necessário.<br><br>
 * 
 * @see Biblioteca
 * @see Sistema
 * @author Rodrigo Damasceno, Rita Kassiane.
 * @since Fev 2020
 * @version 1.0
 */
public class Bibliotecario {
    
    /**
     * Esse método associa dados digitados pelo usuário para o cadastramento de um novo Livro.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     */
    public void opcao1(Sistema sis){
    //--------------------------------------------------------------------------    
        
        String ebook;
        String titulo;
        String autor;
        String mes;
        String ano;
        String link;
        No aux;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número do ebook [Somente números].");
        System.out.print("Nº Ebook: ");
        ebook = sc.nextLine();
        System.out.println("Digite o título do livro.");
        System.out.print("Título: ");
        titulo = sc.nextLine();
        System.out.println("Digite o nome do autor.");
        System.out.print("Autor: ");
        autor = sc.nextLine();
        System.out.println("Digite o mês em que o livro foi publicado [Somente as 3 primeiras letras].");
        System.out.print("Mês: ");
        mes = sc.nextLine();
        System.out.println("Digite o ano em que o livro foi publicado.");
        System.out.print("Ano: ");
        ano = sc.nextLine();
        System.out.println("Digite o link para acesso do livro.");
        System.out.print("Link: ");
        link = sc.nextLine();
        
        aux = sis.cadastrarLivro(ebook, titulo, autor, mes, ano, link);
        if(aux != null){
            Livro add = (Livro) aux.getObjeto();
            System.out.println("Novo livro adicionado");
            System.out.println("Nº ebook: "+ add.getEbook());
            System.out.println("Título: "+add.getTitulo());
            System.out.println("Autor(a): "+add.getAutor());
            System.out.println("Mes/Ano de publicação:" + add.getMes()+"/"+add.getAno());
            System.out.println("Link para acesso: "+add.getLink());

        //--------------------------------------------------------------------------
            System.out.println("-------------------------------------------------");
            No aux2 = sis.cadastrarAutor(autor, add);
            if(aux2!= null){
                System.out.println("Lista de livros do Author " + autor + " atualizado");
            }
            No aux3 = sis.cadastrarColecao(ano, add);
            if (aux3 != null){
                System.out.println("Colecão do ano " + ano + " atualizada" );
            }
        }
        else{
            System.out.println("O livro de Nº de ebook "+ ebook+" já consta no nosso banco de dados");
        }
        
    }
    
    /**
     * 
     * Esse método faz a leitura do arquivo CVS padrão encontrado no sistema.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     * @throws IOException
     */
    public void opcao2(Sistema sis) throws IOException{
        sis.leituraArq();
    
    }
    
    /**
     * Esse método faz a leitura de um arquivo CSV dado pelo usuário.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     * @param arquivo Uma String contendo o nome do arquivo que será lido.
     * @throws IOException
     */
    public void opcao3(Sistema sis,String arquivo) throws IOException{
        sis.leituraArqQualquer(arquivo);
    
    }
    
    /**
     * 
     * Esse método lista todos os autores catalogados e que estão contidos na árvore, juntamente com a quantidade de  Livros por eles escrito.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     */
    public void opcao4(Sistema sis){
        sis.listar_Quant_Autor();
    }
    
    /**
     *
     * Esse método lista todos os livros escritos de um dado autor.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     * @param key Uma String contendo o nome do autor que deseja buscar.
     */
    public void opcao5(Sistema sis, String key){
        No aux;
        aux = sis.listar_Livro_Autor(key);
        if (aux == null){
            System.out.println("Desculpe mas o autor " + key +" não está cadastrado no nosso banco de dados." );
        }
    
    }
    
    /**
     *
     * Esse método lista todos os livros catalogados no sistema.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     */
    public void opcao6(Sistema sis){
        sis.listar_Quantidade_Livros();
    }
    
    /**
     * 
     * Esse método busca um livro através de um dado número de ebook e o mostra na tela.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     * @param key Uma String contendo o número do ebook do livro que será buscado na árvore do sistema.
     */
    public void opcao7(Sistema sis, String key){
        sis.buscarLivro(key);
    }
    
    /**
     * Esse método lista todos os livros publicados em um certo ano.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     * @param key Uma String contendo o ano que será buscado os livros nesse ano foram publicados.
     */
    public void opcao8(Sistema sis, String key){
        No aux;
        aux = sis.listar_Ano(key);
        if (aux == null){
            System.out.println("Desculpe mas o ano " + key +" não está cadastrado no nosso banco de dados." );
        }

    
    }
    
    /**
     * Esse método exclui um dado livro do banco de dados do sistema.<br><br>
     * Esse método chama métodos da classe Sistema que se façam necessários para atender a opção selecionada.<br><br>
     * @param sis O objeto do tipo Sistema inicializado na classe Biblioteca.
     * @param key Uma String contendo o número do ebook que será deletado.
     */
    public void opcao9(Sistema sis,String key){
        No aux;
        aux = sis.excluir(key);
        if (aux != null){
            System.out.println("O livro com Nº de ebook " + key +" foi excluido do nosso banco de dados." );
        }
        else{
            System.out.println("O livro com Nº de ebook "+key+" não foi encontrado");
        }
 
    }
    
}
