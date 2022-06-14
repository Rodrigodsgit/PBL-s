'''/*******************************************************************************
Autor: Rodrigo Damasceno Sampaio
Componente Curricular: MI Algoritmos
Concluido em: 10/08/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/'''

# Função para a leitura do arquivo Tecnicos.txt.
def abrirTecnicos():
    try:
        abrirTecnicos = open('tecnicosIBGE.txt', 'r')
        tecnicosAberto = abrirTecnicos.readlines()
        abrirTecnicos.close()
    except:
        abrirTecnicos = open('tecnicosIBGE.txt', 'r', encoding='UTF-8')
        tecnicosAberto = abrirTecnicos.readlines()
        abrirTecnicos.close()
    # Visando possíveis erros de leitura do arquivo foi feito um tratamento para que, caso o arquivo não abra, ele tente declarar a codificação do arquivo em UTF-8
    # Depois do arquivo ter sido aberto, cada linha dele é transformado em uma lista
    # Com a função readlines, depois a variavel que contém o arquivo é fechada
    return tecnicosAberto
    #È retornado a variavél que contém o arquivo lido e transfomado em listas

# Função para a leitura do arquivo Regiões.txt.
def abrirRegioes():
    try:
        abrirRegioes = open('regioes.txt', 'r',)
        regioesAberto = abrirRegioes.readlines()
        abrirRegioes.close()
    except:
        abrirRegioes = open('regioes.txt', 'r', encoding='UTF-8')
        regioesAberto = abrirRegioes.readlines()
        abrirRegioes.close()
    # Visando possíveis erros de leitura do arquivo foi feito um tratamento para que, caso o arquivo não abra, ele tente declarar a codificação do arquivo em UTF-8
    # Depois do arquivo ter sido aberto, cada linha dele é transformado em uma lista
    # Com a função readlines, depois a variavel que contém o arquivo é fechada
    return regioesAberto
    # È retornado a variavél que contém o arquivo lido e transfomado em listas

# Função para a leitura do arquivo Pesquisa.txt.
def abrirPesquisa():
    try:
        abrirPesquisa = open('Pesquisa.txt','r',)
        pesquisaAberta = abrirPesquisa.readlines()
        abrirPesquisa.close()
    except:
        abrirPesquisa = open('Pesquisa.txt', 'r',encoding='UTF-8' )
        pesquisaAberta = abrirPesquisa.readlines()
        abrirPesquisa.close()
    # Visando possíveis erros de leitura do arquivo foi feito um tratamento para que, caso o arquivo não abra, ele tente declarar a codificação do arquivo em UTF-8
    # Depois do arquivo ter sido aberto, cada linha dele é transformado em uma lista
    # Com a função readlines, depois a variavel que contém o arquivo é fechada
    return pesquisaAberta
    #È retornado a variavél que contém o arquivo lido e transfomado em listas

# Função para a criação de matrizes a partir de arquivos lidos.
def criarMatriz(arquivo):
    matriz = []
    for i in range(len(arquivo)):
        linha = []
        quantidadeDeColuna = arquivo[i].strip('\n')
        quantidadeDeColuna = quantidadeDeColuna.split(';')
        #È criado um laço de repetição no tamanho do arquivo que foi dado como parâmetro
        #È inicializada uma lista vazia
        #Após isso é usada uma varivael auxiliar para contabilizar quantas coluna serão criadas
        #Usando a função strip e split são retirado os espaços, e transfomados cada elemento separado por ';' em uma lista respectivamente
        for j in range(len(quantidadeDeColuna)):
            linha.append([])
        matriz.append(linha)
        #Depois é inicializado outro laço de repetição para cada linha do arquivo no tamanho de colunas contabilizados anteriomente
        #Desse modo é possível a criação de matrizes vazias com a quantidade de colunas necessárias para cada linha
        #Dentro desse laço a lista vazia criada anteriomente recebe uma quantidade listas vazias referente as colunas
        #Após isso a matriz recebe essa linha criada, e ao final do processo temos uma matriz vazia equivalente ao arquivo dado


    for i in range(len(arquivo)):
        linha = arquivo[i].strip('\n')
        linha = linha.split(';')
        for j in range(len(linha)):
            matriz[i][j] = linha[j]
        #Nesse processo é repetido o uso das funções strip e split para o memso fim
        #E utilizando como range o tamanho do arquivo e a quantidade de elementos (listas) em cada linha respesctivamente
        #São associados cada elemento de cada linha do arquivo para seu devido local na matriz que até o momento era vazia
    return matriz
    #È retornada a matriz com todos seus espaços preeenchidos pelo arquivo

