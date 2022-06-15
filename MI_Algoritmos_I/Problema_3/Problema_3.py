'''/*******************************************************************************
Autor: Rodrigo Damasceno Sampaio
Componente Curricular: MI Algoritmos
Concluido em: 14/09/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/'''
import random

#Criação da classe Carta, com seus devidos atributos.
class Cartas:
    def __init__(self):
        self.nome  = ''
        self.valor = 0
        self.forca = 0.0
        self.energia  = 0.0
        self.jokempo = ''

#Criação do arquivo que vai contém todos  os jogadores e seus respectivos dados.
def arquivo_cadrastro():
    #Tenta abrir o arquivo no modo leitura
    try:
        arquivo = open('Users.txt', 'r')
        arquivoAberto = arquivo.readlines()
        arquivo.close()
    #Caso não exista é criado um novo arquivo
    except:
        arquivo = open('Users.txt', 'w')
        arquivo.write('NomePadrao;PartidasJogadas;Partidas ganhas\n')
        arquivo.close()
        arquivo = open('Users.txt', 'r')
        arquivoAberto = arquivo.readlines()
        arquivo.close()

    arquivoCadrasto = []
    for cadrasto in arquivoAberto:
        cadrasto = cadrasto.strip('\n').split(';')
        arquivoCadrasto.append(cadrasto)
    return arquivoCadrasto

#Criação da lista que vai contém todas as cartas do baralho.
def abrir_Baralho():
    #Abre o arquivo de cartas, trata ele e transforma em uma matriz
    baralho = open('Cartas.txt','r')
    baralhoLido = baralho.readlines()
    baralho.close()
    baralhoLimpo = []


    for carta in baralhoLido:
        carta = carta.strip('\n').split(';')
        if carta[0] != 'Personagem':
            baralhoLimpo.append(carta)


    return baralhoLimpo

#Função que trasnforma cada carta do baralho em um objeto da classe Cartas, retornando uma lista(baralho) com todas as cartas.
def classe_Carta(lista):
    #Transforma cada cada carta na matriz lida na função anterior em um objeto do tipo Cartas, depois esse objeto criado é adicionado a lista baralhoFinal
    baralhoFinal =[]
    for i in lista:
        c = Cartas()
        c.nome = i[0]
        c.valor = int(i[1])
        c.forca = float(i[2])
        c.energia = float(i[3])
        c.jokempo = i[4]
        baralhoFinal.append(c)
    return baralhoFinal

#Função para embaralhar a lista de cartas (baralho)
def embaralhar(lista):
    #Recebe o lista de objetos criado anteriomente e embaralha ela através da remoção de um elemento aleatório da lista
    #E a reposição desse elemento em outra lista(baralhoEmbaralhado)
    #È repetido o processo até que essa nova lista tenha o mesmo tamanho da lista inicial passada por parâmetro
    baralhoEmbaralhado = []
    tamanho = len(lista)
    while len(baralhoEmbaralhado) < tamanho:
        indice = (random.randint(0, len(lista) - 1))
        auxiliar = lista.pop(indice)
        baralhoEmbaralhado.append(auxiliar)

    return baralhoEmbaralhado

#Função que recebe a lista de objetos tipo Carta e remove 5 cartas para a mão de cada jogador
def destribuir_Cartas(baralho):
    maoJogador1 = []
    maoJogador2 = []
    for i in range(5):
        maoJogador1.append(baralho.pop())
        maoJogador2.append(baralho.pop())

    return maoJogador1,maoJogador2,baralho

