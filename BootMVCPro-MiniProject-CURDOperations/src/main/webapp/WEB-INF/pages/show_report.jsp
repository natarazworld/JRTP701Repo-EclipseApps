<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
   <c:when  test="${!empty empList}">
     <table  border="1" bgcolor="cyan"  align="center">
        <tr>
          <th>empno </th><th>emp name </th><th>emp desg </th> <th>emp salary </th> <th>deptno </th><th> operations </th>
        </tr>
        
        <c:forEach var="emp"  items="${empList}">
            <tr>
              <td>${emp.empno}</td>
              <td>${emp.ename}</td>
              <td>${emp.job}</td>
              <td>${emp.sal}</td>
              <td>${emp.deptno}</td>
            <td><a href="edit?no=${emp.empno}"><img src="images/edit.png" width="30px" height="30px"></a> &nbsp;&nbsp;&nbsp;
                       <a href="delete?no=${emp.empno}" onclick="return confirm(' are u sure to delete???')"><img src="images/delete.jpg" width="30px" height="30px"></a> 
              </td>
            </tr>
        </c:forEach>
        
     </table>
   
   </c:when>
   <c:otherwise>
       <h1 style="color:red;text-align:center"> Records not found  </h1>
   </c:otherwise>

</c:choose>
 <br><br><br>
 
<h2 style="color:green;text-align:center"> ${resultMsg}  </h2> 
 
<center>  <a href="register">Register Employee <img src="images/add.jpg"  width="100px" height="100px"/></a></center>
 
<br>
<center>  <a href="./">home <img src="images/home.jpg"  width="100px" height="100px"/></a></center>
