/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemagestaodiscente;

import java.util.List;

/**
 *
 * @author filipe
 */
public interface PersistenciaDados {

    public <T> List<T> carregarDados();

    public <T> void armazenarDados(List<T> objetos);
}