# Função para a criação de matrizes e vetor vazios utlizando como tamanho parâmetros dados.
def matrizVazia(linha,coluna,vetor):
    vetorAux = []
    matriz = []
    for i in range(linha):
        vetorAux.append([])
        i = []
        for j in range(coluna):
            i.append([])
        matriz.append(i)
    #Foi utilizado o mesmo processo de laços de repetições como na função criarMatriz
    #Com a diferença de não usar o strip e split pois a quantidade de linhas e colunas já são dadas por parâmetros
    #Também é utilizado essa mesma estrutura para criar um vetor auxiliar que será utilizado na estatística 3 e 5
    #Ao final do laço temos uma matriz vazia do tamanho desejado


    if vetor == 1:
        return vetorAux

    else:
        return matriz
    #O terceiro parâmetro é utlizado para retornar o vetor criado ou a matriz, ambos vazios, dependendo da esolha.

# Função para a validação da matriz contendo o arquivo pesquisa
def validacao(x,y,z,):
    # Para a diminuição da escrita cada parâmetro remete a uma matriz de um arquivo diferente
    # X= Matriz com o arquivo de pesquisa
    # Y= Matriz com o arquivo de técnicos
    # Z= Matriz com o arquivo de regiões

    matriz = matrizVazia(len(x),21,0)
    # Chama-se a função para criar uma matriz vazia.

    for linha in range(len(x)):
        for linha2 in range(len(y)):
            validacaoTec = x[linha][0] in y[linha2][0]
            # O primeiro é utilizado para percorrer linha por linha da matriz de pesquisas, e cada linha passará pelo processo de validação
            # O segundo laço é utilizado para percorrer todas as linhas da matriz de técnicos
            # Esse laço continua se repetindo até que ele encontre o mesmo técnico da matriz pesquisa(que está na coluna 0) na matriz de técnicos( também localizado na coluna 0)
            # Caso não encontre na matriz técnicos é porque esse técnico não existe, prosseguindo pra proxima linha da matriz pesquisa e descosiderando essa testada

            if validacaoTec == True and len(x[linha][0]) == 4:
            # Caso exista o técnico a varíavel "validacaoTec' recebe um valor boleando (True) e segue para o próximo laço
            # Ainda foi adicionado mais uma validação referente a quantidade de caracteres na coluna técnicos, assumindo que sempre existirá 4 caracteres "T000"
            # A linha não será valida em quantidades superiores ou inferiores
            # (Dado casos de erros onde existe o técnico 'T156' e validava técnicos como: 'T', 'T1' ,'T15')

                for linha3 in range(len(z)):
                    validacaoReg = x[linha][1] in z[linha3][2]
                    if validacaoReg == True and len(x[linha][1]) == 7:
                    # È repetido o mesmo processo anteriomente, mas nesse caso para a validação do código IBGE, utilizando a matriz pesquisa e matriz de regiões
                    # Também é alterado a coluna escolhida, agora é utilizada a coluna que contém o coódigo do IBGE

                        # Após a linha da matriz pesquisa passar pela validação de técnicos e regiões segue para validação do fluxo abaixo
                        # Dividido em 2 blocos principais para a resposta 1 e 5,6 na pergunta 1.02
                        if x[linha][3] == '5' or x[linha][3] == '6':
                            # Primeiro caso para ver se resposta que se encontra na coluna 3 da matriz pesquisa é 5 ou 6
                            if x[linha][5] == '-' and x[linha][6] == '-' and x[linha][7] == '-' and x[linha][8] == '-' and x[linha][9] == '-' and x[linha][10]  == '-' and x[linha][11] == '-' and x[linha][12] == '-':
                            # Se for, assumindo o fluxo que que para esse caso não é feitas as perguntas da questão 2, todas as colunas descritas acima tem como resposta '-'
                                if x[linha][3] == '6' :
                                    if x[linha][14] == '-':
                                        for i in range(1):
                                            for j in range(len(x[linha])):
                                                matriz[linha][j] = x[linha][j]
                                        break
                                else:
                                    for i in range(1):
                                        for j in range(len(x[linha])):
                                            matriz[linha][j] = x[linha][j]
                                    break
                            # No caso da resposta ser 6, ainda é necessária mais um validação referente a pergunta 3.02
                            # Após isso é usado um laço de repetição para alocar cada elemento dessa linha na lista da matriz vazia que foi chamado no inicio da função
                            # Também foi necessário o uso de um break para que não retornasse para o mesmo laço de repetição e adicionasse os mesmos elementos repetidas vezes

                        elif x[linha][3] == '1':
                            if x[linha][5]!='-' and x[linha][6]!= '-' and x[linha][9]!='-' and x[linha][10]!='-' and x[linha][11]!='-':
                                    if x[linha][6] != '0':
                                        if x[linha][7] == '-':
                                            if x[linha][11] == '1':
                                                for i in range(1):
                                                    for j in range(21):
                                                        matriz[linha][j] = x[linha][j]
                                                break
                                            elif x[linha][11] == '2' or x[linha][11] == '3':
                                                if x[linha][12] == '-':
                                                    for i in range(1):
                                                        for j in range(21):
                                                            matriz[linha][j] = x[linha][j]
                                                    break
                                    elif x[linha][6] == '0':
                                        if x[linha][7] == '1':
                                            if x[linha][11] == '1':
                                                for i in range(1):
                                                    for j in range(21):
                                                        matriz[linha][j] = x[linha][j]
                                                break
                                            elif x[linha][11] == '2' or x[linha][11] ==  '3':
                                                if x[linha][12] == '-':
                                                    for i in range(1):
                                                        for j in range(21):
                                                            matriz[linha][j] = x[linha][j]
                                                    break
                                        elif x[linha][7] == '2':
                                            if x[linha][8] == '-':
                                                if x[linha][11] == '1':
                                                    for i in range(1):
                                                        for j in range(21):
                                                            matriz[linha][j] = x[linha][j]
                                                    break
                                                elif x[linha][11] == '2' or x[linha][11] == '3':
                                                    if x[linha][12] == '-':
                                                        for i in range(1):
                                                            for j in range(21):
                                                                matriz[linha][j] = x[linha][j]
                                                        break
    # Foi utilizado a mesma lógica com laço de repetição para a resposta 1, diferenciando somente o seu fluxo de resposta
    # Repete-se o processo até que todas linhas da matriz pesquisa tenham sido lidas
    return matriz
    #È retornado a matriz validada com todos os elementos alocados nela.

