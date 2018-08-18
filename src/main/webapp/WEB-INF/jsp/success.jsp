
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dododo</title>
</head>
<body>
    <form action="../test/testpojo" method="post">
        <input type="text" name="name">
        <input type="text" name="password">
        <input type="text" name="email">
        <input type="text" name="age">
        <input type="text" name="address.city">
        <input type="text" name="address.province">
        <input type="submit">
    </form>

</body>
</html>
