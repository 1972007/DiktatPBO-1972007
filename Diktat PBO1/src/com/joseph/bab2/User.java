/**
 * @author Joseph Setiawan Hardadi (1972007)
 */

package com.joseph.bab2;

public class User {
    private String userName;
    private String password;
    private String phoneNum;

    public User(){
    }

    public User(String userName, String password, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void userDetails(){
        System.out.println("User : "+ userName + '\n'+
                "Phone Number : "+phoneNum);
    }

    public void login(String userName, String password){
        int result = 0;
        if(userName.equals(this.userName) && password.equals(this.password)){
            result=1;
            userDetails();
        }
        else{
            System.out.println("invalid login info");
        }
    }
}
