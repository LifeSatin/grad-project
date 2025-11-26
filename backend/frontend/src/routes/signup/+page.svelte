<h6>회원가입 페이지</h6>

<form method="POST">
    <div>
    <label>
        ID
        <input
            name="id"
            autocomplete="off"
        />
    </label>
    </div>
    <div>
    <label>
        닉네임
        <input
            name="nickname"
            autocomplete="off"
        />
    </label>
    </div>
    <div>
    <label>
        비밀번호
        <input
            name="password"
            autocomplete="off"
        />
    </label>
    </div>
    <div>
    <label>
        비밀번호 확인
        <input
            name="password-check"
            autocomplete="off"
        />
    </label>
    </div>
    <button class="submit">가입</button>
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
        margin: 0 auto;
    }
</style>