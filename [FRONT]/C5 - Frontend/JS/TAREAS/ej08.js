document.getElementById('numberForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    var number = document.getElementById('numberInput').value;
    
    if(isNaN(number)) {
        document.getElementById('result').innerText = 'Por favor, introduce un número válido.';
        return;
    }
    
    number = parseInt(number, 10);
    
    if(number % 2 === 0) {
        document.getElementById('result').innerText = 'El número ' + number + ' es par.';
    } else {
        document.getElementById('result').innerText = 'El número ' + number + ' es impar.';
    }
});