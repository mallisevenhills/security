<html>
<head>
<script src="http://code.jquery.com/jquery-1.7.js"  type="text/javascript"></script>
<script src="js/json2.js"  type="text/javascript"></script>
</head>
<body>
<ul>
<li><a href="mvc/user/showRegisterForm">Sign Up</a></li>
<li><a href="mvc/login">Sign in</a></li>
<li><a href="#" id ="rest">Get data by rest</a></li>
<li><a href="#" id ="rest-post">Post data by rest</a></li>
</ul>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        $('#rest').click(function () {
            jQuery.support.cors = true;
            $.ajax(
                {
                    type: "GET",
                    url: '<%= request.getContextPath()%>/mvc/rest/getUserResponse',
                    data: "{}",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success : recv,
                    error : fail
                });

        });
    });
  
    $("#rest-post").click(function (){
    	$.ajax(
    			{type: "POST", 
    			url:  '<%= request.getContextPath()%>/mvc/rest/postUserResponse',
    			data: '{"id":"1"}',
    			contentType: "application/json; charset=utf-8",
    			dataType: "json",
    			success : recv,
    			error : fail});
    });
    
    
    function recv(o, st, jqr) {
    	var s = jqr ? jqr.responseText : null;
    	alert(s);
    }
    
    function fail(o) {
    	alert("Error calling server " + o.status + ": " + o.statusText);
    }
</script>
</html>
