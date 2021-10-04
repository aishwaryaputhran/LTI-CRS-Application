package com.lt.constants;

 

public enum Role {
    ADMIN, PROFESSOR, STUDENT;
    
    
    public static Role stringToName(int role)
    {
        Role userRole=null;

 

        if(role==1)
            userRole=Role.STUDENT;
        else if(role==2)
            userRole=Role.PROFESSOR;
        else if(role==3)
            userRole=Role.ADMIN;
        return userRole;
    }

 

}