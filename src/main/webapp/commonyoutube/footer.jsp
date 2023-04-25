<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script src="<c:url value='/template/useryoutube/js/jquery-3.5.1.min.js'/>"></script>
	<script src="<c:url value='/template/useryoutube/js/popper.min.js'/>"></script>
	<script src="<c:url value='/template/useryoutube/js/bootstrap.min.js'/>"></script>

	<script>
		$(document).ready(function () {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	
	<script>
	$('#changePassBtn').click(function(){
		$('#messageChangePassword').text('');
		var currentPass = $('#currentPass').val();
		var newPass = $('#newPass').val();
		var formData = {
				'currentPass': currentPass,
				'newPass': newPass
				};

		$.ajax({
			url: 'changePass',
			type: 'POST',
			data: formData
		}).then(function(data) {
			$('#messageChangePassword').text('Your password has been changed succesfully');
		}).fail(function(error) {
			$('#messageChangePassword').text('Your password is not correct, try again');
		});
	});
</script>