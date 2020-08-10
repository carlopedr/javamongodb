package com.pdv.mongodb.interfaces;

import java.util.List;

import com.pdv.mongodb.modelo.Cliente;


public interface ClienteCRUD {
    public boolean createCliente (Cliente cliente);
    public Cliente list (int id);
    public boolean updateCliente(Cliente cliente);
    public boolean deleteCliente (int id);
    public List<Cliente> listarClientes();
    
}
