<script>
    import { onMount } from 'svelte';
    /** @type {import('./$types').PageProps} */
    let { data } = $props();
    import { redirect } from '@sveltejs/kit';
    import { goto } from '$app/navigation';

    onMount(() => {
        async function logout() {
            let formData = new FormData();
            formData.append("token", data.token);
            console.log(formData);
            const res = await fetch(`https://3.27.115.22:8443/logout`, {
                                    method: "POST",
                                    body: formData,
            });
        }
        console.log(data);
        console.log(data.token);

        logout();
        goto("/");
    });
</script>

hihi

<style>

</style>