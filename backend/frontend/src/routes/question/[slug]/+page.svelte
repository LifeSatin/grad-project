<script>
    import { page } from '$app/state';
    import AudioPlayer from './AudioPlayer.svelte';
    /** @type {import('./$types').PageProps} */
    let { data } = $props();

    console.log(data);

    import { onMount } from 'svelte';
        let { loading } = $state(true);
        let comments = $state([]);
        let newComment = "";

        async function loadComments() {
            loading = true;
            const res = await fetch(`https://3.27.115.22.nip.io:8443/comments?boardId=0&postId=${page.params.slug}`);
            const commentJson = await res.json();
            comments = commentJson.comments;
            console.log($state.snapshot(comments))
            loading = false;
        }

        onMount(() => {
            loadComments();

        });

    let { audioLoading } = $state(true);

    async function loadAudio() {
        audioLoading = true;

        audioLoading = false;
    }

    export const track = {
        src: `http://3.27.115.22.nip.io:8443/file?fileName=${data.item.fileId}`,
        title: `${data.item.fileName}`,
        artist: 'Johann Strauss'
    }
</script>

<h6>질문 게시글 페이지</h6>

<div class="content">
    {#await data}
            <p>로딩 중...</p>
        {:then data}
            <h2>{data.item.title}</h2>
            <p>{data.item.time}</p>
            <p>작성자 <strong>{data.item.nickname}</strong></p>
            {#if audioLoading}
             <p>오디오 로딩 중...</p>
            {:else}
            <div class="audioPlayer">
                <AudioPlayer {...track}/>
            </div>
            {/if}
            <p>{data.item.content}</p>
            <a href="/discuss/create"><strong>이 음원으로 토론 게시판 만들기</strong></a>
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
                <div><input type="hidden" class="hidden" name="postId" value={page.params.slug} /> </div>
                                <div><input type="hidden" class="hidden" name="boardId" value=0 /> </div>
                <button class="comment-button">작성</button>
            </form>
</div>

<style>
    .audioPlayer {
        display: flex;
        flex-direction: column;
        width: 90%;
        height: 100%;
        gap: 0.5em;
        max-width: 40em;
        margin: 0 auto;
        margin-top: 20px;
        margin-bottom: 40px;
    }

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