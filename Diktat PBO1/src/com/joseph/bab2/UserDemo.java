/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab2;

public class UserDemo {
    public static void main(String[] args){
        User user1 = new User("Joseph","12345678","08123435642");
        User user2 = new User();
        user2.setUserName("Setiawan");
        user2.setPassword("87654321");
        user2.setPhoneNum("0892843728");

        user1.login("Joseph","12345678");
        System.out.println();
        user1.login("Setiawan","87654321");
        System.out.println();
        user2.login("Setiawan","87654321");
    }
}
