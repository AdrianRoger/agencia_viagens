Algoritmo "Skyline - Trace your destiny"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Marcelo Vasques
// Descrição   : Cadastro de clientes, cadastro de destinos para agência de
//               viagens e consulta para cada estrutura de dados
// Autor(a)    : Adrian Roger Corrêa dos Santos
// Data atual  : 03/08/2023
Var
// Seção de Declarações das variáveis
cliente:vetor[1..10]de caracter
nomeCliente:caracter //variável para buscar cliente por nome
numCliente:inteiro

destino:vetor[1..10]de caracter
nomeDestino:caracter //variável para buscar destino por nome
numDestino:inteiro

opcaoMenu:inteiro
varMenu:logico

Inicio

//Procedimento Cadastro Cliente
procedimento cadastroCliente()
inicio
   se (numCliente <= 10)entao
      escreval("Digite o nome do cliente")
      leia(cliente[numCliente])
      numCliente <- numCliente + 1
      limpatela
      escreval("Cliente (",cliente[numCliente - 1],") castrado com sucesso")
      escreval(" ")
   senao
      escreval("Vetor de Clientes Cheio")
      escreval(" ")
   fimse
fimprocedimento

//Procedimento Cadastro Destino
procedimento cadastroDestino()
inicio
   se (numDestino <= 10)entao
      escreval("Digite o nome do Destino")
      leia(destino[numDestino])
      numDestino <- numDestino + 1
      limpatela
      escreval("Destino (",destino[numDestino - 1] ,") castrado com sucesso")
      escreval(" ")
   senao
      escreval("Vetor de Destinos Cheio")
      escreval(" ")
   fimse
fimprocedimento

//Procedimento Buscar Cliente por nome
procedimento buscarCliente(nome:caracter)
var aux_proc:caracter
    i:inteiro
    naoEncontrado:logico

inicio
   naoEncontrado <- verdadeiro
   
   se (numCliente > 1) então
      para i de 1 ate numCliente -1 faca
         se (cliente[i] = nome) então
            escreval("o Cliente ", cliente[i], " está na posição: ", i)
            naoEncontrado <- falso
         fimse
      fimpara
      
      se (naoEncontrado = verdadeiro) então
         escreval ("Cliente Não Encontrado")
      fimse
      
      escreval("")
   senao
      escreval("Não existem clientes cadastrados.")
      escreval("")
   fimse
fimprocedimento

//Procedimento Buscar Destino por nome
procedimento buscarDestino(nome:caracter)
var aux_proc:caracter
    i:inteiro
    naoEncontrado:logico
inicio
   naoEncontrado <- verdadeiro

   se (numDestino > 1) então
      para i de 1 ate numDestino -1 faca
         se (destino[i] = nome) então
            escreval("o Destino ", destino[i], " está na posição: ", i)
            naoEncontrado <- falso
         fimse
      fimpara
      
      se (naoEncontrado = verdadeiro) então
         escreval ("Destino Não Encontrado")
      fimse
      
      escreval("")
   senao
      escreval("Não existem Destinos cadastrados.")
      escreval("")
   fimse
fimprocedimento

//Procedimento Mostrar Clientes ---
procedimento mostrarClientes()
var i:inteiro
inicio
   para i de 1 ate numCliente - 1 faça
      escreval(i, "--" ,cliente[i])
   fimpara
   escreval("")
fimprocedimento

//Procedimento Mostrar Destinos
procedimento mostrarDestinos()
var i:inteiro
inicio
   para i de 1 ate numDestino - 1 faça
      escreval(i, "--" ,destino[i])
   fimpara
   escreval("")
fimprocedimento

//-------------------------------------------------------------------
//Declaração de variáveis e menu de acesso
numCliente <- 1
numDestino <- 1
varMenu <- verdadeiro


repita
   escreval("Skyline - Trace Your Destiny")
   escreval("Selecione a opção desejada")
   escreval("")
   escreval("Cadastro de cliente. ----- 1")
   escreval("Cadastro de destino. ----- 2")
   escreval("Buscar cliente. ---------- 3")
   escreval("Buscar destino. ---------- 4")
   escreval("Mostrar todos os Clientes. 5")
   escreval("Mostrar todos os destinos. 6")
   escreval("Sair. -------------------- 7")
   leia(opcaoMenu)
   limpatela

   escolha(opcaoMenu)
   caso 1
      cadastroCliente
   caso 2
      cadastroDestino
   caso 3
      escreval("Digite o nome do Cliente para buscar")
      leia(nomeCliente)
      buscarCliente(nomeCliente)
   caso 4
      escreval("Digite o nome do Destino para buscar")
      leia(nomeDestino)
      buscarDestino(nomeDestino)
   caso 5
      mostrarClientes
   caso 6
      mostrarDestinos
   caso 7
      varMenu <- falso
   outrocaso
      escreval("Opção inválida")
      escreval("")
   fimescolha

ate(varMenu = falso)

Fimalgoritmo