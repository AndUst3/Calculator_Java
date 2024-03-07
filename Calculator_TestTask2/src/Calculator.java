class Calculator {
    String parse(String expression) throws Exception {
        String operand;
        String result;

        int num1;
        int num2;
        boolean isRoman;

        String[] operands = expression.split("[+\\-*/]");

        if (operands.length != 2)
            throw new Exception("Должно быть два числа в выражении или вы ввели неверный знак вычисления");

        operand = detectOperation(expression);

        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        }

        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }

        else {
            throw new Exception("Числа должны быть одного формата или вы записали неверное значение");
        }

        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны 1 от одного до 10");
        }

        int arabian = calculating(num1, num2, operand);

        if (isRoman) {
            if (arabian <=0) {
                throw new Exception("Римское число должно быть больше 0");
            }
            result = Roman.convertToRoman(arabian);
        }
        else {
            result = String.valueOf((arabian));
        }
        return result;
    }

    static String detectOperation(String expression) {

        if (expression.contains("+"))
            return "+";
        else if (expression.contains("-"))
            return "-";
        else if (expression.contains("*"))
            return "*";
        else
            return "/";
    }

    static int calculating(int a, int b, String operand) {
        if (operand.equals("+"))
            return a + b;
        else if (operand.equals("-"))
            return a - b;
        else if (operand.equals("*"))
            return a * b;
        else
            return a / b;
    }
}
