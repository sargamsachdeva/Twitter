<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:javascript library="jquery"/>
</head>
<body>
<g:formRemote name="saveUser" url="[controller:'user', action:'register']" update="showErrorInSaveUser">
    <label for="name">Username</label><g:textField name="name"/><br/>
    <label for="emailId">Email Id</label><g:textField name="emailId"/><br/>
    <label for="password">Password</label><g:textField name="password"/><br/>
    <label for="password2">Renter Password</label><g:textField name="password2"/><br/>
    <g:submitButton name="Save User"/>
</g:formRemote>
<div id="showErrorInSaveUser">
    <g:render template="/user/userSaveError"/>
</div>
</body>
</html>