# Abaixo, funções para cada estatística seguindo a ordem proposta no problema
def estatistica1(matrizValidada):
    domicilios = 0
    for i in range(len(matrizValidada)):
        if matrizValidada[i][0] != []:
            domicilios += 1
    #Laço de repetição para contabilizar os domicílios validados, descosiderando linhas vazias da matriz

    print('_-'*30)
    print(f'Estatística-1\nForam utilizados {domicilios} domicílios para a coleta dos dados!')
    print('_-'*30)

def estatistica2(matrizValidada):
    domicilioPago = 0
    domicilioPagando = 0
    domicilioAlugado = 0

    for i in range(len(matrizValidada)):
        if matrizValidada[i][0] != []:
            if matrizValidada[i][5] == '1':
                domicilioPago += 1
            elif matrizValidada[i][5] == '2':
                domicilioPagando += 1
            elif matrizValidada[i][5] == '3':
                domicilioAlugado += 1

    #È utilizado um laço de repetição para olhar a coluna 5 e somar mais 1 para a varíavel referente a resposta

    print('_-'*30)
    print(f'''Estatística-2\nDos domicílios particulares obteve os seguintes resultados
{domicilioPago}-Domicílios já foram pagos
{domicilioPagando}-Domicílios ainda estão sendo pagos
{domicilioAlugado}-Domicílios são alugados''')
    print('_-'*30)

