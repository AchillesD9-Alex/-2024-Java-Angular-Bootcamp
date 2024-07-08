function calcularFactorial(n) {
    let factorial = 1;
    for (let i = 1; i <= n; i++) {
        factorial *= i;
    }
    return factorial;
}

// Ejemplo: Calcular el factorial de 5
let numero = 5;
console.log(`El factorial de ${numero} es ${calcularFactorial(numero)}`);