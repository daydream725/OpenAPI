<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="v2_iteminsert.do" method="post">
	<c:forEach begin="1" end="2" step="1" var = "i">
	<input type="text" placeholder="물품번호" name = "no" readonly="readonly" value="${lastno+i}"/>
		<input type="text" placeholder="이름" name = "name"/>
		<input type="text" placeholder="가격" name = "price"/>
		<input type="text" placeholder="수량" name = "qty"/>
		<input type="submit" value="확인"/>
	</c:forEach>
	</form>
	
	<table>
		<tr>
			<td>물품번호</td>
			<td>이름</td>
			<td>가격</td>
			<td>수량</td>
			<td>등록일자</td>
		</tr>
		
		<c:forEach var="i" items="${list }">
		<tr>
			<td>${i.no }</td>
			<td>${i.name }</td>
			<td>${i.price }</td>
			<td>${i.qty }</td>
			<td>${i.date1 }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>