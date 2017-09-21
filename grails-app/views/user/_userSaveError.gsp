<div class='value ${hasErrors(bean:command,field:'name','errors')}'>
    <div id="nameErrorFromCommand" name="name" >${fieldError(bean:command,field:'name')}</div>
</div>
<div class='value ${hasErrors(bean:command,field:'emailId','errors')}'>
    <div id="emailIdErrorFromCommand" name="emailId" >${fieldError(bean:command,field:'emailId')}</div>
</div>
<div class='value ${hasErrors(bean:command,field:'password','errors')}'>
    <div id="passwordErrorFromCommand" name="password" >${fieldError(bean:command,field:'password')}</div>
</div>