

const btnSave = document.getElementById('btnSave');
const textArea = document.getElementById('textArea');
console.log(btnSave);

btnSave.addEventListener('click', function () {
const http = new StrHttp();

console.log('clicou');
    const data = {
        url: window.location.pathname,
        text: textArea.value
    };

    http.post('https://strpad.herokuapp.com/save', data)
    //http.post('http://localhost:8080/save', data)
        .then(response => console.log(response))
        .catch(error => console.log(error));
});