def estatistica3(matrizValidada,regioes):
    vetorAux = matrizVazia(len(matrizValidada),0,1)
    matriz = matrizVazia(len(matrizValidada),3,0)
    cont = 0
    index = 0
    # È chamado uma lista no tamanho da matriz validada e uma matriz do mesmo tamanho com 3 colunas, ambos vazios

    for c in range(len(matrizValidada)):
        if matrizValidada[c][0] != []:
            if matrizValidada[c][3] == '1':
                # Através de uma laço e auxilio de condicionais é possivel selecionar somente as linhas que atendem o requisto da estatística
                if matrizValidada[c][1] not in vetorAux[:]:
                    vetorAux[cont] = matrizValidada[c][1]
                    # È verificado se o codigo IBGE já está no vetor auxiliar (lista) que foi criado
                    # Caso não esteja é adicionado ao vetor na posição da variavél contador
                    if matrizValidada[c][6] == '0' or matrizValidada[c][6] == 0:
                        matriz[cont][1] = 1
                        matriz[cont][2] = 0

                    else:
                        matriz[cont][2] = 1
                        matriz[cont][1] = 0
                    # Dependendo da resposta é alocado o valor 1 a sua respectiva coluna e 0 nas demais, ambos nas linhas referente ao contador
                    # Para que assim a posição da matriz esteja sempre espelhada ao vetor
                    cont +=1
                    # È atulizado o contador para que não seja sob-escrito as informações anteriores

                else:
                    for a in range(len(vetorAux)):
                        if matrizValidada[c][1] == vetorAux[a]:
                            index = a
                    # Caso o código já esteja no vetor é feita uma busca nos elementos do vetor para descobrir qual sua posição
                    if matrizValidada[c][6] == '0' or matrizValidada [c][6] == 0:
                        matriz[index][1] = matriz[index][1]+1
                    else:
                        matriz[index][2] = matriz[index][2]+1
                    # Desse modo é contabilizado +1 na coluna referente a resposta obtida, para os casos de domicílios em mesma cidade

    for c in range(len(vetorAux)):
        for b in range(len(regioes)):
            auxiliar = regioes[b][2]
            if vetorAux[c] == auxiliar:
                matriz[c][0] = str(regioes[b][1])

    # Usando dois laços de repetição foi possivél encontrar o codigo IBGE do vetor auxiliar na matriz de regioes
    # Após isso é utlizado o nome da cidade equivalente ao código IBGE, que está localizado na mesma linha onde os códigos são iguais
    # Essa string é adicionada a matriz da estatística 3 na coluna 0, até então vazia

    print('_-'*30)
    print('Estatística-3')
    for c in range(len(matriz)):
        if matriz[c][0] != []:
            if matriz[c][1] == '0' or matriz[c][1] == [] or matriz[c][1] == 0:
                print(f'Todos os {matriz[c][2]} domicílios da cidade {matriz[c][0]} possuem banheiros')
            elif matriz[c][2] == '0' or matriz[c][2] == [] or matriz[c][2] == 0:
                print(f'Todos os {matriz[c][1]} domicílios da cidade {matriz[c][0]} não possuem banheiros')
            else:
                print(f'O municipio {matriz[c][0]} possue {matriz[c][1]} domicílios sem banheiro e {matriz[c][2]} domicílios com banheiro')
    print('_-'*30)

