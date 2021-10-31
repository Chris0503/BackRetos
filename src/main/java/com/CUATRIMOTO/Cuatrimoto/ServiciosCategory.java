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
public class ServiciosCategory {
    
    @Autowired
    private RepositorioCategory metodosCrud;
    
    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategory (int categoryId){
        return metodosCrud.getCategory(categoryId);
    }
    
    public Category seve (Category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<Category> e=metodosCrud.getCategory(category.getId());
            if(e.isEmpty()){
                return metodosCrud.save(category);
            }else{
                return category;
            }
        }
                
    }
    
    public Category upDate(Category category){
        if(category.getId()!=null){
            Optional<Category> g=metodosCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }                  
                return metodosCrud.save(g.get());
            }                        
        }
        return category;
        
    }
    
    public boolean deleteCategory(int categoryId){
        Boolean aBoolean = getCategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return  aBoolean;
    }    
}
