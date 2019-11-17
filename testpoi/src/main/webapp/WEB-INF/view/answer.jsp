<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>值班表</title>
</head>
<%@include file="common.jsp" %>
<body>

<div class="table-responsive">

    <div align="center" style="background-color:#ff7f50">值班表</div>

    <table class="table">
        <thead class="Table cell" align="center">
        <td><b>周一</b></td>
        <td><b>周二</b></td>
        <td><b>周三</b></td>
        <td><b>周四</b></td>
        <td><b>周五</b></td>
        <td><b>周六</b></td>
        <td><b>周日</b></td>
        </thead>

        <tbody>

        <td align="center" colspan="7" bgcolor="#ff7f50">下午</td>

        <c:forEach var="day" items="${day}">
            <tr class="success" align="center">
                <td>${day.mon_user}</td>
                <td>${day.thu_user}</td>
                <td>${day.wen_user}</td>
                <td></td>
                <td>${day.fri_user}</td>
                <td>${day.sat_user}</td>
                <td>${day.sun_user}</td>
            </tr>
        </c:forEach>>
        </tbody>

        <td align="center" colspan="7" bgcolor="#ff7f50">晚上</td>

        <tbody>

        <c:set var="salary" value="0"/>
        <c:set var="salary1" value="0"/>
        <c:set var="salary2" value="0"/>
        <c:set var="salary3" value="0"/>
        <c:set var="salary4" value="0"/>
        <c:set var="salary5" value="0"/>
        <c:set var="salary6" value="0"/>

        <c:forEach var="day" items="${day}">

<%--            <tr class="success"  align="center">--%>
<%--&lt;%&ndash;                周一的晚上&ndash;%&gt;--%>

<%--                <c:if test="${(day.bookMon == false)&&(salary >= 2)}">--%>
<%--                    <td>${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookMon == true)&&(salary >= 2)}">--%>
<%--                    <td>${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookMon == false)&&(salary < 2)}">--%>
<%--                    <td>${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookMon == true) && (salary < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.mon_user2}</td>--%>
<%--                    <c:set var="salary" value="${salary + 1}"/>--%>
<%--                </c:if>--%>
<%--&lt;%&ndash;周二的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookThu == false)&&(salary1 >= 2)}">--%>
<%--                    <td>${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookThu == true)&&(salary1 >= 2)}">--%>
<%--                    <td>${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookThu == false)&&(salary1 < 2)}">--%>
<%--                    <td>${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookThu == true) && (salary1 < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.thu_user2}</td>--%>
<%--                    <c:set var="salary1" value="${salary1 + 1}"/>--%>
<%--                </c:if>--%>
<%--&lt;%&ndash;周三的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookWen == false)&&(salary2 >= 2)}">--%>
<%--                    <td>${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookWen == true)&&(salary2 >= 2)}">--%>
<%--                    <td>${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookWen == false)&&(salary2 < 2)}">--%>
<%--                    <td>${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookWen == true) && (salary2 < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.wen_user2}</td>--%>
<%--                    <c:set var="salary2" value="${salary2 + 1}"/>--%>
<%--                </c:if>--%>
<%--&lt;%&ndash;周四的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookTue == false)&&(salary3 >= 2)}">--%>
<%--                    <td>${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookTue == true)&&(salary3 >= 2)}">--%>
<%--                    <td>${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookTue == false)&&(salary3 < 2)}">--%>
<%--                    <td>${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookTue == true) && (salary3 < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.tue_user}</td>--%>
<%--                    <c:set var="salary3" value="${salary3 + 1}"/>--%>
<%--                </c:if>--%>
<%--&lt;%&ndash;周五的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookFri == false)&&(salary4 >= 2)}">--%>
<%--                    <td>${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookFri == true)&&(salary4 >= 2)}">--%>
<%--                    <td>${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookFri == false)&&(salary4 < 2)}">--%>
<%--                    <td>${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookFri == true) && (salary4 < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.fri_user2}</td>--%>
<%--                    <c:set var="salary4" value="${salary4 + 1}"/>--%>
<%--                </c:if>--%>
<%--&lt;%&ndash;周六的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookSat == false)&&(salary5 >= 2)}">--%>
<%--                    <td>${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSat == true)&&(salary5 >= 2)}">--%>
<%--                    <td>${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSat == false)&&(salary5 < 2)}">--%>
<%--                    <td>${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSat == true) && (salary5 < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.sat_user2}</td>--%>
<%--                    <c:set var="salary5" value="${salary5 + 1}"/>--%>
<%--                </c:if>--%>
<%--&lt;%&ndash;周天的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookSun == false)&&(salary6 >= 2)}">--%>
<%--                    <td>${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSun == true)&&(salary6 >= 2)}">--%>
<%--                    <td>${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSun == false)&&(salary6 < 2)}">--%>
<%--                    <td>${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSun == true) && (salary6 < 2)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.sun_user2}</td>--%>
<%--                    <c:set var="salary6" value="${salary6 + 1}"/>--%>
<%--                </c:if>--%>
<%--            </tr>--%>



<%--            <tr class="success"  align="center">--%>
<%--                &lt;%&ndash;周一的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookMon == false)}">--%>
<%--                    <td>${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookMon == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周二的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookThu == false)}">--%>
<%--                    <td>${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookThu == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周三的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookWen == false)}">--%>
<%--                    <td>${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookWen == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周四的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookTue == false)}">--%>
<%--                    <td>${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookTue == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周五的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookFri == false)}">--%>
<%--                    <td>${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookFri == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周六的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookSat == false)}">--%>
<%--                    <td>${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSat == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周天的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookSun == false)}">--%>
<%--                    <td>${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSun == true)}">--%>
<%--                    <td style="background-color: #8a6d3b">${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--            </tr>--%>

<%--            <tr class="success"  align="center">--%>
<%--                    &lt;%&ndash;周一的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookMon == false)}">--%>
<%--                    <td>${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookMon == true)}">--%>
<%--                    <td>${day.mon_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周二的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookThu == false)}">--%>
<%--                    <td>${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookThu == true)}">--%>
<%--                    <td>${day.thu_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周三的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookWen == false)}">--%>
<%--                    <td>${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookWen == true)}">--%>
<%--                    <td>${day.wen_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周四的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookTue == false)}">--%>
<%--                    <td>${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookTue == true)}">--%>
<%--                    <td>${day.tue_user}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周五的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookFri == false)}">--%>
<%--                    <td>${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookFri == true)}">--%>
<%--                    <td>${day.fri_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周六的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookSat == false)}">--%>
<%--                    <td>${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSat == true)}">--%>
<%--                    <td>${day.sat_user2}</td>--%>
<%--                </c:if>--%>
<%--                    &lt;%&ndash;周天的晚上&ndash;%&gt;--%>
<%--                <c:if test="${(day.bookSun == false)}">--%>
<%--                    <td>${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${(day.bookSun == true)}">--%>
<%--                    <td>${day.sun_user2}</td>--%>
<%--                </c:if>--%>
<%--            </tr>--%>

        </c:forEach>>
        </tbody>

    </table>
</div>
</body>
</html>