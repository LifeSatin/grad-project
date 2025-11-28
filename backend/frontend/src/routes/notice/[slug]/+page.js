/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
	const res = await fetch(`https://3.27.115.22.nip.io:8443/notice/post?postId=${params.slug}`);
    const item = await res.json();

    return { item };
}