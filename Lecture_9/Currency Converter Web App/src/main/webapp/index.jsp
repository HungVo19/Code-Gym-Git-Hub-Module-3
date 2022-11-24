<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Currency Converter</h2>
<form method="get" action="Converter">
    <label style="font-weight: bold">Rate:</label><br>
    <label>
        <input type="text" name="rate" placeholder="rate" value="22000">
    </label><br>
    <label style="font-weight: bold">USD</label><br>
    <label>
        <input type="text" name="usd" placeholder="USD" value="0"><br>
    </label>
    <label>
        <input onclick="validate()" type = "submit" id = "submit" value = "Converter">
    </label>
</form>
</body>
<script>
function validate(){
    let input = document.getElementById("usd").value;
    if(input == 1){
        alert("Wrong input!")
    } else {
        window.location.href="Lecture_9/Currency Converter Web App/src/main/java/Converter.java"
    }
}
</script>
</html>