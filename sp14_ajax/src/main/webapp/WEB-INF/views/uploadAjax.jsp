<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- jQuery import -->
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- jQuery Form Plugin import -->
<script src="<%=request.getContextPath()%>/js/jquery.form.min.js"></script>
<!-- jQuery MultiFile Plugin import -->
<script src="<%=request.getContextPath()%>/js/jQuery.MultiFile.min.js"></script>
<!-- file.js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/file.js" defer="defer"></script>
</head>
<body>

	<h1>Upload with Ajax</h1>
	<h2>경로 : <%=request.getContextPath() %></h2>

	<div class="uploadDiv">
		<input type='file' name='uploadFile' multiple="multiple">
	</div>
	
	<div class='uploadResult'>
	<ul>
	
	</ul>
	</div>
	<button id='uploadBtn'>Upload</button>

</body>
</html>