#Função que ordena a mão do jogaodr de acordo com o modo de disputa escolhido
def modo_disputa(deck,disputa):
    #Através do modo de ordenação (mais explicado no relatório) é organizado a mão do jogador no modo de disputa escolhido
    #Depois é mostrado a mão do jogador na forma ordenada
    #E é retornada o novo deck dele
    if disputa == '1':
        for i in range(0, len(deck)):
            menor = deck[i]
            for j in range(i, len(deck)):
                if menor.valor > deck[j].valor:
                    deck[i] = deck[j]
                    deck[j] = menor
                    menor = deck[i]
        print('Deck organizado por Valor')
        for a in deck:
            print(a.nome, a.valor, a.forca, a.energia, a.jokempo)
        return deck
    elif disputa == '2':
        for i in range(0, len(deck)):
            menor = deck[i]
            for j in range(i, len(deck)):
                if menor.forca > deck[j].forca:
                    deck[i] = deck[j]
                    deck[j] = menor
                    menor = deck[i]
        print('Deck organizado por Força')
        for a in deck:
            print(a.nome, a.valor, a.forca, a.energia, a.jokempo)
        return deck
    elif disputa == '3':
        for i in range(0, len(deck)):
            menor = deck[i]
            for j in range(i, len(deck)):
                if menor.energia > deck[j].energia:
                    deck[i] = deck[j]
                    deck[j] = menor
                    menor = deck[i]
        print('Deck organizado por energia')
        for a in deck:
            print(a.nome, a.valor, a.forca, a.energia, a.jokempo)
        return deck
    #No caso do modo Jokempô as cartas na mão do jogador são embaralhadas, utilizando o mesmo metódo da função embaralhar o baralho
    elif disputa == '4':
        deck_embaralhado = []
        tamanho = len(deck)
        while len(deck_embaralhado) < tamanho:
            indice = (random.randint(0, len(deck)-1))
            auxiliar = deck.pop(indice)
            deck_embaralhado.append(auxiliar)
        print('Deck embaralhado')
        for a in deck_embaralhado:
            print(a.nome, a.valor, a.forca, a.energia, a.jokempo)
        return deck_embaralhado
    #Tipo de disputa 5  é em caso do modo de jogo manual, onde as cartas estão sempre em ordem alfabética
    elif disputa == '5':
        for i in range(0, len(deck)):
            menor = deck[i]
            for j in range(i, len(deck)):
                if menor.nome > deck[j].nome:
                    deck[i] = deck[j]
                    deck[j] = menor
                    menor = deck[i]
        for a in deck:
            print(a.nome, a.valor, a.forca, a.energia, a.jokempo)
        return deck

