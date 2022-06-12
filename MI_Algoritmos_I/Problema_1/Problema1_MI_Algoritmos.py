'''/*******************************************************************************
Autor: Rodrigo Damasceno Sampaio
Componente Curricular: MI Algoritmos
Concluido em: 18/04/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/'''
#Declaração nescessária de algumas variaveis para que possam serem utilizadas no código.
#qp é uma varíavel que representa as quantidades diferentes de potências, e é usada no while
#de perguntas sobre o aparelho como condição até se igualar a quantidade informada pelo usuário.
resposta = 'S'
qp = 0
consumo = 0
consumoTotal = 0
valorBruto = 0
repetir = 'S'
consumoSetor = 0

#Esse while tem como finalidade repetir o simulador caso o usuário responda 'S' ao final do programa.
#Se não o programa encerra suas atividades e fecha.
while repetir == 'S':
    print('----------------------------------------------------------------')
    print('|#Bem-vindo ao simulador de consumo de energia da UEFS (SICEU)#|')
    print('----------------------------------------------------------------')
    resposta = 'S'
    tarifa = float(input('\nDigite o valor da Tarifa Residencial de Baixa Tesão:'))

    #Esse outro laço de repetição faz com que repita o calculo de um novo setor, se o usuário responder 'S'
    #Se não o simulador vai informa os dados e vai para a pergunta de reiniciar o simulador.
    while resposta == 'S':
        print('Inciando calculo de um novo setor!')
        print('\n#Lâmpada#')
        pd = int(input('\nExistem quantas potências para este aparelho?:'))

        #pd é a varíavel que armazena as quantidades de potências diferentes informada pelo usuário.
        #Essa condição serve para sinalizar o usuário de como ele prosseguir na operação
        #caso ele tenha vários aparelhos de potência diferentes , visando evitar erros de interpretação.
        if pd >= 2:
            print('Separe os aparelhos em grupos de potências diferentes e informe a seguir')
        else:
            print('Somente um potência para este aparelho!')

        #Temos o uso de outro while para repetir as perguntas até que a quantidade de potências diferentes for atingida.
        while pd != qp:
            print('\nSobre lâmpadas de mesma potência, informe;')
            qa = int(input('Quantos aparelhos de mesma potência existem em funcionamento neste setor?:'))
            p = float(input('Qual a potência em Watts desse grupo de aparelhos?:'))
            qhd = float(input('Quantas horas esse grupo de aparelho fica ligado no dia?:'))
            qdm = int(input('Quantos dias no mês esse grupo de aparelho fica ligado?:'))
            consumo += float(((qhd*qdm)*p)*qa)/1000
            qp += 1
        #Notas para os nomes de cada varíavel e seu significado
        #qa armazena as quantidades de aparelhos naquele setor
        #p armazena a potencia em watts de cada grupo de aparelho que tenha potências iguais
        #qhd armazena quantas horas esse grupo de aparelho fica em funcionamento no dia
        #qdm armazena quantos dias no mês esse aparelho fica ligado
        #Algumas das variaveis acima são zeradas para que possam ser novamente utlizadas sem alterar o resultado final
        pd = 0
        qp = 0
        print('\nO valor de consumo total de energia desse aparelho é de {:.2f}Kwh'.format(consumo))
        consumoSetor += consumo
        consumoTotal += consumo
        consumo = 0
        #Os valores de consumo desse aparelho é somado a variavel do setor e do programa em geral
        #que serão mostrados individualmente posteriomente, podendo assim zerar e reutilizar a variavel consumo.

        #Repete-se todos os passos ditos anteriomente, alterando somente o nome do aparelho.
        print('\n#Televisor#')
        pd = int(input('\nExistem quantas potências para este aparelho?:'))
        if pd >= 2:
            print('Separe os aparelhos em grupos de potências diferentes e informe a seguir')
        else:
            print('Somente um potência para este aparelho!')
        while pd != qp:
            print('\nSobre televisores de mesma potência, informe;')
            qa = int(input('Quantos aparelhos de mesma potência existem em funcionamento neste setor?:'))
            p = float(input('Qual a potência em Watts desse grupo de aparelhos?:'))
            qhd = float(input('Quantas horas esse grupo de aparelho fica ligado no dia?:'))
            qdm = int(input('Quantos dias no mês esse grupo de aparelho fica ligado?:'))
            consumo += float(((qhd * qdm) * p) * qa) / 1000
            qp += 1
        pd = 0
        qp = 0
        print('\nO valor de consumo total de energia desse aparelho é de {}Kwh'.format(consumo))
        consumoSetor += consumo
        consumoTotal += consumo
        consumo = 0

        # Repete-se todos os passos ditos anteriomente, alterando somente o nome do aparelho.
        print('\n#Geladeira#')
        pd = int(input('\nExistem quantas potências para este aparelho?:'))
        if pd >= 2:
            print('Separe os aparelhos em grupos de potências diferentes e informe a seguir')
        else:
            print('Somente um potência para este aparelho!')
        while pd != qp:
            print('\nSobre geladeiras de mesma potência, informe;')
            qa = int(input('Quantos aparelhos de mesma potência existem em funcionamento neste setor?:'))
            p = float(input('Qual a potência em Watts desse grupo de aparelhos?:'))
            qhd = float(input('Quantas horas esse grupo de aparelho fica ligado no dia?:'))
            qdm = int(input('Quantos dias no mês esse grupo de aparelho fica ligado?:'))
            consumo += float(((qhd * qdm) * p) * qa) / 1000
            qp += 1
        pd = 0
        qp = 0
        print('\nO valor de consumo total de energia desse aparelho é de {}Kwh'.format(consumo))
        consumoSetor += consumo
        consumoTotal += consumo
        consumo = 0

        # Repete-se todos os passos ditos anteriomente, alterando somente o nome do aparelho.
        print('\n#Ar-condicionado#')
        pd = int(input('\nExistem quantas potências para este aparelho?:'))
        if pd >= 2:
            print('Separe os aparelhos em grupos de potências diferentes e informe a seguir')
        else:
            print('Somente um potência para este aparelho!')
        while pd != qp:
            print('\nSobre ar-condicionado de mesma potência, informe;')
            qa = int(input('Quantos aparelhos de mesma potência existem em funcionamento neste setor?:'))
            p = float(input('Qual a potência em Watts desse grupo de aparelhos?:'))
            qhd = float(input('Quantas horas esse grupo de aparelho fica ligado no dia?:'))
            qdm = int(input('Quantos dias no mês esse grupo de aparelho fica ligado?:'))
            consumo += float(((qhd * qdm) * p) * qa) / 1000
            qp += 1
        pd = 0
        qp = 0
        print('\nO valor de consumo total de energia desse aparelho é de {}Kwh'.format(consumo))
        consumoSetor += consumo
        consumoTotal += consumo
        consumo = 0

        # Repete-se todos os passos ditos anteriomente, alterando somente o nome do aparelho.
        print('\n#Computador#')
        pd = int(input('\nExistem quantas potências para este aparelho?:'))
        if pd >= 2:
            print('Separe os aparelhos em grupos de potências diferentes e informe a seguir')
        else:
            print('Somente um potência para este aparelho!')
        while pd != qp:
            print('\nSobre computadores de mesma potência, informe;')
            qa = int(input('Quantos aparelhos de mesma potência existem em funcionamento neste setor?:'))
            p = float(input('Qual a potência em Watts desse grupo de aparelhos?:'))
            qhd = float(input('Quantas horas esse grupo de aparelho fica ligado no dia?:'))
            qdm = int(input('Quantos dias no mês esse grupo de aparelho fica ligado?:'))
            consumo += float(((qhd * qdm) * p) * qa) / 1000
            qp += 1
        pd = 0
        qp = 0
        print('\nO valor de consumo total de energia desse aparelho é de {}Kwh'.format(consumo))
        consumoSetor += consumo
        consumoTotal += consumo
        consumo = 0

        #A resposta a seguir  fará com que o processo até aqui seja repetido,
        #Retonando para o segundo while do código e somando o valor de outro setor.
        valorBruto = consumoSetor*tarifa
        print('\nEsse setor consome {:.2f}Kwh de energia, que equivale a R$:{:.2f} sem tributação'.format(consumoSetor,valorBruto))
        resposta = str(input('\nDeseja calcula um novo setor?(S ou N):')).upper()
        consumoSetor = 0

    #Caso não tenha necessidade de somar mais setores, o programa segue para o proximo passo,
    #que é apresenta o consumo total, calcular e mostrar o valor da conta em reais com e sem impostos.
    valorBruto = 0
    valorBruto = consumoTotal*tarifa
    print('\nO valor do consumo total é de {:.2f}Kwh'.format(consumoTotal))
    print('O valor bruto a ser pago é de R$:{:.2f}'.format(valorBruto))
    valorBruto += (valorBruto*0.27) + (valorBruto*0.0165) + (valorBruto*0.0761)
    #O processo acima serve para calcular o valor que será tributado sob o valor bruto a ser pago.
    print('O valor total a ser pago com os impostos é: R$:{:.2f}'.format(valorBruto))

    #Zera-se novamente as variaveis utilizadas anteriormente, visando o usos do simulador novamente.
    valorBruto = 0
    consumoTotal = 0

    #A resposta a seguir fará com que o simulador inicie novamente caso a reposta for 'S'
    #Caso contrário o programa encerra.
    repetir = str(input('\nDeseja iniciar o programa novamente? (S ou N):')).upper()
print('Obrigado por utilizar o SICEU')

