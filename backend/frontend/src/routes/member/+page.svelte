<script>
	import PasswordModal from './PasswordModal.svelte';
	import NicknameModal from './NicknameModal.svelte';
	import BookmarkModal from './BookmarkModal.svelte';
	import SignoutModal from './SignoutModal.svelte';

	let showNicknameModal = $state(false);
	let showPasswordModal = $state(false);
	let showBookmarkModal = $state(false);
	let showSignoutModal = $state(false);

    let postComment = $state(true);
    /** @type {import('./$types').PageProps} */
    let { data } = $props();
    console.log(data);


</script>

<div class="memberInfo">
    <h6>{data.item.nickname}({data.item.loginId})님의 마이페이지</h6>
    <strong>직책:
        {#if data.item.power == "regular"}
            정회원
        {/if}
    </strong>
</div>

<div class="layout">
    <div class="posts">
        <h5 class="memberInfo">작성 글 보기</h5>
        <div class="postbuttons">
            <div class="post">
                <a onclick={()=>(postComment = true)}>
                    {#if postComment}
                        <strong>게시글</strong>
                    {:else}
                        게시글
                    {/if}
                </a>
            </div>
            <div class="post">
                <a onclick={()=>(postComment = false)}>
                    {#if postComment}
                         댓글
                    {:else}
                         <strong>댓글</strong>
                    {/if}
                </a>
            </div>
        </div>
        <div>
            {#if postComment}
            {:else}
                 {#each data.comlist.memberComments as comment, index}
                      <div>
                           <p>{comment.content}</p>
                      </div>
                 {/each}
            {/if}
        </div>
    </div>

    <div>
        <aside class="functions">
            <ul>
            <li>
                <a onclick={() => (showNicknameModal = true)}><strong>닉네임 수정</strong></a>
            </li>
            <li>
                <a onclick={() => (showPasswordModal = true)}><strong>비밀번호 수정</strong></a>
            </li>
            <li>
                <a onclick={() => (showBookmarkModal = true)}><strong>즐겨찾기 게시판 관리</strong></a>
            </li>
            <li>
                <a onclick={() => (showSignoutModal = true)}><strong>회원 탈퇴</strong></a>
            </li>
            </ul>
        </aside>
    </div>
</div>

<NicknameModal bind:showNicknameModal>
    <form>
        <div>
            새 닉네임을 입력하세요.
        </div>
        <div>
                <label for="nickname">
                    <input id="nickname" name="nickname" autocomplete="off" required/>
                </label>
        </div>
    </form>
</NicknameModal>

<PasswordModal bind:showPasswordModal>
    <form>
            <div>
                새 비밀번호를 입력하세요.
            </div>
            <div>
                    <label for="newpassword">
                        <input id="newpassword" name="newpassword" autocomplete="off" required/>
                    </label>
            </div>
            <div>
                            기존 비밀번호를 입력하세요.
                    </div>
                    <div>
                         <label for="oldpassword">
                         <input id="oldpassword" name="oldpassword" autocomplete="off" required/>
                         </label>
            </div>
    </form>
</PasswordModal>

<BookmarkModal bind:showBookmarkModal>
    즐겨찾기 게시판 바꾸기
</BookmarkModal>

<SignoutModal bind:showSignoutModal>
    정말 탈퇴하시겠습니까?
</SignoutModal>


<style>
    .memberInfo {
            text-align: left;
            text-decoration: none;
    }

    .layout {
        margin-top: 30px;
        display: flex;
    }

    .posts {
        width: 500px;
        display: block;
    }

    .functions {
        display: block;
    }

    a {
            text-decoration: none;
        }

    p {
        text-align: left;
    }

    .post {
        margin: 20px;
    }

    .postbuttons {
        display: flex;
    }
</style>