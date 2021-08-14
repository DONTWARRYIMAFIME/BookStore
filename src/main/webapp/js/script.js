function validateFormInput() {
    const firstName = document.getElementById("firstName");
    const lastName = document.getElementById("lastName");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
}

function confirmDelete(userId) {
    const message = 'Are you sure want to delete user with ID ' + userId + ' ?';
    if (confirm(message)) {
        window.location = 'delete_user?id=' + userId;
    }
}