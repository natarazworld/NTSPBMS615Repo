<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<link rel="stylesheet"
       href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"/> 

<div class="container">       

<c:choose>
   <c:when test="${!empty empsData.getContent()}">
     <!-- <table border="1"  class="table table-striped" > -->
      <!--  <table border="1"  class="table table-hover" > -->
      <table border="1"  class="table" >
      <tr class="table-danger">
         <th>EmpNo  </th>
         <th>EmpName </th>
         <th>Job </th>
         <th>Salary</th>
         <th> Operations </th>
      </tr>
      <c:forEach var="emp" items="${empsData.getContent()}">
           <tr  class="table-success">
              <td>${emp.empno} </td>
              <td>${emp.ename} </td>
              <td>${emp.job} </td>
             <td>${emp.sal} </td>
             <td><a href="edit?no=${emp.empno}"><img src="images/edit1.png" width="50" height="50"/></a>
                   &nbsp;&nbsp;&nbsp; <a onclick="return confirm('Do you want to delete')" href="delete?no=${emp.empno}"><img src="images/delete1.jpg" width="50" height="50"></a>  </td>
           </tr>          
      </c:forEach>
      </table>
       
       <p  style="text-align:center">
      <c:if test="${empsData.hasPrevious()}"> 
          <a href="report?page=${empsData.getPageable().getPageNumber()-1}"> previous </a>  &nbsp; &nbsp;
       </c:if>
       <c:if test="${!empsData.isFirst()}">
          <a href="report?page=0">first</a>  &nbsp; &nbsp;
       </c:if>
       
               <c:forEach var="i" begin="1" end="${empsData.getTotalPages()}" step="1">
                       [<a href="report?page=${i-1}">${i}</a>]  &nbsp;&nbsp;
               </c:forEach>
               
       <c:if test="${!empsData.isLast()}">
          <a href="report?page=${empsData.getTotalPages()-1}">Last</a>  &nbsp; &nbsp;
       </c:if>
       
               
        <c:if test="${empsData.hasNext()}">       
            <a href="report?page=${empsData.getPageable().getPageNumber()+1}"> next </a>
        </c:if>            
       </p>
         
   </c:when>
      <c:otherwise>
          <h1 style="color:red;text-align:center"> Records not found </h1>
      </c:otherwise>
</c:choose>
                      
                             <c:if test="${!empty resultMsg}">
                                 <h3 style="color:green;text-align:center"> ${resultMsg }</h3>
                             </c:if>
                                     
 <br><br>
 <hr>
          <h1 style="text-align:center"><a href="./"><img src="images/home1.png" width="50" height="50">Home</a> </h1>
 <hr>
  <h1 style="text-align:center"><a  href="add"><img src="images/add.png" width="50" height="50"> Add Employee</a> </h1>
</div>