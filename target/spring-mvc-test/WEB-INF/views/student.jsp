<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Student Information</h2>
      <form:form method = "POST" action = "/spring-mvc-test/addStudent">
         <table>
            <tr>
               <td><form:label path = "name">Name changed</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "age">Age</form:label></td>
               <td><form:input path = "age" /></td>
            </tr>
            <tr>
               <td><form:label path = "id">id</form:label></td>
               <td><form:input path = "id" /></td>
            </tr>

            <tr>
                     <td>Languages: ${languages}</td>
            </tr>

            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>


      <h2>Students List</h2>
      		<table>
      			<tr>
      			<td><strong>Id</strong></td>
      				<td><strong>Name</strong></td>
      				<td><strong>Age</strong></td>
      			</tr>
      			<c:forEach items="${list}" var="user">
      				<tr>
      				    <td>${user.id}</td>
      					<td>${user.name}</td>
      					<td>${user.age}</td>
      				</tr>
      			</c:forEach>
      		</table>

   </body>

</html>