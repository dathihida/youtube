<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light fixed-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="<c:url value='/index' /> "> <img
			alt="" src="<c:url value='/template/useryoutube/images/logo.JPG'/>">
		</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto" style="padding-right: 4.5rem">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false">${sessionScope.currentUser.username}</a>
					<div class="dropdown-menu">
					<fmt:setLocale value="${sessionScope.lang}" scope="request" />
			   		<fmt:setBundle basename="global" scope="request"/>
						<c:choose>
							<c:when test="${not empty sessionScope.currentUser}">
								<a class="dropdown-item" href="favorites"><fmt:message key="menu.like"/></a>
								<a class="dropdown-item" href="history"><fmt:message key="menu.history"/></a>
								<a class="dropdown-item" href="logout"><fmt:message key="menu.lgout"/></a>
								<a class="dropdown-item" aria-current="page" data-toggle="modal"
									data-target="#changePassModal"><fmt:message key="menu.changePass"/></a>
							</c:when>
							<c:otherwise>
								<a class="dropdown-item" href="login"><fmt:message key="menu.login"/></a>
								<a class="dropdown-item" href="register"><fmt:message key="menu.register"/></a>
								<a class="dropdown-item" href="forgotPass"><fmt:message key="menu.forgotPass"/></a>
							</c:otherwise>
						</c:choose>
					</div>
					
				</li>
				<li class="nav-item" style="padding-top: 0.5rem; padding-left: 1rem"> 
					<a href="?lang=en">English</a> |
               		<a href="?lang=vi">Tiếng Việt</a>
               	</li>
			</ul>
		</div>
	</div>
</nav>


<%-- 				<fmt:setLocale value="${sessionScope.lang}" scope="request" />
			   	<fmt:setBundle basename="global" scope="request"/>
               	<c:url var="home" value="/home"/> 
               	<a href="${home}/index"> <fmt:message key="menu.home"/></a> |
               	<a href="${home}/about"> <fmt:message key="menu.about"/></a> |
               	<a href="${home}/contact"> <fmt:message key="menu.contact"/> </a> |
               	<a href="?lang=en">English</a> |
               	<a href="?lang=vi">Tiếng Việt</a> --%>

<!-- Modal -->
<div class="modal fade" id="changePassModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
				<button type="button" class="btn btn-close" data-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="form-group">
                    <input type="password" name="currentPass" id="currentPass" class="form-control rounded-0" placeholder="CurrentPass" required />
                </div>
                <div class="form-group">
                    <input type="password" name="newPass" id="newPass" class="form-control rounded-0" placeholder="New Pass" required />
                </div>
                <h5 style="color: red" id = "messageChangePassword"></h5>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id ="changePassBtn">Save changes</button>
			</div>
		</div>
	</div>
</div>