<script>
	import favicon from '$lib/assets/favicon.svg';
	let { children } = $props();
	let value = $state();

import { goto } from '$app/navigation';

	function goPage() {
	    goto(`/wiki/${encodeURIComponent(value)}`);
	    value = null;
	}
</script>
<!--
<input id="pageName" name="pageName" onchange={goPage} placeholder="검색할 위키 문서의 제목을 입력하세요" bind:value={value} autocomplete="off" required />
-->
{@render children?.()}