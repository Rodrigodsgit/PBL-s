                   
package Model;

/**
 * A classe árvore é a forma de armazenamento principal desse sistema, usada para guarda os Livros, Authores e Coleções.<br><br>
 * Ela é formada pelos Nos e graças a sua forma de implementação e balaceamento obtemos uma sistema de busca em OLog(n).<br><br>
 * Ela contém como atributo um No raiz que equivale ao primeiro No da árvore.<br><br>
 * 
 * @see Livro
 * @see Author
 * @see Colecao
 * @see No
 * @author Rodrigo Damasceno, Rita Kassiane
 * @since Fev 2020
 * @version 1.0
 */
public class Arvore {
    private No raiz;

//------------------------------------------------------------------------------

    /**
     * Esse método pega o No raiz da árvore e o retorna .<br><br>
     * @return O No raiz da árvore.
     */
    public No getRaiz() {
        return raiz;
    }

    /**
     * Esse método atualiza o No raiz da ´árvore .<br><br>
     * @param raiz Um objeto do tipo No que será a nova raiz.
     */
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
    
//------------------------------------------------------------------------------      

    /**
     * Esse método retorna true caso a a´rvore esteja vazia e false caso exista algum elemento nela.<br><br>
     * @return Um boolean
     */
    
    public boolean isEmpty(){
        return (raiz == null);       
    }
    
    /**
     * Esse método compara a altura de dois Nos e retorna o valor da maior altura.<br><br>
     * @param altura_1 Um inteiro que equivale a altura de um No.
     * @param altura_2  Um inteiro que equivale a altura de um No.
     * @return Um int 
     */
    public int alturaMax (int altura_1, int altura_2){
        if (altura_1 > altura_2){
            return altura_1;
        }
        else{
            return altura_2;
        }
    
    }
    
    /**
     * Esse método retornar a altura do No, caso o No passado seja null a altura retornada é 0.<br><br>
     * @param no Um No 
     * @return Um inteiro equivalente a altura do No.
     */
    public int altura (No no){
        if (no == null){
            return 0;
        }
        else{
            return no.getAltura();
        
        }
    }
    
    /**
     * Esse método rotaciona a árvore a esquerda quando há um desbalaceamento a direita.<br><br>
     * @param raiz Um objeto do tipo No que precisa ser balanceado
     * @return Um objeto do tipo equivalente ao No rotacionado.
     */
    public No rotacaoEsquerda (No raiz){
        No aux = raiz.getDireito();
        raiz.setDireito(aux.getEsquerdo());
        aux.setEsquerdo(raiz);
        
        raiz.setAltura(alturaMax(altura(raiz.getEsquerdo()), altura(raiz.getDireito())) + 1);
        aux.setAltura(alturaMax(altura(aux.getEsquerdo()), altura(aux.getDireito())) + 1);
        
        return aux;
    
    }
    
    /**
     * Esse método rotaciona a árvore para a direita quando há um desbalanceamento a esquerda.<br><br>
     * @param raiz Um objeto do tipo No que precisa ser balanceado.
     * @return Um objeto do tipo NO equivalente ao No rotacionado.
     */
    public No rotacaoDireita (No raiz){ 
        No aux = raiz.getEsquerdo();       
        raiz.setEsquerdo(aux.getDireito());
        aux.setDireito(raiz);  
        
        raiz.setAltura(alturaMax(altura(raiz.getEsquerdo()),altura(raiz.getDireito())) + 1);
        aux.setAltura(alturaMax(altura(raiz.getEsquerdo()),altura(raiz.getDireito())) + 1);
        
        return aux;
        
    }
    
    /**
     * Esse método faz uma rotação Direta-Esquerda chamando primeiro a função já existente rotacaoDireita e depois rotacaoEsquerda .<br><br>
     * @param raiz Um objeto do tipo No que precisa ser balanceado.
     * @return Um objeto do tipo No equivalente ao No rotacionado.
     */
    public No rotacaoDireitaEsquerda (No raiz){
        raiz.setDireito(rotacaoDireita(raiz.getDireito()));
        return rotacaoEsquerda(raiz);  
    }
    
    /**
     * Esse método faz uma rotação Esquerda-Direita chamando primeiro a função jpa existente rotacaoEsquerda e depois rotacaoDireita.<br><br>
     * @param raiz Um objeto do tipo No que precisa ser balanceado.
     * @return Um objeto do tipo No equivalente ao No rotancionado.
     */
    public No rotacaoEsquerdaDireita(No raiz){
        raiz.setEsquerdo(rotacaoEsquerda(raiz.getEsquerdo()));
        return rotacaoDireita(raiz);
    
    }