def estatistica4(matrizValidada,regioes):
    vetorAux = matrizVazia(len(matrizValidada), 0, 1)
    matriz = matrizVazia(len(matrizValidada), 11, 0)
    cont = 0
    index = 0
    # È chamado uma lista no tamanho da matriz validada e uma matriz do mesmo tamanho com 11 colunas, ambos vazios

    for c in range(len(matrizValidada)):
        if matrizValidada[c][0] != []:
            if matrizValidada[c][3] == '1':
                # Através de uma laço e auxilio de condicionais é possivel selecionar somente as linhas que atendem o requisto da estatística
                if matrizValidada[c][1]  not in vetorAux[:]:
                    vetorAux[cont] = matrizValidada[c][1]
                    # È verificado se o codigo IBGE já está no vetor auxiliar (lista) que foi criado
                    # Caso não esteja é adicionado ao vetor na posição da variavél contador
                    for a in range(1,11):
                        if matrizValidada[c][9] == str(a):
                            for b in range(1,11):
                                matriz[cont][b] = 0
                            matriz[cont][a] = 1
                            break
                    cont += 1
                    # È utilizado um laço para achar a resposta através de uma comparação com o contador assumindo os possivéis valores de resposta
                    # Após isso é alocado zeros em todas as colunas exceto na coluna que é equivalente a resposta, nela é adicionado 1
                    # È atulizado o contador para que não seja sob-escrito as informações anteriores
                    # Foi utilizado um break para que o programa retornasse ao primeiro laço, evitando repetições desnecessárias
                else:
                    for d in range(len(vetorAux)):
                        if matrizValidada[c][1] in vetorAux[d]:
                            index = d
                    # Caso o código já esteja no vetor é feita uma busca nos elementos do vetor para descobrir qual sua posição
                    for e in range(1,11):
                        if matrizValidada[c][9] == str(e):
                            matriz[index][e] = matriz[index][e]+1
                            break
                    # Desse modo é contabilizado +1 na coluna referente a resposta obtida, para os casos de domicílios em mesma cidade
    for c in range(len(vetorAux)):
        for a in range(len(regioes)):
            auxiliar = regioes[a][2]
            if vetorAux[c] == auxiliar:
                matriz[c][0] = str(regioes[a][1])
    # Usando dois laços de repetição foi possivél encontrar o codigo IBGE do vetor auxiliar na matriz de regioes
    # Após isso é utlizado o nome da cidade equivalente ao código IBGE, que está localizado na mesma linha onde os códigos são iguais
    # Essa string é adicionada a matriz da estatística 4 na coluna 0, até então vazia

    print('_-'*30)
    print('Estatística-4')
    for c in range(len(matriz)):
        if matriz[c][0] != []:
            for a in range(1,11):
                coluna = 0
                for b in range(1,11):
                    if matriz[c][a] > matriz[c][b]:
                        coluna +=1
                # Usando laços é possível ferificar se cada elemento da coluna na linha escolhida é maior que todas as outras colunas
                # Caso seja maior que todas as outras 9 colunas o contador chegará a 9 e o valor 'a' do segundo laço de repetição equivale a coluna
                # Com a forma mais comum de abastecimento
                if coluna == 9:
                    if a == 1:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Rede geral de distribuição')
                    elif a == 2:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Poço ou nascente na propriedade')
                    elif a == 3:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Poço ou nascente fora da propriedade ')
                    elif a == 4:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Carro-Pipa')
                    elif a == 5:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Àgua da chuva armazenada em cisterna')
                    elif a == 6:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Àgua da chuva armazenada de outra forma')
                    elif a == 7:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Rios, açudes, lagos e igarapés')
                    elif a == 8:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Outra forma não disponível no questionário')
                    elif a == 9:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Poço ou nascente na aldeia')
                    elif a == 10:
                        print(f'A forma de abastecimento mais comum nos domicílios da cidade {matriz[c][0]} é por: Poço ou nascente fora da aldeia')
                    break
                elif a == 10 and coluna < 9:
                    print(f'Não há uma única forma mais comum de abastecimento na cidade {matriz[c][0]}')
    print('_-'*30)

