<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>バトル画面</title>
<link rel="stylesheet" href="./styles/janken.css">
</head>
<body>
    <h1>あなたの手を選んでね</h1>
    
    <form action="janken" method="GET">
    	<div class="players">
    		<label>対戦人数を選んでね</label>
    		<input type="number" name="num" required="required">
    	</div>
    	
    	<div class="images">
    		<button  type="submit" name="hand" value="1">
     			<img class="selectHand" src="./images/hand0.png" >
     		</button>
     		<button  type="submit" name="hand" value="2">
     			<img class="selectHand" src="./images/hand1.png" >
     		</button>
     		<button type="submit" name="hand" value="3">
     			<img class="selectHand" src="./images/hand2.png" >
     		</button>
    	</div>
    </form>
</body>
</html>