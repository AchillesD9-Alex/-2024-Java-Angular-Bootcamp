document.getElementById('dniForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'];
    
    var dniNumber = document.getElementById('dniNumber').value;
    var dniLetter = document.getElementById('dniLetter').value.toUpperCase();
    
    if(dniNumber < 0 || dniNumber > 99999999) {
        document.getElementById('result').innerText = 'El número de DNI no es válido.';
        return;
    }

    var calculatedLetter = letras[dniNumber % 23];

    if(calculatedLetter === dniLetter) {
        document.getElementById('result').innerText = 'La letra del DNI es correcta.';
    } else {
        document.getElementById('result').innerText = 'La letra del DNI es incorrecta. Debería ser ' + calculatedLetter + '.';
    }
});