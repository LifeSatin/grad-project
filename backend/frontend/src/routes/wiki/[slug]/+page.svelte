<script>
/** @type {import('./$types').PageProps} */
let { data } = $props();

import { goto } from '$app/navigation';
function openEditPage() {
    goto(`/wiki/edit?pageName=${data.pageName}`);
}

</script>

<h1>위키 문서 페이지: {decodeURIComponent(data.pageName)}</h1>

{#if data.pageExists}
        <p>"{decodeURIComponent(data.pageName)}" 문서가 존재하지 않습니다. "{decodeURIComponent(data.pageName)}" 문서를 생성하시겠습니까?</p>
        <form method="post">
            <input type="hidden" name="pageName" value={data.pageName} />
            <button>생성하기</button>
        </form>
{:else}
    <button onclick={openEditPage}>문서 수정</button>
    <p>{decodeURIComponent(data.pageContent)}</p>
{/if}