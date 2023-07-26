package com.mercadolivro.service

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService(
        val customerRepository: CustomerRepository
) {

    private val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return customerRepository.findByNameContaining(it)
        }

        return customerRepository.findAll().toList()
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel) {

        if (customerRepository.existsById(customer.id!!)) {
            customerRepository.save(customer)
        } else {
            throw Exception()
        }
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun delete(id: Int) {

        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id)
        } else {
            throw Exception()
        }
    }
}