<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
   String cp = request.getContextPath();
%>

<link rel="stylesheet" href="<%=cp%>/resource/css/style.css" type="text/css">
<link rel="stylesheet" href="<%=cp%>/resource/css/layout.css" type="text/css">

<div class="body-container" style="width: 700px;">
	<header>
	    <div class="header-top">
	        <div class="header-left">
	        	<p> 
	        		<a href="<%=cp%>/">
	        			<span> MINI BOARD </span>
	        		</a>
	        	</p>
	        </div>
	        
	        <div class="header-right">
	          <div style="float: right;">
		           <c:if test="${empty sessionScope.member}">
			          	<a href="<%=cp%>/member/login"> 로그인 </a> &nbsp;
			          	<a href="<%=cp%>/member/member"> 회원가입 </a>
		           </c:if>
		           
		           <c:if test="${not empty sessionScope.member}">
		           		<span> 박지송아님 </span> &nbsp;
		           		<a href="<%=cp%>/member/logout"> 로그아웃 </a> &nbsp;
		           		<a href="<%=cp%>member/pwd"> 정보수정 </a> &nbsp;		           
		           </c:if>	
	          </div>
	        </div>
	    </div>
	    
	    <div class="menu">
	    	<ul class="nav">
	    		<li> <a href="#"> 게시판 </a> </li>	    	
	    	</ul>	    
	    </div>	    
	    
    </header>
</div>