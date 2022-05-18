/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.lsg.bookstoreweb.model.bean;

/**
 *
 * @author devsys-b
 */
public class User {
    
    public User(){
        
    }
    
    private int id;
    private String email;
    private String password;
    private String fullName;

    public User(int id, String email, String password, String FullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = FullName;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String FullName) {
        this.fullName = FullName;
    }
    
    
}
