<script>
    import { page } from '$app/state';
    import { tick, onMount } from 'svelte';
    let { qLoad, dLoad, wLoad } = $state(true);
    let { qEmpty, dEmpty, wEmpty } = $state(true);
    let { qList, dList, wList } = $state([]);

    async function loadWiki() {
        wLoad = true;
        wEmpty = true;
        const res = await fetch(`http://backend:8080/wiki/search?keyword=${page.url.searchParams.get("q")}`,  {
                    headers: {
                        "Access-Control-Allow-Origin": "http://backend:8080",
                   }});
        const wJson = await res.json();
        wList = wJson.pageList;
        if (wList.length > 0) {
            wEmpty = false;
        }
        wLoad = false;
    }

    async function loadQBoard() {
            qEmpty = true;
            qLoad = true;
            const res = await fetch(`http://3.27.115.22:8080/question/search?keyword=${page.url.searchParams.get("q")}`);
            const qJson = await res.json();
            qList = qJson.questionList;
            if (qList.length > 0) {
                qEmpty = false;
            }
            qLoad = false;
        }

    async function loadDBoard() {
            dEmpty = true;
            dLoad = true;
            const res = await fetch(`http://3.27.115.22:8080/discuss/search?keyword=${page.url.searchParams.get("q")}`);
            const dJson = await res.json();
            dList = dJson.discussionList;
            if (dList.length > 0) {
                dEmpty = false;
            }
            dLoad = false;
        }

    $effect(() => {
        loadWiki();
        loadQBoard();
        loadDBoard();
    })

</script>

<h4 class="title">검색 결과: {page.url.searchParams.get("q")}</h4>

<div>
    <h3>질문 게시판</h3>
    {#if qLoad}
            <p>검색 중...</p>
        {:else}
            {#if qEmpty}
                검색 결과 없음
            {/if}
            <ul>
                {#each qList as q}
            	    <li><a href="/question/{q.id}">{q.title}</a></li>
                {/each}
            </ul>
        {/if}
    <a href="/question">더보기...</a>
</div>
<div>
    <h3>토론 게시판</h3>
    {#if dLoad}
            <p>검색 중...</p>
        {:else}
            {#if dEmpty}
                검색 결과 없음
            {/if}
            <ul>
                {#each dList as d}
            	    <li><a href="/discuss/{d.boardId}/{d.id}">{d.title}</a></li>
                {/each}
            </ul>
        {/if}
    <a href="/discuss">더보기...</a>
</div>
<div>
    <h3>위키</h3>
    {#if wLoad}
        <p>검색 중...</p>
    {:else}
        {#if wEmpty}
            <p>검색 결과가 없습니다. <a href="/wiki/create?q={page.url.searchParams.get("q")}">"{page.url.searchParams.get("q")}" 문서를 새로 생성하시겠습니까?</a></p>
        {/if}
        <ul>
            {#each wList as w}
        	    <li><a href="/wiki/{w}">{w}</a></li>
            {/each}
        </ul>
    {/if}
    <a href="/wiki">더보기...</a>
</div>

<style>
    * {
        text-align: left;
    }

    .title {
        text-align: center;
    }

    div {
        margin-bottom: 20px;
    }


</style>