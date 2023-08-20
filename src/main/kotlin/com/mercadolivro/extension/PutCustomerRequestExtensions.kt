package com.mercadolivro.extension

import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.CustomerModel

fun PutCustomerRequest.toCustomerModel(customer: CustomerModel): CustomerModel {
    return CustomerModel(id = customer.id, name = this.name, email = this.email, status = customer.status)
}