<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果画面</title>
<link rel="stylesheet" href="./styles/janken.css">
</head>
<body>

	<% int[] handInfo = (int[])request.getAttribute("handInfo"); %>
	<% int handInfoSize = handInfo.length;%>
	<% int  result =  handInfo[handInfoSize-1]; %>

	<h1>結果は…
	<% if (result == 0){ %>
		引き分け〜
	<% }else if(result == 1){ %>
		勝ち！！！
	<% }else{ %>
		負けだよ〜
	<% } %>
	</h1>
	
	<h2>あなたの手</h2>
		<img class='playerHand' src='./images/hand<%=handInfo[0]%>.png'>
	<h2>相手の手</h2>
	<% for(int i = 1; i < handInfoSize - 1; i++){ %>
		<img class='cpHand' src='./images/hand<%=handInfo[i]%>.png'>
	<% } %>

</body>
</html>