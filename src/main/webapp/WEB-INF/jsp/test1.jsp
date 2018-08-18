
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
    <title>test jsp</title>
</head>
<body>
    ${requestScope.date} <br>

    ${requestScope.as}<br>

    ${sessionScope.user}<br>
    ${sessionScope.name}<br>

    ${requestScope.user}<br>
    ${requestScope.name}<br>
</body>
</html>



