package Model;

/**
 * A classe <b>Lista</b>  é composta por objetos do tipo  <b>No</b>, e através dos seus métodos
 * é capaz de manipular esses objetos de tal forma a gerar uma lista.
 * Ela será responsável por ser a estrutura que irá conter os obejtos <b>Paciente</b>, <b>Medico</b> e <b>Exame</b> separadamente.<br><br>
 * Essa lista foi implementada baseada no livro "Estruturas de dados e algoritmos em java" do autor Robert Lafore.
 * 
 * @see Exame
 * @see No
 * @see Medico
 * @see Paciente
 * @author Rodrigo Damasceno Sampaio
 * @since Nov 2019
 * @version 1.0
 * 
 */
public class Lista {

    private No primeiro;
    private No ultimo;
    private int quantidade;

    /**
     *Construtor default da classe <b>No</b>.<br><br>
     * <b>Uso:</b><br>
     * Lista lista = new Lista()<br><br>
     * 
     */
    public Lista() {
        primeiro = null;
        ultimo = null;
        quantidade = 0;

    }
//---------------------------------------------------------------------------

    /**
     * Esse metódo acessa o atributo primeiro do objeto <b>Lista</b>  e o retorna.
     * @return Um <b>No</b> que equivale a referencia do primeiro <b>No</b> da <b>Lista</b> .
     * 
     */
    public No getPrimeiro() {
        return primeiro;
    }

    /**
     * Esse metódo acessa o atributo primeiro do objeto <b>Lista</b> e o altera.
     * @param primeiro È um objeto do tipo <b>No</b>.
     * 
     */
    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    /**
     * Esse metódo acessa o atributo ultimo do objeto <b>Lista</b>  e o retorna.
     * @return Um <b>No</b> que equivale a referencia do ultimo <b>No</b> da <b>Lista</b> .
     * 
     */
    public No getUltimo() {
        return ultimo;
    }

    /**
     * Esse metódo acessa o atributo ultimo do objeto <b>Lista</b> e o altera.
     * @param ultimo È um objeto do tipo <b>No</b>.
     * 
     */
    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Esse metódo acessa o atributo quantidade do objeto <b>Lista</b> e o retorna.
     * @return Um int que se refere a quantidade de <b>No</b> (elementos) que a <b>Lista</b> tem.
     * 
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Esse metódo acessa o atributo quantidade do objeto <b>Lista</b> e o altera.
     * @param quantidade È um int que se refere a quantidade de <b>No</b> (elementos) que a <b>Lista</b> tem.
     * 
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

//------------------------------------------------------------------------------   

    /**
     * Esse metódo acessa o atributo primeiro e verifica se ele é nulo, deste modo ver se a <b>Lista</b> está vazia.
     * @return Um boolean.
     */
    public boolean isEmpty() {
        return (primeiro == null);
    }

//------------------------------------------------------------------------------

    /**
     * Esse método cria um novo <b>No</b> e o insere no início da <b>Lista</b>.
     * @param objeto È um Object que será inserido como o dado do objeto <b>No</b> que será criado.
     */
    public void insertFirst(Object objeto) {
        No novoNo = new No(objeto);
        if (this.isEmpty()) {
            primeiro = ultimo = novoNo;
        } else {
            novoNo.setProximo(primeiro);
            primeiro = novoNo;
        }

        quantidade++;

    }

    /**
     * Esse método cria um novo <b>No</b> e o insere no fim da <b>Lista</b>.
     * @param objeto È um Object que será inserido como o dado do objeto <b>No</b> que será criado.
     * 
     */
    public void insertLast(Object objeto) {
        No novoNo = new No(objeto);
        if (this.isEmpty()) {
            this.primeiro = novoNo;
        } else {
            ultimo.setProximo(novoNo);
        }
        ultimo = novoNo;
        quantidade++;

    }

    /**
     * Esse método cria um novo <b>No</b> e o insere ao final do ultimo objeto prioritário da <b>Lista</b>.<br><br>
     * Dentro desse método é utlizado outros dois métodos ja prontos da <b>Lista</b>, sendo eles o <b>insertFirst</b> e o <b>insertLast</b>.<br><br> 
     * Esse método só é utilizado para objetos da classe <b>Paciente</b>
     * @see insertFirst
     * @see insertLast
     * @see Paciente
     * @param objeto È um Object que será inserido como o dado do objeto <b>No</b> que será criado.
     * 
     */
    public void insertPrioridade(Object objeto) {
        No novoNo = new No(objeto);
        No atual = primeiro;
        No anterior = primeiro;
        No teste = primeiro;

        if (this.isEmpty()) {
            this.insertFirst(objeto);
        } else {
            Paciente paciente = (Paciente)atual.getData();
            while (paciente.isPrioridade()) {
                if (atual == ultimo) {
                    ultimo.setProximo(novoNo);
                    ultimo = novoNo;
                    quantidade++;
                    return;
                } else {
                    anterior = atual;
                    atual = atual.getProximo();
                    paciente = (Paciente) atual.getData();
                }

            }
            if (atual == primeiro) {
                this.insertFirst(objeto);
                return;
            }
            novoNo.setProximo(atual);
            anterior.setProximo(novoNo);
            quantidade++;

        }
    }

//------------------------------------------------------------------------------