#Função de jogabilidade do modo aleatório
def jogar_aleatorio(deck,jogadores):
    deck1 = deck[0]
    deck2 = deck[1]
    cava = deck[2]
    rodada_jogador1 = 0
    rodada_jogador2 = 0
    jogador1 = jogadores[0]
    jogador2 = jogadores[1]

    #È criado um laço na quantidade máxima de rodadas
    for i in range(10):
        #Caso seja a primeira partida o jogador 1 começa e assim vai alternando a cada rodada
        if i % 2 == 0:
            print('-_' * 20)
            print(f'Jogador 1: {jogador1} || Rodadas ganhas {rodada_jogador1}')
            print('Essa é sua mão')
            for a in deck1:
                print(a.nome,a.valor,a.forca,a.energia,a.jokempo)
            print('-_' * 20)
            print('Escolha o tipo da disputa')
            print('{1} Valor\n{2} Força\n{3} Energia\n{4} Jokempô')
            tipo_disputa = input()
            print('-_' * 20)
            #È chamada a função que ordena a mão do jogador de acordo com o modo de disputa
            deck1 = modo_disputa(deck1,tipo_disputa)
            print('-_' * 20)
            #È sorteado um número de acordo com a quantidade de cartas que o usuário tem em mãos
            posicao = (random.randint(0,len(deck1)-1))
            #È removida da mão a carta sorteada, sempre preocupação de salvá-la, pois idenpendente do resultado ela será descartada
            carta_jogador1 = deck1.pop(posicao)
            print('Sua carta sorteada foi')
            print(carta_jogador1.nome, carta_jogador1.valor, carta_jogador1.forca, carta_jogador1.energia, carta_jogador1.jokempo)

            #Estrura de tratamento somente para converter o número da disputa para o nome, deixando mais prático para o entendimento do usuário
            if tipo_disputa == '1':
                modo = 'Valor'
            elif tipo_disputa == '2':
                modo = 'Força'
            elif tipo_disputa == '3':
                modo = 'Energia'
            elif tipo_disputa == '4':
                modo = 'Jokempô'

            #È feita a mesma coisa para o jogador 2
            print('-_' * 20)
            print(f'Jogador 2: {jogador2} || Rodadas ganhas {rodada_jogador2}')
            print(f'O tipo de disputa escolhido foi: {modo}')
            deck2 = modo_disputa(deck2,tipo_disputa)
            print('-_' * 20)
            posicao = (random.randint(0, len(deck2) - 1))
            carta_jogador2 = deck2.pop(posicao)
            print('Sua carta sorteada foi')
            print(carta_jogador2.nome, carta_jogador2.valor, carta_jogador2.forca, carta_jogador2.energia, carta_jogador2.jokempo)
            print('-_' * 20)

            #È passado para a função de comparação do ganhador da rodada, as cartas dos jogadores e todas as outras informações que serão atualizadas nela
            resultado = ganhador_rodada(deck1,deck2,cava,jogadores,tipo_disputa,carta_jogador1,carta_jogador2,rodada_jogador1,rodada_jogador2)
            rodada_jogador1 = resultado[0]
            rodada_jogador2 = resultado[1]
        #Repetido o mesmo processo, invertendo a ordem dos jogadores.
        else:
            print('-_' * 20)
            print(f'Jogador 2: {jogador2} || Rodadas ganhas {rodada_jogador2}')
            print('Essa é sua mão')
            for a in deck2:
                print(a.nome, a.valor, a.forca, a.energia, a.jokempo)
            print('-_' * 20)
            print('Escolha o tipo da disputa')
            print('{1} Valor\n{2} Força\n{3} Energia\n{4} Jokempô')
            tipo_disputa = input()
            print('-_' * 20)
            deck2 = modo_disputa(deck2, tipo_disputa)
            print('-_' * 20)
            posicao = (random.randint(0, len(deck2) - 1))
            carta_jogador2 = deck2.pop(posicao)
            print('Sua carta sorteada foi')
            print(carta_jogador2.nome, carta_jogador2.valor, carta_jogador2.forca, carta_jogador2.energia,
                  carta_jogador2.jokempo)

            if tipo_disputa == '1':
                modo = 'Valor'
            elif tipo_disputa == '2':
                modo = 'Força'
            elif tipo_disputa == '3':
                modo = 'Energia'
            elif tipo_disputa == '4':
                modo = 'Jokempô'

            print('-_' * 20)
            print(f'Jogador 1: {jogador1} || Rodadas ganhas {rodada_jogador1}')
            print(f'O tipo de disputa escolhido foi: {modo}')
            deck1 = modo_disputa(deck1, tipo_disputa)
            print('-_' * 20)
            posicao = (random.randint(0, len(deck1) - 1))
            carta_jogador1 = deck1.pop(posicao)
            print('Sua carta sorteada foi')
            print(carta_jogador1.nome, carta_jogador1.valor, carta_jogador1.forca, carta_jogador1.energia,
                  carta_jogador1.jokempo)
            print('-_' * 20)

            resultado = ganhador_rodada(deck1, deck2, cava, jogadores, tipo_disputa, carta_jogador1, carta_jogador2,rodada_jogador1, rodada_jogador2)
            rodada_jogador1 = resultado[0]
            rodada_jogador2 = resultado[1]
        # Confirmação para saber se algum jogador já está semc artas nas mãos
        if len(deck1) == 0 or len(deck2) == 0:
            return deck1,deck2,jogador1,jogador2,0

    return deck1,deck2,jogador1,jogador2,1

