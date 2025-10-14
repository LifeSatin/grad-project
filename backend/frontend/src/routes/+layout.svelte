<script>
	import favicon from '$lib/assets/favicon.svg';

	let { children } = $props();
</script>

<nav>
    검색창
    알림함
    <a href="/signup">회원가입</a>
    <a href="/login">로그인</a>
</nav>

<nav>
    <ul>
        <li><a href="/notice">공지사항</a></li>
        <li><a href="/question">질문 게시판</a></li>
        <li><a href="/discuss">토론 게시판 전체 목록</a></li>
        <li>즐겨찾기</li>
        <li><a href="/wiki">위키</a></li>
    </ul>
</nav>

<svelte:head>
	<link rel="icon" href={favicon} />
</svelte:head>

{@render children?.()}
