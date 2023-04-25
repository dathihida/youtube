<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>Youtube</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="/commonyoutube/head.jsp"%>

</head>

<body>
	<!-- Top navbar -->
	<%@ include file="/commonyoutube/header.jsp"%>
	<!-- Top navbar -->
	<!-- sidebar -->
	<nav class="main-nav">
		<ul>
			<li class=""><a href="<c:url value='/index' /> "> <span class="fa fa-2x">
						<svg
							style="display: block; height: 24px; width: 24px; margin: auto;"
							viewBox="0 0 24 24">
							<path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8" fill="red"></path>
						</svg>
				</span> <span class="nav-text"> Home </span>
			</a></li>

			<li class="has-subnav"><a href="trending.html"> <span
					class="fa fa-2x"> <svg
							style="display: block; height: 24px; width: 24px; margin: auto;"
							viewBox="0 0 24 24">
							<path
								d="M17.53 11.2c-.23-.3-.5-.56-.76-.82-.65-.6-1.4-1.03-2.03-1.66-1.46-1.46-1.78-3.87-.85-5.72-.9.23-1.75.75-2.45 1.32C8.9 6.4 7.9 10.07 9.1 13.22c.04.1.08.2.08.33 0 .22-.15.42-.35.5-.22.1-.46.04-.64-.12-.06-.05-.1-.1-.15-.17-1.1-1.43-1.28-3.48-.53-5.12C5.87 10 5 12.3 5.12 14.47c.04.5.1 1 .27 1.5.14.6.4 1.2.72 1.73 1.04 1.73 2.87 2.97 4.84 3.22 2.1.27 4.35-.12 5.96-1.6 1.8-1.66 2.45-4.3 1.5-6.6l-.13-.26c-.2-.45-.47-.87-.78-1.25zm-3.1 6.3c-.28.24-.73.5-1.08.6-1.1.38-2.2-.16-2.88-.82 1.2-.28 1.9-1.16 2.1-2.05.17-.8-.14-1.46-.27-2.23-.12-.74-.1-1.37.2-2.06.15.38.35.76.58 1.06.76 1 1.95 1.44 2.2 2.8.04.14.06.28.06.43.03.82-.32 1.72-.92 2.26z"
								fill="#606060"></path>
						</svg>
				</span> <span class="nav-text"> Trending </span>
			</a></li>

			<li class="has-subnav mb-2"><a href="subscription.html"> <span
					class="fa fa-2x"> <svg
							style="display: block; height: 24px; width: 24px; margin: auto;"
							viewBox="0 0 24 24">
							<path
								d="M18.7 8.7H5.3V7h13.4v1.7zm-1.7-5H7v1.6h10V3.7zm3.3 8.3v6.7c0 1-.7 1.6-1.6 1.6H5.3c-1 0-1.6-.7-1.6-1.6V12c0-1 .7-1.7 1.6-1.7h13.4c1 0 1.6.8 1.6 1.7zm-5 3.3l-5-2.7V18l5-2.7z"
								fill="#606060"></path>
						</svg>
				</span> <span class="nav-text"> Subscription </span>
			</a></li>

			<li class="has-subnav border-top"><a href="library.html"> <span
					class="fa fa-2x"> <svg
							style="display: block; height: 24px; width: 24px; margin: auto;"
							viewBox="0 0 24 24">
							<path
								d="M4 6H2v14c0 1.1.9 2 2 2h14v-2H4V6zm16-4H8c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2zm-8 12.5v-9l6 4.5-6 4.5z"
								fill="#606060"></path>
						</svg>
				</span> <span class="nav-text"> Library </span>
			</a></li>
			<li class="has-subnav"><a href="history.html"> <span
					class="fa fa-2x"> <svg
							style="display: block; height: 24px; width: 24px; margin: auto;"
							viewBox="0 0 24 24">
							<path
								d="M11.9 3.75c-4.55 0-8.23 3.7-8.23 8.25H.92l3.57 3.57.04.13 3.7-3.7H5.5c0-3.54 2.87-6.42 6.42-6.42 3.54 0 6.4 2.88 6.4 6.42s-2.86 6.42-6.4 6.42c-1.78 0-3.38-.73-4.54-1.9l-1.3 1.3c1.5 1.5 3.55 2.43 5.83 2.43 4.58 0 8.28-3.7 8.28-8.25 0-4.56-3.7-8.25-8.26-8.25zM11 8.33v4.6l3.92 2.3.66-1.1-3.2-1.9v-3.9H11z"
								fill="#606060"></path>
						</svg>
				</span> <span class="nav-text"> History </span>
			</a></li>
		</ul>
	</nav>
	<!-- sidebar -->
	<div class="row main_container">

		<div class="col-md-2"></div>
		<div class="col-md-8">
			<!-- content section -->
			<div class="container-fluid">
				<div class="">
					<form action="/asm_java4/trending" method="get">
						<div class="input-group mb-3">
							<input type="text" class="form-control search" placeholder="Search" name="search">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" title="Search!"><i class="fas fa-search"></i></button>
							</div>
						</div>
					</form>
				</div>
				<c:forEach var="item" items="${videoList}">
				<div class="container-fluid mt-4 pl-2">
					<a href="#">
					
						<div class="card">
							<div class="row">
								<div class="col-md-3">
									<a href="<c:url value='/video?action=watch&id=${item.href }'/>">
							<img src="${item.poster }" alt="Image" class="img-fluid" height="10rem"></a>
								</div>
								<div class="col-md-7 p-0 pt-2">
									<div class="row">
										<div class="col-1 ml-2 mr-3 desc_hide">
											<img id="img" width="48"
												src="https://yt3.ggpht.com/a-/AOh14GinKFFtcXMMwrPfhFbie8tgLV0vMzfvVFSMlw=s68-c-k-c0x00ffffff-no-rj-mo"
												class="rounded-circle">
										</div>
										<div class="col-10">
											<p class="mb-1 title">${item.title}</p>
											<p class="subtitle">
												T-Series <i class="fas fa-check-circle"></i>
												70M views • 7 months ago
											</p>
											<div class="short_description">
												Modi Govt has announced 20 Lakh Crore Package to help the people in
												these times of economic slowdown and recession. It was announced on 12th
												May but details were released in 5 parts across
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
						
					</a>
				</div>
			</c:forEach>
				
			</div>
		</div>
	</div>

	<%@ include file="/commonyoutube/footer.jsp"%>
</body>

</html>