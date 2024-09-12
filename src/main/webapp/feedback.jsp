<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<%@ include file="components/links.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div
		class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
		<h3>Please fill the Feedback Form</h3>

		<form action="<%=application.getContextPath()%>/FeedbackServlet" method="post" class= "mt-3">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> 
					<input required name="email" placeholder="Enter here" type="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Phone No</label>
				<input required name="phone" type="text" placeholder="Enter here" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Your feedback message</label>
				<textarea name="msg" rows="10" class="form-control" required placeholder="Enter here"></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Submit</button>
				<a href="feedback.jsp" type="submit" class="btn btn-primary">Reset</a>
			</div>
			
		</form>
	</div>



	<%@ include file="scripts.jsp"%>
</body>

</html>