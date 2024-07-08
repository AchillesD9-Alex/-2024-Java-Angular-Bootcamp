var valores = [true, 5, false, "hola", "adios", 2];

// 1. Determinar cuál de los dos elementos de texto es mayor
var texto1 = valores[3];
var texto2 = valores[4];
if (texto1.length < texto2.lenght) {
  console.log(texto1);
} else {
  console.log(texto2);
}

// 2. Obtener resultados true y false utilizando los valores booleanos del array
var booleano1 = valores[0];
var booleano2 = valores[2];

// Resultado true
var resultadoTrue = booleano1 || booleano2;
console.log("Resultado true: " + resultadoTrue);

// Resultado false
var resultadoFalse = booleano1 && booleano2;
console.log("Resultado false: " + resultadoFalse);

// 3. Realizar las cinco operaciones matemáticas con los elementos numéricos
var num1 = valores[1];
var num2 = valores[5];

// Suma
var suma = num1 + num2;
console.log("Suma: " + suma);

// Resta
var resta = num1 - num2;
console.log("Resta: " + resta);

// Multiplicación
var multiplicacion = num1 * num2;
console.log("Multiplicación: " + multiplicacion);

// División
var division = num1 / num2;
console.log("División: " + division);

// Módulo
var modulo = num1 % num2;
console.log("Módulo: " + modulo);


