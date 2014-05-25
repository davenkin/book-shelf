<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <body>
  
  <div id="container">

    <form:form  modelAttribute="book">
      <label for="isbnInput">ISBN: </label>
      <form:input path="isbn" id="isbnInput" />
      <br/>

      <label for="nameInput">Name: </label>
      <form:input path="name" id="nameInput" />
      <br/>

      <label for="authorInput">Author: </label>
      <form:input path="author" id="authorInput" />
      <br/>

      <label for="priceInput">Price: </label>
      <form:input path="price" id="priceInput" />
      <br/>



      <input type="submit" value="Submit" />
    </form:form>
  </div>

    </body>
  </html>