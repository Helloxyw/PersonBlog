<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>登录界面</title>



    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>

        <link rel="stylesheet" href="css/loginstyle.css">




  </head>


  <body>

  <div class="wrapper">
    <form action="${pageContext.request.contextPath}/blogger/login" class="form-signin" method="post">
      <h2 class="form-signin-heading">Please login</h2>
      <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>
  </div>





  </body>
</html>