def estatistica5(matrizValidada,regioes):
    vetorAux = matrizVazia(len(matrizValidada), 0, 1)
    matriz = matrizVazia(len(matrizValidada), 3, 0)
    cont = 0
    index = 0
    # È chamado uma lista no tamanho da matriz validada e uma matriz do mesmo tamanho com 3 colunas, ambos vazios

    for c in range(len(matrizValidada)):
        if matrizValidada[c][0] != []:
            if matrizValidada[c][3] == '1':
                # Através de uma laço e auxilio de condicionais é possivel selecionar somente as linhas que atendem o requisto da estatística
                if matrizValidada[c][1] not in vetorAux[:]:
                    vetorAux[cont] = matrizValidada[c][1]
                    # È verificado se o codigo IBGE já está no vetor auxiliar (lista) que foi criado
                    # Caso não esteja é adicionado ao vetor na posição da variavél contador
                    if matrizValidada[c][11] == '1' or matrizValidada[c] [11] == '2':
                        matriz[cont][1] = 1
                        matriz[cont][2] = 0
                    elif matrizValidada[c][11] == '3' :
                        matriz[cont][2] = 1
                        matriz[cont][1] = 0
                    # Dependendo da resposta é alocado o valor 1 a sua respectiva coluna e 0 nas demais, ambos nas linhas referente ao contador
                    # Para que assim a posição da matriz esteja sempre espelhada ao vetor
                    cont += 1
                    # È atulizado o contador para que não seja sob-escrito as informações anteriores

                else:
                    for a in range(len(vetorAux)):
                        if matrizValidada[c][1] in vetorAux[a]:
                            index = a
                    # Caso o código já esteja no vetor é feita uma busca nos elementos do vetor para descobrir qual sua posição
                    if matrizValidada[c][11] == '1' or matrizValidada[c][11] == '2':
                        matriz[index][1] = matriz[index][1]+1
                    elif matrizValidada[c][11] == '3':
                        matriz[index][2] = matriz[index][2]+1
                    # Desse modo é contabilizado +1 na coluna referente a resposta obtida, para os casos de domicílios em mesma cidade
    for c in range(len(vetorAux)):
        for a in range(len(regioes)):
            auxiliar = regioes[a][2]
            if vetorAux[c] == auxiliar:
                matriz[c][0] = str(regioes[a][1])
    # Usando dois laços de repetição foi possivél encontrar o codigo IBGE do vetor auxiliar na matriz de regioes
    # Após isso é utlizado o nome da cidade equivalente ao código IBGE, que está localizado na mesma linha onde os códigos são iguais
    # Essa string é adicionada a matriz da estatística 5 na coluna 0, até então vazia
    print('_-'*30)
    print('Estatística-5')
    for c in range(len(matriz)):
        if matriz[c][0] != []:
            if matriz[c][1] != [] and matriz[c][1] != 0:
                total = matriz[c][1]
                # È conferido se a coluna 1 não está vazia, adicionando o valor dela a variavél total
                if matriz[c][2] != [] and matriz[c][2] != 0:
                    total += matriz[c][2]
                    # O mesmo processo é feito com a coluna 2
                    porcentagem = (matriz[c][2]*100)/total
                    # Por fim é efetuado o calculo
                    print(f'Dos domicílios pesquisados da cidade {matriz[c][0]}, {porcentagem:.1f}% deles não possuem energia elétrica ')
            else:
                if matriz[c][2] != [] and matriz[c][2] != 0:
                    total = matriz[c][2]
                    porcentagem = (matriz[c][2]*100)/total
                    print(f'Dos domicílios pesquisados da cidade {matriz[c][0]}, {porcentagem:.1f}% deles não possuem energia elétrica ')
    print('_-'*30)

def estatistica6(matrizValidada):
    branca = 0
    preta = 0
    amarela = 0
    parda = 0
    indigena = 0
    totalDeMoradores = 0

    for i in range(len(matrizValidada)):
        if matrizValidada[i][0] != []:
            # Usando uma condição para contabilizar as linhas que não estão vazias
            if matrizValidada[i][18] == '1':
                branca += 1
            elif matrizValidada[i][18] == '2':
                preta += 1
            elif matrizValidada[i][18] == '3':
                amarela += 1
            elif matrizValidada[i][18] == '4':
                parda += 1
            elif matrizValidada[i][18] == '5':
                indigena += 1
            totalDeMoradores += 1
            # Dependo da resposta na coluna é contabilizado +1 na sua respectiva variável
            # E idependente da resposta é somado 1 ao total de Moradores

    branca = (branca*100)/totalDeMoradores
    preta = (preta*100)/totalDeMoradores
    amarela = (amarela*100)/totalDeMoradores
    parda = (parda*100)/totalDeMoradores
    indigena =(indigena*100)/totalDeMoradores
    # È efetuado todos os calculos
    print('_-'*30)
    print(f'''Estatística-6\nDo total de {totalDeMoradores} moradores entrevistados temos os seguintes dados 
{branca:.2f}% Tem cor/raça branca
{preta:.2f}% Tem cor/raça preta
{amarela:.2f}% Tem cor/raça amarela
{parda:.2f}% Tem cor/raça parda
{indigena:.2f}% Tem cor/raça indigena''')
    print('_-'*30)

