package com.mercadolivro.service

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {

    private val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }

        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    fun update(customer: CustomerModel) {
        val customer = customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun create(customer: CustomerModel) {

        val indexOfNewCostumer = customers.count() + 1
        customer.id = indexOfNewCostumer.toString()

        customers.add(customer)
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}