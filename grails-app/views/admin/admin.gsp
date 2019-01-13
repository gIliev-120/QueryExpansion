<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Admin Interface</title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/admin/index')}"><g:message code="default.home.label"/></a></li>
        <li><g:link controller="user" action="index">Users</g:link></li>
        <li><g:link controller="history" action="index">History</g:link></li>
        <li><g:link controller="userLogin" action="logOut" >Log Out</g:link></li>
    </ul>
</div>
<div id ="greetings" style="text-align: center;font-size: 50px;">
    <h1>Hello,Admin</h1>

</div>
</body>
</html>