/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.mycompany.myapp.entities.user;

/**
 *
 * @author AYOUB
 */
public class session {
      private static user loggedUser = null;

    public static user getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(user loggedUser) {
        session.loggedUser = loggedUser;
    }
}
