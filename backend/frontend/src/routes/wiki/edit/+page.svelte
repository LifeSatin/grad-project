<script>
import { page } from '$app/state';
/** @type {import('./$types').PageProps} */
let { data } = $props();
let value = $state(data.pageContent);

</script>

<h6>위키 문서 페이지</h6>
<h2 class="title">{decodeURIComponent(page.url.searchParams.get('pageName'))}(수정)</h2>

<form method="POST">
    <div>
        <label>
            <textarea style="resize: none;" id="content" name="content" bind:value={value}></textarea>
        </label>
    </div>
    <div>
        <input type="hidden" name="pageName" value={page.url.searchParams.get('pageName')} />
    </div>
    <button>작성</button>
</form>

<style>

    h2, h6 {
        text-align: left;
        text-decoration: none;
    }

    #content {
        height: 500px;
    }

    .hidden {
        margin: 0;
    }

</style>