    /**
     * Esse método tem como função imprimir na tela todos os atributos do objeto <b>Lista</b>.
     * @param inf
     */
    public void display(int inf) {
        No aux = primeiro;
        while (aux != null) {
            aux.display(inf);
            aux = aux.getProximo();
        }
    }

//------------------------------------------------------------------------------

    /**
     * Esse método percorre a <b>Lista</b> até encontrar um determinado 
     * <b>No</b>  da <b>Lista</b> e o remove, excluindo juntamente o objeto que este <b>No</b> possui.
     * @param identificador È uma String que será a chave para localizar esse determinado <b>No</b>.
     * @return O objeto <b>No</b> removido.
     */
    public No remove(String identificador) {
        No atual = primeiro;
        No anterior = primeiro;

        if (atual.getData() instanceof Exame) {
            Exame aux = (Exame) atual.getData();
            while (aux.getNome() != identificador) {

                if (atual.getProximo() == null) {
                    return null;
                } else {
                    anterior = atual;
                    atual = atual.getProximo();
                    aux = (Exame) atual.getData();
                }

            }
            if (atual == primeiro) {
                primeiro = primeiro.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }

            quantidade--;
            return atual;
        } else if (atual.getData() instanceof Medico) {
            Medico aux = (Medico) atual.getData();
            while (aux.getCRM() != identificador) {

                if (atual.getProximo() == null) {
                    return null;
                } else {
                    anterior = atual;
                    atual = atual.getProximo();
                    aux = (Medico) atual.getData();
                }

            }
            if (atual == primeiro) {
                primeiro = primeiro.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }

            quantidade--;
            return atual;
        } else if (atual.getData() instanceof Paciente) {
            Paciente aux = (Paciente) atual.getData();
            while (aux.getMatricula() != identificador) {

                if (atual.getProximo() == null) {
                    return null;
                } else {
                    anterior = atual;
                    atual = atual.getProximo();
                    aux = (Paciente) atual.getData();
                }

            }
            if (atual == primeiro) {
                primeiro = primeiro.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
            quantidade--;
            return atual;
        } else {
            return null;
        }
    }

    /**
     * Esse método remove o primeiro <b>No</b>  da <b>Lista</b>, excluindo juntamente o objeto que este <b>No</b> possui.
     * @return O objeto <b>No</b> removido.
     */
    public No removePrimeiro() {
        No aux = primeiro;
        primeiro = primeiro.getProximo();
        quantidade--;
        return aux;
    }

//------------------------------------------------------------------------------

    /**
     * Esse método percorre toda a lista até encontrar um determinado <b>No</b> que contém objeto da classe <b>Exame</b>.
     * @param identificador È uma String que será a chave para localizar esse determinado <b>No</b>.
     * @return O obejto <b>Exame</b> encontrado
     */
    public Exame findExame(String identificador) {
        if (this.isEmpty()) {
            return null;
        }

        No atual = primeiro;
        Exame aux = (Exame) atual.getData();
        while (!aux.getNome().equals(identificador)) {
            if (atual.getProximo() == null) {
                return null;
            } else {
                atual = atual.getProximo();
                aux = (Exame) atual.getData();
            }
        }
        return aux;
    }

    /**
     * Esse método percorre toda a lista até encontrar um determinado <b>No</b> que contém objeto da classe <b>Paciente</b>.
     * @param identificador È uma String que será a chave para localizar esse determinado <b>No</b>.
     * @return O obejto <b>Paciente</b> encontrado
     */
    public Paciente findPaciente(String identificador) {
        if (this.isEmpty()) {
            return null;
        }

        No atual = primeiro;
        Paciente aux = (Paciente) atual.getData();
        while (!aux.getMatricula().equals(identificador)) {
            if (atual.getProximo() == null) {
                return null;
            } else {
                atual = atual.getProximo();
                aux = (Paciente) atual.getData();
            }
        }
        return aux;
    }

    /**
     *  * Esse método percorre toda a lista até encontrar um determinado <b>No</b> que contém objeto da classe <b>Medico</b>.
     * @param identificador È uma String que será a chave para localizar esse determinado <b>No</b>.
     * @return O obejto <b>Medico</b> encontrado
     */
    public Medico findMedico(String identificador) {   
        if (this.isEmpty()) {
            return null;
        }

        No atual = primeiro;
        Medico aux = (Medico) atual.getData();
        while (!aux.getCRM().equals(identificador)) {
            if (atual.getProximo() == null) {
                return null;
            } else {
                atual = atual.getProximo();
                aux = (Medico) atual.getData();
            }
        }
        return aux;
    }

//------------------------------------------------------------------------------

    void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
