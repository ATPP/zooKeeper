<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form name="form1" action="${pageContext.request.contextPath}/manage/product/upLoad.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="上传文件">
</form>

<form name="form2" action="${pageContext.request.contextPath}/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="富文本编辑器上传文件">
</form>
</body>
</html>
