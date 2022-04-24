<%@ page  isELIgnored="false"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 

<h1 style="color:red;text-align:center"> Result page</h1>

<b>   sys date and time :: ${sysDate}  </b> <br>
<b>   Wish Message :: ${wMsg}  </b> <br>
<br>
 <b>   Wish Message :: <c:out value="${wMsg}"  />  </b> <br> 


<br><br>

<a href="./">Go to home</a>
