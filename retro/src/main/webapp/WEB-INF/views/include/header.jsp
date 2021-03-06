<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="common.jsp"  %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/common.css?v=1">
<link rel="stylesheet" href="${path}/resources/css/header.css?v=1">
<title>Insert title here</title>
</head>
<body>
	<div id="modal">
		<div id="modal_login">
			<header>
			<div class="header_logo"><img alt="네이버로고" src="${path}/resources/images/피앙세.png"></div>
		</header>
		<section>
			<div class="input_tag">
				<input type="text" class="idpw" id="login_id" name="" placeholder="아이디를 입력해주세요"></input>
			</div>
			<div class="input_tag">
				<input type="password" class="idpw" id="login_pw" name="" placeholder="비밀번호를 입력해주세요"></input>
			</div>
			<div class="idpw_find">
				<span class="id_find">아이디 찾기</span>
				<span>|</span>
				<span class="pw_find">비밀번호 찾기</span>
			</div>
			<div class="err_msg">등록되어 있지 않은 아이디 입니다.</div>
			<div class="login_btn">
				<button id="btn_login">로그인</button>
			</div>
			<footer>
			<div id="footer">
				<ul>
					<li><a href="#">이용약관</a></li>
					<li><strong><a href="#">개인정보처리방침</a></strong></li>
					<li><a href="#">책임의 한계와 법적고지</a></li>
					<li><a href="#">회원정보 고객센터</a></li>
				</ul>

				<div id="address">
					<span>copyright</span>
					<span>ⓒ</span>
					<span><strong><a href="#">a finace corp.</a></strong></span>
					<span>All Rights Reserved.</span>
				</div>			
			</div>
		</section>
		<button id="modal_close"><i class="fas fa-times"></i></button>
		</div>
	</div>
	<header>
	<div class="header_menu">
		<div class="inner_header inner_header_menu">
		 	<div class="header_sns">	
		 		<a href="#">
		 			<i class="fab fa-instagram"></i></a>
		 		<a href="#">
		 			<i class="fab fa-twitter-square"></i></a>
		 		<a href="#">
		 			<i class="fab fa-facebook-square"></i></a>
		 		<a href="#">
		 			<i class="fab fa-line"></i></a>

			</div>
		
		<div class="header_member">
			<ul>
				<li><a href="#">
					
	
	<button id="topBtn">
		<i class="fas fa-arrow-up"></i>				
	</button></a></li>	
			<c:choose>
				<c:when test="${empty sessionScope.userid}" >				
					<li><a href="${path}/member/constract" id="login_btn">회원가입</a></li>
					<li><a id="modal_open">로그인</a><%-- <a href="${path}/loginPage.retro">로그인</a> --%></li>
				</c:when>
				<c:otherwise>
					<li style="color:white"><a href="#" style="color:#FFB6C1">${sessionScope.name}</a>(${sessionScope.userid})</li>
					 <%-- a href="${path}/loginOutAjax.retro"  --%>
					<li><a href="#" class="logout_btn">로그아웃</a></li>
					<li><a href="${path}/member/update">내정보수정</a></li>
					<li><a href="${path}/member/pwupdate">비밀번호수정</a></li>					
					<li><a href="${path}/member/delete">회원 탈퇴</a></li>
				</c:otherwise>
			</c:choose>					
			</ul>
		</div>	
	</div>		
	<div class="header_logo">		
		<div class="inner_header">
			<img src="${path}/resources/images/피앙세.png" alt="로고이미지">
		</div>
	</div>
	<div class="header_nav">
		<div class="nav_wrap">
			<div class="right_content">
				<ul>  <!-- <ul> 태그는 순서없이 모양으로 (unordered[순서가 매겨지지않은] list) 목록을 만듬! -->
					<li id="SELECTSHOP">
						<a href="#">SELECTSHOP</a>
					</li>								
					<li class= "dropdown"><a href="#">BEST</a>
						<div class= "dropdown_content">
						 	<a href= "https://rafsimons.com/">Maison Kitsuné</a>
						 	<a href= "https://www.off---white.com/en/KR?utm_referrer=https%3A%2F%2Fwww.google.com%2F">OFF WHITE</a>
						 	<a href= "#">ROLEX</a>
						 	<a href= "#">GUCCI</a>	
						 	<a href= "#">YSL</a>					 		
						</div>
					</li>      <!--  <a></a> 태그는 하이퍼링크를 걸어주는 태그 -->
					<li class= "dropdown"><a href="#">luxury</a>
						<div class= "dropdown_content">
						 	<a href= "https://rafsimons.com/">RAF SIMONS</a>
						 	<a href= "https://www.off---white.com/en/KR?utm_referrer=https%3A%2F%2Fwww.google.com%2F">OFF WHITE</a>
						 	<a href= "#">FENDI </a>
						 	<a href= "#">GUCCI</a>	
						 	<a href= "#">YSL</a>					 		
						</div>
					</li>
					<li class="dropdown"><a href="#">WATCH </a>
					<div class= "dropdown_content">
					 	<a href= "https://rafsimons.com/">ROLEX</a>
					 	<a href= "#">MIDO</a>  
					 	<a href= "#">cartier</a>
					 	<a href= "#">hamilton</a>	
					 	<a href= "#">OMEGA</a>					 		
					</div>
					</li>	
					<li class="dropdown"><a href="#"> formal </a>
						<div class= "dropdown_content">
						 	<a href= "https://rafsimons.com/">Tommy Hilfiger </a>
						 	<a href= "#">acne studio</a>  
						 	<a href= "#">Maison Kitsuné</a>
						 	<a href= "#">LACOSTE</a>	
						 	<a href= "#">COS</a>					 		
						</div>
					</li>
						
					<li class="dropdown"><a href="#"> preppy </a>
						<div class= "dropdown_content">
						 	<a href= "https://rafsimons.com/">Tommy Hilfiger </a>
						 	<a href= "#">polo</a>  
						 	<a href= "#">SANDRO</a>
						 	<a href= "#">LACOSTE</a>	
						 	<a href= "#">COS</a>					 		
						</div>
					</li>
					<li class="dropdown"><a href="#"> ACC </a>
						<div class= "dropdown_content">
						 	<a href= "https://rafsimons.com/">cartier</a>
						 	<a href= "#">Tiffany&Co</a>  
						 	<a href= "#">bulgari</a>
						 	<a href= "#">STONEHENGE</a>	
						 	<a href= "#">Swarovski</a>					 		
						</div>
					</li>
					<li class="dropdown"><a href="#"> 게시판 </a>
						<div class= "dropdown_content">
						 	<a href= "${path}/board/list">게시판</a>		
						 	 <!--1. 해당 버튼 클릭시 해당경로로 이동  경로 이동할때 반드시 web,xml이동 -->				 				 		
						</div>
					</li>
				</ul>

			</div>
		</div>
	</div>
				

	</header>
	<!-- header 끝 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<script type="text/javascript">
	// LoginInterceptor 에서 보내는 메세지	
	
		var message = '${message}';
		var uri = '${uri}';
			
						
			if (message == "nologin") {
				$('#modal').css('display', 'flex');
				$('#login_id').focus();
				$('.err_msg').text('로그인이 필요합니다.').css('display', 'block');           				  
			}

		
		
				$(document).ready(function() {
					$(window).scroll(function() {
						var scrollValue = $(this).scrollTop();
						if(scrollValue> 40) {
							$('#topBtn').fadeIn();
						}else{
							$('#topBtn').fadeOut();
						}
					});
					$('#topBtn').click(function() {
						$('html,body').animate({scrollTop : 0}, 60);
					});
				});		
				
				
				$(document).ready(function(){					
					
					$("#btn_login").click(function(){
						
						var id = $.trim($('#login_id').val());
						var pw = $.trim($('#login_pw').val());
						
						var regEmpty = /\s/g;
						
						// 1. null 체크
						// 2. 공백 체크
						
						if(id == null || id.length == 0) {
							$('.err_msg').text('필수 정보입니다.')
										 .css('display', 'block');
							return false;
						} else if(id.match(regEmpty)) {
							$('.err_msg').text('공백 없이 입력해주세요.')
							 			 .css('display', 'block');
							return false;
						}
						
						if(pw == null || pw.length == 0) {
							$('.err_msg').text('필수 정보입니다.')
										 .css('display', 'block');
							return false;
						} else if(pw.match(regEmpty)) {
							$('.err_msg').text('공백 없이 입력해주세요.')
							 			 .css('display', 'block');
							return false;
						}
						
						$.ajax({
							url: "${path}/member/login",
							type: "POST",
							dataType: "text", // ajax 처리후 받을데이터 success: function(data)의 데이터를 반환받음.
							data: "id="+id+"&pw="+pw,
							success: function(data) {
								if(data == "1") {
									if (uri == '') {
										location.reload();
									} else {
										location.href = uri;
									}												
								} else if(data == "-1") {
									$('#login_id').select();
									$('.err_msg').text('회원 아이디 또는 비밀번호가 일치하지 않습니다.')
									             .css('display', 'block');
								}
							},
							error:function() {
								alert("System Error!");
							}
						});
					});
					
					});
					$('#modal_open').click(function(){
						$('#modal').css('display', 'flex');
						$('#login_id').focus();
					});
					$('#modal_close').click(function(){
						$('.idpw').val("");
						$('.err_msg').css('display', 'none');
						$('#modal').css('display', 'none');
					});
					
					
					$(document).on('click','.logout_btn', function(){
						$.ajax({
							url: "${path}/member/logout",
							type: "POST",													
							success: function(){  // 리턴값으로 받을값이 없으니 fuction 가운데에 date가 있다.							 
								location.reload();
							},
							error:function() {
								alert("System Error\(*.*)/");						
							}
							
						});
					});
						
					/* $('.logout_btn').click(function(){
						$.ajax({
							url: "logOutAjax.retro",
							type: "POST",
							dataType: "json",
							data: "",
							success: function(data) {
								location.reload();
							},
							errer:function() {
								alert("System Error♨");
							}
						});
					}); */
					
					
				/* $(document).ready(function() {
				$('#open_btn').click(function(event) {
					$('#modal_all').css('display', 'flex');
					});

				$('#close_btn').click(function(event) {
					$('#modal_all').css('display', 'none');
					});
				});
				$(document).on('click', '.logout_btn', function(){
					$.ajax({
						url: "logoutAjax.retro",
						type: "POST",
						dataType: "json",						
						success: function(data){							 
							location.reload();
						},
						error:function() {
							alert("System Error\(*.*)/");						
						}
						
					}); */
					
				
	</script>
</body>
</html>