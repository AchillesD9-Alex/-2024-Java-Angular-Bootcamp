let displayValue = '';
let currentOperation = '';
let firstOperand = null;

function appendNumber(number) {
    displayValue += number;
    $('#display').val(displayValue);
}

function setOperation(operation) {
    if (displayValue === '') return;
    if (firstOperand === null) {
        firstOperand = parseFloat(displayValue);
    } else if (currentOperation) {
        firstOperand = performCalculation(currentOperation, firstOperand, parseFloat(displayValue));
    }
    currentOperation = operation;
    displayValue = '';
    $('#display').val('');
}

function performCalculation(operation, a, b) {
    switch (operation) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b === 0) {
                alert("Error: División por cero");
                return 0;
            }
            return a / b;
        default:
            return b;
    }
}

function calculate() {
    if (firstOperand === null || currentOperation === '' || displayValue === '') return;
    const result = performCalculation(currentOperation, firstOperand, parseFloat(displayValue));
    $('#display').val(result);
    displayValue = result;
    firstOperand = null;
    currentOperation = '';
}

function clearDisplay() {
    displayValue = '';
    currentOperation = '';
    firstOperand = null;
    $('#display').val('');
}
