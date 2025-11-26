<h4>질문 작성하기</h4>

<form class="writing" method="POST" enctype="multipart/form-data">
    <div>
        <label>
            <input
                placeholder="제목을 입력하세요"
                autocomplete="off"
                name="title"
            />
        </label>
    </div>
    <div>
        <label class="attach">
            <p>의뢰할 .mp3 파일</p>
            <input type="file" id="file" name="file"/>
        </label>
    </div>
    <div>
        <label>
            <textarea class="content" style="resize: none;" placeholder="내용을 입력하세요" name="content"></textarea>
        </label>
    </div>
    <button>작성</button>
</form>

<style>
    .content {
        height: 400px;
    }

    label {
        display: flex;
        align-items: center;
    }

    label p {
        width: 250px;
    }

    .writing {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    form div {
        width: 100%;
    }

    .attach {
        height: 50px;
    }

    div label {
        display: flex;
        align-items: center;
    }
</style>