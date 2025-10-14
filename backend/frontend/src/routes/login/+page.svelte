<script>
    import { enhance } from "$app/forms";

    /** @type {import('./$types').PageProps} */
    let { form } = $props();
</script>

<h1>로그인</h1>

<form method="post" use:enhance>
    <div>
        <label for="loginId">ID</label>
            <input type="text" id="loginId" name="loginId" autocomplete="off" required/>
    </div>
    <div>
        <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" autocomplete="off" required/>
    </div>
    {#if form === -1}
        <p>ID 또는 비밀번호가 잘못되었습니다. 다시 시도해주세요.</p>
    {/if}
    <button type="submit">로그인</button>
</form>