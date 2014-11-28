package com.nodexy.genome.api;  
  
public class UserApiTest {

    private final static String accessToken = "***********************";
    private final static UserApi a = new UserApi(accessToken);
    
    public static void getUser(){
        
        String s = a.getUser();
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        getUser();
    }
}
