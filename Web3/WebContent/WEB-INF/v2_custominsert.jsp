<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="css/w3.css"/>
</head>
<body>

	<form action="v2_custominsert.do" method="post">
		<label>아이디</label>
		<input type="text" name="id" id="id" /><br/>
		<label>비밀전호</label>
		<input type="password" name="pw" id="pw" /><br/>
		<label>이름</label>
		<input type="text" name="name" id="name" /><br/>
		<label>전화번호</label>
		<input type="text" name="tel" id="tel" /><br/>
		<input type="submit" value="확인"/>
	</form>
	
</body>
</html>