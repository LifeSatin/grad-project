<script>

let page = 1
let limit = 10

$: items = fetch(`http://backend:8080/question`)
            .then(response => response.json())
            .then(json => json.questionList)

function nextPage() {
    page = page + 1
}

</script>

<h4 class="title">질문 게시판</h4>

<form action="/question/write">
    <label>
        <input class="write" type="submit" value="글 작성하기">
    </label>
</form>

<div class="main" id="main">
    {#await items}
        <p>로딩 중...</p>
    {:then items}
            {#each items as item, index}
                <div>
                    <article>
                        <a href="/question/{item.id}"><h4>{item.title}</h4></a>
                        <p>{item.time}</p>
                        <strong>{item.nickname}</strong>
                    </article>
                </div>
            {/each}
    {:catch error}
        <p>오류 발생</p>
    {/await}
</div>

<p>

</p>

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

    .main {
        display: flex;
        flex-direction: column;
    }

    .main p {
        text-align: right;
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
</style>