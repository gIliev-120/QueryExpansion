<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'history.label', default: 'History')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-history" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/admin/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link controller="userLogin" action="logOut" >Log Out</g:link></li>
            </ul>
        </div>
        <div id="list-history" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${historyList}" />

            <div class="pagination">
                <g:paginate total="${historyCount ?: 0}" />
            </div>
        </div>
    </body>
</html>