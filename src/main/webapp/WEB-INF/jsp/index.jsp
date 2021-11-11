<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome to MyWord</title>
</head>
<body>
<span>${name}様、Welcome to Java World!</span>
<form action="/formregsiter" class="register_user" method="post" >
    <h2>User Login</h2>
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" class="username" placeholder="ユーザ名を入力してください！"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" class="password" placeholder="パスワードを入力してください！"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" class="button-submit">登録</button>
            </td>
        </tr>
    </table>
    <%
        //pageContext.setAttribute("name","王小明");
        //request.setAttribute("name","张百亿");
        session.setAttribute("name","谷千万");
        //application.setAttribute("name","杨一毛");
    %>
    <c:choose>
        <c:when test="${name=='张百亿'}">1</c:when>
        <c:when test="${name=='谷千万'}">2</c:when>
        <c:when test="${name=='杨一毛'}">3</c:when>
        <c:otherwise>4</c:otherwise>
    </c:choose>
    <span>
        <c:out value="${f:h(name)}" default="yaliu"> </c:out>
    </span>
</form>


</body>
</html>