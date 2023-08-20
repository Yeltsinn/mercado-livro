package com.mercadolivro.extension

import com.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.model.CustomerModel

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(this.id, this.name, this.email, this.status)
}