<script>
/** @type {import('./$types').PageProps} */
let { data } = $props();

import { goto } from '$app/navigation';

</script>

<h6>위키 문서 페이지</h6>
<h2 class="title">{data.pageName}</h2>

{#if data.pageExists}
        <p>"{decodeURIComponent(data.pageName)}" 문서가 존재하지 않습니다. "{decodeURIComponent(data.pageName)}" 문서를 생성하시겠습니까?</p>
        <form method="post">
            <input type="hidden" name="pageName" value={data.pageName} />
            <button>생성하기</button>
        </form>
{:else}
    <p class="fix">
    <a href="/wiki/edit?pageName={data.pageName}"><strong>문서 수정하기</strong></a>
    </p>
    <p>{decodeURIComponent(data.pageContent)}</p>
{/if}

<style>
    h2, h6, p {
        text-align: left;
    }

    .fix {
        text-align: right;
    }
</style>