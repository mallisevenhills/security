<form action='<%= request.getContextPath() %>/pub/j_spring_security_check' method="post">
    <fieldset>
    <div>
      <div>
        <label>User Name </label>
        <div><input type="text" name="j_username" value=""/></div>
      </div>
      <div>
        <label>Password </label>
        <div><input type="password" name="j_password" value=""/></div>
      </div>        
      <div><button type="submit" >Login</button></div>
    </div>
    </fieldset>
</form>


