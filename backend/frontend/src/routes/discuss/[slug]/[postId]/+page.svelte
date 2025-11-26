<script>
    import { page } from '$app/state';

    /** @type {import('./$types').PageProps} */
    let { data } = $props();

    console.log(data);

    import { onMount } from 'svelte';
    let { loading } = $state(true);
    let comments = $state([]);
    let newComment = "";

    async function loadComments() {
        loading = true;
        const res = await fetch(`http://backend:8080/comments?boardId=${page.params.slug}&postId=${page.params.postId}`);
        const commentJson = await res.json();
        comments = commentJson.comments;
        loading = false;
    }

    onMount(() => {
        loadComments();
    });

</script>

<h6>토론 게시글 페이지</h6>

<div class="content">
    {#await data}
            <p>로딩 중...</p>
        {:then data}
            <h2>{data.post.title}</h2>
            <p>{data.post.time}</p>
            <p>작성자 <strong>{data.post.nickname}</strong></p>
            <p>{data.post.content}</p>
        {:catch data}
            <p>오류 발생</p>
    {/await}
    <h4>댓글 목록:</h4>

    {#if loading}
    	<p>댓글 불러오는 중...</p>
    {:else}
    	{#each comments as c}
    		<div class="comment">
    			<strong>{c.authorNickname}</strong>
    			<p>{c.content}</p>
    		</div>
    	{/each}
    {/if}

    <form class="commenting" method="POST">
        <div>
        <label class="comment-content">
            <input
                name="content"
                class="comment-content"
                autocomplete="off"
                placeholder="댓글을 작성하세요"
            />
        </label>
        </div>
        <div><input type="hidden" class="hidden" name="postId" value={page.params.postId} /> </div>
        <div><input type="hidden" class="hidden" name="boardId" value={page.params.slug} /> </div>
        <button class="comment-button">작성</button>
    </form>


</div>

<style>
    * {
        text-align: left;
        text-decoration: none;
    }

    .content {
            display: flex;
            flex-direction: column;
        }

        .content a {
            text-align: center;
            margin-bottom: 20px;
        }

        .commenting {
            display: flex;
            align-items: center;
        }

        .comment-content {
            display: flex;
            align-items: center;
            width: 650px;
            height: 70px;
            margin: 0;
        }

        .comment-button {
            height: 70px;
            width: 100px;
            margin-left: auto;
            text-align: center;
        }

        .hidden {
            margin: 0;
        }
</style>