<script>
/** @type {import('./$types').PageProps} */
let { data } = $props();

</script>

<h1>토론 게시글 작성</h1>

<form method="POST">
    <div>
        <label>
            <input
                placeholder="제목을 입력하세요."
                autocomplete="off"
                name="title"
            />
        </label>
    </div>
    <div>
        <label>
            <textarea style="resize: none;" placeholder="내용을 입력하세요" name="content">
            </textarea>
        </label>
    </div>
    <div>
        <input type="hidden" name="authorId" value=1 />
    </div>
    <div>
            <input type="hidden" name="boardId" value=1 />
    </div>
    <button>작성</button>
</form>