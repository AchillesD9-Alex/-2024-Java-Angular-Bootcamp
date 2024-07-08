document.getElementById('palindromeForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    var text = document.getElementById('textInput').value;
    var result = isPalindrome(text);
    
    document.getElementById('result').innerText = result ? 'La cadena es un palíndromo.' : 'La cadena no es un palíndromo.';
});

function isPalindrome(text) {
    // Eliminar espacios y caracteres no alfanuméricos, y convertir a minúsculas
    var cleanedText = text.toLowerCase().replace(/[^a-z0-9]/g, '');
    
    // Comprobar si el texto limpio es igual al texto invertido
    var reversedText = cleanedText.split('').reverse().join('');
    
    return cleanedText === reversedText;
}
