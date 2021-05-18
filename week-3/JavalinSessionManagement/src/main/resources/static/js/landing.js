window.onload = function() {
    renderCurrentUser();
}

function renderCurrentUser() {
    fetch('http://ec2-3-140-201-86.us-east-2.compute.amazonaws.com:7000/current_user', {
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