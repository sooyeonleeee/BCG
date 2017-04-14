<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:forward page="/sample/openSampleList.do" />

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>This is index.jsp</h1>
	<h1><%=request.getContextPath() %></h1>
</body>
</html>