#Função de jogabilidade do modo manual
def jogar_manual(deck,jogadores):
    deck1 = deck[0]
    deck2 = deck[1]
    cava = deck[2]
    rodada_jogador1 = 0
    rodada_jogador2 = 0
    jogador1 = jogadores[0]
    jogador2 = jogadores[1]

    #È utilizada a mesma lógica da função aleatório, a diferença que quando o jogador escolhe o modo de disputa, esse resultado não é enviado
    #Como parâmetro para a função de ordenação, por que a ordenação semrpe será alfabética, ou seja tipo 5
    #E também não é randomizado um valor de posição da carta, pois o usuário que a escolhe
    for i in range(10):
        if i % 2 == 0:
            print('-_' * 20)
            print(f'Jogador 1: {jogador1} || Rodadas ganhas {rodada_jogador1}')
            print('Essa é sua mão')
            #Chamando a função de ordenação para o modo alfabético
            deck1 = modo_disputa(deck1, '5')
            print('-_' * 20)
            print('Escolha o tipo da disputa')
            print('{1} Valor\n{2} Força\n{3} Energia\n{4} Jokempô')
            tipo_disputa = input()
            posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck1) - 1}]:'))
            #Laço de repetição caso o usuário digite uma posição errada
            while posicao > len(deck1)-1:
                posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck1)-1}]:'))
            print('-_' * 20)
            carta_jogador1 = deck1.pop(posicao)
            print('A carta que você escolheu foi')
            print(carta_jogador1.nome, carta_jogador1.valor, carta_jogador1.forca, carta_jogador1.energia,carta_jogador1.jokempo)

            #Repetido o mesmo processo
            if tipo_disputa == '1':
                modo = 'Valor'
            elif tipo_disputa == '2':
                modo = 'Força'
            elif tipo_disputa == '3':
                modo = 'Energia'
            elif tipo_disputa == '4':
                modo = 'Jokempô'

            print('-_' * 20)
            print(f'Jogador 2: {jogador2} || Rodadas ganhas {rodada_jogador2}')
            print(f'O tipo de disputa escolhido foi: {modo}')
            deck2 = modo_disputa(deck2,'5')
            print('-_' * 20)
            posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck2) - 1}]:'))
            while posicao > len(deck2) - 1:
                posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck2) - 1}]:'))
            carta_jogador2 = deck2.pop(posicao)
            print('A carta que você escolheu foi')
            print(carta_jogador2.nome, carta_jogador2.valor, carta_jogador2.forca, carta_jogador2.energia,carta_jogador2.jokempo)
            print('-_' * 20)
            resultado = ganhador_rodada(deck1, deck2, cava, jogadores, tipo_disputa, carta_jogador1, carta_jogador2, rodada_jogador1, rodada_jogador2)
            rodada_jogador1 = resultado[0]
            rodada_jogador2 = resultado[1]

        #Mesma lógica, porém com a ordem dos jogadores trocadas
        else:
            print('-_' * 20)
            print(f'Jogador 2: {jogador2} || Rodadas ganhas {rodada_jogador2}')
            print('Essa é sua mão')
            deck2 = modo_disputa(deck2, '5')
            print('-_' * 20)
            print('Escolha o tipo da disputa')
            print('{1} Valor\n{2} Força\n{3} Energia\n{4} Jokempô')
            tipo_disputa = input()
            posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck2) - 1}]:'))
            while posicao > len(deck2) - 1:
                posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck2) - 1}]:'))
            print('-_' * 20)
            carta_jogador2 = deck2.pop(posicao)
            print('A carta que você escolheu foi')
            print(carta_jogador2.nome, carta_jogador2.valor, carta_jogador2.forca, carta_jogador2.energia,
                  carta_jogador2.jokempo)

            if tipo_disputa == '1':
                modo = 'Valor'
            elif tipo_disputa == '2':
                modo = 'Força'
            elif tipo_disputa == '3':
                modo = 'Energia'
            elif tipo_disputa == '4':
                modo = 'Jokempô'

            print('-_' * 20)
            print(f'Jogador 1: {jogador1} || Rodadas ganhas {rodada_jogador1}')
            print(f'O tipo de disputa escolhido foi: {modo}')
            deck1 = modo_disputa(deck1,'5')
            print('-_' * 20)
            posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck1) - 1}]:'))
            while posicao > len(deck1) - 1:
                posicao = int(input(f'Digite posição da carta que você quer jogar,de [{0}] á [{len(deck1) - 1}]:'))
            carta_jogador1 = deck1.pop(posicao)
            print('A carta que você escolheu foi')
            print(carta_jogador1.nome, carta_jogador1.valor, carta_jogador1.forca, carta_jogador1.energia,
                  carta_jogador1.jokempo)
            print('-_' * 20)
            resultado = ganhador_rodada(deck1, deck2, cava, jogadores, tipo_disputa, carta_jogador1, carta_jogador2,rodada_jogador1, rodada_jogador2)
            rodada_jogador1 = resultado[0]
            rodada_jogador2 = resultado[1]

        #Confirmação para saber se algum jogador já está semc artas nas mãos
        if len(deck1) == 0 or len(deck2) == 0:
            return deck1, deck2, jogador1, jogador2, 0

    return deck1, deck2, jogador1, jogador2, 1

