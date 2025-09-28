<%@ page language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
try {
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
    String operation = request.getParameter("r1");

    if (operation.equals("Add")) {
        out.println("Addition is: " + (num1 + num2));
    } else if (operation.equals("Sub")) {
        out.println("Subtraction is: " + (num1 - num2));
    } else if (operation.equals("Mul")) {
        out.println("Multiplication is: " + (num1 * num2));
    } else if (operation.equals("Div")) {
        if (num2 != 0) {
            out.println("Division is: " + (num1 / num2));
        } else {
            out.println("Error: Division by zero is not allowed.");
        }
    } else {
        out.println("No operation selected.");
    }
} catch (Exception e) {
    out.println("Invalid input. Please enter valid numbers.");
}
%>
</body>
</html>
