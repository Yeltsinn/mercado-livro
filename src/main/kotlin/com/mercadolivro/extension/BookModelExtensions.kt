package com.mercadolivro.extension

import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.model.BookModel

fun BookModel.toResponse(): BookResponse {
    return BookResponse(this.id, this.name, this.price, this.customer, this.status)
}