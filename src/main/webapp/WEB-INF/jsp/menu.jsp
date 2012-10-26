<%@  page  language="java"  contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<body>
<ul>
<li><a href="userdetails">Get Details</a></li></br>
</ul>

<c:if test="${ not empty menuinfo }">
<c:forEach items="${menuinfo}" var="user">
<c:out value="${user.username}"></c:out>
</c:forEach>    
</c:if>
</body>
</html>


