package com.fernandocandiotti.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(name = "descricao", length = 100)
    private String descricao;

    @NotNull(message = "{campo.preco.obrigatorio}")
    @Column(name = "preco_unitario")
    private BigDecimal preco;
}