#Função que contabiliza e faz as comparações para saber quem foi ganhador da rodada
def ganhador_rodada(deck1,deck2,cava,jogadores,tipo_disputa,carta_jogador1,carta_jogador2,rodada_jogador1,rodada_jogador2):
    jogador1 = jogadores[0]
    jogador2 = jogadores[1]
    #Todas as comparações possíveis de acordo com o modo de disputa da rodada, em comparação as duas cartas escolhidas os sorteadas
    #Obedecendo a lógica de que quem ganhar não cava e quem eprder sim, em caso de empate ambos cavam.
    #Depois é retornado o valor atualizado de quantas rodadas o jogador venceu
    if tipo_disputa == '1':
        if carta_jogador1.valor > carta_jogador2.valor:
            deck2.append(cava.pop())
            print(f'Jogador {jogador1} venceu essa rodada')
            rodada_jogador1 += 1
        elif carta_jogador1.valor < carta_jogador2.valor:
            deck1.append(cava.pop())
            print(f'Jogador {jogador2} venceu essa rodada')
            rodada_jogador2 += 1
        else:
            deck1.append(cava.pop())
            deck2.append(cava.pop())
            print('Empate')
    elif tipo_disputa == '2':
        if carta_jogador1.forca > carta_jogador2.forca:
            deck2.append(cava.pop())
            print(f'Jogador {jogador1} venceu essa rodada')
            rodada_jogador1 += 1
        elif carta_jogador1.forca < carta_jogador2.forca:
            deck1.append(cava.pop())
            print(f'Jogador {jogador2} venceu essa rodada')
            rodada_jogador2 += 1
        else:
            deck1.append(cava.pop())
            deck2.append(cava.pop())
            print('Empate')
    elif tipo_disputa == '3':
        if carta_jogador1.energia > carta_jogador2.energia:
            deck2.append(cava.pop())
            print(f'Jogador {jogador1} venceu essa rodada')
            rodada_jogador1 += 1
        elif carta_jogador1.energia < carta_jogador2.energia:
            deck1.append(cava.pop())
            print(f'Jogador {jogador2} venceu essa rodada')
            rodada_jogador2 += 1
        else:
            deck1.append(cava.pop())
            deck2.append(cava.pop())
            print('Empate')
    elif tipo_disputa == '4':
        if carta_jogador1.jokempo == 'Papel':
            if carta_jogador2.jokempo == 'Pedra':
                deck2.append(cava.pop())
                print(f'Jogador {jogador1} venceu essa rodada')
                rodada_jogador1 += 1
            elif carta_jogador2.jokempo == 'Tesoura':
                deck1.append(cava.pop())
                print(f'Jogador {jogador2} venceu essa rodada')
                rodada_jogador2 += 1
            else:
                deck1.append(cava.pop())
                deck2.append(cava.pop())
                print('Empate')
        elif carta_jogador1.jokempo == 'Tesoura':
            if carta_jogador2.jokempo == 'Pedra':
                deck1.append(cava.pop())
                print(f'Jogador {jogador2} venceu essa rodada')
                rodada_jogador2 += 1
            elif carta_jogador2.jokempo == 'Papel':
                deck2.append(cava.pop())
                print(f'Jogador {jogador1} venceu essa rodada')
                rodada_jogador1 += 1
            else:
                deck1.append(cava.pop())
                deck2.append(cava.pop())
                print('Empate')
        elif carta_jogador1.jokempo == 'Pedra':
            if carta_jogador2.jokempo == 'Tesoura':
                deck2.append(cava.pop())
                print(f'Jogador {jogador1} venceu essa rodada')
                rodada_jogador1 += 1
            elif carta_jogador2.jokempo == 'Papel':
                deck1.append(cava.pop())
                print(f'Jogador {jogador2} venceu essa rodada')
                rodada_jogador2 += 1
            else:
                deck1.append(cava.pop())
                deck2.append(cava.pop())
                print('Empate')
    return rodada_jogador1,rodada_jogador2

