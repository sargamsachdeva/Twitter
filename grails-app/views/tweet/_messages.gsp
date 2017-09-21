
    <g:hiddenField name="id" value="${message?.id}"/>
    <div class="form-group row">
    <div class="message">
    <strong>${message.user.username} tweets</strong>
    <span>
        "${message.message}"
    </span>
    <div class="date">at <g:formatDate date="${message.dateCreated}" format="mm-dd-yyyy"/></div>
        <g:remoteLink action="likeTweet" id="${message?.id}"><button>Like</button></g:remoteLink>

    </div>
    </div>