    /**
     * Esse método calcula o fator de balaceamento de um No.<br><br>
     * @param raiz Um objeto do tipo No que deseja ver o fator.
     * @return Um inteiro que equivale ao valor de balanceamento.
     */
    public int balanceamento(No raiz){
        if (raiz == null){
            return 0;
        }
        else{
            return altura(raiz.getEsquerdo()) - altura(raiz.getDireito());
        }
    
    }
   
    /**
     * Esse método, através do fator de balaceamento (2 e -2), julga se é necessário balancear a árvore e qual tipo de rotação deverá ser feita.<br><br>
     * @param raiz Um objeto do tipo No que deseja ver se é necessário o balanceamento (sendo percorrido a árvore toda).
     * @return Um objeto do tipo No equivalente ao No balanceado.
     */
    public No balancear (No raiz){ 
        if (balanceamento(raiz)== -2){
            if (balanceamento(raiz.getDireito())<=0){
                return rotacaoEsquerda(raiz);
            }
            else if (balanceamento(raiz.getDireito())> 0){
                return rotacaoDireitaEsquerda(raiz);
            }
        }
        else if(balanceamento(raiz) == 2){
            if(balanceamento(raiz.getEsquerdo()) >= 0){
                return rotacaoDireita(raiz);
            }
            else if (balanceamento(raiz.getEsquerdo()) < 0){
                return rotacaoEsquerdaDireita(raiz);
            }
        }
        return raiz;
    }
  
    /**
     * Esse método insere um novo No na árvore na posição adequada e balanceado se caso seja necessário.<br><br>
     * Esse método utiliza como forma de comparação para a inserção chaves de valores inteiros.<br><br>
     * Esse método chama outro método privado que fará tudo descrito anteriomente.<br><br>
     * @param novo O novo No que deseja inserir.
     */
    public void insercaoInt (No novo){
        this.raiz = inserirInt(this.raiz,novo);
            
        }
  
    /**
     * 
     * Esse método insere um novo No na árvore na posição adequada e balanceado se caso seja necessário.<br><br>
     * Esse método utiliza como forma de comparação para a inserção chaves de String.<br><br>
     * Esse método chama outro método privado que fará tudo descrito anteriomente.<br><br>
     * @param novo O novo No que deseja inserir.
     */
    public void insercaoStr (No novo){
        this.raiz = inserirStr(this.raiz,novo);
            
        }
 
    private No inserirInt(No raiz, No novo){
        if (raiz == null){           
            return novo;
        }
        int numNovo = Integer.parseInt(novo.getKey());
        int numRaiz = Integer.parseInt(raiz.getKey());

        if (numNovo == numRaiz){
            
        }
        else if (numNovo < numRaiz){
            raiz.setEsquerdo(inserirInt(raiz.getEsquerdo(),novo));
        }    
        else if (numNovo > numRaiz){
            raiz.setDireito(inserirInt(raiz.getDireito(),novo));
        }
        else{
            return raiz;
        }
        
        raiz.setAltura(alturaMax(altura(raiz.getEsquerdo()),altura(raiz.getDireito()))+1);
        return balancear(raiz);
    
    }
    
    private No inserirStr(No raiz, No novo){
        
        if (raiz == null){
           
            return novo;
        }
        if (novo.getKey().compareToIgnoreCase(raiz.getKey()) == 0){
           
            
        }
        else if (novo.getKey().compareToIgnoreCase(raiz.getKey()) < 0){
            raiz.setEsquerdo(inserirStr(raiz.getEsquerdo(),novo));
        }    
        else if (novo.getKey().compareToIgnoreCase(raiz.getKey()) > 0){
            raiz.setDireito(inserirStr(raiz.getDireito(),novo));
        }
        else{
            return raiz;
        }
        
        raiz.setAltura(alturaMax(altura(raiz.getEsquerdo()),altura(raiz.getDireito()))+1);
        return balancear(raiz);
    
    }
    
    /**
     * 
     * Esse método, através de recurssividade, contabiliza quantos elemento existem na árvore.<br><br>
     * @param raiz O no que equivale a raiz da árvore.
     * @return Um inteiro equivalente a quantidade de elementos na árvore.
     */
    public int contar( No raiz){
        int esq = 0;
        int dir = 0;
        if(raiz != null){
            esq = contar(raiz.getEsquerdo());
            dir = contar(raiz.getDireito());
            return dir+ esq +1;
        }
        return dir + esq;
    }
    
