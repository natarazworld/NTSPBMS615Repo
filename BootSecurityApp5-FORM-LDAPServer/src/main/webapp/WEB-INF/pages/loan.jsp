
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<h1 style="color:red;text-align:center">Loan Approval Page</h1>

<b>Hello , Mr. <%=SecurityContextHolder.getContext().getAuthentication().getName() %></b> <br>
<br><br><br>
  <h3> Approved Loan Amount ::  <%=new java.util.Random().nextInt(100000) %></h3>
  
  <br>
  <a href="./">home</a>
  
   <br>
  <a href="signout">Logout</a>