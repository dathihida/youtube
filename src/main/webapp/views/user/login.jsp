<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
<%@ include file="/commonyoutube/head.jsp"%>
<!--
    
TemplateMo 556 Catalog-Z

https://templatemo.com/tm-556-catalog-z

-->
</head>
<body>
    <!-- Page Loader -->
    	<%@ include file="/commonyoutube/header.jsp"%>

    <div class="container-fluid tm-mt-60">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
               <center><h2 class="tm-text-primary mb-5" style="padding-top: 12rem">Login</h2></center>
                <form id="contact-form" action="login" method="POST" class="tm-contact-form mx-auto" style="width: 25%">
                	
                    <div class="form-group">
                        <input type="text" name="username" class="form-control rounded-0" placeholder="Username" required />
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control rounded-0" placeholder="Password" required />
                    </div>
                    <div class="form-group tm-text-right" style="padding-left: 9rem">
                        <button type="submit" class="btn btn-primary" style="width: 35%">Send</button>
                    </div>
                </form>             
            </div>
        </div>
    </div>

<%@ include file="/commonyoutube/footer.jsp"%>
</body>
</html>