    private No deleteInt(String key, No raiz){
        if(raiz == null){
            this.raiz= null;
        }
        
        int numRaiz = Integer.parseInt(raiz.getKey());
        int numKey = Integer.parseInt(key);


        if (numKey < numRaiz ){
            raiz.setEsquerdo(deleteInt(key,raiz.getEsquerdo()));
        }
        else if (numKey > numRaiz){
            raiz.setDireito(deleteInt(key,raiz.getDireito()));
        }
        else{
          if(raiz.getEsquerdo() == null || raiz.getDireito() == null){
              No aux;
              if (raiz.getEsquerdo() == null){
                  aux = raiz.getDireito();
                  raiz = aux;
              }
              else{
                  aux = raiz.getEsquerdo();
                  raiz = aux;
              }
              if(aux == null){
                  aux = raiz;
                  raiz = null;
                  return raiz;
              }
          }
          else{
              No auxiliador = this.keyMenor(raiz.getDireito());
              if (auxiliador == null){
                raiz.getDireito().setEsquerdo(raiz.getEsquerdo());
                raiz = raiz.getDireito();
              }
              else{
                raiz.setKey(auxiliador.getKey());
                raiz.setObjeto(auxiliador.getObjeto());
                raiz.setDireito(deleteInt(auxiliador.getKey(),raiz.getDireito()));
              }   
            }
        }
        raiz.setAltura(alturaMax(altura(raiz.getEsquerdo())+1, altura(raiz.getDireito())));
        return balancear(raiz);
        
    }
    
    private No deleteStr(String key, No raiz){
        if(raiz == null){
            this.raiz= null;
        }
        if (key.compareToIgnoreCase(raiz.getKey()) < 0 ){
            raiz.setEsquerdo(deleteStr(key,raiz.getEsquerdo()));
        }
        else if (key.compareToIgnoreCase(raiz.getKey()) > 0){
            raiz.setDireito(deleteStr(key,raiz.getDireito()));
        }
        else{
          if(raiz.getEsquerdo() == null || raiz.getDireito() == null){
              No aux;
              if (raiz.getEsquerdo() == null){
                  aux = raiz.getDireito();
                  raiz = aux;
              }
              else{
                  aux = raiz.getEsquerdo();
                  raiz = aux;
              }
              if(aux == null){
                  aux = raiz;
                  raiz = null;
                  return raiz;
              }
          }
          else{
            No auxiliador = this.keyMenor(raiz.getDireito());
            if (auxiliador == null){
                raiz.getDireito().setEsquerdo(raiz.getEsquerdo());
                raiz = raiz.getDireito();
              }
            else{
                raiz.setKey(auxiliador.getKey());
                raiz.setObjeto(auxiliador.getObjeto());
                raiz.setDireito(deleteInt(auxiliador.getKey(),raiz.getDireito()));
              } 
          } 
        }
        raiz.setAltura(alturaMax(altura(raiz.getEsquerdo())+1, altura(raiz.getDireito())));
        return balancear(raiz);
        
    }

    /**
     * 
     * Esse método buscar na árvore qual o elemento de menor chave/valor.<br><br>
     * @param raiz O No equivalente a raiz da árvore.
     * @return Um objeto do tipo No que possui a menor chave/valor da árvore. 
     */
    public No keyMenor(No raiz) {
        if (raiz == null){
            return null;
        }
        if (raiz.getDireito()== null && raiz.getEsquerdo() == null) {
            return raiz;
        } else if (raiz.getEsquerdo() != null) {
            return keyMenor(raiz.getEsquerdo());
        } else {
            return raiz;
        }

        
    }
    
    /**
     * Esse método deleta um No da árvore através do identificador informado, após isso árvore é balanceada novamente caso necessário.<br><br>
     * Esse método exclui um No baseado em um identificador de valor inteiro.<br><br>
     * Esse método chama outro método privado que fará tudo dito anteriomente.
     * @param key Uma String que será convertida para inteiro, que será usada com identificador do No para acha-ló na árvore.
     */
    public void deletarStr(String key) {
        this.raiz = deleteStr(key,this.raiz);

    } 
    
    /**
     * 
     * Esse método deleta um No da árvore através do identificador informado, após isso árvore é balanceada novamente caso necessário.<br><br>
     * Esse método exclui um No baseado em um identificador String.<br><br>
     * Esse método chama outro método privado que fará tudo dito anteriomente.
     * @param key Uma String que será usada com identificador do No para acha-ló na árvore.
     */
    public void deletarInt(String key) {
        this.raiz = deleteInt(key,this.raiz);

    } 
    
    private No procuraNo(String key, No raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.getKey().equals(key)) {
            return raiz;
        } else if (raiz.getKey().compareToIgnoreCase(key) > 0) {
            return procuraNo(key, raiz.getEsquerdo());
        } else {
            return procuraNo(key, raiz.getDireito());
        }
    }
    
    /**
     * Esse método busca um No na árvore.<br><br>
     * @param key Uma String identificadora do No.
     * @return Um objeto do tipo No que se refere ao no buscado, caso nao encontre o valor é null.
     */
    public No find(String key){
        return procuraNo(key,this.raiz);
    
    }
    
    
    
    

}
