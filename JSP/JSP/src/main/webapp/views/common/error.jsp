<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/common/menubar.jsp"/>
<h1 class="error-msg">
    <c:out value="${errorMsg}" default="알 수 없는 오류가 발생하였습니다." />
</h1>

</body>
</html>