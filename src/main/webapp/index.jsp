<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Chat Application | MohitRaj</title>
<!-- <link rel="stylesheet" href="/css/style.css" />
<link
	href="/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css"> -->
	
	<link type="text/css" href="<c:url value='/assets/css/bootstrap.min.css' />" rel="stylesheet" />
	 <link type="text/css" href="<c:url value='/assets/css/style.css' />" rel="stylesheet" />
    <%-- <script src="<c:url value='/assets/js/bootstrap.min.js' />" type="text/javascript"></script> --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script
	src="/js/bootstrap.min.js"></script> -->
</head>
<body>

	<div id="welcome-page">
		<div class="welcome-page-container">
			<h1 class="title">Welcome - To join the chat group enter your
				name</h1>
			<form id="welcomeForm" name="welcomeForm">
				<div class="form-group">
					<input type="text" id="name" placeholder="name"
						class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" onclass="accent username-submit">Lets
						Begin</button>
				</div>
			</form>
		</div>
	</div>


	<div id="dialogue-page" class="hidden">
		<div class="dialogue-container">
			<div class="dialogue-header">
				<h2>JavaInUse Chat Application</h2>
			</div>
			<ul id="messageList">

			</ul>
			<!-- nameForm="dialogueForm" -->
			<form id="dialogueForm" name="dialogueForm" >
				<div class="form-group">
					<div class="input-group clearfix">
						<input type="text" id="chatMessage"
							placeholder="Enter a message...." autocomplete="off"
							class="form-control" />
						<button type="submit" class="glyphicon glyphicon-share-alt">Send</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="<c:url value='/assets/js/sockjs.min.js' />" type="text/javascript"></script>
	<script src="<c:url value='/assets/js/stomp.min.js' />" type="text/javascript"></script>
	<script src="<c:url value='/assets/js/script.js' />" type="text/javascript"></script>
	<%-- 
	<script
		src="/js/sockjs.min.js"></script>
	<script
		src="/js/stomp.min.js"></script> --%>
	<!-- <script src="/js/script.js"></script> -->
</body>
</html>