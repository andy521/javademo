<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!!!！</h2>
<a href="/test/href1">测试页面一</a>
<a href="/test/href2">测试页面二</a>
<input type="text" id="data" name="data" onchange="changeUrl(this)"><br/>
<a id="test3" href="test/href3/data=">测试页面三</a>
</body>
<script>
    function changeUrl(obj){
        document.getElementById("test3").href="test/href3/data="+obj.value;
    }
</script>
</html>
