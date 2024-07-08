document.getElementById('textForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    var text = document.getElementById('textInput').value;
    var result = determineTextComposition(text);
    
    document.getElementById('result').innerText = result;
});

function determineTextComposition(text) {
    if (text === text.toUpperCase()) {
        return 'La cadena está formada solo por mayúsculas.';
    } else if (text === text.toLowerCase()) {
        return 'La cadena está formada solo por minúsculas.';
    } else {
        return 'La cadena está formada por una mezcla de mayúsculas y minúsculas.';
    }
}
