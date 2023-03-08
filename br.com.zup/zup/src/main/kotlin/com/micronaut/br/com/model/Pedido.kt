package com.micronaut.br.com.model

import java.math.BigDecimal

class Pedido(val cliente : Cliente, val total: BigDecimal, val itens: List<ItemPedido>) {
}