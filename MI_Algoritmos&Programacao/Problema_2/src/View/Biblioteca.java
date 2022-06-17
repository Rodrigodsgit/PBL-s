/**
 ****************************************************************************************
 *Autores: Rodrigo Damasceno Sampaio, Rita Kassiane
 *Componente Curricular: MI- Programação
 *Concluido em: 03/02/2020
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ******************************************************************************************
 */


package View;

import Controller.Sistema;
import java.io.IOException;
import java.util.Scanner;

/**
 * A classe Biblioteca contém a main do programa e através dela será dado inicio ao todo sistema.<br><br>
 * A classe Biblioteca possui um quadro de menu disponibilizando nela 9 opções para o usuário.<br><br>
 * A classe Biblioteca é responsável por coletar os dados e passa-lós a classe Bibliotecario.<br><br>
 * 
 * @see Bibliotecario
 * @author Rodrigo Damasceno, Rita  Kassiane.
 * @since Fev 2020
 * @version 1.0
 */
public class Biblioteca {

    /**
     * Construtor da classe Biblioteca.<br><br>
     * È inicializado diretamente pelo programa.
     * Contém a tela de menu do programa.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
       
        Sistema sis = new Sistema();
        Bibliotecario bio = new Bibliotecario();
        String resposta = "N";
        Scanner sc = new Scanner(System.in);
        System.out.println("#=================================================#");
        System.out.println("#=================================================#");
        System.out.println("#=======Seja bem vindo ao clube de leitura========#");
        System.out.println("#============= COMUNIDADE DA BATATA ==============#");
        System.out.println("#=================================================#");
        System.out.println("#====Nosso sistema está pronto pra atende-lo======#");
        System.out.println("#================Faça um bom uso==================#");
        System.out.println("#=================E lembre-se ====================#");
        System.out.println("#============A leitura engrandece a alma==========#");
        System.out.println("#=================================================#");
        System.out.println("#=================================================#");
        
        
        do{
            System.out.println("#=================================================#");
            System.out.println("#========Sistema de Cataloção de Livro (SCL)======#");
            System.out.println("#=================================================#");
            System.out.println("----------Escolha uma da opções abaixo-------------");
            System.out.println("--------------Ou digite {S} para sair--------------");
            System.out.println("#=================================================#");
            System.out.println("#1--Cadrastar um novo livro------------------------");
            System.out.println("#2--Carregar catálogo padrão do nosso sistema------");
            System.out.println("#3--Carregar catálogo de sua prefência-------------");
            System.out.println("#4--Listar autores e sua respectiva quantidade de livros");
            System.out.println("#5--Listar todos os livros de um autor-------------");
            System.out.println("#6--Listar todos os livros catalogados-------------");
            System.out.println("#7--Buscar livro-----------------------------------");
            System.out.println("#8--Listar livros publicados em um dado ano--------");
            System.out.println("#9--Excluir um determinado livro-------------------");
            
            resposta = sc.nextLine();
            switch (resposta){
                case "1":
                    bio.opcao1(sis);
                    break;
                case "2":
                    bio.opcao2(sis);
                    break;
                case "3":
                    caso3(bio,sis);
                    break;
                case "4":
                    bio.opcao4(sis);
                    break;
                case "5":
                    caso5(bio,sis);
                    break;
                case "6":
                    bio.opcao6(sis);
                    break;
                case "7":
                    caso7(bio,sis);
                    break;
                case "8":
                    caso8(bio,sis);
                    break;
                case "9":
                    caso9(bio,sis);
                    break;
                default:
                    break;
            }

            

        System.out.println("Deseja sair do programa? {S/N}");
        System.out.print("=======>>");
        resposta = sc.nextLine();
        resposta = resposta.toUpperCase();

        }while(!"S".equals(resposta));
        System.out.println("#=================================================#");
        System.out.println("#=================================================#");
        System.out.println("#========Obrigado por utilizar nosso sistema======#");
        System.out.println("#=========Programa encerrado com sucesso==========#");
        System.out.println("#=================================================#");
        System.out.println("#=================================================#");
       
    }
    
    /**
     * Esse método tem única função de pegar uma informação do usuário, passa-lá para a classe Bibliotecario e manter uma melhor estética.<br><br>
     * @param bio Objeto do tipo Bibliotecario instânciado pela classe Biblioteca
     * @param sis Objeto do tipo Sistema instânciado pela classe Biblioteca
     * @throws IOException
     */
    public static void caso3(Bibliotecario bio,Sistema sis) throws IOException{
        Scanner sc = new Scanner(System.in);
        String arquivo;
        System.out.println("#=================================================#");
        System.out.println("#--Por favor digite o nome do arquivo que deseja carregar.");
        System.out.print("==========>>");
        arquivo = sc.nextLine();
        
        bio.opcao3(sis, arquivo);
    
    }

    /**
     *
     * Esse método tem única função de pegar uma informação do usuário, passa-lá para a classe Bibliotecario e manter uma melhor estética.<br><br>
     * @param bio Objeto do tipo Bibliotecario instânciado pela classe Biblioteca
     * @param sis Objeto do tipo Sistema instânciado pela classe Biblioteca
     */
    public static void caso5(Bibliotecario bio, Sistema sis){
        Scanner sc = new Scanner(System.in);
        String autor;
        System.out.println("#=================================================#");
        System.out.println("#--Por favor digite o nome do autor que deseja buscar.");
        System.out.print("=======>>");
        autor = sc.nextLine();
        
        bio.opcao5(sis, autor);
        
        
    }
    
    /**
     * Esse método tem única função de pegar uma informação do usuário, passa-lá para a classe Bibliotecario e manter uma melhor estética.<br><br>
     * @param bio Objeto do tipo Bibliotecario instânciado pela classe Biblioteca
     * @param sis Objeto do tipo Sistema instânciado pela classe Biblioteca
     */
    public static void caso7(Bibliotecario bio, Sistema sis){
        Scanner sc = new Scanner(System.in);
        String livro;
        System.out.println("#=================================================#");
        System.out.println("#--Por favor digite o Nº do ebook que deseja buscar.");
        System.out.println("=======>>");
        livro = sc.nextLine();
        
        bio.opcao7(sis, livro);
        
     }
     
    /**
     *
     * Esse método tem única função de pegar uma informação do usuário, passa-lá para a classe Bibliotecario e manter uma melhor estética.<br><br>
     * @param bio Objeto do tipo Bibliotecario instânciado pela classe Biblioteca
     * @param sis Objeto do tipo Sistema instânciado pela classe Biblioteca
     */
    public static void caso8(Bibliotecario bio, Sistema sis){
        Scanner sc = new Scanner(System.in);
        String ano;
        System.out.println("#=================================================#");
        System.out.println("#--Por favor digite qual ano deseja fazer a buscar");
        System.out.println("=======>>");
        ano = sc.nextLine();
        
        bio.opcao8(sis, ano);
        
     }
    
    /**
     * 
     * Esse método tem única função de pegar uma informação do usuário, passa-lá para a classe Bibliotecario e manter uma melhor estética.<br><br>
     * @param bio Objeto do tipo Bibliotecario instânciado pela classe Biblioteca
     * @param sis Objeto do tipo Sistema instânciado pela classe Biblioteca
     */
    public static void caso9(Bibliotecario bio, Sistema sis){
        Scanner sc = new Scanner(System.in);
        String livro;
        System.out.println("#=================================================#");
        System.out.println("#--Por favor digite o Nº do ebook que deseja excluir.");
        System.out.println("=======>>");
        livro = sc.nextLine();

     bio.opcao9(sis, livro);

  }
    
}
