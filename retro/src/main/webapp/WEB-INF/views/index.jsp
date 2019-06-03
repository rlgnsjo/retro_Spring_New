<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/section.css?v=1">
<title>Insert title here</title>
</head>
<body>
	<%@  include file="include/header.jsp"%>
	<section>

		<div class="gallery">
			<ul>
				<li>
					<c:forEach items="${pLists.bList}" var="best">
						<a href="#"><img src="resources/images/${best.p_img}" target="_blank "></a>
					</c:forEach>
				</li>
			</ul>
			<div class="desc">
				<a href="#">
				<h2>BEST CHANEL LOOK</h2></a>
						
			<!-- 	<p id="gucci">EXO KAI is best guc</p> -->

			</div>
		</div>

		<div class="gallery">
			<ul>
				<c:forEach items="${pLists.nList}" var="sin">
					<a href="#"><img src="resources/images/${sin.p_img}" target="_blank "></a>
					</c:forEach>
			</ul>

			<div class="desc">
				<h2>BEST GUCCI LOOK</h2>
<!-- 				<p id="gucci">EXO KAI is best gucci dreessr</p> -->

			</div>
		</div>
		
		<div class="gallery">
			<ul>
			<c:forEach items="${pLists.vList}" var="cnt">
						<a href="#"><img src="resources/images/${cnt.p_img}" target="_blank "></a>
					</c:forEach>
			
			</ul>
			<div class="desc">
				<h2>BEST K-POP STAR LOOK</h2>
	<!-- 			<p id="gucci">EXO KAI is best guc</p> -->
			</div>
	
		</div>



	</section>

	<%@ include file="include/footer.jsp"%>

</body>
</html>