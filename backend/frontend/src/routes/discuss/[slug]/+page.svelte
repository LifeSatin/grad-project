<script>

let page = 1
let limit = 10

function nextPage() {
    page = page + 1
}

/** @type {import('./$types').PageProps} */
let { data } = $props();

</script>

<h4 class="title">{data.items.boardName} 게시판</h4>

<form action="/discuss/{data.boardId}/write">
    <label>
        <input class="write" type="submit" value="글 작성하기">
    </label>
</form>

<div class="main" id="main">
    <div>
        {#each data.items.discussList as item}
             <article>
                <a href="/discuss/1/{item.id}"><h4>{item.title}</h4></a>
                <p>{item.time}</p>
                <strong>{item.nickname}</strong>
             </article>
        {/each}
    </div>
</div>

<style>

    * {
        text-decoration: none;
        text-align: left;
    }

    .title {
            text-align: center;
        }

    a {
        text-decoration: none;
    }

    .write {
            height: 50px;
            width: 120px;
            padding: 0;
            text-align: center;
            margin-left: auto;
            display: block;
            margin-bottom: 20px;
    }

    .main {
            display: flex;
            flex-direction: column;
        }

        .main p {
            text-align: right;
        }

</style>