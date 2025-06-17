# 📋 Projeto Cadastro de Clientes

Este é um projeto simples em Java que permite **cadastrar**, **consultar**, **alterar** e **excluir** clientes usando janelas gráficas (`JOptionPane`) e armazenando os dados em memória com `HashMap`.

## ✅ Funcionalidades

- Cadastrar cliente
- Consultar cliente por CPF
- Alterar dados do cliente
- Excluir cliente
- Sair do programa

## 💡 Como usar

1. Ao executar o programa, escolha uma opção no menu:
   - 1: Cadastrar
   - 2: Consultar
   - 3: Excluir
   - 4: Alterar
   - 5: Sair

2. Siga as instruções na tela para digitar os dados do cliente.

## 📁 Organização do código

- `App.java`: classe principal com o menu
- `Cliente.java`: classe com os dados do cliente
- `IClienteDao.java`: interface com os métodos
- `ClienteMapDAO.java`: implementa a interface usando `HashMap`
