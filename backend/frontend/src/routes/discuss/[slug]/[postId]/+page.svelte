<script>
    /** @type {import('./$types').PageProps} */
    let { data } = $props();
</script>

<h1>토론 게시글 페이지</h1>

<div>
    {#await data}
            <p>로딩 중...</p>
        {:then data}
            <h2>{data.item.title}</h2>
            <p>{data.item.content}</p>
        {:catch data}
            <p>오류 발생</p>
    {/await}
</div>