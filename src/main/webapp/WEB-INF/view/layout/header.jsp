<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
   String cp = request.getContextPath();
%>
<div class="header-top">
    <div class="header-left">
        <p style="margin: 2px;">
            <a href="<%=cp%>/" style="text-decoration: none;">
                <span style="width: 200px; height: 70; position: relative; left: 0; top:20px; color: #7D3C98; font-family: arial black; font-size: 30px; font-weight: bold;">MINI BOARD</span>
            </a>
        </p>
    </div>
    <div class="header-right">
        <div style="padding-top: 20px;  float: right;">
            <c:if test="${empty sessionScope.member}">
                <a href="<%=cp%>/member/login">로그인</a>
                    &nbsp;|&nbsp;
                <a href="<%=cp%>/member/member">회원가입</a>
            </c:if>
            <c:if test="${not empty sessionScope.member}">
                <span style="color:#7D3C98;">${sessionScope.member.userName}</span>님
                &nbsp;|&nbsp;
                <a href="<%=cp%>/member/logout">로그아웃</a>
                &nbsp;|&nbsp;
                <a href="<%=cp%>/member/pwd">정보수정</a>
           </c:if>
        </div>
    </div>
</div>

<div class="menu">
    <ul class="nav">
        <li> <a href="<%=cp%>/bbs/list">게시판</a> </li>     
    </ul>      
</div>
