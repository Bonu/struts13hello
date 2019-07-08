<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
    <style>
        body{
            font-family: verdana;
        }

        table {
            width: 500px;

        }

        table, th, td {
            border: 1px solid black;
            padding: 2px;
        }

        th{
            background-color: #00439A;
            color : #FFFFFF;
        }

        tr.odd{
            background-color: #CFCFCF;
        }

        tr.even{
            background-color: #1076F5;
        }
    </style>
</head>
<body>
<h1>User Information</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr class="<c:if test="${user.id}%2==0">even</c:if><c:if test="${user.id}%2!=0">odd</c:if>">
            <td align="center"><c:out value="id"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td align="center"><c:out value="age"/></td>
            <td><c:if test="${user.gender} == 'M'">Male</c:if><c:if test="${user.gender} == 'F'">Female</c:if></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>