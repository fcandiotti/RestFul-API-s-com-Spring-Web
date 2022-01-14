package com.fernandocandiotti.rest.dto;

import com.fernandocandiotti.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {

    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;

    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private BigDecimal total;

    @NotEmptyList(message = "{Pedido não pode ser realizado sem itens.}")
    private List<ItemPedidoDTO> itens;

}
