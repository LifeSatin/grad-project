<script>
    /** @type {import('./$types').PageLoad} */
	import favicon from '$lib/assets/favicon.svg';
    import { onMount } from 'svelte';

	let { data, children } = $props();

	let { isLoggedIn } = $state("false");

	onMount(() => {
    	if (data.item.status === 200) {
    	    isLoggedIn = true;
    	} else {
    	    isLoggedIn = false;
    	}
    });
</script>


<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
>

<div id="wrapper">
	<header class="header-items">
		<form id="search" action="/search">
			<label class="inputs">
				<input class="search" name="q" placeholder="검색어를 입력하세요..." />
				<input class="submit" value="검색" type="submit" />
			</label>
		</form>
		<nav id="navs">
			<ul class="nav-items">
			    {#if isLoggedIn}
			    <li><a href="/">회원 정보</li>
                <li><a href="/logout">로그아웃</a></li>
			    {:else}
				<li><a href="/signup">회원가입</a></li>
				<li><a href="/login">로그인</a></li>
				{/if}
			</ul>
		</nav>
	</header>



	<div id="content-wrap">
		<div>
			<aside class="sidebar">
				<div>
					<ul id="boards">
						<li><a href="/notice">공지사항</a></li>
						<li><a href="/question">질문 게시판</a></li>
						<li><a href="/discuss">토론 게시판 전체 목록</a></li>
					</ul>
				</div>
			</aside>
		</div>
		<div id="content">
			<section>
				<article>
					{@render children?.()}
				</article>
			</section>
		</div>
	</div>


	<footer></footer>
</div>

<style>
	@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable-dynamic-subset.min.css');

	.suffix {
		white-space: nowrap;
	}

	.inputs {
	    margin: 0;
	    display: flex;
	    align-items: center;
	    gap: 5px;
		width: 500px;
	}

	.submit {
	    margin: 0;
		padding: 0;
		min-width: 100px;
		max-width: 100px;
		height: 60px;
	}

	:global(body) {
		margin: 0;
		height: 100%;
	}

	#wrapper {
		font-family:
			Pretendard Variable,
			sans-serif;
		height: 100%;
		margin: 0;
	}

	#content-wrap {
		display: flex;
		height: 100%;
	}

	#search {
		width: 1000px;
		height: 100px;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin: 0 auto;
		padding-left: 400px;
		padding-right: 200px auto;
	}

	#boards {
		margin-top: 32px;
		margin-bottom: 32px;
	}

	#navs {
		align-items: center;
		margin-right: 50px;
	}

	#sidebar-hot-title {
		font-size: 11px;
		font-weight: 600;
		color: #888;
		margin-left: 32px;
		margin-bottom: 8px;
		letter-spacing: 1px;
	}

	#content {
		width: 100%;
	}

	.search {
		width: 800px;
		height: 60px;
		margin: 0;
	}

	.sidebar {
		position: fixed;
		height: 100%;
		background: white;
	}

	.sidebar ul {
		list-style: none;
	}

	.sidebar li {
		margin: 4px 0;
		color: #333;
		padding: 8px 10px;
		border-radius: 6px;
		transition: background 0.15s ease;
	}

	.sidebar a {
		text-decoration: none;
	}

	.nav-items {
		display: inline;
	}

	.header-items {
		display: flex;
		align-items: center;
	}

	.nav-items li {
		display: inline-block;
	}

	header {
		position: fixed;
		background: white;
		height: 100px;
		width: 100%;
		display: inline-block;
		border-bottom: 1px solid #ddd;
	}

	aside {
		top: 100px;
		width: 300px;
		border-right: 1px solid #ddd;
		padding: 16px;
	}

	section {
		display: flex;
		justify-content: center;
		margin-top: 110px;
		margin-left: 200px;
		height: 100%;
		padding: 16px;
	}

	article {
		width: 800px;
		text-align: center;
		margin-left: 100px;
		margin-right: 100px;
	}
</style>
