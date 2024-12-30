package DAO;

import DOMAIN.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDao{

    //Mapa para armazenar os clientes, com o CPF como chave
    private Map<Long, Cliente> mapaClientes;

    //construtor
    public ClienteMapDAO() {
        this.mapaClientes = new HashMap<>(); // inicializando mapa

    }


    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (mapaClientes.containsKey(cliente.getCpf())) {
            return false;
        }
        mapaClientes.put(cliente.getCpf(), cliente);
        return true; //Cadastra o cliente no mapa
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastro = this.mapaClientes.get(cpf);
        if (clienteCadastro != null) {
            this.mapaClientes.remove(clienteCadastro.getCpf(), clienteCadastro);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastro = this.mapaClientes.get(cliente.getCpf());
        if (clienteCadastro != null) {
            clienteCadastro.setNome(cliente.getNome());
            clienteCadastro.setTel(cliente.getTel());
            clienteCadastro.setNumero(cliente.getNumero());
            clienteCadastro.setEnd(cliente.getEnd());
            clienteCadastro.setCidade(cliente.getCidade());
            clienteCadastro.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return mapaClientes.get(cpf); //retorna o cliente encontrado pelo cpf

    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return mapaClientes.values(); //retorna todos os clientes armazenados
    }
}
