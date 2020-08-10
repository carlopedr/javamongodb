package com.pdv.mongodb.test;

import java.util.Iterator;
import java.util.List;

import com.pdv.mongodb.modelo.Cliente;
import com.pdv.mongodb.modeloDAO.ClienteDAO;

public class Test {
	public static void main(String[] args) {
		
		ClienteDAO cldao= new ClienteDAO();
		Cliente cliente = new Cliente(4,"José","jose@usco.edu.co");
		cldao.createCliente(cliente);
		cldao.listarClientes();
		List<Cliente> list = cldao.listarClientes();
        Iterator<Cliente> iter = list.iterator();
        Cliente cl = null;
        while (iter.hasNext()) {
            cl = iter.next();
            System.out.println(cl.getNomcliente());
            System.out.println(cl.toString());
        }
        cldao.deleteCliente(3);
	
	}
}
