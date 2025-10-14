<script>

let page = 1
let limit = 10

$: items = fetch(`http://localhost:8080/question`)
            .then(response => response.json())
            .then(json => json.questionList)

function nextPage() {
    page = page + 1
}

</script>

<h1>질문 게시판입니다.</h1>

<a href="/question/write">작성</a>

<div class="main" id="main">
    {#await items}
        <p>로딩 중...</p>
    {:then items}
        <ul>
            {#each items as item, index}
                <li>
                    <p><a href="/question/{item.id}">{item.title}</a></p>
                </li>
            {/each}
        </ul>
    {:catch error}
        <p>오류 발생</p>
    {/await}
</div>