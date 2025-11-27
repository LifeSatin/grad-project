<script>
    import { page } from '$app/state';
    import { onMount } from 'svelte';
    import { goto } from '$app/navigation';

    async function createPage() {
        const q = page.url.searchParams.get("q");
        console.log('the component has mounted');
        let formData = new FormData();
        const res = await fetch(`http://3.27.115.22:8080/wiki?pageName=${q}`, {
        method: "post",
                body: formData,
            });
        const item = await res.json();
        console.log(item);

        if (res.ok) {
            goto(`/wiki/edit?pageName=${q}`);
        }
    }

    onMount(() => {
        createPage();
    });
</script>

<h3>로딩 중...</h3>