#Função que identifica de qual forma o jogador ganhou, por esvaziar a mão ou por limite de rodadas
def contagem_pontos(resultado_partida):
    deck1 = resultado_partida[0]
    deck2 = resultado_partida[1]
    jogador1 = resultado_partida[2]
    jogador2 = resultado_partida[3]
    resultado = resultado_partida[4]
    #Se a mão de algum jogador chegou a zero é mostrada a mesangem de quem ganhou e segue para a função de atualizar o arquivo cadrasto
    #Caso dê empate é chamada a função para fazer as comparações e dizer quem é o vencedor
    #E depois de toda forma atualizar o arquivo cadrasto

    if resultado == 0:
        print('-_' * 20)
        print('Partida encerrada')
        if len(deck1) == 0:
            print(f'O jogador {jogador1}  ganhou 5 rodadas e não tem mais nenhuma carta em mãos')
            print(f'Portanto o jogador {jogador1} é o vencedor da partida')
            print('-_' * 20)
            return 1,jogador1,jogador2
        elif len(deck2) == 0:
            print(f'O jogador {jogador2}  ganhou 5 rodadas e não tem mais nenhuma carta em mãos')
            print(f'Portanto o jogador {jogador2} é o vencedor da partida')
            print('-_' * 20)
            return 2,jogador1,jogador2
    else:
        print('-_' * 20)
        print('Partida encerrada')
        print('Acabou todas as 10 rodadas e ambos jogadores ainda tem cartas nas mãos')
        print(f'O jogador {jogador1} com {len(deck1)} cartas')
        print(f'O jogador {jogador2} com {len(deck2)} cartas')
        print('-_' * 20)
        print('Dando inicio as compações das cartas para o desempate')

        return comparacao(deck1,deck2,jogador1,jogador2)

