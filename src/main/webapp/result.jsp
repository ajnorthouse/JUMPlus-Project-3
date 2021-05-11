<%var result = (String[]) request.getAttribute("result");
if (result != null) {%>
	<p class="<%result[0].toString();%>"><%result[1].toString();%></p>
<%}%>