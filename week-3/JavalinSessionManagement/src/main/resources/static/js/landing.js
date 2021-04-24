window.onload = function() {
    renderCurrentUser();
}

function renderCurrentUser() {
    fetch('http://localhost:7000/current_user', {
        method: 'GET',
        credentials: 'include'
    }).then((response) => {
        if (response.status === 400) {
            window.location.href = '/';
        }

        return response.json();
    }).then((data) => {
        let id = data.id;
        let username = data.username;
        let password = data.password;

        let userInfoElement = document.querySelector('#user');
        userInfoElement.innerHTML = `User id: ${id}, username: ${username}, password: ${password}`
    })
}