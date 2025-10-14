<script>

let page = 1
let limit = 10

function nextPage() {
    page = page + 1
}

/** @type {import('./$types').PageProps} */
let { data } = $props();

</script>

<h1>{data.items.boardName} 게시판</h1>

<a href="/discuss/{data.boardId}/write">작성</a>

<div class="main" id="main">
    <ul>
        {#each data.items.discussList as item}
            <li>
                <p><a href="/discuss/1/{item.id}">{item.title}</a></p>
            </li>
        {/each}
    </ul>
</div>