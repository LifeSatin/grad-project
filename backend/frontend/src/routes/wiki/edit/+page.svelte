<script>
import { page } from '$app/state';
/** @type {import('./$types').PageProps} */
let { data } = $props();
let value = $state(decodeURIComponent(data.pageContent));

</script>

<h1>위키 문서 수정: {decodeURIComponent(page.url.searchParams.get('pageName'))}</h1>

<form method="POST">
    <div>
        <label>
            <textarea style="resize: none;" placeholder="내용을 입력하세요" name="content" bind:value={value}>
            </textarea>
        </label>
    </div>
    <div>
        <input type="hidden" name="pageName" value={page.url.searchParams.get('pageName')} />
    </div>
    <button>작성</button>
</form>