/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.repository;

import com.homey.servicos.model.Contrato;

/**
 * Repositório do contrato (interface apenas - assinaturas para uso com Mockito)
 */
public interface ContratoRepository {

    void salvar(Contrato contrato);

}
