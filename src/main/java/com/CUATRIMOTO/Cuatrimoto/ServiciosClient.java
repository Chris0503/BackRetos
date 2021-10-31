/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CUATRIMOTO.Cuatrimoto;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 57318
 */
@Service
public class ServiciosClient {
    
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient (int clientId){
        return metodosCrud.getClient(clientId);
    }
    
    public Client seve (Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> e=metodosCrud.getClient(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
                
    }
    
    public Client upDate(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e=metodosCrud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                } 
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                } 
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }                                  
                metodosCrud.save(e.get());
            }else{
                return e.get();
            }    
        }else{
            return client;
        }    
        return client;
        
    }
    
    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return  aBoolean;
    }
    
}