#Função que em caso de limites de rodadas alcançado é feita todas as comparações possíveis referente ao desempate, ela é chamada pela função contagem_pontos()
def comparacao(deck1,deck2,jogador1,jogador2):
    #Em caso de empate é somado os valores, forças e energia de todas as cartas restantes na mão
    #Depois é comparada na ordem, valor, força e energia, se algum tiver o menor valor em algum desses atributos seguindo a ordem, é declarado vencedor,
    #Caso dê empate nos três  nã há vencedor
    soma1 = [0,0,0]
    soma2 = [0,0,0]
    for i in range(len(deck1)):
        soma1[0] += deck1[i].valor
        soma1[1] += deck1[i].forca
        soma1[2] += deck1[i].energia

    for j in range(len(deck2)):
        soma2[0] += deck2[j].valor
        soma2[1] += deck2[j].forca
        soma2[2] += deck2[j].energia

    print('-_' * 20)
    print('Comparação por [Valor]')
    print(f'A soma das cartas do tipo [Valor] do jogador {jogador1} é de  {soma1[0]}')
    print(f'A soma das cartas do tipo [Valor] do jogador {jogador2} é de  {soma2[0]}')
    print('-_' * 20)

    if soma1[0] < soma2[0]:
        print(f'O jogador {jogador1} venceu a partida com a menor soma em [Valor]')
        return 1,jogador1,jogador2
    elif soma1[0] > soma2[0]:
        print(f'O jogador {jogador2} venceu a partida com a menor soma em [Valor]')
        return 2,jogador1,jogador2
    else:
        print('Empate na soma dos valores')
        print('-_' * 20)
        print('Comparação por [Força]')
        print(f'A soma das cartas do tipo [Força] do jogador {jogador1} é de  {soma1[1]}')
        print(f'A soma das cartas do tipo [Força] do jogador {jogador2} é de  {soma2[1]}')
        print('-_' * 20)
        if soma1[1] < soma2[1]:
            print(f'O jogador {jogador1} venceu a partida com a menor soma em [Força]')
            return 1,jogador1,jogador2
        elif soma1[1] > soma2[1]:
            print(f'O jogador {jogador2} venceu a partida com a menor soma em [Força]')
            return 2,jogador1,jogador2
        else:
            print('Empate na soma das forças')
            print('-_' * 20)
            print('Comparação por [Energia]')
            print(f'A soma das cartas do tipo [Energia] do jogador {jogador1} é de  {soma1[2]}')
            print(f'A soma das cartas do tipo [Energia] do jogador {jogador2} é de  {soma2[2]}')
            print('-_' * 20)

            if soma1[2] < soma2[2]:
                print(f'O jogador {jogador1} venceu a partida com a menor soma em [Força]')
                return 1,jogador1,jogador2
            elif soma1[2] > soma2[2]:
                print(f'O jogador {jogador2} venceu a partida com a menor soma em [Força]')
                return 2,jogador1,jogador2
            else:
                print('Empate em todos os atributos')
                print('Sendo desta forma declarado empate entre ambos jogadores')
                print('Não houve vencedores')
                return 3,jogador1,jogador2

#Função que escreve no arquivo cadrastro toda as atualizações departidas de cada usuário
def contabilizando_partida(resultado_jogo):
    arquivo = arquivo_cadrastro()
    resultado = resultado_jogo[0]
    jogador1 = resultado_jogo[1]
    jogador2 = resultado_jogo[2]
    #Aqui é tratado as informações de quem ganhou para que possa ser escrito no arquivo cadrasto
    #Sempre atualizando a quantidade de partidas jogadas, e somente atualizando partidas ganhas casa seja informado que esse jogador foi o vencedor

    if resultado == 1:
        for i in range(len(arquivo)):
            if arquivo[i][0] == jogador1:
                arquivo[i][1] = str(1 + int(arquivo[i][1]))
                arquivo[i][2] = str(1 + int(arquivo[i][2]))
            if arquivo[i][0] == jogador2:
                arquivo[i][1] = str(1 + int(arquivo[i][1]))
    elif resultado == 2:
        for i in range(len(arquivo)):
            if arquivo[i][0] == jogador2:
                arquivo[i][1] = str(1 + int(arquivo[i][1]))
                arquivo[i][2] = str(1 + int(arquivo[i][2]))
            if arquivo[i][0] == jogador1:
                arquivo[i][1] = str(1 + int(arquivo[i][1]))
    else:
        for i in range(len(arquivo)):
            if arquivo[i][0] == jogador1:
                arquivo[i][1] = str(1 + int(arquivo[i][1]))
            if arquivo[i][0] == jogador2:
                arquivo[i][1] = str(1 + int(arquivo[i][1]))

    #Depois é apagado o antigo arquivo e rescrito um novo e atualizado por cima
    novo_arquivo = open('Users.txt','w')
    novo_arquivo.close()
    novo_arquivo = open('Users.txt','a')
    for j in range(len(arquivo)):
        linha_arquivo = (arquivo[j][0],arquivo[j][1],arquivo[j][2])
        escrever_linha = ';'.join(linha_arquivo)
        novo_arquivo.write(escrever_linha)
        novo_arquivo.write('\n')
    novo_arquivo.close()

