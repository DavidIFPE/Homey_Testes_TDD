/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.repository;

/**
 *
 * @author GPADS
 */
import com.homey.servicos.model.Servico;
import java.util.List;

public interface ServicoRepository {

    List<Servico> buscarPorPalavraChave(String palavraChave);

}
