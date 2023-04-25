<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot password</title>
	<%@ include file="/commonyoutube/head.jsp"%>
<!--
    
TemplateMo 556 Catalog-Z

https://templatemo.com/tm-556-catalog-z

-->
</head>
<body>
    <!-- Page Loader -->
     <%@ include file="/commonyoutube/header.jsp"%>

    <div class="container-fluid tm-mt-60" style="padding-top: 12rem">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
               <center><h2 class="tm-text-primary mb-5" >Forgot password</h2></center>
                    <center><div class="form-group" style="width: 25%">
                        <input id="email" type="email" name="email" class="form-control rounded-0" placeholder="Email" required />
                    </div>
                    <div class="form-group tm-text-right">
                        <button type="submit" id="sendBtn" class="btn btn-primary">Send</button>
                    </div>
                    <h5 style="color: red" id="messageReturn"></h5></center>               
            </div>
        </div>
    </div> <!-- container-fluid, tm-container-content -->

    <%@ include file="/commonyoutube/footer.jsp"%>
    
</body>

<script>
	$('#sendBtn').click(function(){
		$('#messageReturn').text('');
		var email = $('#email').val();
		var formData = {'email': email};
		$.ajax({
			url: 'forgotPass',
			type: 'POST',
			data: formData
		}).then(function(data) {
			$('#messageReturn').text('Password has been reset, please');
			setTimeout(function() {
				window.location.href = 'http://localhost:8080/asm_java4/index';
			},5*1000);
		}).fail(function(error) {
			$('#messageReturn').text('You information is not correct, try again');
		});
	});
</script>

</html>