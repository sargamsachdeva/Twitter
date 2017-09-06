<g:form controller="tweet" action="likeTweet" method="POST">
    <g:hiddenField name="id" value="${message?.id}"/>
    <div class="form-group row">
    <div class="message">
    <strong>${message.user.username} tweets</strong>
    <span>
        "${message.message}"
    </span>
    <div class="date">at <g:formatDate date="${message.dateCreated}"/></div>
    <input type="submit" class="text-button" value="Like"/>
    </div>
    </div>
</g:form>