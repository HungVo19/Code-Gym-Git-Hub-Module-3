$('#exampleModal').on('show.bs.modal', function (event) {
    let bookId = $(event.relatedTarget).data('bookid')
    $(this).find('.modal-body input').val(bookId)
})