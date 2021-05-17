<script type="text/javascript">

	var result = "${requestScope.resultClass}";
	
	if (result === "is-success") {
		
		var message = "${requestScope.result}";
		
		alert(message);
		
		window.location.href = "${pageContext.request.contextPath}" + "/sign-in";
	}
</script>
<p class="${requestScope.resultClass}">
	${requestScope.result}
</p>