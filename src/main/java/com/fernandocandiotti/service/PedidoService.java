package com.fernandocandiotti.service;

import com.fernandocandiotti.domain.entity.Pedido;
import com.fernandocandiotti.domain.enums.StatusPedido;
import com.fernandocandiotti.rest.controller.PedidoController;
import com.fernandocandiotti.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);

}
