<ul class="personList">
    <g:each in="${people}" var="p">
        <li>

            ${p.username} <span class="byline"> @${p.username}</span>
        </li>
    </g:each>
</ul>
