package yorizori.domain;

import java.io.Serializable;

public class User implements Serializable {

    /** */
    private static final long serialVersionUID = -9185684730090993396L;

    private String userId;
    private String password;
    private String name;
    
    //--------------------------------------------------------------------------
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
