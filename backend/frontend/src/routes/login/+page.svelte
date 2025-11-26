<script>
    import { enhance } from "$app/forms";

    /** @type {import('./$types').PageProps} */
    let { form } = $props();
</script>

<h6>로그인</h6>

<form method="post" use:enhance>
    <div>
        <label for="loginId">ID
            <input type="text" id="loginId" name="loginId" autocomplete="off" required/>
            </label>
    </div>
    <div>
        <label for="password">비밀번호
            <input type="password" id="password" name="password" autocomplete="off" required/>
            </label>
    </div>
    {#if form === -1}
        <p>ID 또는 비밀번호가 잘못되었습니다. 다시 시도해주세요.</p>
    {/if}
    <button class="submit">로그인</button>
</form>

<style>
    h6, label {
            text-align: left;
            text-decoration: none;
    }

    label {
        display: flex;
        align-items: center;
        margin-left: 180px;
        margin-right: 180px;
    }

    label input {
        margin-left: auto;
        height: 50%;
        width: 50%;
    }

    .submit {
        width = 100px;
        margin: 0 auto;
    }
</style>