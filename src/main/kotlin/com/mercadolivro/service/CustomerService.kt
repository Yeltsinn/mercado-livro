package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
        val customerRepository: CustomerRepository,
        val bookService: BookService
) {

    private val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return customerRepository.findByNameContaining(it)
        }

        return customerRepository.findAll().toList()
    }

    fun findById(id: Int): CustomerModel {
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

        val customer = findById(id)
        bookService.deleteByCustomer(customer)
        customerRepository.deleteById(id)
    }
}