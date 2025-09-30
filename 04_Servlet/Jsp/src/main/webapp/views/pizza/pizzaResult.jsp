<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>피자 결제 페이지</title>
</head>

<body>
	<h1>피자 결제 페이지</h1>
	<h2>주문내역</h2>
	<h3>[주문자 정보]</h3>
	<ul>
		<li>성함 : ${userName}</li>
		<li>전화번호 : ${phone}</li>
		<li>주소 : ${address}</li>
		<li>요청사항 : ${message}</li>
	</ul>
	<br>
	<h3>[주문 정보]</h3>
	<ul>
		<li>피자 : ${pizza}</li>
		<li>토핑 : <c:forEach var="t" items="${toppings}">
                    ${t}<c:if
					test="${!t eq toppings[toppings.length-1]}">, </c:if>
			</c:forEach>
		</li>
		<li>결제방식 : ${payment}</li>
	</ul>
	<h3>위와 같이 주문하셨습니다.</h3>
	<h2>총 가격 : ${price}원</h2>
</body>

</html>