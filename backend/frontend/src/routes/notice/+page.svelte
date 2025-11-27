<script>

let page = 1
let limit = 10

$: items = fetch(`http://3.27.115.22:8080/notice`)
            .then(response => response.json())
            .then(json => json.noticeList)

function nextPage() {
    page = page + 1
}

</script>

<h1>공지사항 게시판</h1>

<a href="/notice/write">작성</a>

<div class="main" id="main">
    {#await items}
        <p>로딩 중...</p>
    {:then items}
        <ul>
            {#each items as item, index}
                <li>
                    <p><a href="/notice/{item.id}">{item.title}</a></p>
                </li>
            {/each}
        </ul>
    {:catch error}
        <p>오류 발생</p>
    {/await}
</div>