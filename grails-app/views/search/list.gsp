<%--
  Created by IntelliJ IDEA.
  User: giliev
  Date: 4.1.2019 г.
  Time: 13:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome to QE!</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <meta name="layout" content="layout"/>
    <style>

    body{
        background-color: #f5f5f5;
    }

    #content{
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        height: 100%
    }
    body form{
        width: 1000px;
        padding: 15px;
        margin: auto;
    }

    .list-group{
        max-height: 500px;
        margin-bottom: 10px;
        overflow:scroll;
        overflow-x: hidden;
        -webkit-overflow-scrolling: touch;
    }

    #navMenu{
        float:right;
        padding-top:20px;
        padding-right: 20px;
        padding-bottom: 20px;


    }
    </style>
    <script>
        function fixSuggestion(link){
            console.log(link.innerHTML);
            document.getElementById("squery").value=link.innerHTML
        }
    </script>

</head>

<body class="text-center">
<g:form  action="search">
    <div id="content" class="form-group">
        <g:if test="${hasError}">
            <label for="squery">
                Did you mean:
                    <a id="suggestionLink" href="#" onclick="fixSuggestion(this)">${suggestion}</a>
                ?
            </label>
        </g:if>
        <g:field class="form-control" type="text" name="squery" value="${original}"></g:field>
        <g:submitButton name="searchButton" value="Search" class="btn btn-lg btn-primary btn-block"></g:submitButton>
    </div>
    <br/>
    <br/>
    <br/>
    <div class="form-group">
        <ul class="list-group">
            <li class="list-group-item active">Are you lookin for:</li>
            <g:each in="${relatedWords}" var="relWord">
                <li class="list-group-item"> <a href="#" onclick="fixSuggestion(this)">${relWord.word}</a> </li>
            </g:each>
        </ul>
    </div>
</g:form>
</body>
</html>