def estatistica7(matrizValidada):
    norte = 0
    nordeste = 0
    sul = 0
    suldeste = 0
    centroOeste = 0
    municipioRepetido = matrizVazia(len(matrizValidada),0,1)
    # È chamado uma lista no tamanho da matriz validada

    for i in range(len(matrizValidada)):
        if matrizValidada[i][0] != []:
        # Usando uma condição para contabilizar as linhas que não estão vazias
                if matrizValidada[i][1] not in municipioRepetido:
                    municipioRepetido[i] = matrizValidada[i][1]
                    if matrizValidada[i][1][0] == '1':
                        norte += 1
                    elif matrizValidada[i][1][0] == '2':
                        nordeste += 1
                    elif matrizValidada[i][1][0] == '3':
                        suldeste += 1
                    elif matrizValidada[i][1][0] == '4':
                        sul += 1
                    elif matrizValidada[i][1][0] == '5':
                        centroOeste += 1
                    # A depender da resposta em cada linha da matriz, sua respectiva região é contabilizada em +1

    print('_-' * 30)
    print(f'Estatística-7')
    if norte > sul and norte > suldeste and norte > nordeste and norte > centroOeste:
        print('A região com maior número de municipios pesquisado é o Norte')
    elif nordeste > norte and nordeste > sul and nordeste > suldeste and nordeste > centroOeste:
        print('A região com maior número de municipios pesquisado é o Nordeste')
    elif suldeste > norte and suldeste > nordeste and suldeste > sul and suldeste > centroOeste:
        print('A região com maior número de municipios pesquisado é o Suldeste')
    elif sul > norte and sul > nordeste and sul > suldeste and sul > centroOeste:
        print('A região com maior número de municipios pesquisado é o Sul')
    elif centroOeste > norte and centroOeste > nordeste and centroOeste > sul and centroOeste > suldeste:
        print('A região com maior número de municipios pesquisado é o Centro-Oeste')
    else:
        print('Não existe uma única região com maior número de cidades pesquisadas')

    print('_-'*30)

# Função de menu para poder acessar todas estatísticas
def menu():

    print('_-'*30)
    print('Analisando dados')
    print('Analise completa')
    print('Programa para análise de estatísticas do censo demográfico do IBGE 2020')
    print('-_' * 30)
    print('''Escolha uma das opções
\n1-Estatística de domicílios utilizados na coleta
2-Estatística sobre domicílios pagos, ainda em pagamento e alugados
3-Estatística sobre domicílios com e sem banheiros por cidade
4-Estatística sobre a forma mais comum de abastecimento de água por cidade
5-Estatística sobre percentual de domicílios por cidade sem energia elétrica
6-Estatística  de moradores por cor ou raça
7-Estatística de região com maior numero de municipios pesquisados
8-Para visualizar todas as estastística 
0-Para sair''')



    visualizarEstatísticas = '1'
    while visualizarEstatísticas != '0':
        # Usando um laço de repetição para que o usuário possa escolher visulizar outra estatística
        # A pergunta abaixo também é repetida caso o usuário insira uma opção que não está disponível
        # O laço encerra-se caso o usuário digite 0
        visualizarEstatísticas = (input('\nEscolha uma opção:'))
        if visualizarEstatísticas == '1':
            estatistica1(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
        elif visualizarEstatísticas == '2':
            estatistica2(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
        elif visualizarEstatísticas == '3':
            estatistica3((validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes()))),criarMatriz(abrirRegioes()))
        elif visualizarEstatísticas == '4':
            estatistica4((validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes()))),criarMatriz(abrirRegioes()))
        elif visualizarEstatísticas == '5':
            estatistica5((validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes()))),criarMatriz(abrirRegioes()))
        elif visualizarEstatísticas == '6':
            estatistica6(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
        elif visualizarEstatísticas == '7':
            estatistica7(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
        elif visualizarEstatísticas == '8':
            estatistica1(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
            estatistica2(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
            estatistica3((validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes()))), criarMatriz(abrirRegioes()))
            estatistica4((validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes()))), criarMatriz(abrirRegioes()))
            estatistica5((validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes()))), criarMatriz(abrirRegioes()))
            estatistica6(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
            estatistica7(validacao(criarMatriz(abrirPesquisa()),criarMatriz(abrirTecnicos()),criarMatriz(abrirRegioes())))
        elif visualizarEstatísticas == '0':
            print('\nEncerrando Programa')
        else:
            print('Opção inválida, por favor digite novamente')


    print('\nSistema de Censo Demográfico Encerrado')

menu()

#PyCharm 2018.3.7 (Community Edition)
# Build #PC-183.6156.16, built on July 9, 2019
# JRE: 1.8.0_152-release-1343-b28 amd64
# JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
# Windows 10 10.0