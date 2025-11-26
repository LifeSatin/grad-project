<h4>토론 게시판 생성</h4>

<form method="POST">
    <div><input type="hidden" name="originalPostId" value=1 /> </div>
    <div>
    <label>
        <p class="label">생성할 게시판의 이름을 입력해주세요.</p>
        <input
            name="boardName"
            autocomplete="off"
        />
    </label>
    </div>
    <button>생성하기</button>
</form>

<style>
    .label {
        text-align: left;
    }
</style>