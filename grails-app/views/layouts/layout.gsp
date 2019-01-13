<!doctype html>
<html lang="en" class="no-js">
<head>
    <g:layoutHead/>
</head>

<body>
<div id="navMenu" class="dropdown show">
    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Hello, ${session.user.firstName}
    </a>

    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
        <g:link controller="userLogin" action="logOut" class="dropdown-item">Log Out</g:link>
    </div>
</div>

<g:layoutBody/>


</body>
</html>
