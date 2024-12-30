package DAO;

import DOMAIN.Cliente;

import java.util.Collection;

public interface IClienteDao {
    public Boolean cadastrar(Cliente cliente);
    public void excluir(Long cpf);
    public void alterar(Cliente Cliente);
    public Cliente consultar(Long cpf);
    public Collection<Cliente> buscarTodos();
    //* Collection<Cliente>:
    // Você pode usar qualquer tipo de coleção, seja ela uma lista, um conjunto ou qualquer outra implementação que siga o contrato da interface Collection.
    //List<Cliente>:
    // Aqui você está especificando que precisa de uma coleção ordenada e indexada.

}
