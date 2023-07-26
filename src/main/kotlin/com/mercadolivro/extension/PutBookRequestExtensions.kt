import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.model.BookModel

fun PutBookRequest.toBookModel(book: BookModel): BookModel {
    return BookModel(
            id = book.id,
            name = this.name ?: book.name,
            price = this.price ?: book.price,
            status = book.status,
            customer = book.customer
    )
}