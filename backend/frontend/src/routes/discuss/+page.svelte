<script>

let page = 1
let limit = 10

$: items = fetch(`http://localhost:8080/dboard`)
            .then(response => response.json())
            .then(json => json.boardList)

function nextPage() {
    page = page + 1
}

</script>

<h1>토론 게시판 목록 페이지</h1>

<a href="/discuss/create">토론 게시판 생성하기</a>

<div class="main" id="main">
    {#await items}
        <p>로딩 중...</p>
    {:then items}
        <ul>
            {#each items as item, index}
                <li>
                    <p><a href="/discuss/{item.id}">{item.name}</a></p>
                </li>
            {/each}
        </ul>
    {:catch error}
        <p>오류 발생</p>
    {/await}
</div>