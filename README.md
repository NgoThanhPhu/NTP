

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Toạ độ</title>
</head>

<body>
<img src="planet.jpg" width="672" height="372" />
<script language="JavaScript">
var firefox=document.getElementById&&!document.all;
document.onmousemove=mouseMove;
function mouseMove(e){
var str;
if (firefox) str="x="+e.clientX+", y="+e.clientY;
else str="x="+event.clientX+", y="+event.clientY;
document.title=str;
}
</script>
</body>
</html>
