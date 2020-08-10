package com.pdv.mongodb.modeloDAO;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.pdv.mongodb.interfaces.ClienteCRUD;
import com.pdv.mongodb.modelo.Cliente;

public class ClienteDAO implements ClienteCRUD
{

	public boolean createCliente(Cliente cliente) {
		try {
			 // Connección al MongoDb Server Listening On A Default Port (i.e. 27017).
	        MongoClient mongoClntObj = new MongoClient("localhost", 27017);
	        // Get MongoDb Database. If The Database Doesn't Exists, MongoDb Will Automatically Create It For You
	        DB dbObj = mongoClntObj.getDB("pdv");
	        // Get MongoDb Collection. If The Collection Doesn't Exists, MongoDb Will Automatically Create It For You
	        DBCollection collectionObj = dbObj.getCollection("clientes");
	        /**** INSERT OPERATION ****/
	        // Creating The MongoDb Documents To Store Key-Value Pair
	        BasicDBObject documentObj;
	        documentObj = new BasicDBObject();              
	        documentObj.append("id", cliente.getId());             
	        documentObj.append("nomcliente", cliente.getNomcliente());               
	        documentObj.append("emailcliente", cliente.getEmailcliente());              
	        collectionObj.insert(documentObj);
	        mongoClntObj.close();
		
		} catch (MongoException mongoExObj) {
	        mongoExObj.printStackTrace();
	    }
	        
	        return false;
        
	}

	public Cliente list(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCliente(int id) {
		System.out.println("Borra Cliente: "+ id);
		MongoClient mongoClntObj = new MongoClient("localhost", 27017);
		DB dbObj = mongoClntObj.getDB("pdv");
		DBCollection collectionObj = dbObj.getCollection("clientes");
		/**** QUERY BY ID ****/
		BasicDBObject selectQuery = new BasicDBObject("id", id);          
		DBCursor cursorObj = collectionObj.find(selectQuery);
		collectionObj.remove(selectQuery);
       // MongoCollection collection = dbObj.getCollection("clientes");
        //collectionObj..deleteOne(Filters.eq("id", id));
        System.out.println("Cliente eliminado id = "+ id);
        cursorObj.close();
		return false;
}

	public List<Cliente> listarClientes() {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		try {
			MongoClient mongoClntObj = new MongoClient("localhost", 27017);
			DB dbObj = mongoClntObj.getDB("pdv");
			DBCollection collectionObj = dbObj.getCollection("clientes");
			/**** LIST OPERATION ****/
			// Get MongoDb Collections Count
			System.out.println("Total Number Of MongoDb Collection?=  "+ collectionObj.getCount());

			/**** READ OPERATION ****/
			// ------------------------------------ Get All Documents ------------------------------------
			DBCursor cursorObj = collectionObj.find();
			try {
				while(cursorObj.hasNext()) {
					Cliente cl = new Cliente();
					DBObject dbo=cursorObj.next();
					cl.setId((Integer) dbo.get("id"));
	                cl.setNomcliente((String) dbo.get("nomcliente"));
	                cl.setEmailcliente((String) dbo.get("emailcliente"));
	                list.add(cl);
					
				}
			} finally {
				cursorObj.close();
			}
		} catch (MongoException mongoExObj) {
			mongoExObj.printStackTrace();
		}
		return list;
	}
	

}
