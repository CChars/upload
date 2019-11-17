<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据</title>
</head>
<%@include file="common.jsp" %>
<body>

<div class="table-responsive">

<%--    <a href="/export"><button type="button" class="btn btn-primary">导出</button></a>--%>

<%--    <form class="form-horizontal" id="form_table" action="/import" enctype="multipart/form-data" method="post">--%>
<%--        <br/>--%>
<%--        <button type="submit" class="btn btn-primary">导入</button>--%>
<%--        <input class="form-input" type="file" name="filename"></input>--%>
<%--    </form>--%>
<%--    <a href = "/answer">--%>
<%--        <button type="button" class="btn btn-primary">跳转</button>--%>
<%--    </a>--%>
    <table class="line">
        <td>
            <a href="/export"><button type="button" class="btn btn-primary">导出</button></a>
        </td>
        <td>
            <form class="form-horizontal" id="form_table" action="/import" enctype="multipart/form-data" method="post">
<%--                <br/>--%>
                <td>
                    <button type="submit" class="btn btn-primary">导入</button>
                </td>
                <td>
                    <input class="form-input" type="file" name="filename"></input>
                </td>
            </form>
        </td>
        <td>
            <a href = "/answer">
                <button type="button" class="btn btn-primary">跳转</button>
            </a>
        </td>
    </table>

    <table class="table">

        <thead class="Table cell">
<%--            <td>ID</td>--%>
            <td>姓名</td>
            <td>周一下午</td>
            <td>周一晚上</td>
            <td>周二下午</td>
            <td>周二晚上</td>
            <td>周三下午</td>
            <td>周三晚上</td>
            <td>周四晚上</td>
            <td>周五下午</td>
            <td>周五晚上</td>
            <td>周六下午</td>
            <td>周六晚上</td>
            <td>周日下午</td>
            <td>周日晚上</td>
            <td>收书</td>
            <td>备注</td>
        </thead>

        <tbody>
            <c:forEach var="user" items="${user}">
                <tr class="success">
<%--                    <td>${user.uid}</td>--%>
                    <td>${user.username}</td>
                    <td>${user.mon_moon}</td>
                    <td>${user.mon_night}</td>
                    <td>${user.tue_moon}</td>
                    <td>${user.tue_night}</td>
                    <td>${user.wed_moon}</td>
                    <td>${user.wed_night}</td>
                    <td>${user.thu_moon}</td>
                    <td>${user.fri_moon}</td>
                    <td>${user.fri_night}</td>
                    <td>${user.sat_moon}</td>
                    <td>${user.sat_night}</td>
                    <td>${user.sun_moon}</td>
                    <td>${user.sun_night}</td>
                    <td>${user.book}</td>
                    <td>${user.remarks}</td>
                </tr>
            </c:forEach>>
        </tbody>

    </table>

</div>
</body>
</html>