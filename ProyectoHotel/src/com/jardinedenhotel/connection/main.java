/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.connection;

/**
 *
 * @author Yader Jr
 */
public class main {

    public static void main(String[] args) {
        conexionn ob1 = new conexionn();
        if (ob1.getconnection()!= null)
        {
            System.out.println("Established");
        }

    }

}
