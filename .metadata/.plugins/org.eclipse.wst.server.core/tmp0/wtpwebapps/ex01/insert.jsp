<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>글쓰기</h1>
<form action="/posts/insert" method="post">
	<hr/>
	<input type="text" value="user02" name="writer">
	<input type="text" name="title"/>
	<br/>
	<textarea rows="10" cols="80" name="body"></textarea>
	<hr/>
	<button type="submit">글등록</button>
</form>