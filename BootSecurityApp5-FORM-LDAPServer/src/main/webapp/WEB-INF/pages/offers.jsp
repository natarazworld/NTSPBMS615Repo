

<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<h1 style="color:red;text-align:center"> offers Page</h1>

  <b>Hello , Mr. <%=SecurityContextHolder.getContext().getAuthentication().getName() %></b>
<br><br><br> 
  <h3> 
     <b>Max Loan amoint:: Rs.1000000</b> <br>
     <b> Rate of Intrest :: 7.3%</b> <br>
     <b> Min Tenure :: years</b>
  </h3>
  
  <br>
  <a href="./">home</a>
  
  <br>
  <a href="signout">Logout</a>