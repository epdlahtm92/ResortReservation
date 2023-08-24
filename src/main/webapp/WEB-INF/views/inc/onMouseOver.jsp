<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script>
		var menuCount = 5;
		function menuShow(pos) {
			var i = 0
			for ( i; i < menuCount; i++) {
				var obj = document.getElementById("secondMenu" + i);
				if (pos == i) {
					obj.style.display = '';
				} else {
					obj.style.display = 'none';
				}
			}
			
		}
	</script>
<meta charset="UTF-8">
<title>onMouseOver</title>
</head>
<body>
</body>
</html>