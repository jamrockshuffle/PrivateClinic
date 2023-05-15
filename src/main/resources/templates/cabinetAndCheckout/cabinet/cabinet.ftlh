helo :)

<br>

<table class="table table-dark table-hover">
    <tr>
        <th>Номер</th>
        <th>Лікар</th>
        <th>Послуга</th>
        <th>Час прийому</th>
        <th>Ціна</th>

    </tr>

    <#list examinations as examination>
        <tr>
            <td>${examination.examinationId}</td>
            <td>${examination.doctor.name}</td>
            <td>${examination.qualification.name}</td>
            <td>${examination.examinationTime}</td>
            <td>${examination.price}</td>
            <td>
                <#if examination.status ?? > ${examination.status}
                <#else> <a href="/checkout/${examination.examinationId}">
                    <button>Оплатити</button>
                </a>
                </#if>
            </td>
            <#--<td>
                <a href="/ui/book/update/${book.id}">
                    <button class="btn btn-light btn-sm">Update</button>
                </a>
            </td>
            <td>
                <a href="/ui/book/delete/${book.id}">
                    <button class="btn btn-light btn-sm">Delete</button>
                </a>
            </td>
            <td>${book.created_at}</td>
            <td><#if book.modified_at ?? > ${book.modified_at}
                <#else> NULL
                </#if></td>-->
        </tr>
    </#list>
</table>