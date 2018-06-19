<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  div {
    background: #fc3; /* Цвет фона */
    border: 2px solid black; /* Параметры рамки */
    padding: 20px; /* Поля вокруг текста */
    margin-top: 20%; /* Отступ сверху */
    text-align: center;
  }
</style>
<body>
<div>
  <form name="Form1"
        action="http://localhost:8080/RegPays\">
    <B>Vvedite summu deneg:</B>
    <input type=textbox name="amount" size=14 value="" >
    <BR>
    <B>Kolichestvo Let:</B>
    <input type=textbox name="period" size=20 value="">
    <BR>
    <B>Vvedite procent po ssudet:</B>
    <input type=textbox name="rate" size=10 value="">
    <BR>
    <B>Ezhemesjachnyj platezh</B>
    <input READONLY type=textbox name="payment" size=12 value="">
    <BR><P>
    <input type=submit value="Submit">
  </form>
</div>
</body>
</html>