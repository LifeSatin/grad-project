<script>

let page = 1
let limit = 10

$: items = fetch(`https://3.27.115.22:8443/notice`)
            .then(response => response.json())
            .then(json => json.noticeList)

function nextPage() {
    page = page + 1
}

</script>

<h4 class="title">질문 게시판</h4>

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

.title {
        text-align: center;
}