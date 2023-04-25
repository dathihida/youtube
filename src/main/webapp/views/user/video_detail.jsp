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
	<%@ include file="/commonyoutube/header.jsp"%>
	<!-- main content -->
	<div class="container-fluid watch_video">
		<div class="row pt-4">
			<div class="col-md-8 video_box">
				<!-- <iframe class="video_responsive" width="100%" height="573" src="https://www.youtube.com/embed/hoNb6HuNmU0" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
				<iframe class="video_responsive" width="100%" height="573px"
					id="tm-video" src="https://www.youtube.com/embed/${video.href }">
				</iframe>
					<input name="views_views" value="${video.views}">
				<div class="p-1 pt-3">
					<div class="title">${video.title }</div>
					<div class="row mt-2 border-bottom">
						<div class="col-7">
							<div name="views" id="views" value="${video.views }">${video.views} Views</div>
						</div>
						<div class="col-5 text-right">
							<div class="row">
								<div class="col-6 border-bottom border-dark">
									<c:if test="${not empty sessionScope.currentUser }">
										<div class="text-center mb-5">
											<button id="likeOrUnlikeBtn"
												class="btn btn-primary tm-btn-big">
												<c:choose>
													<c:when test="${flagLikedBtn == true}">
														Unlike
													</c:when>
													<c:otherwise>Like</c:otherwise>
												</c:choose>
											</button>
										</div>
									</c:if>
								</div>
								
								<div class="col-3">
									<div class="text-center mb-5">
										<a id="viewsUser" href="" class="btn btn-primary tm-btn-big">Views</a>
									</div>
								</div>
								
								<div class="col-3">
									<div class="text-center mb-5">
										<a href="" class="btn btn-primary tm-btn-big" data-toggle="modal" data-target="#exampleModal">Share</a>
									</div>
									<!-- Modal -->
									 <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Share Video</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<iframe class="video_responsive" width="100%"
														height="200px" id="tm-video"
														src="https://www.youtube.com/embed/${video.href }">
														
													</iframe>
													<input id="email" type="email" name="email" class="form-control rounded-0" placeholder="Email" required />
												</div>
												<input id="href" type="hidden" name="href" value="${video.href}">
												<input id="shares" type="hidden" name="shares" value="${video.shares}">
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
													<button type="submit" id="sendBtn" class="btn btn-primary">Share</button>
													
													<h5 style="color: red" id="messageReturn"></h5></center>
												</div>
											</div>
										</div>
									</div> 
								</div>
								
								
								<div class="col-3">
									<a href="#" style="color: #606060;" title="Save"> <svg
											style="height: 18px; width: 18px; margin: auto;"
											viewBox="0 0 24 24">
											<path
												d="M14 10H2v2h12v-2zm0-4H2v2h12V6zm4 8v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zM2 16h8v-2H2v2z"
												fill="#606060"></path>
										</svg> SAVE
									</a>
								</div>
							</div>
						</div>
						<input id="videoIdHdn" type="hidden" value="${video.href}" />
					</div>
					<div class="row mt-4 border-bottom ">
						<div class="col-1 pr-0 w-2 text-right">
							<img id="img" width="48"
								src="https://yt3.ggpht.com/a-/AOh14GinKFFtcXMMwrPfhFbie8tgLV0vMzfvVFSMlw=s68-c-k-c0x00ffffff-no-rj-mo"
								class="rounded-circle">
						</div>
						<div class="col-9 pl-0">
							<p style="color: #303030;">
								<b>T-Series</b> <i class="fas fa-check-circle"></i><br> <span
									style="color: #606060">139M subscribers</span>
							</p>
							<p>
								Presenting the full video "KHAIRIYAT (BONUS TRACK)" from the
								Bollywood movie "CHHICHHORE". The film is directed by Nitesh
								Tiwari and produced by Sajid Nadiadwala under the banner of
								Nadiadwala Grandson Entertainment. The film stars Sushant Singh
								Rajput, Shraddha Kapoor, Varun Sharma, Prateik Babbar and
								follows the lives of seven friends from 1992 to present day.<span
									id="dots">...</span> <span id="more">erisque enim ligula
									venenatis dolor. Maecenas nisl est, ultrices nec congue eget,
									auctor vitae massa. Fusce luctus vestibulum augue ut aliquet.
									Nunc sagittis dictum nisi, sed ullamcorper ipsum dignissim ac.
									In at libero sed nunc venenatis imperdiet sed ornare turpis.
									Donec vitae dui eget tellus gravida venenatis. Integer
									fringilla congue eros non fermentum. Sed dapibus pulvinar nibh
									tempor porta.</span>
							</p>
							<button onclick="myFunction()" id="myBtn" class="btn">SHOW
								MORE</button>
						</div>
						<div class="col-2 text-right">
							<button class="btn btn-danger">SUBSCRIBE</button>
						</div>

					</div>
					<div class="row mb-4">
						<div class="col-12 m-4" style="color: #303030; font-weight: bold">10,699
							Comments</div>
						<div class="col-1">
							<img id="img" width="30" src="images/icon/avatar.png"
								class="rounded-circle">
						</div>
						<div class="col-11">
							<form>
								<input type="text" name="comment" class="input_comment"
									placeholder="Add a public comment...">
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-6">Up Next</div>
					<div class="col-6 text-right">
						AUTOPLAY <label class="switch"> <input type="checkbox"
							class="switch-input"> <span class="switch-label"
							data-on="On" data-off="Off"></span> <span class="switch-handle"></span>
						</label>
					</div>
				</div>
				<c:forEach items="${videoList}" var="video">
				<div class="container-fluid video_list">
					<a href="#">
						<div class="card">
							<div class="row p-0">
								<div class="col-md-5">
										<a href="<c:url value='/video?action=watch&id=${video.href }'/>">
											<img src="${video.poster }" alt="Image" class="img-fluid"
											height="10rem">
										</a>
								</div>
								<div class="col-md-7 p-0">
									<p class="mb-1">${video.title}</p>
								</div>
								
							</div>
						</div>
					</a>
				</div>
				<hr>
				</c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="/commonyoutube/footer.jsp"%>

<script>
		$('#likeOrUnlikeBtn').click(function() {
			var videoId = $('#videoIdHdn').val();
			$.ajax({
				url : 'video?action=like&id=' + videoId
			}).then(function(data) {
				var text = $('#likeOrUnlikeBtn').text();
				if (text.indexOf('Like') != -1) {
					$('#likeOrUnlikeBtn').text('Unlike');
				} else {
					$('#likeOrUnlikeBtn').text('Like');
				}
			}).fail(function(error) {
				alert('opppp');
			})
		});
</script>
	
<script>
	$('#sendBtn').click(function(){
		$('#messageReturn').text('');
		var email = $('#email').val();
		var href = $('#href').val();
		var shares = $('#shares').val();
		var views = $('#views').val();
		var formData = {'email': email,
						'href': href,
						'shares':shares,
						'views':views};
		$.ajax({
			url: 'share',
			type: 'POST',
			data: formData
		}).then(function(data) {
			$('#messageReturn').text('VideoShare');
		}).fail(function(error) {
			$('#messageReturn').text('Videonotshare');
		});
	});
</script>
</body>
</html>