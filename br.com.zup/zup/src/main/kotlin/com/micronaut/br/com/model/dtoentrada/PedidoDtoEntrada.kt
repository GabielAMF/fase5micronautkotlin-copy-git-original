package com.micronaut.br.com.model.dtoentrada

import com.micronaut.br.com.model.Cliente
import com.micronaut.br.com.model.ItemPedido
import com.micronaut.br.com.model.Pedido
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

@Introspected
data class PedidoDtoEntrada(val cliente: ClienteDtoEntrada,
                            @field: Positive val total :BigDecimal,
                            @field: Size(min = 1) val itens: List<ItemPedidoDtoEntrada>){

    fun paraPedido(): Pedido{
        val novoCliente :Cliente = Cliente(nome = this.cliente.nome,email = this.cliente.email)
        var listaItens: MutableList<ItemPedido> = mutableListOf();
        for (item in this.itens){
            listaItens.add(ItemPedido(codigo = item.codigo,preco = item.preco,quantidade = item.quantidade))
        }

        return  Pedido(cliente = novoCliente,this.total,itens = listaItens)

    }


}