#Função menu
def menu():
    print('-_' * 20)
    print('Bem vindo ao Jogo da Disputa')
    print('-_' * 20)

    opcao = input('''\nEscolha uma das opções a seguir\nDigite {0} Para Sair do Jogo\nDigite {1} Para iniciar o jogo\n''')
    jogadores = []

    if opcao == '0':
        print('Encerrando jogo.')

    elif opcao == '1':
        for j in range(2):
            #Laço de repetição enquanto os dois jogadores não acharem ou não fizeram seu cadrastro
            while opcao != '0':
                if opcao == '1':
                    nick = input(f'Digite o nickname do jogador {j+1}:')
                    listaLogin = arquivo_cadrastro()
                    contador = 0
                    #Laço que percorre o arquivo para encontrar o usuário
                    for i in listaLogin:
                        contador += 1
                        if nick == i[0]:
                            print('-_'*20)
                            print(f'Bem vindo(a) {i[0]}\nVocê já jogou {i[1]} partidas\nJá ganhou {i[2]} partidas')
                            #Tentativa de gerar a porcentagem do jogador
                            try:
                                print(f'Sua taxa de sucesso nesse jogo é de: {(int(i[2])*100)/int(i[1]):.2f}%')
                            #Caso dê erro é por que o usuário nunca jogou
                            except:
                                print('Não podemos gerar sua taxa de sucesso, pois você ainda não jogou nenhuma partida')
                            print('-_'*20)
                            jogadores.append(nick)
                            opcao = '0'
                            break
                        elif contador == len(listaLogin):
                            print('Não encontramos seu cadrasto')
                            opcao = input('Digite {1} caso queira procurar por outro cadrasto\nDigite {2} caso queira fazer um novo cadrasto\n')

                #Opção para criar um novo usuário, como é novo simplesmente basta adiciona-lo ao final do arquivo
                elif opcao == '2':
                    novonick = input('Digite seu novo nickname para criamos um novo cadrasto:')
                    print('-_'*20)
                    print(f'\nMuito bem vindo(a) {novonick}, estamos gerando sua conta...\n')

                    arquivo = open('Users.txt', 'a')
                    arquivo.write(novonick)
                    arquivo.write(';0;0\n')
                    arquivo.close()
                    print('Conta criada')
                    jogadores.append(novonick)
                    opcao = '0'
            opcao ='1'
    #Terminando o login é iniciado o jogo
    if j == 1:
        print('\nInciando o jogo')
        modoJogo(jogadores)

#Função que chama o modo de jogo aletório ou manual
def modoJogo(jogadores):
    modo = input('''\nQual modo de jogo deseja jogar ?\nDigite {0} Para o modo Aleatório\nDigite {1} Para o modo Manual\n''')

    if modo == '0':
        baralho_objetos = classe_Carta(abrir_Baralho())
        baralho_embaralhado = embaralhar(baralho_objetos)
        mao_jogadores = destribuir_Cartas(baralho_embaralhado)
        jogo = jogar_aleatorio(mao_jogadores,jogadores)
        vendo_quem_ganhou = contagem_pontos(jogo)
        contabilizando_partida(vendo_quem_ganhou)
    elif modo == '1':
        baralho_objetos = classe_Carta(abrir_Baralho())
        baralho_embaralhado = embaralhar(baralho_objetos)
        mao_jogadores = destribuir_Cartas(baralho_embaralhado)
        jogo = jogar_manual(mao_jogadores, jogadores)
        vendo_quem_ganhou = contagem_pontos(jogo)
        contabilizando_partida(vendo_quem_ganhou)

menu()
