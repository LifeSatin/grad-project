<script>

let page = 1
let limit = 10

$: items = fetch(`http://3.27.115.22:8080/dboard`)
            .then(response => response.json())
            .then(json => json.boardList)

function nextPage() {
    page = page + 1
}

</script>

<h4>토론 게시판 목록</h4>

<div class="main" id="main">
    {#await items}
        <p>로딩 중...</p>
    {:then items}
            {#each items as item, index}
                <article>
                    <h6><a href="/discuss/{item.id}">{item.name}</a></h6>
                </article>
            {/each}
    {:catch error}
        <p>오류 발생</p>
    {/await}
</div>

<style>
    .main {
        text-align: left;
    }

    .main a {
        text-decoration: none;
    }

    article h6 {
        align-items: center;
        margin-bottom: 0;
    }
</style>