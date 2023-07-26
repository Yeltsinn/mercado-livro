package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
            name = this.name,
            price = this.price,
            status = BookStatus.ATIVO,
            customer = customer
    )
}